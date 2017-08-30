package cn.tedu.cloudnote.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.cloudnote.dao.NoteDao;
import cn.tedu.cloudnote.dao.NotebookDao;
import cn.tedu.cloudnote.dao.UserDao;
import cn.tedu.cloudnote.entity.Note;
import cn.tedu.cloudnote.entity.Notebook;
import cn.tedu.cloudnote.entity.User;

@Service("noteService")
//@Transactional
public class NoteServiceImpl implements NoteService {

	@Resource 
	private NoteDao noteDao;

	@Resource 
	private UserDao userDao;
	
	@Resource
	private NotebookDao notebookDao;
	
	@Transactional(readOnly=true)
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
	
	@Transactional(readOnly=true)
	public Note getNote(String noteId)
			throws NoteNotFoundException {
		if(noteId==null||noteId.trim().isEmpty()){
			throw new NoteNotFoundException("ID空");
		}
		Note note = noteDao.findNoteById(noteId);
		//保存读取记录....
		if(note==null){
			throw new NoteNotFoundException("id错误");
		}
		return note;
	}
	
	@Transactional(isolation=Isolation.READ_UNCOMMITTED)
	public boolean update(String noteId, String title, String body) throws NoteNotFoundException {
		if(noteId==null || noteId.trim().isEmpty()){
			throw new NoteNotFoundException("ID不能空");
		}
		Note note = noteDao.findNoteById(noteId);
		if(note==null){
			throw new NoteNotFoundException("没有对应的笔记");
		}
		Note data = new Note();
		if(title!=null && !title.equals(note.getTitle())){
			data.setTitle(title);
		}
		if(body!=null && !body.equals(note.getBody())){
			data.setBody(body);
		}
		data.setId(noteId);
		data.setLastModifyTime(System.currentTimeMillis());
		System.out.println(data); 
		int n = noteDao.updateNote(data);
		return n==1;
	}
	
	@Transactional
	public void addScore(){
		//String s = null;
		//s.length();
	}
	
	@Transactional
	public Note addNote(String userId, 
			String notebookId, String title)
			throws UserNotFoundException, 
			NotebookNotFoundException {
	
		if(userId==null||userId.trim().isEmpty()){
			throw new UserNotFoundException("ID空");
		}
		User user=userDao.findUserById(userId);
		if(user==null){
			throw new UserNotFoundException("木有人");
		}
		if(notebookId==null||notebookId.trim().isEmpty()){
			throw new NotebookNotFoundException("ID空");
		}
		Notebook notebook=notebookDao.findNotebookById(notebookId);
		if(notebook==null){
			throw new NotebookNotFoundException("没有笔记本");
		}
		if(title==null || title.trim().isEmpty()){
			title="葵花宝典";
		}
		String id = UUID.randomUUID().toString();
		String statusId = "0";
		String typeId = "0";
		String body = "";
		long time=System.currentTimeMillis();
		Note note = new Note(id, notebookId,
			userId, statusId, typeId, title, 
			body, time, time);
		int n = noteDao.addNote(note);
		if(n!=1){
			throw new NoteNotFoundException("保存失败");
		}
		//调用子业务方法
		addScore();
		return note;
	}
	
	@Transactional //必须配置事务管理器才能生效
	public boolean moveNote(String noteId, String notebookId) throws NoteNotFoundException, NotebookNotFoundException {
		if(notebookId==null||notebookId.trim().isEmpty()){
			throw new NotebookNotFoundException("ID空");
		}
		Notebook notebook=notebookDao.findNotebookById(notebookId);
		if(notebook==null){
			throw new NotebookNotFoundException("没有笔记本");
		}
		if(noteId==null || noteId.trim().isEmpty()){
			throw new NoteNotFoundException("ID不能空");
		}
		Note note = noteDao.findNoteById(noteId);
		if(note==null){
			throw new NoteNotFoundException("没有对应的笔记");
		}
		Note data = new Note();
		data.setId(noteId);
		data.setNotebookId(notebookId);
		data.setLastModifyTime(System.currentTimeMillis());
		System.out.println(data); 
		int n = noteDao.updateNote(data);
		
		//String s = "";
		//s.charAt(0);
		
		return n==1;
	}

	@Transactional
	public boolean deleteNotes(String... ids) {
		//for(String id : ids){
		//	int n = noteDao.deleteNoteById(id);
		//	if(n!=1){
		//		throw new NoteNotFoundException(
		//				"ID错误!");
		//	}
		//}
		int n = noteDao.deleteNotesById(ids);
		if(n == ids.length){
			return true;
		}
		throw new NoteNotFoundException("ID错误!");
	}
}







