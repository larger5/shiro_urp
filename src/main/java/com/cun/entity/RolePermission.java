package com.cun.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_role_permission")
public class RolePermission {

	@Id
	@GeneratedValue
	private Integer id; // 编号

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role; // 角色

	@ManyToOne
	@JoinColumn(name = "permission_id")
	private Permission menu; // 菜单

	@Column(length = 1000)
	private String remarks; // 备注
	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Permission getMenu() {
		return menu;
	}

	public void setMenu(Permission menu) {
		this.menu = menu;
	}

	public RolePermission() {
		super();
	}

}
