package cn.tedu.cloudnote.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloudnote.entity.User;
import cn.tedu.cloudnote.service.NameException;
import cn.tedu.cloudnote.service.PasswordException;
import cn.tedu.cloudnote.service.UserService;
import cn.tedu.cloudnote.util.JsonResult;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	@ResponseBody
	@RequestMapping("/login.do")
	public Object login(String name,String password){
		try {
			User user
			=userService.Login(name, password);
			return new JsonResult(user);
		}catch (NameException e) {
			e.printStackTrace();
			return new JsonResult(2,e);	
		}catch (PasswordException e) {
			e.printStackTrace();
			return new JsonResult(3,e);	
		}catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(e);	
		}	
	}
	//用户注册
	@RequestMapping("/regist.do")
	@ResponseBody
	public JsonResult regist(String name,String password,
							 String nick){
		try {
			User user
			=userService.regist(name, password, nick);
			return new JsonResult(user);
		} catch(NameException e){
			e.printStackTrace();
			return new JsonResult(2,e);
		}catch(PasswordException e){
			e.printStackTrace();
			return new JsonResult(3,e);
		}catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(e);
		}
	}
}






