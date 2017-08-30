package cn.houhe.api.user.web.bo;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 实体类 - 表：verify_third_query
 * @since 2017-06-06 14:31:52
 */
@Alias("VerifyThirdQueryDto")
public class VerifyThirdQueryDto implements Serializable {
	/** id --  */
	private Integer id;

	/** real_name -- 真实姓名 */
	private String realName;

	/** idcard_no -- 身份证号 */
	private String idcardNo;

	/** mobile -- 手机号 */
	private String mobile;

	/*userId -- 系统用户id*/
	private Integer userId;

	private Integer page=1;

	private Integer rows=20;


	/** 获取 */
	public Integer getId() {
		return id;
	}

	/** 设置 */
	public void setId(Integer id) {
		this.id = id;
	}

	/** 获取真实姓名 */
	public String getRealName() {
		return realName;
	}

	/** 设置真实姓名 */
	public void setRealName(String realName) {
		this.realName = realName == null ? null : realName.trim();
	}

	/** 获取身份证号 */
	public String getIdcardNo() {
		return idcardNo;
	}

	/** 设置身份证号 */
	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo == null ? null : idcardNo.trim();
	}

	/** 获取手机号 */
	public String getMobile() {
		return mobile;
	}

	/** 设置手机号 */
	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}
}