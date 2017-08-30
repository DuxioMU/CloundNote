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
	
	boolean update(String noteId, 
			String title, String body)
		throws NoteNotFoundException;
	
	public Note addNote(String userId, 
			String notebookId, String title)
			throws UserNotFoundException,
			NotebookNotFoundException;
	
	public boolean moveNote(String noteId, 
			String notebookId)
			throws NoteNotFoundException,
			NotebookNotFoundException;
	
	//NoteService
	boolean deleteNotes(String... ids);
	// String[]  ==  String... 变长参数
	// 调用时候:
	// String[] 参数 必须传递数组参数:
	//   deleteNotes(new String[]{"id1","id2","id3"})
	// String... 参数可以直接传递元素:
	//   deleteNotes("id1","id2","id3","id4")
	// 或deleteNotes(new String[]{"id1","id2","id3"})
	//   编译器会将"id1","id2","id3" 替换为数组
	// 注意: String... 只能使用在最后一个参数位置
	
	
	
}











