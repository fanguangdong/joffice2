package com.htsoft.test.system;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.oa.dao.system.DepartmentDao;
import com.htsoft.oa.model.system.Department;
import com.htsoft.test.BaseTestCase;

public class DepartmentDaoTestCase extends BaseTestCase {
	@Resource
	private DepartmentDao departmentDao;
	
	@Test
	@Rollback(false)
	public void batchAdd(){
		//100个局，每个局下三个机构
		
		for(int i=1;i<=100;i++){
			Department dep=new Department();
			dep.setDepLevel(1);
			dep.setDepName("局" + i);
			dep.setDepDesc("局" + i);
			dep.setParentId(new Long(0));
			departmentDao.save(dep);
			
			dep.setPath("0." + dep.getDepId() + ".");
			
			departmentDao.save(dep);
			
			for(int j=1;j<=5;j++){
				Department subDep=new Department();
				subDep.setDepLevel(2);
				subDep.setParentId(dep.getDepId());
				subDep.setDepName(dep.getDepName() + "-" + j);
				subDep.setDepDesc(dep.getDepName() + "-" + j);
				departmentDao.save(subDep);
				subDep.setPath(dep.getPath() + subDep.getDepId() + ".");
			}
		}
	}
}
