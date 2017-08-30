package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.ServiceOperationException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.AliTools;
import cn.houhe.api.common.FDDUtil;
import cn.houhe.api.common.FlowNoUtil;
import cn.houhe.api.loan.entity.LoanContract;
import cn.houhe.api.loan.mapper.LoanContractMapper;
import com.aliyun.oss.common.utils.IOUtils;
import com.fadada.sample.client.FddClientBase;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务实现层 - 表：loan_contract
 * @since 2017-04-07 17:08:11
 */
@Service("loanContractService")
public class LoanContractService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private LoanContractMapper loanContractMapper;

	public void insert(LoanContract entity) throws ServiceException {
		try {
			loanContractMapper.insert(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
	public void insertSelective(LoanContract entity) throws ServiceException {
		try {
			loanContractMapper.insertSelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(LoanContract entity) throws ServiceException {
		try {
			loanContractMapper.deleteByPrimaryKey(entity.getLcId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				loanContractMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(LoanContract entity) throws ServiceException {
		try {
			loanContractMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(LoanContract entity) throws ServiceException {
		try {
			loanContractMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public LoanContract findByPrimaryKey(Integer lcId) throws ServiceException {
		try {
			return loanContractMapper.selectByPrimaryKey(lcId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<LoanContract> findPage(Criteria<LoanContract> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(LoanContract.class);
			}
			criteria.pagination(true);
			List<LoanContract> list = loanContractMapper.selectByCriteria(criteria);
			return new Pager<LoanContract>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<LoanContract> findAll(Criteria<LoanContract> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(LoanContract.class);
			}
			criteria.pagination(false);
			return loanContractMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}


	/**
	 * 生成合同并签属
	 * @param param
	 */
	public void generateAndSignCreditApplyContract(Integer caId, Map<String,String> param) throws Exception {

		final String custId = FDDUtil.custCA(param.get("realname"),param.get("idcard"),param.get("mobile"));
		param.put("sign",param.get("realname"));
		creditSignContract(caId,param,custId,"4");
		//todo 盖单位置
	}

	private void creditSignContract(Integer caId, Map<String, String> param, String custId, String role) throws IOException {
		List<Map> contractList = (List) contracts.get("credit");
		ExpressionParser parser = new SpelExpressionParser();
		EvaluationContext context = new StandardEvaluationContext();
		for (Map.Entry<String, String> entry : param.entrySet()) {
			context.setVariable(entry.getKey(),entry.getValue());
		}
		for (Map val : contractList){
			final LoanContract contract = new LoanContract();
			contract.setContractName((String) val.get("name"));
			contract.setCreditinfoId(caId);
			contract.setContractNumber("CA" + FlowNoUtil.next());
			Map<String, Object> paramMap = (Map<String, Object>) val.get("param");
			if(paramMap==null)
			{
				paramMap=new HashMap<>();
			}
			Map<String,String> signParamMap = new HashMap<>();
			for (Map.Entry<String, Object> entry : paramMap.entrySet()) {//解析参数值
				signParamMap.put(entry.getKey(),parser.parseExpression((String) entry.getValue()).getValue(context,String.class));
			}
			if(signParamMap.containsKey("cano"))
			{
				signParamMap.replace("cano",contract.getContractName());
			}

			FDDUtil.generateContract((String) val.get("templateId"),contract.getContractNumber(),contract.getContractName(),signParamMap);
			String signWord = parser.parseExpression((String) val.get("signWord")).getValue(context,String.class);
			Map result = FDDUtil.autoSign("CAT"+ FlowNoUtil.next(),custId,role,contract.getContractNumber(),contract.getContractName(),signWord,null);
	//		FDDUtil.autoSignPlat("CAT"+ FlowNoUtil.next(),regContract.getContractNumber(),regContract.getContractName(),"cname",null);
			String foldername = param.get("realname") + "/" + DateFormatUtils.format(new Date(), "yyyyMMdd") +"/" + caId;
			contract.setContractPreviewUrl((String) result.get("viewpdf_url"));
			contract.setContractFileUrl(AliTools.uploadFileToAli(foldername,contract.getContractName()+".pdf", IOUtils.readStreamAsByteArray(new URL((String)result .get("download_url")).openStream())) );
			insertSelective(contract);
			FDDUtil.fillingContract(contract.getContractNumber());//归档
		}

	}

	private void loanSignContract(Integer loanId, String cname, Map<String, String> param, String custId) throws IOException {
		List<Map> contractList = (List) contracts.get("loan");
		ExpressionParser parser = new SpelExpressionParser();
		EvaluationContext context = new StandardEvaluationContext();
		for (Map.Entry<String, String> entry : param.entrySet()) {
			context.setVariable(entry.getKey(),entry.getValue());
		}
		for (Map val : contractList) {
			final LoanContract contract = new LoanContract();
			contract.setContractName((String) val.get("name"));
			contract.setLoanRecordId(loanId);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			String flono=(FlowNoUtil.next()+"");
			String no="CFD" + sdf.format(new Date())+ flono.substring(flono.length()-10,flono.length()-1);
			contract.setContractNumber(no);
			String templateId = (String) val.get("templateId");
			Map<String, Object> paramMap = (Map<String, Object>) val.get("param");
			Map<String,String> signParamMap = new HashMap<>();
			for (Map.Entry<String, Object> entry : paramMap.entrySet()) {//解析参数值
				signParamMap.put(entry.getKey(),parser.parseExpression((String) entry.getValue()).getValue(context,String.class));
				if(entry.getKey().equals("loan_no"))
				{
					signParamMap.put("loan_no",no);
				}
			}
			String signWord = parser.parseExpression((String) val.get("signWord")).getValue(context,String.class);
			String platSignWord = parser.parseExpression((String) val.get("platSignWord")).getValue(context,String.class);
			FDDUtil.generateContract(templateId, contract.getContractNumber(), contract.getContractName(), signParamMap);
			Map result = FDDUtil.autoSign("LAT" + FlowNoUtil.next(), custId, "4", contract.getContractNumber(), contract.getContractName(), signWord, null);
			if(templateId.equals("platformxieyi20170810_1")||templateId.equals("shouquan_koukuanxieyi20170810")) {
				if(templateId.equals("shouquan_koukuanxieyi20170810"))
				{
					platSignWord="深圳车飞贷信息科技有限公司       ";
				}
				FDDUtil.autoSignPlat("LAT" + FlowNoUtil.next(), contract.getContractNumber(), contract.getContractName(), platSignWord, null);
			}
			String foldername = cname + "/" + DateFormatUtils.format(new Date(), "yyyyMMdd") +"/" + loanId;
			contract.setContractPreviewUrl((String) result.get("viewpdf_url"));
			contract.setContractFileUrl(AliTools.uploadFileToAli(foldername, contract.getContractName() + ".pdf", IOUtils.readStreamAsByteArray(new URL((String) result.get("download_url")).openStream())));
			insertSelective(contract);
			FDDUtil.fillingContract(contract.getContractNumber());//归档
		}
	}

	private Map<String,Object> contracts = new HashMap<>();

	@PostConstruct
	public void initContracts(){
		YamlMapFactoryBean yaml = new YamlMapFactoryBean();
		yaml.setResources(new ClassPathResource("fdd.yml"));
		contracts = yaml.getObject();
	}


	public void fillingContract(){

	}

	public void generateAndSignLoanApplyContract(Integer loanId, Map<String,String> param) throws Exception{

		final String custId = FDDUtil.custCA(param.get("realname"),param.get("idcard"),param.get("mobile"));
		param.put("sign", param.get("realname"));
		param.put("signplatform","深圳市车飞贷信息科技有限公司      ");
		loanSignContract(loanId,param.get("realname"),param,custId);
	}

	public String preview(String type, String tid) {
		try {
			List list = (List) contracts.get(type);
			for (Object o : list) {
				Map map = ((Map) o);
				if (MapUtils.getString(map,"index") .equals(tid)){
					return MapUtils.getString(map,"templateUrl");
				}
			}
			throw new ServiceOperationException("模板不存在");
		} catch (Exception e) {
			throw new ServiceOperationException("模板不存在");
		}
	}
}