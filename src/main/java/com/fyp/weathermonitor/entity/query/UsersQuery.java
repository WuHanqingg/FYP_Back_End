package com.fyp.weathermonitor.entity.query;

import java.util.Date;


/**
 * 参数
 */
public class UsersQuery extends BaseParam {


	/**
	 * 
	 */
	private Long id;

	/**
	 * 登录用户名
	 */
	private String username;

	private String usernameFuzzy;

	/**
	 * bcrypt 哈希值
	 */
	private String passwordHash;

	private String passwordHashFuzzy;

	/**
	 * 
	 */
	private String fullName;

	private String fullNameFuzzy;

	/**
	 * 用户角色
	 */
	private String role;

	private String roleFuzzy;

	/**
	 * 
	 */
	private Integer isActive;

	/**
	 * 
	 */
	private String createdAt;

	private String createdAtStart;

	private String createdAtEnd;

	/**
	 * 
	 */
	private String updatedAt;

	private String updatedAtStart;

	private String updatedAtEnd;


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

	public void setUsernameFuzzy(String usernameFuzzy){
		this.usernameFuzzy = usernameFuzzy;
	}

	public String getUsernameFuzzy(){
		return this.usernameFuzzy;
	}

	public void setPasswordHash(String passwordHash){
		this.passwordHash = passwordHash;
	}

	public String getPasswordHash(){
		return this.passwordHash;
	}

	public void setPasswordHashFuzzy(String passwordHashFuzzy){
		this.passwordHashFuzzy = passwordHashFuzzy;
	}

	public String getPasswordHashFuzzy(){
		return this.passwordHashFuzzy;
	}

	public void setFullName(String fullName){
		this.fullName = fullName;
	}

	public String getFullName(){
		return this.fullName;
	}

	public void setFullNameFuzzy(String fullNameFuzzy){
		this.fullNameFuzzy = fullNameFuzzy;
	}

	public String getFullNameFuzzy(){
		return this.fullNameFuzzy;
	}

	public void setRole(String role){
		this.role = role;
	}

	public String getRole(){
		return this.role;
	}

	public void setRoleFuzzy(String roleFuzzy){
		this.roleFuzzy = roleFuzzy;
	}

	public String getRoleFuzzy(){
		return this.roleFuzzy;
	}

	public void setIsActive(Integer isActive){
		this.isActive = isActive;
	}

	public Integer getIsActive(){
		return this.isActive;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return this.createdAt;
	}

	public void setCreatedAtStart(String createdAtStart){
		this.createdAtStart = createdAtStart;
	}

	public String getCreatedAtStart(){
		return this.createdAtStart;
	}
	public void setCreatedAtEnd(String createdAtEnd){
		this.createdAtEnd = createdAtEnd;
	}

	public String getCreatedAtEnd(){
		return this.createdAtEnd;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return this.updatedAt;
	}

	public void setUpdatedAtStart(String updatedAtStart){
		this.updatedAtStart = updatedAtStart;
	}

	public String getUpdatedAtStart(){
		return this.updatedAtStart;
	}
	public void setUpdatedAtEnd(String updatedAtEnd){
		this.updatedAtEnd = updatedAtEnd;
	}

	public String getUpdatedAtEnd(){
		return this.updatedAtEnd;
	}

}
