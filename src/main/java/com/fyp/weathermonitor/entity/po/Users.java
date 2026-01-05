package com.fyp.weathermonitor.entity.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import com.fyp.weathermonitor.entity.enums.DateTimePatternEnum;
import com.fyp.weathermonitor.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;


/**
 * 
 */
public class Users implements Serializable {


	/**
	 * 
	 */
	private Long id;

	/**
	 * 登录用户名
	 */
	private String username;

	/**
	 * bcrypt 哈希值
	 */
	private String passwordHash;

	/**
	 * 
	 */
	private String fullName;

	/**
	 * 用户角色
	 */
	private String role;

	/**
	 * 
	 */
	private Integer isActive;

	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdAt;

	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updatedAt;


	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return this.username;
	}

	public void setPasswordHash(String passwordHash){
		this.passwordHash = passwordHash;
	}

	public String getPasswordHash(){
		return this.passwordHash;
	}

	public void setFullName(String fullName){
		this.fullName = fullName;
	}

	public String getFullName(){
		return this.fullName;
	}

	public void setRole(String role){
		this.role = role;
	}

	public String getRole(){
		return this.role;
	}

	public void setIsActive(Integer isActive){
		this.isActive = isActive;
	}

	public Integer getIsActive(){
		return this.isActive;
	}

	public void setCreatedAt(Date createdAt){
		this.createdAt = createdAt;
	}

	public Date getCreatedAt(){
		return this.createdAt;
	}

	public void setUpdatedAt(Date updatedAt){
		this.updatedAt = updatedAt;
	}

	public Date getUpdatedAt(){
		return this.updatedAt;
	}

	@Override
	public String toString (){
		return "id:"+(id == null ? "空" : id)+"，登录用户名:"+(username == null ? "空" : username)+"，bcrypt 哈希值:"+(passwordHash == null ? "空" : passwordHash)+"，fullName:"+(fullName == null ? "空" : fullName)+"，用户角色:"+(role == null ? "空" : role)+"，isActive:"+(isActive == null ? "空" : isActive)+"，createdAt:"+(createdAt == null ? "空" : DateUtil.format(createdAt, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，updatedAt:"+(updatedAt == null ? "空" : DateUtil.format(updatedAt, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
	}
}
