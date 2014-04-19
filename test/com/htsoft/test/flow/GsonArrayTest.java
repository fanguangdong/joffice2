package com.htsoft.test.flow;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonArrayTest {
	private String name;
	private int age;
	
	public GsonArrayTest() {
		// TODO Auto-generated constructor stub
	}
	




	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}

	public String toString(){
		return "name:"+ this.name + " age:" + this.age;
	}

	public static void main(String[]args){
		//String data="[{}]";
//		String obj="{name:'lim',age:''}";
//		
//		Gson gson=new Gson();
//		GsonArrayTest test=gson.fromJson(obj, GsonArrayTest.class);
//		
//		System.out.println(test.toString());
		Gson gson=new GsonBuilder().serializeNulls().create();

		String obj2="[{name:'ding',age:''},{name:'king',age:'1'}]";
		
		GsonArrayTest[] test2=gson.fromJson(obj2, GsonArrayTest[].class);
		for(GsonArrayTest a:test2){
			System.out.println("a:" + a.toString());
		}
	}
}
