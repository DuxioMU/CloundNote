package cn.tedu.cloudnote.test;

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
}











