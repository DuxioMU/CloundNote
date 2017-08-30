package cn.tedu.cloudnote.service;

import java.util.List;
import java.util.Map;

public interface NotebookService {
	/**
	 * 根据用户ID查询笔记本列表 
	 * @param userId 用户ID
	 * @return 笔记本列表, 每个笔记本信息包含ID和name
	 * @throws UserNotFoundException 用户ID不存在时候
	 *   抛出异常
	 */
	List<Map<String, Object>> listNotebooks(
			String userId) 
			throws UserNotFoundException;
}




