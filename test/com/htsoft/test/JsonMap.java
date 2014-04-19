package com.htsoft.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonMap {
	public static void main(String[]args){
		String json="{'productName':'ABC,aaa','price':12321,'quantity':'1','descp':'122'}";
		Gson gson=new Gson();
	
		HashMap map=gson.fromJson(json, new TypeToken<HashMap<String,String>>() {
		}.getType());
		
		Iterator<Map.Entry> it=map.entrySet().iterator();
		
		while(it.hasNext()){
			Map.Entry entry=it.next();
			
			System.out.println("key:"+entry.getKey() + " VAL:"+entry.getValue());
		}
	}
}
