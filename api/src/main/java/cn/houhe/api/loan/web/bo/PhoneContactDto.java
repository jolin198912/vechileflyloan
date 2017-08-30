package cn.houhe.api.loan.web.bo;

import java.io.Serializable;

public class PhoneContactDto implements Serializable {

	/** name -- 联系人名字 */
	private String name;

	/** mobile -- 手机号码 */
	private String mobile;

	/** relation_type -- 0父母1配偶2兄弟姐妹3朋友4同事5其他 */
	private Byte relationType;


	private static final long serialVersionUID = 1L;


	/** 获取联系人名字 */
	public String getName() {
		return name;
	}

	/** 设置联系人名字 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/** 获取手机号码 */
	public String getMobile() {
		return mobile;
	}

	/** 设置手机号码 */
	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}


	/** 获取0父母1配偶2兄弟姐妹3朋友4同事5其他 */
	public Byte getRelationType() {
		return relationType;
	}

	/** 设置0父母1配偶2兄弟姐妹3朋友4同事5其他 */
	public void setRelationType(Byte relationType) {
		this.relationType = relationType;
	}

}