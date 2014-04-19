package com.htsoft.test.system;

import javax.annotation.Resource;

import org.junit.Test;

import com.htsoft.oa.model.system.AppFunction;
import com.htsoft.oa.model.system.AppRole;
import com.htsoft.oa.service.system.AppFunctionService;
import com.htsoft.oa.service.system.AppRoleService;
import com.htsoft.test.BaseTestCase;

public class AppRoleTestCase extends BaseTestCase{
	@Resource
	private AppRoleService appRoleService;
	@Resource
	private AppFunctionService appFunctionService;
	
	//@Test
	public void testMerge(){
		AppRole role=new AppRole();
		role.setRoleId(1L);
		role.setStatus((short)0);
		appRoleService.merge(role);
	}
	
	//@Test
	public void updateFunctions(){
		AppRole role=appRoleService.get(3l);
		for(int id=1;id<=2;id++){
			AppFunction appFunction=appFunctionService.get(new Long(id));
			role.getFunctions().add(appFunction);
		}
		appRoleService.save(role);
		
	}
	@Test
	public void test(){
		
		AppRole role=appRoleService.get(new Long(1l));
		
		System.out.println("role:" + role.getName());
		
	}
}
