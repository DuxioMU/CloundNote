package cn.tedu.cloudnote.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.cloudnote.dao.NoteDao;
import cn.tedu.cloudnote.dao.NotebookDao;
import cn.tedu.cloudnote.entity.Note;
import cn.tedu.cloudnote.entity.Notebook;

@Service("noteService")
public class NoteServiceImpl implements NoteService {

	@Resource 
	private NoteDao noteDao;
	
	@Resource
	private NotebookDao notebookDao;
	
	public List<Map<String, Object>> 
		listNotes(String notebookId) 
		throws NotebookNotFoundException {
		if(notebookId==null || notebookId.trim().isEmpty()){
			throw new NotebookNotFoundException("Id空");
		}
		Notebook notebook = notebookDao
				.findNotebookById(notebookId);
		if(notebook==null){
			throw new NotebookNotFoundException(
				"笔记本不存在");
		}
		return noteDao.findNotesByNotebookId(notebookId);
	}
	
	public Note getNote(String noteId)
			throws NoteNotFoundException {
		if(noteId==null||noteId.trim().isEmpty()){
			throw new NoteNotFoundException("ID空");
		}
		Note note = noteDao.findNoteById(noteId);
		if(note==null){
			throw new NoteNotFoundException("id错误");
		}
		return note;
	}

}







