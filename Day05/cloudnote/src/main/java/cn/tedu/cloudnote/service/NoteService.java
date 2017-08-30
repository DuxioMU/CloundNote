package cn.tedu.cloudnote.service;

import java.util.List;
import java.util.Map;

import cn.tedu.cloudnote.entity.Note;

public interface NoteService {
	/**
	 * 笔记列表功能 
	 * @param notebookId 笔记本ID
	 * @return 笔记本中的笔记列表, 每个笔记对象包含
	 *   id和title两个属性 
	 * @throws NotebookNotFoundException 笔记本不存在
	 *   时候抛出异常 
	 */
	List<Map<String, Object>> listNotes(
			String notebookId)
		throws NotebookNotFoundException;
	
	Note getNote(String noteId)
			throws NoteNotFoundException;
}



