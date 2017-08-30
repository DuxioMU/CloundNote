package cn.tedu.cloudnote.test;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.cloudnote.entity.Note;
import cn.tedu.cloudnote.service.NoteService;

public class TestNoteService 
	extends TestCaseBase{
	
	NoteService service;
	
	@Before
	public void initService(){
		service = ctx.getBean(
			"noteService", NoteService.class);
	}
	@Test
	public void testListNotes(){
		String notebookId="0b11444a-a6d6-45ff-8d46-282afaa6a655";
		List<Map<String, Object>> list=
				service.listNotes(notebookId);
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}
	
	@Test
	public void testGetNote(){
		String noteId = "019cd9e1-b629-4d8d-afd7-2aa9e2d6afe0";
		Note note = service.getNote(noteId);
		System.out.println(note);
	}
	
	@Test
	public void testUpdate(){
		String id = "019cd9e1-b629-4d8d-afd7-2aa9e2d6afe0";
		String title = "Test";
		String body = "今天天气不错";
		boolean b = service.update(id, title, body);
		Note note = service.getNote(id);
		System.out.println(b);
		System.out.println(note);
	}
}



