package com.htsoft.test.jbpm;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.htsoft.core.util.XmlUtil;
import com.htsoft.oa.model.flow.ExtFormItem;

public class GsonTestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String data="[{\"xtype\":\"textfield\",\"fieldLabel\":\"TEST1\",\"anchor\":\"100%\",\"name\":\"test1\"},{\"xtype\":\"textarea\",\"fieldLabel\":\"TEST2\",\"anchor\":\"100%\",\"name\":\"test2\"}]";
		//Gson gson=new Gson();
		
		
		//System.out.println(gson.toJson("Ext.Panel({title:\"sdfsdfs\"})"));
		
//		ExtFormItem[]formItems=gson.fromJson(data, ExtFormItem[].class);
//		
//		for(int i=0;i<formItems.length;i++){
//			System.out.println("name:" + formItems[i].getName());
//		}
		
//		Gson gson=new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
//		
//		System.out.println("gson:"+ gson.toJson(new Date()));
		
		//test();
		
		testArray();
	}
	
	public static void test(){
		String path="L:/devtools/workspace/joffice/test/com/htsoft/test/jbpm/jbpmdef.xml";
		
		String defXml=XmlUtil.load(path).getRootElement().asXML();
		
		System.out.println("xml:" + defXml);
	}
	
	public static void testArray(){
		HashSet<Long> userIds=new HashSet<Long>();
		
		userIds.add(new Long(1));
		userIds.add(new Long(2));
		
		Long []uIds=userIds.toArray(new Long[]{});
		
		for(Long u:uIds){
			System.out.println("out:"+u);
		}
	}

}
