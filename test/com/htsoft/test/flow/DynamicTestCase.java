package com.htsoft.test.flow;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.htsoft.core.json.JsonDateSerializer;
import com.htsoft.core.service.DynamicService;
import com.google.gson.reflect.TypeToken;
import com.htsoft.core.util.BeanUtil;
import com.htsoft.core.util.JsonUtil;
import com.htsoft.test.BaseTestCase;

import flexjson.JSONSerializer;

public class DynamicTestCase extends BaseTestCase{
	
	@Test
	public void test() {
//		HashMap data=new HashMap();
//		
//		data.put("createtime",new Date());
//		data.put("itemDescp", "aaaaa");
//		data.put("itemSubject", "subject is here");
//		data.put("runId", new Long(1));
		DynamicService service=BeanUtil.getDynamicServiceBean("WF_Order");
		
		//service.save(data);
		Object obj=service.get(new Long(1));
		
		//Gson gson=new GsonBuilder().registerTypeAdapter(java.util.Date.class, new JsonDateSerializer()).create();  
		
		
//		JSONSerializer ser=new JSONSerializer();
//		
//		System.out.println("ser:"+ser.deepSerialize(obj));
		
		Map<String,Object> map=(Map<String,Object>)obj;
		
		System.out.println("sjo:"+JsonUtil.mapEntity2Json(map, "WF_Order"));
		
		
//		new TypeToken<Map<String, User>>(){}.getType()
		//System.out.println("gson:"+gson.toJson(map));
		Iterator it=map.values().iterator();
		//TODO
		while(it.hasNext()){
			System.out.println("val:"+it.next());
		}
		
	}
	
}
