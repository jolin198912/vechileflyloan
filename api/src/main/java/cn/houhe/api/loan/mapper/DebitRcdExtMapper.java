package cn.houhe.api.loan.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.loan.entity.DebitRcd;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：debit_rcd
 * @since 2017-05-05 09:44:17
 */
@Repository
public interface DebitRcdExtMapper {

	/**
	 * 插入还款记录
	 * @since 2017-05-05 16:56:38
	 */
	int insertDebitRcd(DebitRcd record);

	/**
	 * 获取某个贷款的最后一期期数
	 * @param id
	 * @return
	 */
	String getLastItem(@Param("loanid") Integer id);
}