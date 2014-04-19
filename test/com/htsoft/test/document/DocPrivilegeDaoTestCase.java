package com.htsoft.test.document;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.google.gson.Gson;
import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.document.DocFolderDao;
import com.htsoft.oa.dao.document.DocPrivilegeDao;
import com.htsoft.oa.dao.document.DocumentDao;
import com.htsoft.oa.dao.system.AppUserDao;
import com.htsoft.oa.model.document.DocFolder;
import com.htsoft.oa.model.document.DocPrivilege;
import com.htsoft.oa.model.document.Document;
import com.htsoft.oa.model.system.AppUser;

import flexjson.JSONSerializer;

public class DocPrivilegeDaoTestCase extends BaseTestCase {
	@Resource
	private DocPrivilegeDao docPrivilegeDao;
	@Resource
	private DocumentDao documentDao;
	@Resource
	private DocFolderDao docFolderDao;
	@Resource
	private AppUserDao dao;
//	@Test
//	@Rollback(false)
//	public void add(){		
//		DocPrivilege docPrivilege=new DocPrivilege();
////		TODO
//
//		docPrivilegeDao.save(docPrivilege);
//	}
	
	@Test
	public void str(){
		
//          Integer in=05;
//          String rr=Integer.toBinaryString(in);
//            Integer read=null;
//			Integer update=null;
//			Integer delete=null;
//			char[] cc=rr.toCharArray();
//			 for(int i=0;i<cc.length;i++){
//	        	  if(cc.length>=1&&cc[0]=='1'){
//	        		  delete=1;
//	        	  }
//	        	  if(cc.length>=2&&cc[1]=='1'){
//	        		  update=1;
//	        	  }
//	        	 if(cc.length>=3&&cc[2]=='1'){
//	        		  read=1;
//	        	  }
//	          }
////		
////          System.out.println(delete+"fdsf"+update+"fsdfds"+read);
//		
////		String st="110";
////		Integer in=Integer.parseInt(st,2);
////		
////		System.out.println(in);
////		
////		Integer in=2;
////		String st=Integer.toBinaryString(in);
////		StringBuffer buff=new StringBuffer(st);
////		buff.insert(0,"00");
////		System.out.println(buff.toString());
////		StringBuffer buff2=new StringBuffer();
////		buff.deleteCharAt(0);
////		buff2.append("0").append(buff.toString());
//////		buff.append("0").append(buff.toString());
////		System.out.println(st);
//////		st.replaceAll(st,buff.toString());
////		System.out.println(buff2.toString());
//		 String strPrivilegeId="9";
//		    String strField="rightU";
//		    
//		    String strFieldValue="false";
//	    if(StringUtils.isNotEmpty(strPrivilegeId)){
//	    	DocPrivilege docPrivilege=docPrivilegeDao.get(Long.parseLong(strPrivilegeId));
//	    	Integer in=docPrivilege.getRights();
//	    	if(in>0){
//	    	System.out.println(in);
//    		String str=Integer.toBinaryString(in);
//    		System.out.println("str"+str);
//    		StringBuffer buff=new StringBuffer(str);
//    		System.out.println("fdfsdf"+buff);
//    		if(buff.length()==1){
//    			buff.insert(0,"00");
//    		}
//    		if(buff.length()==2){
//    			buff.insert(0,"0");
//    		}
//    		if(buff.length()<=0){
//    			buff.insert(0,"000");
//    		}
//    		System.out.println("buff"+buff);  		
//    		String rights="";
//	    	if("rightR".equals(strField)){
//	    		StringBuffer newBuff=new StringBuffer();
//	    		if("true".equals(strFieldValue)){
//	    			System.out.println("true");
//	    			newBuff.append(buff.deleteCharAt(2).toString()).append("1");
//	    		}else{
//	    			newBuff.append(buff.deleteCharAt(2).toString()).append("0");
//	    		}
//	    		rights=newBuff.toString();
//	    		
//	    	}
//	    	if("rightU".equals(strField)){
//	    		StringBuffer newBuff=new StringBuffer();
//	    		if("true".equals(strFieldValue)){
//	    			newBuff.append(buff.delete(1,3).toString());
//	    			newBuff.append("1");
//	    			newBuff.append(buff.delete(0,2).toString());
//	    		}else{
//	    			newBuff.append(buff.charAt(0));
//	    			newBuff.append("0");
//	    			newBuff.append(buff.charAt(2));
//	    		}
//	    		rights=newBuff.toString();
//	    	}
//	    	
//	    	if("rightD".equals(strField)){
//	    		StringBuffer newBuff=new StringBuffer();
//	    		if("true".equals(strFieldValue)){
//	    			newBuff.append("0").append(buff.deleteCharAt(0).toString());
//	    		}else{
//	    			newBuff.append("0").append(buff.deleteCharAt(0).toString());
//	    		}
//	    		rights=newBuff.toString();
//	    	}
//	    	System.out.println("newBuff:"+rights);
//	    	Integer right=Integer.parseInt(rights,2);
//	    	System.out.println("rigths:"+right);
////	    	docPrivilege.setRights(right);
////	    	docPrivilegeDao.save(docPrivilege);
//	    	}
//	    }
//		List<DocPrivilege> list=docPrivilegeDao.getAll();
//		JSONSerializer serializer=new JSONSerializer();
//		System.out.println(serializer.exclude(new String[]{"class","appUser.department"}).prettyPrint(list));
//	    System.out.println("-------------------------------------------");
//		List<Document> list2=documentDao.getAll();
//	    Gson gson=new Gson();
//	    System.out.println(gson.toJson(list2));
////		JSONSerializer serializer2=new JSONSerializer();
////		System.out.println(serializer2.exclude(new String[]{"class","appUser.department"}).prettyPrint(list2));
//		System.out.println("-------------------------------------------");
//		List<DocFolder> list3=docFolderDao.getAll();
//		JSONSerializer serializer3=new JSONSerializer();
//		System.out.println(serializer3.exclude(new String[]{"class","appUser.department"}).prettyPrint(list3));
////	    Gson gson=new Gson();
////	    System.out.println(gson.toJson(list3));
//		System.out.println(4|4);
		AppUser user=dao.get(2l);
		Integer right=docPrivilegeDao.getRightsByDocument(user,1l);
		System.out.println(right);
	}
		
		
	
}