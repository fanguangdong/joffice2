package com.htsoft.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BastTest {
	public static void main(String[]args){
		  String s="PF.CREATORID=? GROUP BY PR.RUNID";
	      Pattern p = Pattern.compile(" GROUP BY [\\w|.]+");
	      
	      Matcher m = p.matcher(s);
	      boolean is=m.find();
          System.out.println("is:" + is);
		     
		      
		      int start = m.start(); //查找匹配串的起始字母的位置 --- 0
		      int end = m.end();   //查找匹配串的结束字母的位置 --- 2
		      
		      System.out.println("start:" + start + "end:" + end + s.substring(start,end));
	     
	      

	}
}
