package cn.houhe.api.config.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

/**
 * 实体类 - 表：comm_data_config
 * @since 2017-04-13 11:30:10
 */
@Alias("CommDataConfig")
public class CommDataConfig implements Serializable {
	/** menu_id -- 主键id */
	private Short menuId;

	/** menu_type -- 菜单类型（0：文化程度；1：单位性质） */
	@NotNull(message="config.CommDataConfig.menuType.NotNull")
	private Byte menuType;

	/** menu_item -- 菜单项 */
	@Length(max=20,message="config.CommDataConfig.menuItem.Length")
	private String menuItem;

	/** sort --  */
	@NotNull(message="config.CommDataConfig.sort.NotNull")
	private Short sort;

	/** value -- 对应的值 */
	@NotNull(message="config.CommDataConfig.value.NotNull")
	private Short value;

	/** createdon -- 创建时间 */
	@NotNull(message="config.CommDataConfig.createdon.NotNull")
	private Date createdon;

	private static final long serialVersionUID = 1L;

	/** 获取主键id */
	public Short getMenuId() {
		return menuId;
	}

	/** 设置主键id */
	public void setMenuId(Short menuId) {
		this.menuId = menuId;
	}

	/** 获取菜单类型（0：文化程度；1：单位性质） */
	public Byte getMenuType() {
		return menuType;
	}

	/** 设置菜单类型（0：文化程度；1：单位性质） */
	public void setMenuType(Byte menuType) {
		this.menuType = menuType;
	}

	/** 获取菜单项 */
	public String getMenuItem() {
		return menuItem;
	}

	/** 设置菜单项 */
	public void setMenuItem(String menuItem) {
		this.menuItem = menuItem == null ? null : menuItem.trim();
	}

	/** 获取 */
	public Short getSort() {
		return sort;
	}

	/** 设置 */
	public void setSort(Short sort) {
		this.sort = sort;
	}

	/** 获取对应的值 */
	public Short getValue() {
		return value;
	}

	/** 设置对应的值 */
	public void setValue(Short value) {
		this.value = value;
	}

	/** 获取创建时间 */
	public Date getCreatedon() {
		return createdon;
	}

	/** 设置创建时间 */
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	/**
	
	 * @since 2017-04-13 11:30:10
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
		CommDataConfig other = (CommDataConfig) that;
		return (this.getMenuId() == null ? other.getMenuId() == null : this.getMenuId().equals(other.getMenuId()))
			&& (this.getMenuType() == null ? other.getMenuType() == null : this.getMenuType().equals(other.getMenuType()))
			&& (this.getMenuItem() == null ? other.getMenuItem() == null : this.getMenuItem().equals(other.getMenuItem()))
			&& (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
			&& (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()));
	}

	/**
	
	 * @since 2017-04-13 11:30:10
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getMenuId() == null) ? 0 : getMenuId().hashCode());
		result = prime * result + ((getMenuType() == null) ? 0 : getMenuType().hashCode());
		result = prime * result + ((getMenuItem() == null) ? 0 : getMenuItem().hashCode());
		result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
		result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		return result;
	}
}