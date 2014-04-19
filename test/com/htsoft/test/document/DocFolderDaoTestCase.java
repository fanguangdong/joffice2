package com.htsoft.test.document;

import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.htsoft.test.BaseTestCase;
import com.htsoft.oa.dao.document.DocFolderDao;
import com.htsoft.oa.dao.system.AppUserDao;
import com.htsoft.oa.model.document.DocFolder;

public class DocFolderDaoTestCase extends BaseTestCase {
	@Resource
	private DocFolderDao docFolderDao;
	@Resource
	private AppUserDao appUserDao;
	
//	@Test
//	@Rollback(false)
//	public void add(){		
//		DocFolder docFolder=new DocFolder();
//		
//		docFolder.setAppUser(appUserDao.get(1l));
//		docFolder.setFolderName("工作目录");
//		docFolder.setIsShared(DocFolder.IS_NOT_SHARED);
//		docFolder.setParentId(null);
//		docFolderDao.save(docFolder);
//		
//		docFolder.setPath(docFolder.getFolderId()+".");
//		
//		docFolderDao.save(docFolder);
//	}
	
	@Test
	public void move(){
//		DocFolder docFolder=docFolderDao.get(1l);
//		DocFolder docFolder1=docFolderDao.get(2l);
//		String path1=docFolder.getPath();
//		String path2=docFolder1.getPath();
//		System.out.println(path1+"           "+path2);
//		docFolder.setParentId(2l);
//		docFolder.setPath(path2+"1.");
//		List<DocFolder> list=docFolderDao.getFolderLikePath(path1);
//		for(DocFolder folder:list){
//			folder.setPath(folder.getPath());
//		}
//		System.out.println(list.size());
		String st="1.2.3.6.5.";
		boolean ss=Pattern.compile("1.3").matcher(st).find();;
		System.out.println(ss);
	}
}