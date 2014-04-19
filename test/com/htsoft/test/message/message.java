package com.htsoft.test.message;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.htsoft.core.util.ContextUtil;
import com.htsoft.core.web.paging.PagingBean;
import com.htsoft.oa.dao.info.InMessageDao;
import com.htsoft.oa.dao.info.ShortMessageDao;
import com.htsoft.oa.model.info.InMessage;
import com.htsoft.oa.model.info.ShortMessage;
import com.htsoft.oa.model.system.AppUser;
import com.htsoft.test.BaseTestCase;

public class message extends BaseTestCase{

	@Resource
	private InMessageDao dao;
	@Resource
	private ShortMessageDao dao2;
	
//	@Test
//	public void see1(){
//		InMessage in=dao.findByRead(new Long(1));
//		ShortMessage s=in.getShortMessage();
////		Type type=new TypeToken<ShortMessage>(){}.getType();
////		Gson gson=new Gson();
////		StringBuffer buff=new StringBuffer(gson.toJson(s,type));
//		StringBuffer buff=new StringBuffer("{success:true,data:[");
//		buff.append("{'messageId':"+s.getMessageId()+",'senderId':"+s.getSenderId()+",'sender':'"+s.getSender()+"','content':'"+s.getContent()+"','sendTime':'"+s.getSendTime()+"','msgType':"+s.getMsgType()+"}]}");
//		System.out.print(buff.toString());
//	}
	
	@Test
	public void set(){
 
		List<Object[]> list=dao.findByUser(new Long(1));
//		Type type=new TypeToken<List<Object[]>>(){}.getType();
        List<InMessage> listk=new ArrayList<InMessage>();
//        List<ShortMessage> listf=new ArrayList<ShortMessage>();
		for(int i=0;i<list.size();i++){
		    InMessage inMessage=(InMessage)list.get(i)[0];
//		    ShortMessage shortMessage=(ShortMessage)list.get(i)[1];
		    listk.add(inMessage);
//		    listf.add(shortMessage);
	    }
		Gson gson=new Gson();
		Type type=new TypeToken<List<InMessage>>(){}.getType();
		System.out.println(gson.toJson(listk,type)+list.size());
	}
}
