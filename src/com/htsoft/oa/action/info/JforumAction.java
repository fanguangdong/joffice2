package com.htsoft.oa.action.info;

import javax.annotation.Resource;

import com.htsoft.core.util.ContextUtil;
import com.htsoft.core.web.action.BaseAction;
import com.htsoft.oa.model.system.AppUser;
import com.htsoft.oa.service.system.AppUserService;

public class JforumAction extends BaseAction {
	@Resource
	private AppUserService appUserService;
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String execute(){
	    AppUser appUser = null;
	    String userId = getRequest().getParameter("userId");
	    if(userId == null){
	        appUser = appUserService.get(new Long(userId));
	    }else{
	    	appUser = appUserService.get(ContextUtil.getCurrentUserId());
	    }
	    getRequest().setAttribute("appUser", appUser);
		return SUCCESS;
	}
}
