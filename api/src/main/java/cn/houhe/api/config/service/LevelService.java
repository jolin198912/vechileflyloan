package cn.houhe.api.config.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.ServiceOperationException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.config.entity.Level;
import cn.houhe.api.config.entity.LevelRateExt;
import cn.houhe.api.config.entity.Rates;
import cn.houhe.api.config.mapper.LevelMapper;
import cn.houhe.api.config.mapper.RatesMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 业务实现层 - 表：level
 *
 * @since 2017-04-10 10:40:01
 */
@Service("levelService")
public class LevelService implements Serializable {
    private static final long serialVersionUID = 1L;

    @Resource
    private LevelMapper levelMapper;

    @Resource
    private RatesMapper ratesMapper;

    public void insert(Level entity) throws ServiceException {
        try {
            levelMapper.insert(entity);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void delete(Level entity) throws ServiceException {
        try {
            levelMapper.deleteByPrimaryKey(entity.getLevelId());
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Transactional
    public void batchDelete(List<Short> ids) throws ServiceException {
        try {
            for (Short id : ids) {
                levelMapper.deleteByPrimaryKey(id);
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void update(Level entity) throws ServiceException {
        try {
            levelMapper.updateByPrimaryKey(entity);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void updateSelective(Level entity) throws ServiceException {
        try {
            levelMapper.updateByPrimaryKeySelective(entity);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public Level findByPrimaryKey(Short levelId) throws ServiceException {
        try {
            return levelMapper.selectByPrimaryKey(levelId);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public Pager<Level> findPage(Criteria<Level> criteria) throws ServiceException {
        try {
            if (criteria == null) {
                criteria = Criteria.create(Level.class);
            }
            criteria.pagination(true);
            List<Level> list = levelMapper.selectByCriteria(criteria);
            return new Pager<Level>(criteria, list);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<Level> findAll(Criteria<Level> criteria) throws ServiceException {
        try {
            if (criteria == null) {
                criteria = Criteria.create(Level.class);
            }
            criteria.pagination(false);
            return levelMapper.selectByCriteria(criteria);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Transactional
    public void addOrUpdate(LevelRateExt dto) throws ServiceException {
        try {
            if (dto.getLevelId() != null && dto.getLevelId() > 0) {//更新
                Level l = new Level();
                l.setLevelId(dto.getLevelId());
                l.setName(dto.getName());
                l.setMinScore(dto.getMinScore());
                l.setMaxScore(dto.getMaxScore());
                l.setMaxLimit(dto.getMaxLimit());
                l.setMinLimit(dto.getMinLimit());
                l.setInstallmentMaxLimit(dto.getInstallmentMaxLimit());
                l.setInstallmentMinLimit(dto.getInstallmentMinLimit());
                l.setInstallmentMaxScore(dto.getInstallmentMaxScore());
                l.setInstallmentMinScore(dto.getInstallmentMinScore());

                Rates r = new Rates();
                r.setRrId(dto.getRrId());
                r.setRate(dto.getRate().divide(new BigDecimal(1000)));
                r.setType(dto.getType());
                r.setLoanPayRate(dto.getLoanPayRate().divide(new BigDecimal(1000)));
                r.setAccountManageRate(dto.getAccountManageRate().divide(new BigDecimal(1000)));
                r.setConsultationRate(dto.getConsultationRate().divide(new BigDecimal(1000)));
                r.setFirstLoanRate(dto.getFirstLoanRate().divide(new BigDecimal(1000)));
                r.setLeastLoanRate(dto.getLeastLoanRate().divide(new BigDecimal(1000)));
                r.setDelayRate(dto.getDelayRate().divide(new BigDecimal(1000)));
                r.setDiscount(dto.getDiscount().divide(new BigDecimal(100)));
                r.setWithdrawalsRate(dto.getWithdrawalsRate().divide(new BigDecimal(1000)));
                r.setQuotaManageRate(dto.getQuotaManageRate().divide(new BigDecimal(1000)));
                r.setRemindFee(dto.getRemindFee());

                if(dto.getRrId1()!=null) {
                    Rates r1 = new Rates();
                    r1.setRrId(dto.getRrId1());
                    r1.setRate(dto.getRate1().divide(new BigDecimal(1000)));
                    r1.setType(dto.getType1());
                    r1.setLoanPayRate(dto.getLoanPayRate1().divide(new BigDecimal(1000)));
                    r1.setAccountManageRate(dto.getAccountManageRate1().divide(new BigDecimal(1000)));
                    r1.setConsultationRate(dto.getConsultationRate1().divide(new BigDecimal(1000)));
                    r1.setFirstLoanRate(dto.getFirstLoanRate1().divide(new BigDecimal(1000)));
                    r1.setLeastLoanRate(dto.getLeastLoanRate1().divide(new BigDecimal(1000)));
                    r1.setDelayRate(dto.getDelayRate1().divide(new BigDecimal(1000)));
                    r1.setDiscount(dto.getDiscount1().divide(new BigDecimal(100)));
                    r1.setWithdrawalsRate(dto.getWithdrawalsRate1().divide(new BigDecimal(1000)));
                    r1.setQuotaManageRate(dto.getQuotaManageRate1().divide(new BigDecimal(1000)));
                    r1.setRemindFee(dto.getRemindFee1());
                    ratesMapper.updateByPrimaryKeySelective(r1);
                }
                else {
                    Rates r1 = new Rates();
                    r1.setRate(dto.getRate1().divide(new BigDecimal(1000)));
                    r1.setType(dto.getType1());
                    r1.setLoanPayRate(dto.getLoanPayRate1().divide(new BigDecimal(1000)));
                    r1.setAccountManageRate(dto.getAccountManageRate1().divide(new BigDecimal(1000)));
                    r1.setConsultationRate(dto.getConsultationRate1().divide(new BigDecimal(1000)));
                    r1.setFirstLoanRate(dto.getFirstLoanRate1().divide(new BigDecimal(1000)));
                    r1.setLeastLoanRate(dto.getLeastLoanRate1().divide(new BigDecimal(1000)));
                    r1.setDelayRate(dto.getDelayRate1().divide(new BigDecimal(1000)));
                    r1.setDiscount(dto.getDiscount1().divide(new BigDecimal(100)));
                    r1.setWithdrawalsRate(dto.getWithdrawalsRate1().divide(new BigDecimal(1000)));
                    r1.setQuotaManageRate(dto.getQuotaManageRate1().divide(new BigDecimal(1000)));
                    r1.setRemindFee(dto.getRemindFee1());

                    r1.setLevelId(l.getLevelId());
                    ratesMapper.insertSelective(r1);
                }

                levelMapper.updateByPrimaryKeySelective(l);
                ratesMapper.updateByPrimaryKeySelective(r);
            } else {//新增
                Level l = new Level();
                l.setName(dto.getName());
                l.setMinScore(dto.getMinScore());
                l.setMaxScore(dto.getMaxScore());
                l.setMaxLimit(dto.getMaxLimit());
                l.setMinLimit(dto.getMinLimit());
                l.setInstallmentMaxLimit(dto.getInstallmentMaxLimit());
                l.setInstallmentMinLimit(dto.getInstallmentMinLimit());
                l.setInstallmentMaxScore(dto.getInstallmentMaxScore());
                l.setInstallmentMinScore(dto.getInstallmentMinScore());

                levelMapper.insertSelective(l);

                Rates r = new Rates();
                r.setRate(dto.getRate().divide(new BigDecimal(1000)));
                r.setType(dto.getType());
                r.setLoanPayRate(dto.getLoanPayRate().divide(new BigDecimal(1000)));
                r.setAccountManageRate(dto.getAccountManageRate().divide(new BigDecimal(1000)));
                r.setConsultationRate(dto.getConsultationRate().divide(new BigDecimal(1000)));
                r.setFirstLoanRate(dto.getFirstLoanRate().divide(new BigDecimal(1000)));
                r.setLeastLoanRate(dto.getLeastLoanRate().divide(new BigDecimal(1000)));
                r.setDelayRate(dto.getDelayRate().divide(new BigDecimal(1000)));
                r.setDiscount(dto.getDiscount().divide(new BigDecimal(100)));
                r.setWithdrawalsRate(dto.getWithdrawalsRate().divide(new BigDecimal(1000)));
                r.setQuotaManageRate(dto.getQuotaManageRate().divide(new BigDecimal(1000)));
                r.setRemindFee(dto.getRemindFee());

                if (dto.getInstallmentMaxScore() != null && dto.getInstallmentMinScore() != null) {
                    Rates r1 = new Rates();
                    r1.setRate(dto.getRate1().divide(new BigDecimal(1000)));
                    r1.setType(dto.getType1());
                    r1.setLoanPayRate(dto.getLoanPayRate1().divide(new BigDecimal(1000)));
                    r1.setAccountManageRate(dto.getAccountManageRate1().divide(new BigDecimal(1000)));
                    r1.setConsultationRate(dto.getConsultationRate1().divide(new BigDecimal(1000)));
                    r1.setFirstLoanRate(dto.getFirstLoanRate1().divide(new BigDecimal(1000)));
                    r1.setLeastLoanRate(dto.getLeastLoanRate1().divide(new BigDecimal(1000)));
                    r1.setDelayRate(dto.getDelayRate1().divide(new BigDecimal(1000)));
                    r1.setDiscount(dto.getDiscount1().divide(new BigDecimal(100)));
                    r1.setWithdrawalsRate(dto.getWithdrawalsRate1().divide(new BigDecimal(1000)));
                    r1.setQuotaManageRate(dto.getQuotaManageRate1().divide(new BigDecimal(1000)));
                    r1.setRemindFee(dto.getRemindFee1());

                    r1.setLevelId(l.getLevelId());
                    ratesMapper.insertSelective(r1);
                }

                r.setLevelId(l.getLevelId());
                ratesMapper.insertSelective(r);
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public LevelRateExt getById(short levelId) throws ServiceException {
        try {
            Level l = levelMapper.selectByPrimaryKey(levelId);
            if (l == null)
                throw new ServiceOperationException("会员级别不存在");

            LevelRateExt lr = new LevelRateExt();
            BeanUtils.copyProperties(lr, l);

            Criteria<Rates> criteria = Criteria.create(Rates.class);
            criteria.setPageSize(2);
            criteria.setCurrentPage(1);
            criteria.add(ExpressionFactory.eq("levelId", levelId));
            List<Rates> list = ratesMapper.selectByCriteria(criteria);
            for (Rates rate : list) {
                if (rate.getType() == 0)//PDL
                {
                    lr.setRrId(rate.getRrId());
                    lr.setRate(rate.getRate().multiply(new BigDecimal(1000)));
                    lr.setType(rate.getType());
                    lr.setLoanPayRate(rate.getLoanPayRate().multiply(new BigDecimal(1000)));
                    lr.setAccountManageRate(rate.getAccountManageRate().multiply(new BigDecimal(1000)));
                    lr.setConsultationRate(rate.getConsultationRate().multiply(new BigDecimal(1000)));
                    lr.setFirstLoanRate(rate.getFirstLoanRate().multiply(new BigDecimal(1000)));
                    lr.setLeastLoanRate(rate.getLeastLoanRate().multiply(new BigDecimal(1000)));
                    lr.setDelayRate(rate.getDelayRate().multiply(new BigDecimal(1000)));
                    lr.setDiscount(rate.getDiscount().multiply(new BigDecimal(100)));
                    lr.setWithdrawalsRate(rate.getWithdrawalsRate().multiply(new BigDecimal(1000)));
                    lr.setQuotaManageRate(rate.getQuotaManageRate().multiply(new BigDecimal(1000)));
                    lr.setRemindFee(rate.getRemindFee());
                }
                if (rate.getType() == 1)//现金分期
                {
                    lr.setRrId1(rate.getRrId());
                    lr.setRate1(rate.getRate().multiply(new BigDecimal(1000)));
                    lr.setType1(rate.getType());
                    lr.setLoanPayRate1(rate.getLoanPayRate().multiply(new BigDecimal(1000)));
                    lr.setAccountManageRate1(rate.getAccountManageRate().multiply(new BigDecimal(1000)));
                    lr.setConsultationRate1(rate.getConsultationRate().multiply(new BigDecimal(1000)));
                    lr.setFirstLoanRate1(rate.getFirstLoanRate().multiply(new BigDecimal(1000)));
                    lr.setLeastLoanRate1(rate.getLeastLoanRate().multiply(new BigDecimal(1000)));
                    lr.setDelayRate1(rate.getDelayRate().multiply(new BigDecimal(1000)));
                    lr.setDiscount1(rate.getDiscount().multiply(new BigDecimal(100)));
                    lr.setWithdrawalsRate1(rate.getWithdrawalsRate().multiply(new BigDecimal(1000)));
                    lr.setQuotaManageRate1(rate.getQuotaManageRate().multiply(new BigDecimal(1000)));
                    lr.setRemindFee1(rate.getRemindFee());
                }
            }
            return lr;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}