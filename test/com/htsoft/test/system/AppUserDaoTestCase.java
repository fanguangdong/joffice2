package com.htsoft.test.system;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.oa.dao.system.AppRoleDao;
import com.htsoft.oa.dao.system.AppUserDao;
import com.htsoft.oa.dao.system.DepartmentDao;
import com.htsoft.oa.model.system.AppRole;
import com.htsoft.oa.model.system.AppUser;
import com.htsoft.oa.model.system.Department;
import com.htsoft.test.BaseTestCase;

public class AppUserDaoTestCase extends BaseTestCase {
	@Resource
	private AppUserDao appUserDao;
	@Resource
	private DepartmentDao departmentDao;
	
	@Test
	@Rollback(false)
	public void batchAdd() throws IOException{
		Department department =departmentDao.get(new Long(1));
		InputStream myxls=null;
		try{
		String userFile="D:/dev/workspace/joffice/metedata/data/users.xls";
		myxls = new FileInputStream(userFile);
		
		HSSFWorkbook workbook     = new HSSFWorkbook(myxls);
		
		HSSFSheet sheet = workbook.getSheetAt(0);       // first sheet
		
		HSSFRow row=null;     
		int i=1;
		Long userId=100l;
		do{
			row = sheet.getRow(i++);
			if(row==null){
				System.out.println("row==null");
				break;
			}
			HSSFCell fullnameCell=row.getCell(0);
			HSSFCell accountCell=row.getCell(1);
			HSSFCell emailCell=row.getCell(2);
			
			if(accountCell==null){
				continue;
			}
			String fullname=fullnameCell.getRichStringCellValue().toString();
			String account=accountCell.getRichStringCellValue().toString();
			String email="";

			if(emailCell!=null){
				email=emailCell.getRichStringCellValue().toString();
				String[]mails=email.split("[ ]");
				email=mails[0];
			}else{
				email=account+"@unkown.com";
			}
			
			System.out.println(fullname + " :" + account + " :" + email);
			
			AppUser appUser=new AppUser();
			appUser.setUserId(userId++);
			appUser.setUsername(account);
			appUser.setFullname(fullname);
			appUser.setPassword("jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=");
			appUser.setEmail(email);
			
			appUser.setTitle(new Short("1"));
			appUser.setDelFlag(new Short("0"));
			appUser.setDepartment(department);
			appUser.setStatus(new Short("1"));
			appUser.setAccessionTime(new Date());
			appUserDao.save(appUser);
			
			
		}while(1==1);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			myxls.close();
		}
		
	}
	
//	@Test
//	@Rollback(false)
	public void add(){
		Department department =departmentDao.get(new Long(1));
		DecimalFormat df=new DecimalFormat("000");
		for(int i=20;i<=120;i++){
			AppUser appUser=new AppUser();
			appUser.setTitle(new Short("1"));
			appUser.setDelFlag(new Short("0"));
			appUser.setEmail("user" + i + "@jsoft.com");
			appUser.setUsername("user" + i);
			appUser.setEducation("大学本科");
			appUser.setMobile("135803XX" + df.format(new Double(i)));
			appUser.setPassword("9uCh4qxBlFqap/+KiqoM68EqO8yYGpKa1c+BCgkOEa4=");
			appUser.setDepartment(department);
			appUser.setStatus(new Short("1"));
			appUser.setAccessionTime(new Date());
			appUser.setFullname("张三" + i);
			//appUser.set
			
			appUserDao.save(appUser);
		}
//		appUser = appUserDao.get(4l);
//		System.out.println(appUser.getAddress());
//		Set set = appUser.getRoles();
//		Iterator it = set.iterator();
//		
//		AppRole role = (AppRole)it.next();
//		System.out.println(role.getRoleName());
	}
	
	
	
	//@Test
	public void addDep(){
		Department dep=new Department();
		dep.setDepName("Root Dep");
		dep.setDepLevel(1);
		
		departmentDao.save(dep);
	}
	//@Rollback(false)
	//@Test
	public void bacthAdd(){
		Department dep=departmentDao.get(1l);
		for(int i=101;i<102;i++){
			AppUser au=new AppUser();
			//au.setUserId((long)i+1);
			au.setTitle((short)1);
			au.setUsername("user" + i);
			au.setPassword("1");
			au.setFullname("李海"+ i);
			au.setAddress("testAddress");
			au.setEducation("test");
			au.setEmail("user"+ i+ "@htsoft.com");
			au.setAccessionTime(new Date());
			au.setPhoto("photo");
			au.setZip("00003");
			au.setStatus((short)1);
			au.setFax("020-003034034");
			//au.setPosition("UserManager");
//			au.setDepartment(dep);
			
			appUserDao.save(au);
		}
	}
}