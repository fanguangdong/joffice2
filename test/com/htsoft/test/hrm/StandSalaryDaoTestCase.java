package com.htsoft.test.hrm;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.oa.dao.hrm.StandSalaryDao;
import com.htsoft.test.BaseTestCase;

public class StandSalaryDaoTestCase extends BaseTestCase {
	@Resource
	private StandSalaryDao standSalaryDao;
	
	@Test
	@Rollback(false)
	public void add(){		
//		StandSalary standSalary=new StandSalary();
////		TODO
//
//		standSalaryDao.save(standSalary);
		BigDecimal abc = new BigDecimal("0");
		BigDecimal abc1 = new BigDecimal("1");
		BigDecimal abc2 = new BigDecimal("2");
		
		System.out.println(abc.add(abc1).add(abc2));
	}
}