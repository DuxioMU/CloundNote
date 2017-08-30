package cn.tedu.cloudnote.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.EJB;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloudnote.service.NotebookService;
import cn.tedu.cloudnote.util.JsonResult;

@Controller
@RequestMapping("/notebook")
public class NotebookController extends BaseController {
	
	@Resource
	private NotebookService notebookService;
	
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonResult list(String userId){
		//调用业务层 notebookService
		List<Map<String, Object>> list=
			notebookService.listNotebooks(userId);
		return new JsonResult(list);
	}
	
}






