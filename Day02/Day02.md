#需求实现流程

1 发送Ajax请求

2 服务器的处理

3 Ajax回调处理

#登录需求
##发送Ajax请求
- 事件绑定:"登录"按钮单击事件
- 获取参数: 用户名和密码
- 格式检测: 空为例
- 请求地址: /user/login.do
- 请求类型: post方式

##服务器的处理
- /user/login.do->Servlet->Mapping

- Controller.login(String name,String password)
  - JsonResult{state: data: message:}
  - 请求的匹配
  - 接收参数数据
  - 调用service
  - json处理

- Service.login(String name,String password)\
  - 调用Dao
  - 比对密码:
  - 明文比对/加密数据比对

- Dao--findByName(String name)--select操作

##Ajax回调处理

- success:

保存cookie

进入edit.html主页面

判断异常处理的情况(用户名错误/密码错误)

- error:提示:登录失败

##伪代码:

1 发送事件代码写在哪:

		html-<script>-$(function(){});

2 事件的绑定:

		登录.click(function(){	
		})

3 获取参数:
		function(){
			var name = 对象.value().trim()
			var password=对象.value().trim()
			if(空){
			}else{
			}
				Ajax请求
			}

		update cn_user set cn_user_password='4QrcOUm6Wau+VuBX8g+IPg==' where cn_user_name='demo';


作业:

- 独立完成登录请求发送和服务器处理

- 完成回调处理(扩展)










