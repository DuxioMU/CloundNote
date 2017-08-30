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
	//TestNoteService
	@Test
	public void testDeleteNotes(){
		String id1 = "3febebb3-a1b7-45ac-83ba-50cdb41e5fc1";
		String id2 = "9187ffd3-4c1e-4768-9f2f-c600e835b823";
		String id3 = "ebd65da6-3f90-45f9-b045-782928a5e2c0";
		String id4 = "fed920a0-573c-46c8-ae4e-368397846efd";
		boolean b = service.deleteNotes(
				id1, id2, id3, id4);
		System.out.println(b);
	}
}













