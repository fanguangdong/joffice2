package com.htsoft.test.system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.htsoft.oa.model.system.AppUser;



public class AppUserTest {
	
	public static void main(String[]args) throws IOException{
		
		
		String userFile="C:/dev/workspace/joffice/metedata/data/users.xls";
		InputStream myxls = new FileInputStream(userFile);
		
		HSSFWorkbook workbook     = new HSSFWorkbook(myxls);
		
		HSSFSheet sheet = workbook.getSheetAt(0);       // first sheet
		
		HSSFRow row=null;     
		int i=1;
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
			
		}while(1==1);
		
		myxls.close();
	}
	
}
