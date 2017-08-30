package cn.tedu.cloudnote.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.cloudnote.entity.Note;

public interface NoteDao {
	
	/**
	 * 查询一个笔记本中的全部笔记信息
	 * @param notebookId
	 * @return 笔记列表, 每个元素包含id和titile
	 */
	List<Map<String, Object>> findNotesByNotebookId(
			String notebookId);
	
	Note findNoteById(String noteId);
	
	int updateNote(Note note);
	
	int addNote(Note note);
	
	//NoteDao
	int deleteNoteById(String id);
	
	int deleteNotesById(String... ids);
	
	/**
	 * 多参数查询 
	 * @param param 可以接受参数 title, body, key 
	 * @return
	 */
	List<Map<String, Object>> findNotesByParam(
			Map<String, Object> param);
	
	List<Map<String, Object>> findNotesByKey(
			@Param("title") String title,  
			@Param("body") String body, 
			@Param("key") String key);
	// map("title":title, "body":body, "key":key)
	
}









