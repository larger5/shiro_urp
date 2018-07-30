package com.cun.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_user_role")
public class UserRole {

	@Id
	@GeneratedValue
	private Integer id; // 编号

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user; // 用户

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role; // 角色

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserRole() {
		super();
	}

}
