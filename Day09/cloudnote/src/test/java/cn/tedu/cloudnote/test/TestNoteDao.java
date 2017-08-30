package cn.tedu.cloudnote.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.cloudnote.dao.NoteDao;
import cn.tedu.cloudnote.entity.Note;

public class TestNoteDao extends TestCaseBase{
	NoteDao dao;
	@Before
	public void initDao(){
		dao = ctx.getBean("noteDao", NoteDao.class);
	}
	@Test
	public void testFindNotesByNotebookId(){
		String notebookId="0b11444a-a6d6-45ff-8d46-282afaa6a655";
		List<Map<String, Object>> list=
			dao.findNotesByNotebookId(notebookId);
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}
	
	@Test
	public void testFindNoteById(){
		String noteId = "019cd9e1-b629-4d8d-afd7-2aa9e2d6afe0";
		Note note = dao.findNoteById(noteId);
		System.out.println(note);
	}
	
	@Test
	public void testUpdateNote(){
		Note note = new Note();
		String noteId = "019cd9e1-b629-4d8d-afd7-2aa9e2d6afe0";
		note.setId(noteId);
		note.setTitle("Test");
		note.setBody("Test123");
		note.setLastModifyTime(System.currentTimeMillis());
		dao.updateNote(note);
		note = dao.findNoteById(noteId);
		System.out.println(note); 
	}
	
	@Test
	public void testDeleteNotesById(){
		String id1="c347f832-e2b2-4cb7-af6f-6710241bcdf6";
		String id2="07305c91-d9fa-420d-af09-c3ff209608ff";
		String id3="5565bda4-ddee-4f87-844e-2ba83aa4925f";
		String id4="1ec185d6-554a-481b-b322-b562485bb8e8";
		int n = dao.deleteNotesById(id1, id2, id3, id4);
		System.out.println(n); 
	}
	
	@Test
	public void testFindNotesByParam(){
		Map<String, Object> param=
				new HashMap<String, Object>();
		param.put("title", "%ABC%");
		param.put("body", "%ABC%");
		param.put("key", "%1%");
		List<Map<String, Object>> list=
			dao.findNotesByParam(param);
		for (Map<String, Object> map : list) {
			System.out.println(map); 
		}
	}
	
	@Test
	public void testFindNotesByKey(){
		List<Map<String, Object>> list=
				dao.findNotesByKey(
				"%1%", null, null);
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}
}











