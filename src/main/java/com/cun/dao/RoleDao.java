package com.cun.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cun.entity.Role;

public interface RoleDao extends JpaRepository<Role, Integer>{
	
	@Query(value="select r.* from t_user u,t_user_role ur,t_role r where u.id=ur.role_id and ur.role_id=r.id and u.user_name=?1",nativeQuery=true)
	List<Role> getRolesByUserName(String userName);

}
