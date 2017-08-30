package cn.houhe.api.loan.mapper;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.houhe.api.loan.entity.LoanRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 璐锋璁板綍：loan_record
 * @since 2017-05-05 16:27:57
 */
@Repository
public interface LoanRecordMapper {
	/**
	 * 按主键删除
	 * @since 2017-05-05 16:27:57
	 */
	int deleteByPrimaryKey(Integer loanId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-05-05 16:27:57
	 */
	int insert(LoanRecord record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-05-05 16:27:57
	 */
	int insertSelective(LoanRecord record);

	/**
	 * 按主键查询
	 * @since 2017-05-05 16:27:57
	 */
	LoanRecord selectByPrimaryKey(Integer loanId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-05-05 16:27:57
	 */
	int updateByPrimaryKeySelective(LoanRecord record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-05-05 16:27:57
	 */
	int updateByPrimaryKey(LoanRecord record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-05-05 16:27:57
	 */
	List<LoanRecord> selectByCriteria(Criteria<LoanRecord> criteria);
}