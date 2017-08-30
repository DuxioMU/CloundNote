package cn.tedu.cloudnote.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.cloudnote.entity.Notebook;

public interface NotebookDao {
	
	/**
	 * 根据用户的ID查找这个用户的全部笔记本信息 
	 * @param userId 用户ID
	 * @return 笔记本信息列表, 每个笔记本信息包含id和name属性
	 */
	List<Map<String, Object>> findNotebookByUserId(
			String userId);
	
	Notebook findNotebookById(String notebookId);
	
	/**
	 * 分页查询方法
	 * @param userId
	 * @param start 起始位置
	 * @param size 每页查询行数
	 * @return
	 */
	List<Map<String, Object>> findNotebookByPage(
			@Param("userId") String userId,
			@Param("start") int start,
			@Param("size") int size);
}




