package cn.tedu.cloudnote.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.cloudnote.dao.NotebookDao;
import cn.tedu.cloudnote.dao.UserDao;
import cn.tedu.cloudnote.entity.User;

@Service("notebookService")
public class NotebookServiceImpl 
	implements NotebookService {

	@Resource //注入数据层 
	private NotebookDao notebookDao;
	
	@Resource
	private UserDao userDao;
	
	public List<Map<String, Object>> 
		listNotebooks(String userId) 
		throws UserNotFoundException {
		if(userId==null || userId.trim().isEmpty()){
			throw new UserNotFoundException("ID空");
		}
		User user = userDao.findUserById(userId);
		if(user==null){
			throw new UserNotFoundException("ID不存在");
		}
		return notebookDao.findNotebookByUserId(userId); 
	}
}



