package com.cun.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cun.entity.User;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping("/user")
public class UserController {

	@PostMapping("/login")
	public Map<String, Object> login(@Valid User user, BindingResult bindingResult, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();

		// 1、JSR303
		if (bindingResult.hasErrors()) {
			map.put("success", false);
			map.put("errorInfo", bindingResult.getFieldError().getDefaultMessage());
			return map;
		}

		// 2、Shiro
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
		try {
			subject.login(token);
			map.put("success", true);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("errorInfo", "用户名或者密码错误!");
			return map;
		}
	}

	@RequiresPermissions({"select"}) //没有的话 AuthorizationException
	@PostMapping("/select")
	public Map<String, Object> selectPermission() {
		System.out.println("select");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("msg", "当前角色有查看的权力");
		return map;
	}
	
	@RequiresPermissions({"insert"}) //没有的话 AuthorizationException
	@PostMapping("/insert")
	public Map<String, Object> insertPermission() {
		System.out.println("insert");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("msg", "当前角色有增加的权力");
		return map;
	}

	@RequiresPermissions({"update"}) //没有的话 AuthorizationException
	@PostMapping("/update")
	public Map<String, Object> updatePermission() {
		System.out.println("update");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("msg", "当前角色有更新的权力");
		return map;
	}

	@RequiresPermissions({"delete"}) //没有的话 AuthorizationException
	@PostMapping("/delete")
	public Map<String, Object> deletePermission() {
		System.out.println("delete");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("msg", "当前角色有删除的权力");
		return map;
	}
	
	@RequiresRoles({"vip"}) //没有的话 AuthorizationException
	@PostMapping("/vip")
	public Map<String, Object> vipRole() {
		System.out.println("vip");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("msg", "当前用户具有 vip 角色");
		return map;
	}
	
	@RequiresRoles({"ip"}) //没有的话 AuthorizationException
	@PostMapping("/ip")
	public Map<String, Object> ipRole() {
		System.out.println("ip");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("msg", "当前用户具有 ip 角色");
		return map;
	}
	
	@RequiresRoles({"p"}) //没有的话 AuthorizationException
	@PostMapping("/p")
	public Map<String, Object> pRole() {
		System.out.println("vip");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("msg", "当前用户具有 p 角色");
		return map;
	}
}
