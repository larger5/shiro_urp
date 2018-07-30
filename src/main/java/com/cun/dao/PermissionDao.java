package com.cun.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cun.entity.Permission;

public interface PermissionDao extends JpaRepository<Permission, Integer>{
	
	@Query(nativeQuery=true,value="select p.* from t_user u,t_user_role ur,t_role_permission rp,t_permission p where u.id=ur.user_id and ur.role_id=rp.role_id and rp.permission_id=p.id and u.user_name=?1")
	List<Permission> getPermissionsByUserName(String userName);

}
