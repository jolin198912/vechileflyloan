package cn.houhe.api.user.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 实体类 - 鐢ㄦ埛琛�：userinfo
 * @since 2017-03-30 13:50:02
 */
@Alias("Userinfo")
public class Userinfo implements Serializable {
	/** usid -- 主键id */
	private Integer usid;

	/** username -- 用户名 */
	@NotEmpty(message="user.Userinfo.username.NotEmpty")
	@Length(max=50,message="user.Userinfo.username.Length")
	private String username;

	/** password -- 密码 */
	@NotEmpty(message="user.Userinfo.password.NotEmpty")
	@Length(max=50,message="user.Userinfo.password.Length")
	private String password;

	/** name -- 姓名 */
	@NotEmpty(message="user.Userinfo.name.NotEmpty")
	@Length(max=50,message="user.Userinfo.name.Length")
	private String name;

	/** phone -- 手机号 */
	@NotEmpty(message="user.Userinfo.phone.NotEmpty")
	@Length(max=20,message="user.Userinfo.phone.Length")
	private String phone;

	/** department -- 部门 */
	@NotEmpty(message="user.Userinfo.department.NotEmpty")
	@Length(max=50,message="user.Userinfo.department.Length")
	private String department;

	/** is_disabled -- 是否禁用（启用0，禁用1） */
	@NotNull(message="user.Userinfo.isDisabled.NotNull")
	private Byte isDisabled;

	/** createdon -- 创建时间 */
	@NotNull(message="user.Userinfo.createdon.NotNull")
	private Date createdon;

	/** createdby -- 创建人 */
	@NotEmpty(message="user.Userinfo.createdby.NotEmpty")
	@Length(max=50,message="user.Userinfo.createdby.Length")
	private String createdby;

	/** modifiedon -- 修改时间 */
	private Date modifiedon;

	/** modifiedby -- 修改人 */
	@Length(max=50,message="user.Userinfo.modifiedby.Length")
	private String modifiedby;

	/** usertypeid --  */
	private Short usertypeid;

	/** efficient_level -- 催收级别（0，M1;1，M2;2，M3;3，M3+） */
	private Byte efficientLevel;

	/** is_boss -- 支持登录老板端APP（0，否;1，是） */
	@NotNull(message="user.Userinfo.isBoss.NotNull")
	private Byte isBoss;

	private static final long serialVersionUID = 1L;

	/** 获取主键id */
	public Integer getUsid() {
		return usid;
	}

	/** 设置主键id */
	public void setUsid(Integer usid) {
		this.usid = usid;
	}

	/** 获取用户名 */
	public String getUsername() {
		return username;
	}

	/** 设置用户名 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/** 获取密码 */
	public String getPassword() {
		return password;
	}

	/** 设置密码 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	/** 获取姓名 */
	public String getName() {
		return name;
	}

	/** 设置姓名 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/** 获取手机号 */
	public String getPhone() {
		return phone;
	}

	/** 设置手机号 */
	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	/** 获取部门 */
	public String getDepartment() {
		return department;
	}

	/** 设置部门 */
	public void setDepartment(String department) {
		this.department = department == null ? null : department.trim();
	}

	/** 获取是否禁用（启用0，禁用1） */
	public Byte getIsDisabled() {
		return isDisabled;
	}

	/** 设置是否禁用（启用0，禁用1） */
	public void setIsDisabled(Byte isDisabled) {
		this.isDisabled = isDisabled;
	}

	/** 获取创建时间 */
	public Date getCreatedon() {
		return createdon;
	}

	/** 设置创建时间 */
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	/** 获取创建人 */
	public String getCreatedby() {
		return createdby;
	}

	/** 设置创建人 */
	public void setCreatedby(String createdby) {
		this.createdby = createdby == null ? null : createdby.trim();
	}

	/** 获取修改时间 */
	public Date getModifiedon() {
		return modifiedon;
	}

	/** 设置修改时间 */
	public void setModifiedon(Date modifiedon) {
		this.modifiedon = modifiedon;
	}

	/** 获取修改人 */
	public String getModifiedby() {
		return modifiedby;
	}

	/** 设置修改人 */
	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby == null ? null : modifiedby.trim();
	}

	/** 获取 */
	public Short getUsertypeid() {
		return usertypeid;
	}

	/** 设置 */
	public void setUsertypeid(Short usertypeid) {
		this.usertypeid = usertypeid;
	}

	/** 获取催收级别（0，M1;1，M2;2，M3;3，M3+） */
	public Byte getEfficientLevel() {
		return efficientLevel;
	}

	/** 设置催收级别（0，M1;1，M2;2，M3;3，M3+） */
	public void setEfficientLevel(Byte efficientLevel) {
		this.efficientLevel = efficientLevel;
	}

	/** 获取支持登录老板端APP（0，否;1，是） */
	public Byte getIsBoss() {
		return isBoss;
	}

	/** 设置支持登录老板端APP（0，否;1，是） */
	public void setIsBoss(Byte isBoss) {
		this.isBoss = isBoss;
	}

	/**
	
	 * @since 2017-03-30 13:50:02
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
		Userinfo other = (Userinfo) that;
		return (this.getUsid() == null ? other.getUsid() == null : this.getUsid().equals(other.getUsid()))
			&& (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
			&& (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
			&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
			&& (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
			&& (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
			&& (this.getIsDisabled() == null ? other.getIsDisabled() == null : this.getIsDisabled().equals(other.getIsDisabled()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()))
			&& (this.getCreatedby() == null ? other.getCreatedby() == null : this.getCreatedby().equals(other.getCreatedby()))
			&& (this.getModifiedon() == null ? other.getModifiedon() == null : this.getModifiedon().equals(other.getModifiedon()))
			&& (this.getModifiedby() == null ? other.getModifiedby() == null : this.getModifiedby().equals(other.getModifiedby()))
			&& (this.getUsertypeid() == null ? other.getUsertypeid() == null : this.getUsertypeid().equals(other.getUsertypeid()))
			&& (this.getEfficientLevel() == null ? other.getEfficientLevel() == null : this.getEfficientLevel().equals(other.getEfficientLevel()))
			&& (this.getIsBoss() == null ? other.getIsBoss() == null : this.getIsBoss().equals(other.getIsBoss()));
	}

	/**
	
	 * @since 2017-03-30 13:50:02
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getUsid() == null) ? 0 : getUsid().hashCode());
		result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
		result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
		result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
		result = prime * result + ((getIsDisabled() == null) ? 0 : getIsDisabled().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getCreatedby() == null) ? 0 : getCreatedby().hashCode());
		result = prime * result + ((getModifiedon() == null) ? 0 : getModifiedon().hashCode());
		result = prime * result + ((getModifiedby() == null) ? 0 : getModifiedby().hashCode());
		result = prime * result + ((getUsertypeid() == null) ? 0 : getUsertypeid().hashCode());
		result = prime * result + ((getEfficientLevel() == null) ? 0 : getEfficientLevel().hashCode());
		result = prime * result + ((getIsBoss() == null) ? 0 : getIsBoss().hashCode());
		return result;
	}
}