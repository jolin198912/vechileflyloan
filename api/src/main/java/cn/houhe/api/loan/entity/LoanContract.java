package cn.houhe.api.loan.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

/**
 * 实体类 - 表：loan_contract
 * @since 2017-05-10 12:16:19
 */
@Alias("LoanContract")
public class LoanContract implements Serializable {
	/** lc_id --  */
	private Integer lcId;

	/** loan_record_id -- 贷款id */
	private Integer loanRecordId;

	/** creditinfo_id -- 授信id */
	private Integer creditinfoId;

	/** contract_name -- 合同名称 */
	@Length(max=200,message="loan.LoanContract.contractName.Length")
	private String contractName;

	/** type -- 合同类型0注册协议1额度借款合同2征信查询授权书3委托代收授权书 */
	@NotNull(message="loan.LoanContract.type.NotNull")
	private Byte type;

	/** contract_number -- 合同编号 */
	@Length(max=30,message="loan.LoanContract.contractNumber.Length")
	private String contractNumber;

	/** contract_preview_url -- 合同预览路径 */
	@Length(max=500,message="loan.LoanContract.contractPreviewUrl.Length")
	private String contractPreviewUrl;

	/** contract_file_url -- 合同文件路径 */
	@Length(max=500,message="loan.LoanContract.contractFileUrl.Length")
	private String contractFileUrl;

	/** createdon --  */
	@NotNull(message="loan.LoanContract.createdon.NotNull")
	private Date createdon;

	/** remark -- 备注 */
	@Length(max=30,message="loan.LoanContract.remark.Length")
	private String remark;

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

	/** 获取授信id */
	public Integer getCreditinfoId() {
		return creditinfoId;
	}

	/** 设置授信id */
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

	/** 获取合同类型0注册协议1额度借款合同2征信查询授权书3委托代收授权书 */
	public Byte getType() {
		return type;
	}

	/** 设置合同类型0注册协议1额度借款合同2征信查询授权书3委托代收授权书 */
	public void setType(Byte type) {
		this.type = type;
	}

	/** 获取合同编号 */
	public String getContractNumber() {
		return contractNumber;
	}

	/** 设置合同编号 */
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber == null ? null : contractNumber.trim();
	}

	/** 获取合同预览路径 */
	public String getContractPreviewUrl() {
		return contractPreviewUrl;
	}

	/** 设置合同预览路径 */
	public void setContractPreviewUrl(String contractPreviewUrl) {
		this.contractPreviewUrl = contractPreviewUrl == null ? null : contractPreviewUrl.trim();
	}

	/** 获取合同文件路径 */
	public String getContractFileUrl() {
		return contractFileUrl;
	}

	/** 设置合同文件路径 */
	public void setContractFileUrl(String contractFileUrl) {
		this.contractFileUrl = contractFileUrl == null ? null : contractFileUrl.trim();
	}

	/** 获取 */
	public Date getCreatedon() {
		return createdon;
	}

	/** 设置 */
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	/** 获取备注 */
	public String getRemark() {
		return remark;
	}

	/** 设置备注 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	
	 * @since 2017-05-10 12:16:19
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
		LoanContract other = (LoanContract) that;
		return (this.getLcId() == null ? other.getLcId() == null : this.getLcId().equals(other.getLcId()))
			&& (this.getLoanRecordId() == null ? other.getLoanRecordId() == null : this.getLoanRecordId().equals(other.getLoanRecordId()))
			&& (this.getCreditinfoId() == null ? other.getCreditinfoId() == null : this.getCreditinfoId().equals(other.getCreditinfoId()))
			&& (this.getContractName() == null ? other.getContractName() == null : this.getContractName().equals(other.getContractName()))
			&& (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
			&& (this.getContractNumber() == null ? other.getContractNumber() == null : this.getContractNumber().equals(other.getContractNumber()))
			&& (this.getContractPreviewUrl() == null ? other.getContractPreviewUrl() == null : this.getContractPreviewUrl().equals(other.getContractPreviewUrl()))
			&& (this.getContractFileUrl() == null ? other.getContractFileUrl() == null : this.getContractFileUrl().equals(other.getContractFileUrl()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()))
			&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
	}

	/**
	
	 * @since 2017-05-10 12:16:19
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getLcId() == null) ? 0 : getLcId().hashCode());
		result = prime * result + ((getLoanRecordId() == null) ? 0 : getLoanRecordId().hashCode());
		result = prime * result + ((getCreditinfoId() == null) ? 0 : getCreditinfoId().hashCode());
		result = prime * result + ((getContractName() == null) ? 0 : getContractName().hashCode());
		result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
		result = prime * result + ((getContractNumber() == null) ? 0 : getContractNumber().hashCode());
		result = prime * result + ((getContractPreviewUrl() == null) ? 0 : getContractPreviewUrl().hashCode());
		result = prime * result + ((getContractFileUrl() == null) ? 0 : getContractFileUrl().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		return result;
	}
}