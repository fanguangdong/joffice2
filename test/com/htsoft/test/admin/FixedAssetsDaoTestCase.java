package com.htsoft.test.admin;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.admin.FixedAssetsDao;
import com.htsoft.oa.model.admin.FixedAssets;

public class FixedAssetsDaoTestCase extends BaseTestCase {
	@Resource
	private FixedAssetsDao fixedAssetsDao;
//	
//	@Test
//	@Rollback(false)
//	public void add(){		
//		FixedAssets fixedAssets=new FixedAssets();
////		TODO
//
//		fixedAssetsDao.save(fixedAssets);
//	}
	
    @Test
	public void text(){
//    	 BigDecimal one = new BigDecimal("125.251");
//    	 BigDecimal one2 = new BigDecimal("125");
//    	 System.out.println(one.add(one2));
    	 
//    	  GregorianCalendar   calendar1=new   GregorianCalendar();  
    	  GregorianCalendar   calendar2=new   GregorianCalendar(2009,2,5);  
//    	  calendar1.setTime(new Date());  
//    	  calendar2.setTime(new Date());
    	  System.out.println(getMonth(new Date(),calendar2.getTime()));
//    	  System.out.println(in);
    	 
//    	 Date d1=gc.getTime();
//    	 Date d2=gc1.getTime();
//    	 Long dq=d1.getTime();
//    	 Long dq1=d2.getTime();
//    	 System.out.println(dq1-dq);
	}
    
	public int getMonth(Date s, Date e) {
		if (s.after(e)) {
			Date t = s;
			s = e;
			e = t;
		}
		Calendar start = Calendar.getInstance();
		start.setTime(s);
		Calendar end = Calendar.getInstance();
		end.setTime(e);
		Calendar temp = Calendar.getInstance();
		temp.setTime(e);
		temp.add(Calendar.DATE, 1);

		int y = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
		int m = end.get(Calendar.MONTH) - start.get(Calendar.MONTH);

		if ((start.get(Calendar.DATE) == 1) && (temp.get(Calendar.DATE) == 1)) {// 前后都不破月
			return y * 12 + m + 1;
		} else if ((start.get(Calendar.DATE) != 1)
				&& (temp.get(Calendar.DATE) == 1)) {// 前破月后不破月
			return y * 12 + m;
		} else if ((start.get(Calendar.DATE) == 1)
				&& (temp.get(Calendar.DATE) != 1)) {// 前不破月后破月
			return y * 12 + m;
		} else {// 前破月后破月
			return (y * 12 + m - 1) < 0 ? 0 : (y * 12 + m - 1);
		}
	}
}