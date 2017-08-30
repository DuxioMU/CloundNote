package cn.tedu.cloudnote.test;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.cloudnote.service.NotebookService;

public class TestNotebookService 
	extends TestCaseBase{
	
	NotebookService service;
	
	@Before
	public void initService(){
		service = ctx.getBean("notebookService",
			NotebookService.class);
	}
	
	@Test
	public void testListNotebooks(){
		String userId="333c6d0b-e4a2-4596-9902-a5d98c2f665a";
		List<Map<String, Object>> list=
			service.listNotebooks(userId);
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}
	
	@Test
	public void testFindByPage(){
		String userId="333c6d0b-e4a2-4596-9902-a5d98c2f665a";
		int page = 1;
		List<Map<String, Object>> list=
			service.listNotebooks(userId, page);
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}
}





