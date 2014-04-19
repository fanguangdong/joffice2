package com.htsoft.oa.model.system;

/*
 *  广州宏天软件有限公司 OA办公管理系统   --  http://www.jee-soft.cn
 *  Copyright (C) 2008-2009 GuangZhou HongTian Software Company
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang.StringUtils;
import org.jbpm.api.identity.User;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.userdetails.UserDetails;

import com.google.gson.annotations.Expose;
import com.htsoft.core.menu.TopModule;
import com.htsoft.core.util.AppUtil;

/**
 * AppUser Base Java Bean, base class for the.oa.model, mapped directly to
 * database table
 * 
 * Avoid changing this file if not necessary, will be overwritten.
 * 
 * TODO: add class/table comments
 */
//@SuppressWarnings("serial")
public class AppUser extends com.htsoft.core.model.BaseModel implements
		UserDetails, User {
	/**
	 * 系统用户ID，由初始化数据加入
	 */
	public static final Long SYSTEM_USER = new Long(-1);
	/**
	 * 超级管理员ID,由初始化数据加入
	 */
	public static final Long SUPER_USER = new Long(1);
	/**
	 * 动态密码状态，０＝未绑定，１＝绑定
	 */
	public static final Short DYNPWD_STATUS_BIND = 1;
	public static final Short DYNPWD_STATUS_UNBIND = 0;

	@Expose
	protected Long userId;
	@Expose
	protected String username;
	protected String password;
	@Expose
	protected String email;
	@Expose
	protected Department department;
	@Expose
	protected Long jobId;
	@Expose
	protected String phone;
	@Expose
	protected String mobile;
	@Expose
	protected String fax;
	@Expose
	protected String address;
	@Expose
	protected String zip;
	@Expose
	protected String photo;
	@Expose
	protected java.util.Date accessionTime;
	@Expose
	protected Short status;
	@Expose
	protected String education;
	@Expose
	protected Short title;
	@Expose
	protected String fullname;
	@Expose
	protected Short delFlag;
	@Expose
	protected String dynamicPwd;
	@Expose
	protected Short dyPwdStatus;
	@XmlTransient
	protected Set<AppRole> roles;

	
	/**
	 * 用户头部的模块菜单，由用户登录后设置 
	 */
	private Map<String,TopModule> topModules=new LinkedHashMap<String,TopModule>();
	
	/**
	 * 用于存储该用户的权限,需要合并公共的
	 */
	protected Set<String> rights = new HashSet<String>();
	

	public Set<String> getRights() {
		return rights;
	}

	public Map<String, TopModule> getTopModules() {
		return topModules;
	}
	public void setTopModules(Map<String, TopModule> topModules) {
		this.topModules = topModules;
	}

	/**
	 * 取得所有的Function的权限，则以_为开头的权限
	 * 
	 * @return
	 */
	public String getFunctionRights() {
		StringBuffer sb = new StringBuffer();

		Iterator<String> it = rights.iterator();

		while (it.hasNext()) {
			sb.append(it.next()).append(",");
		}

		if (rights.size() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}

		return sb.toString();
	}

	public void setRights(Set<String> rights) {
		this.rights = rights;
	}

	/**
	 * Default Empty Constructor for class AppUser
	 */
	public AppUser() {
		super();
	}

	/**
	 * Default Key Fields Constructor for class AppUser
	 */
	public AppUser(Long in_userId) {
		this.setUserId(in_userId);
	}

	/**
	 * * @return Long
	 * 
	 * @hibernate.id column="userId" type="java.lang.Long"
	 *               generator-class="native"
	 */
	public Long getUserId() {
		return this.userId;
	}

	/**
	 * Set the userId
	 */
	public void setUserId(Long aValue) {
		this.userId = aValue;
	}

	/**
	 * * @return String
	 * 
	 * @hibernate.property column="username" type="java.lang.String"
	 *                     length="128" not-null="true" unique="false"
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * Set the username
	 * 
	 * @spring.validator type="required"
	 */
	public void setUsername(String aValue) {
		this.username = aValue;
	}

	/**
	 * * @return String
	 * 
	 * @hibernate.property column="password" type="java.lang.String"
	 *                     length="128" not-null="true" unique="false"
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Set the password
	 * 
	 * @spring.validator type="required"
	 */
	public void setPassword(String aValue) {
		this.password = aValue;
	}

	/**
	 * * @return String
	 * 
	 * @hibernate.property column="email" type="java.lang.String" length="128"
	 *                     not-null="true" unique="false"
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Set the email
	 * 
	 * @spring.validator type="required"
	 */
	public void setEmail(String aValue) {
		this.email = aValue;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Long getJobId() {
		return this.jobId;
	}

	public void setJobId(Long aValue) {
		this.jobId = aValue;
	}

	/**
	 * * @return String
	 * 
	 * @hibernate.property column="phone" type="java.lang.String" length="32"
	 *                     not-null="false" unique="false"
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * Set the phone
	 */
	public void setPhone(String aValue) {
		this.phone = aValue;
	}

	/**
	 * * @return String
	 * 
	 * @hibernate.property column="mobile" type="java.lang.String" length="32"
	 *                     not-null="false" unique="false"
	 */
	public String getMobile() {
		return this.mobile;
	}

	/**
	 * Set the mobile
	 */
	public void setMobile(String aValue) {
		this.mobile = aValue;
	}

	/**
	 * * @return String
	 * 
	 * @hibernate.property column="fax" type="java.lang.String" length="32"
	 *                     not-null="false" unique="false"
	 */
	public String getFax() {
		return this.fax;
	}

	/**
	 * Set the fax
	 */
	public void setFax(String aValue) {
		this.fax = aValue;
	}

	/**
	 * * @return String
	 * 
	 * @hibernate.property column="address" type="java.lang.String" length="64"
	 *                     not-null="false" unique="false"
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * Set the address
	 */
	public void setAddress(String aValue) {
		this.address = aValue;
	}

	/**
	 * * @return String
	 * 
	 * @hibernate.property column="zip" type="java.lang.String" length="32"
	 *                     not-null="false" unique="false"
	 */
	public String getZip() {
		return this.zip;
	}

	/**
	 * Set the zip
	 */
	public void setZip(String aValue) {
		this.zip = aValue;
	}

	/**
	 * * @return String
	 * 
	 * @hibernate.property column="photo" type="java.lang.String" length="128"
	 *                     not-null="false" unique="false"
	 */
	public String getPhoto() {
		return this.photo;
	}

	/**
	 * Set the photo
	 */
	public void setPhoto(String aValue) {
		this.photo = aValue;
	}

	/**
	 * * @return java.util.Date
	 * 
	 * @hibernate.property column="accessionTime" type="java.util.Date"
	 *                     length="19" not-null="true" unique="false"
	 */
	public java.util.Date getAccessionTime() {
		return this.accessionTime;
	}

	/**
	 * Set the accessionTime
	 * 
	 * @spring.validator type="required"
	 */
	public void setAccessionTime(java.util.Date aValue) {
		this.accessionTime = aValue;
	}

	/**
	 * * @return Short
	 * 
	 * @hibernate.property column="status" type="java.lang.Short" length="5"
	 *                     not-null="true" unique="false"
	 */
	public Short getStatus() {
		return this.status;
	}

	/**
	 * Set the status
	 * 
	 * @spring.validator type="required"
	 */
	public void setStatus(Short aValue) {
		this.status = aValue;
	}

	/**
	 * * @return String
	 * 
	 * @hibernate.property column="education" type="java.lang.String"
	 *                     length="64" not-null="false" unique="false"
	 */
	public String getEducation() {
		return this.education;
	}

	/**
	 * Set the education
	 */
	public void setEducation(String aValue) {
		this.education = aValue;
	}

	/**
	 * * @return Short
	 * 
	 * @hibernate.property column="title" type="java.lang.Short" length="32"
	 *                     not-null="false" unique="false"
	 */
	public Short getTitle() {
		return this.title;
	}

	/**
	 * Set the title
	 */
	public void setTitle(Short aValue) {
		this.title = aValue;
	}

	/**
	 * * @return String
	 * 
	 * @hibernate.property column="fullname" type="java.lang.String"
	 *                     length="128" not-null="false" unique="false"
	 */
	public String getFullname() {
		return this.fullname;
	}

	/**
	 * Set the fullname
	 */
	public void setFullname(String aValue) {
		this.fullname = aValue;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */

	public Short getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Short delFlag) {
		this.delFlag = delFlag;
	}

	public String getDynamicPwd() {
		return dynamicPwd;
	}

	public void setDynamicPwd(String dynamicPwd) {
		this.dynamicPwd = dynamicPwd;
	}

	public Short getDyPwdStatus() {
		return dyPwdStatus;
	}

	public void setDyPwdStatus(Short dyPwdStatus) {
		this.dyPwdStatus = dyPwdStatus;
	}

	/**
	 * Return the name of the first key column
	 */
	public String getFirstKeyColumnName() {
		return "userId";
	}

	public Set<AppRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<AppRole> roles) {
		this.roles = roles;
	}

	public GrantedAuthority[] getAuthorities() {
		GrantedAuthority[] rights = roles.toArray(new GrantedAuthority[roles
				.size() + 1]);
		rights[rights.length - 1] = new GrantedAuthorityImpl("ROLE_PUBLIC");
		return rights;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		if (status == 1) {
			return true;
		}
		return false;
	}

	// overwrite for

	/**
	 * Return the Id (pk) of the entity
	 */
	public String getId() {
		return userId.toString();
	}

	@Override
	public String getBusinessEmail() {
		return email;
	}

	@Override
	public String getFamilyName() {
		return fullname;
	}

	@Override
	public String getGivenName() {
		return fullname;
	}

	public boolean isSupperManage() {
		Set<AppRole> roles = getRoles();
		boolean flag = false;
		for (Iterator<AppRole> it = roles.iterator(); it.hasNext();) {
			AppRole role = it.next();
			if (role.getRoleId().shortValue() == AppRole.SUPER_ROLEID
					.shortValue()) {
				flag = true;
			}
		}
		return flag;
	}
	
	/**
	 * 初始化菜单权限信息
	 */
	public void initMenuRights(){
		//取得公共TopMenuId
		getTopModules().putAll(AppUtil.getPublicTopModules());
		
		// 进行合并权限的处理
		Set<AppRole> roleSet = getRoles();
		Iterator<AppRole> it = roleSet.iterator();

		while (it.hasNext()) {
			AppRole role = it.next();
			if (role.getRoleId().equals(
					AppRole.SUPER_ROLEID)) {// 具有超级权限
				getRights().clear();
				getTopModules().clear();
				getRights().add(AppRole.SUPER_RIGHTS);
				getTopModules().putAll(AppUtil.getAllTopModels());
				break;
			} else {
				if (StringUtils.isNotEmpty(role.getRights())) {
					String[] items = role.getRights().split("[,]");
					for (int i = 0; i < items.length; i++) {
						String item = items[i];
						// 代表模板菜单,即上面的菜单
						if (item.startsWith("Mod_")) {
							if (!getTopModules().containsKey(item)) {
								getTopModules().put(items[i],AppUtil.getAllTopModels().get(item));
							}
							continue;
						}
						if (!getRights().contains(item)) {
							getRights().add(item);
						}
					}
				}
			}
		}
		//排序用户的topModules;
		
		List<TopModule> list=new ArrayList<TopModule>();
		list.addAll(getTopModules().values());
		Collections.sort(list, new Comparator<TopModule>() {
			@Override
			public int compare(TopModule o1, TopModule o2) {
				if(o1.getSn()>o2.getSn()){
					return 1;
				}
				return 0;
			}
		});
		getTopModules().clear();
		for(TopModule topMod:list){
			getTopModules().put(topMod.getId(),topMod);
		}
	}
	
	
}
