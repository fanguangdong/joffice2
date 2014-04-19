package com.htsoft.test.document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.htsoft.test.BaseTestCase;
import com.htsoft.core.web.paging.PagingBean;
import com.htsoft.oa.dao.document.DocumentDao;
import com.htsoft.oa.dao.system.AppUserDao;
import com.htsoft.oa.model.document.Document;
import com.htsoft.oa.model.system.AppUser;


public class DocumentDaoTestCase extends BaseTestCase {
	@Resource
	private DocumentDao documentDao;
	@Resource
	private AppUserDao appUserDao;
//	@Test
//	@Rollback(false)
//	public void add(){		
//		Document document=new Document();
////		TODO
//
//		documentDao.save(document);
//	}
	
	@Test
	public void tesss(){
		
//		Document doc=documentDao.get(3l);
////		JSONSerializer serializer=new JSONSerializer();
////		System.out.println(serializer.exclude(new String[]{"class"}).prettyPrint(doc));
//		
//		Gson gson=new Gson();
//		System.out.println(gson.toJson(doc).toString());
		
//		StringBuffer buff=new StringBuffer("abcd");
//		char cc=buff.charAt(2);
//		System.out.println(cc);
		
		AppUser user=appUserDao.get(2l);
//		
//		Document list=documentDao.get(10l);
//		
//		Gson gson=new Gson();
//		System.out.println(gson.toJson(list)+list.getDocFolder()+list.getAppUser());
//		Document document=documentDao.get(2l);
//		System.out.println(list.toArray());
//		PagingBean pb=new PagingBean(0, 5);
//		List<Document> list=documentDao.findByPublic(null,null,null,null,user,pb);
//		
//		System.out.println(pb.getTotalItems());
//		for(Document doc:list){
//			System.out.println(doc.getDocId()+"         "+doc.getDocName());
//		}
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		String jsonOutput = gson.toJson(list);
//		System.out.println(jsonOutput);
//		JSONSerializer serializer=new JSONSerializer();
//		serializer.transform(new DateTransformer("yyyy-MM-dd HH:mm:ss"),"createtime");
//		serializer.transform(new DateTransformer("yyyy-MM-dd HH:mm:ss"),"updatetime");
//		System.out.println(serializer.exclude(new String[]{"class","appUser.department"}).prettyPrint(list));
//		

//		Set<AppRole> appRoles=user.getRoles();
//		Iterator it=appRoles.iterator();
//		ArrayList<Long> arrayList=new ArrayList<Long>();
//		while(it.hasNext()){
//			arrayList.add(((AppRole)it.next()).getRoleId());
//		}
//		Long[] roleIds=null;
//		if(arrayList!=null&&arrayList.size()>0){
////			roleIds=arrayList;
//		}
		PagingBean pb=new PagingBean(0, 6);
		Document document=documentDao.get(6l);
		List<Document> docs=documentDao.findByPersonal(2l,null,null,null,null, pb);
		System.out.println("size:"+docs.size());
	}
	
}