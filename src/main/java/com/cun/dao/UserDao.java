package com.cun.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cun.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	/**
	 * 登录的时候，根据用户名获取用户实体
	 * @param userName
	 * @return
	 */
	@Query(value="select * from t_user where user_name=?1",nativeQuery=true)
	public User getUserByUserName(String userName);
}
