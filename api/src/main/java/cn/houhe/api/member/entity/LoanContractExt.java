package cn.houhe.api.member.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 实体类 - 表：loan_contract
 * @since 2017-04-07 17:08:11
 */
@Alias("LoanContractExt")
public class LoanContractExt implements Serializable {
	/** lc_id --  */
	private Integer lcId;

	/** loan_record_id -- 贷款id */
	private Integer loanRecordId;

	/** creditinfo_id -- 征信id */
	private Integer creditinfoId;

	/** contract_name -- 合同名称 */
	private String contractName;

	/** contract_file_url -- 合同文件路径 */
	private String contractFileUrl;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Integer getLcId() {
		return lcId;
	}

	/** 设置 */
	public void setLcId(Integer lcId) {
		this.lcId = lcId;
	}

	/** 获取贷款id */
	public Integer getLoanRecordId() {
		return loanRecordId;
	}

	/** 设置贷款id */
	public void setLoanRecordId(Integer loanRecordId) {
		this.loanRecordId = loanRecordId;
	}

	/** 获取征信id */
	public Integer getCreditinfoId() {
		return creditinfoId;
	}

	/** 设置征信id */
	public void setCreditinfoId(Integer creditinfoId) {
		this.creditinfoId = creditinfoId;
	}

	/** 获取合同名称 */
	public String getContractName() {
		return contractName;
	}

	/** 设置合同名称 */
	public void setContractName(String contractName) {
		this.contractName = contractName == null ? null : contractName.trim();
	}

	/** 获取合同文件路径 */
	public String getContractFileUrl() {
		return contractFileUrl;
	}

	/** 设置合同文件路径 */
	public void setContractFileUrl(String contractFileUrl) {
		this.contractFileUrl = contractFileUrl == null ? null : contractFileUrl.trim();
	}

	/**
	
	 * @since 2017-04-07 17:08:11
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		LoanContractExt other = (LoanContractExt) that;
		return (this.getLcId() == null ? other.getLcId() == null : this.getLcId().equals(other.getLcId()))
			&& (this.getLoanRecordId() == null ? other.getLoanRecordId() == null : this.getLoanRecordId().equals(other.getLoanRecordId()))
			&& (this.getCreditinfoId() == null ? other.getCreditinfoId() == null : this.getCreditinfoId().equals(other.getCreditinfoId()))
			&& (this.getContractName() == null ? other.getContractName() == null : this.getContractName().equals(other.getContractName()))
			&& (this.getContractFileUrl() == null ? other.getContractFileUrl() == null : this.getContractFileUrl().equals(other.getContractFileUrl()));
	}

	/**
	
	 * @since 2017-04-07 17:08:11
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getLcId() == null) ? 0 : getLcId().hashCode());
		result = prime * result + ((getLoanRecordId() == null) ? 0 : getLoanRecordId().hashCode());
		result = prime * result + ((getCreditinfoId() == null) ? 0 : getCreditinfoId().hashCode());
		result = prime * result + ((getContractName() == null) ? 0 : getContractName().hashCode());
		result = prime * result + ((getContractFileUrl() == null) ? 0 : getContractFileUrl().hashCode());
		return result;
	}
}