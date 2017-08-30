package cn.houhe.api.loan.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

/**
 * 实体类 - 表：loan_pay
 * @since 2017-05-05 09:36:25
 */
@Alias("LoanPay")
public class LoanPay implements Serializable {
	/** lp_id --  */
	private Integer lpId;

	/** loan_record_id -- 贷款id */
	private Integer loanRecordId;

	/** amount -- 放款金额 */
	@NotNull(message="loan.LoanPay.amount.NotNull")
	private BigDecimal amount;

	/** loan_limit -- 贷款额度 */
	@NotNull(message="loan.LoanPay.loanLimit.NotNull")
	private BigDecimal loanLimit;

	/** pay_platform -- 放款平台（微众银行等） */
	@Length(max=20,message="loan.LoanPay.payPlatform.Length")
	private String payPlatform;

	/** member_id -- 用户id */
	@NotNull(message="loan.LoanPay.memberId.NotNull")
	private Integer memberId;

	/** username -- 贷款人姓名 */
	@Length(max=50,message="loan.LoanPay.username.Length")
	private String username;

	/** user_mobile -- 贷款人手机 */
	@Length(max=50,message="loan.LoanPay.userMobile.Length")
	private String userMobile;

	/** receive_bank_cardno -- 收款银行账号 */
	@Length(max=50,message="loan.LoanPay.receiveBankCardno.Length")
	private String receiveBankCardno;

	/** receive_bank -- 收款银行 */
	@Length(max=50,message="loan.LoanPay.receiveBank.Length")
	private String receiveBank;

	/** status -- 打款状态（0待打款，1已打款，2打款中，3打款失败） */
	@NotNull(message="loan.LoanPay.status.NotNull")
	private Byte status;

	/** paytime -- 打款时间 */
	private Date paytime;

	/** number -- 还款号 */
	@Length(max=50,message="loan.LoanPay.number.Length")
	private String number;

	/** flownumber -- 第三方（易联）打款批次号 */
	@Length(max=50,message="loan.LoanPay.flownumber.Length")
	private String flownumber;

	/** createdon --  */
	@NotNull(message="loan.LoanPay.createdon.NotNull")
	private Date createdon;

	/** remark -- 备注 */
	@Length(max=30,message="loan.LoanPay.remark.Length")
	private String remark;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Integer getLpId() {
		return lpId;
	}

	/** 设置 */
	public void setLpId(Integer lpId) {
		this.lpId = lpId;
	}

	/** 获取贷款id */
	public Integer getLoanRecordId() {
		return loanRecordId;
	}

	/** 设置贷款id */
	public void setLoanRecordId(Integer loanRecordId) {
		this.loanRecordId = loanRecordId;
	}

	/** 获取放款金额 */
	public BigDecimal getAmount() {
		return amount;
	}

	/** 设置放款金额 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/** 获取贷款额度 */
	public BigDecimal getLoanLimit() {
		return loanLimit;
	}

	/** 设置贷款额度 */
	public void setLoanLimit(BigDecimal loanLimit) {
		this.loanLimit = loanLimit;
	}

	/** 获取放款平台（微众银行等） */
	public String getPayPlatform() {
		return payPlatform;
	}

	/** 设置放款平台（微众银行等） */
	public void setPayPlatform(String payPlatform) {
		this.payPlatform = payPlatform == null ? null : payPlatform.trim();
	}

	/** 获取用户id */
	public Integer getMemberId() {
		return memberId;
	}

	/** 设置用户id */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/** 获取贷款人姓名 */
	public String getUsername() {
		return username;
	}

	/** 设置贷款人姓名 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/** 获取贷款人手机 */
	public String getUserMobile() {
		return userMobile;
	}

	/** 设置贷款人手机 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile == null ? null : userMobile.trim();
	}

	/** 获取收款银行账号 */
	public String getReceiveBankCardno() {
		return receiveBankCardno;
	}

	/** 设置收款银行账号 */
	public void setReceiveBankCardno(String receiveBankCardno) {
		this.receiveBankCardno = receiveBankCardno == null ? null : receiveBankCardno.trim();
	}

	/** 获取收款银行 */
	public String getReceiveBank() {
		return receiveBank;
	}

	/** 设置收款银行 */
	public void setReceiveBank(String receiveBank) {
		this.receiveBank = receiveBank == null ? null : receiveBank.trim();
	}

	/** 获取打款状态（0待打款，1已打款，2打款中，3打款失败） */
	public Byte getStatus() {
		return status;
	}

	/** 设置打款状态（0待打款，1已打款，2打款中，3打款失败） */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/** 获取打款时间 */
	public Date getPaytime() {
		return paytime;
	}

	/** 设置打款时间 */
	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}

	/** 获取还款号 */
	public String getNumber() {
		return number;
	}

	/** 设置还款号 */
	public void setNumber(String number) {
		this.number = number == null ? null : number.trim();
	}

	/** 获取第三方（易联）打款批次号 */
	public String getFlownumber() {
		return flownumber;
	}

	/** 设置第三方（易联）打款批次号 */
	public void setFlownumber(String flownumber) {
		this.flownumber = flownumber == null ? null : flownumber.trim();
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
	
	 * @since 2017-05-05 09:36:25
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
		LoanPay other = (LoanPay) that;
		return (this.getLpId() == null ? other.getLpId() == null : this.getLpId().equals(other.getLpId()))
			&& (this.getLoanRecordId() == null ? other.getLoanRecordId() == null : this.getLoanRecordId().equals(other.getLoanRecordId()))
			&& (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
			&& (this.getLoanLimit() == null ? other.getLoanLimit() == null : this.getLoanLimit().equals(other.getLoanLimit()))
			&& (this.getPayPlatform() == null ? other.getPayPlatform() == null : this.getPayPlatform().equals(other.getPayPlatform()))
			&& (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
			&& (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
			&& (this.getUserMobile() == null ? other.getUserMobile() == null : this.getUserMobile().equals(other.getUserMobile()))
			&& (this.getReceiveBankCardno() == null ? other.getReceiveBankCardno() == null : this.getReceiveBankCardno().equals(other.getReceiveBankCardno()))
			&& (this.getReceiveBank() == null ? other.getReceiveBank() == null : this.getReceiveBank().equals(other.getReceiveBank()))
			&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
			&& (this.getPaytime() == null ? other.getPaytime() == null : this.getPaytime().equals(other.getPaytime()))
			&& (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
			&& (this.getFlownumber() == null ? other.getFlownumber() == null : this.getFlownumber().equals(other.getFlownumber()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()))
			&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
	}

	/**
	
	 * @since 2017-05-05 09:36:25
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getLpId() == null) ? 0 : getLpId().hashCode());
		result = prime * result + ((getLoanRecordId() == null) ? 0 : getLoanRecordId().hashCode());
		result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
		result = prime * result + ((getLoanLimit() == null) ? 0 : getLoanLimit().hashCode());
		result = prime * result + ((getPayPlatform() == null) ? 0 : getPayPlatform().hashCode());
		result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
		result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
		result = prime * result + ((getUserMobile() == null) ? 0 : getUserMobile().hashCode());
		result = prime * result + ((getReceiveBankCardno() == null) ? 0 : getReceiveBankCardno().hashCode());
		result = prime * result + ((getReceiveBank() == null) ? 0 : getReceiveBank().hashCode());
		result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
		result = prime * result + ((getPaytime() == null) ? 0 : getPaytime().hashCode());
		result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
		result = prime * result + ((getFlownumber() == null) ? 0 : getFlownumber().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		return result;
	}
}