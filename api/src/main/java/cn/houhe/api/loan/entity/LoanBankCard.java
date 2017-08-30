package cn.houhe.api.loan.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

/**
 * 实体类 - 表：loan_bank_card
 * @since 2017-05-05 16:09:35
 */
@Alias("LoanBankCard")
public class LoanBankCard implements Serializable {
	/** lbc_id --  */
	private Integer lbcId;

	/** loan_record_id -- 贷款id */
	@NotNull(message="loan.LoanBankCard.loanRecordId.NotNull")
	private Integer loanRecordId;

	/** repay_platform -- 贷款平台（微众银行等） */
	@Length(max=20,message="loan.LoanBankCard.repayPlatform.Length")
	private String repayPlatform;

	/** receive_bank -- 收款银行 */
	@Length(max=50,message="loan.LoanBankCard.receiveBank.Length")
	private String receiveBank;

	/** receive_bank_cardno -- 收款银行账号 */
	@Length(max=50,message="loan.LoanBankCard.receiveBankCardno.Length")
	private String receiveBankCardno;

	/** receive_name -- 收款人姓名 */
	@Length(max=50,message="loan.LoanBankCard.receiveName.Length")
	private String receiveName;

	/** repay_bank_cardno -- 还款银行卡号 */
	@Length(max=50,message="loan.LoanBankCard.repayBankCardno.Length")
	private String repayBankCardno;

	/** repay_bank -- 还款银行 */
	@Length(max=50,message="loan.LoanBankCard.repayBank.Length")
	private String repayBank;

	/** repay_name -- 还款人姓名 */
	@Length(max=50,message="loan.LoanBankCard.repayName.Length")
	private String repayName;

	/** createdon --  */
	@NotNull(message="loan.LoanBankCard.createdon.NotNull")
	private Date createdon;

	/** remark -- 备注 */
	@Length(max=30,message="loan.LoanBankCard.remark.Length")
	private String remark;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Integer getLbcId() {
		return lbcId;
	}

	/** 设置 */
	public void setLbcId(Integer lbcId) {
		this.lbcId = lbcId;
	}

	/** 获取贷款id */
	public Integer getLoanRecordId() {
		return loanRecordId;
	}

	/** 设置贷款id */
	public void setLoanRecordId(Integer loanRecordId) {
		this.loanRecordId = loanRecordId;
	}

	/** 获取贷款平台（微众银行等） */
	public String getRepayPlatform() {
		return repayPlatform;
	}

	/** 设置贷款平台（微众银行等） */
	public void setRepayPlatform(String repayPlatform) {
		this.repayPlatform = repayPlatform == null ? null : repayPlatform.trim();
	}

	/** 获取收款银行 */
	public String getReceiveBank() {
		return receiveBank;
	}

	/** 设置收款银行 */
	public void setReceiveBank(String receiveBank) {
		this.receiveBank = receiveBank == null ? null : receiveBank.trim();
	}

	/** 获取收款银行账号 */
	public String getReceiveBankCardno() {
		return receiveBankCardno;
	}

	/** 设置收款银行账号 */
	public void setReceiveBankCardno(String receiveBankCardno) {
		this.receiveBankCardno = receiveBankCardno == null ? null : receiveBankCardno.trim();
	}

	/** 获取收款人姓名 */
	public String getReceiveName() {
		return receiveName;
	}

	/** 设置收款人姓名 */
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName == null ? null : receiveName.trim();
	}

	/** 获取还款银行卡号 */
	public String getRepayBankCardno() {
		return repayBankCardno;
	}

	/** 设置还款银行卡号 */
	public void setRepayBankCardno(String repayBankCardno) {
		this.repayBankCardno = repayBankCardno == null ? null : repayBankCardno.trim();
	}

	/** 获取还款银行 */
	public String getRepayBank() {
		return repayBank;
	}

	/** 设置还款银行 */
	public void setRepayBank(String repayBank) {
		this.repayBank = repayBank == null ? null : repayBank.trim();
	}

	/** 获取还款人姓名 */
	public String getRepayName() {
		return repayName;
	}

	/** 设置还款人姓名 */
	public void setRepayName(String repayName) {
		this.repayName = repayName == null ? null : repayName.trim();
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
	
	 * @since 2017-05-05 16:09:35
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
		LoanBankCard other = (LoanBankCard) that;
		return (this.getLbcId() == null ? other.getLbcId() == null : this.getLbcId().equals(other.getLbcId()))
			&& (this.getLoanRecordId() == null ? other.getLoanRecordId() == null : this.getLoanRecordId().equals(other.getLoanRecordId()))
			&& (this.getRepayPlatform() == null ? other.getRepayPlatform() == null : this.getRepayPlatform().equals(other.getRepayPlatform()))
			&& (this.getReceiveBank() == null ? other.getReceiveBank() == null : this.getReceiveBank().equals(other.getReceiveBank()))
			&& (this.getReceiveBankCardno() == null ? other.getReceiveBankCardno() == null : this.getReceiveBankCardno().equals(other.getReceiveBankCardno()))
			&& (this.getReceiveName() == null ? other.getReceiveName() == null : this.getReceiveName().equals(other.getReceiveName()))
			&& (this.getRepayBankCardno() == null ? other.getRepayBankCardno() == null : this.getRepayBankCardno().equals(other.getRepayBankCardno()))
			&& (this.getRepayBank() == null ? other.getRepayBank() == null : this.getRepayBank().equals(other.getRepayBank()))
			&& (this.getRepayName() == null ? other.getRepayName() == null : this.getRepayName().equals(other.getRepayName()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()))
			&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
	}

	/**
	
	 * @since 2017-05-05 16:09:35
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getLbcId() == null) ? 0 : getLbcId().hashCode());
		result = prime * result + ((getLoanRecordId() == null) ? 0 : getLoanRecordId().hashCode());
		result = prime * result + ((getRepayPlatform() == null) ? 0 : getRepayPlatform().hashCode());
		result = prime * result + ((getReceiveBank() == null) ? 0 : getReceiveBank().hashCode());
		result = prime * result + ((getReceiveBankCardno() == null) ? 0 : getReceiveBankCardno().hashCode());
		result = prime * result + ((getReceiveName() == null) ? 0 : getReceiveName().hashCode());
		result = prime * result + ((getRepayBankCardno() == null) ? 0 : getRepayBankCardno().hashCode());
		result = prime * result + ((getRepayBank() == null) ? 0 : getRepayBank().hashCode());
		result = prime * result + ((getRepayName() == null) ? 0 : getRepayName().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		return result;
	}
}