package cn.houhe.api.loan.web.bo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class CreditChildrenDto implements Serializable {

	/** birth -- 出生年月 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birth;

	/** sex -- 性别0男1女 */
	private Byte sex;

	private static final long serialVersionUID = 1L;


	/** 获取出生年月 */
	public Date getBirth() {
		return birth;
	}

	/** 设置出生年月 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	/** 获取性别0男1女 */
	public Byte getSex() {
		return sex;
	}

	/** 设置性别0男1女 */
	public void setSex(Byte sex) {
		this.sex = sex;
	}

}