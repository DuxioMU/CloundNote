$(function(){	//Body加载完调用
		//登录事件绑定
		$("#login").click(loginAction);
		//注册事件绑定
		$("#regist_button").click(registAction);
}); 
function loginAction(){ //绑定登录单击事件
			//清空提示信息
			$("#count_span").html("");
			$("#password_span").html("");
			//获取参数
			var name=$("#count").val().trim();
			var password=$("#password").val().trim();
			//alert(name+","+password);
			var ok=true;
			//检测参数格式
			if(name==""){
				$("#count_span").html("用户名为空");
				ok=false;
			}
			if(password==""){
				$("#password_span").html("密码为空");
				ok=false;
			}
			//发送Ajax请求
			if(ok){	//格式检测通过
				$.ajax({
					url:path+"/user/login.do",
					type:"post",
					data:{"name":name,"password":password},
					dataType:"json",
					success:function(result){
						if(result.state==0){ //登录成功
							//将用户信息写入cookie
							var user=result.data;
							addCookie("userId",user.id,2);
							window.location.href="edit.html";
						}else if(result.state==2){//用户名错误
							$("#count_span").html(result.message);
						}else if(result.state==3){//密码错误
							$("#password_span").html(result.message);
						}
					},
					error:function(){
						alert("登录失败");
					}
				});
			}
		}
function registAction(){
	//清空提示信息
	$("#warning_1 span").html("");
	$("#warning_2 span").html("");
	$("#warning_3 span").html("");
	//获取参数
	var name=$("#regist_username").val().trim();
	var nick=$("#nickname").val().trim();
	var password=$("#regist_password").val().trim();
	var final_password=$("#final_password").val().trim();
	//alert(name+","+nick+","+password+","+final_password);
	var ok=true;
	//检测用户名
	if(name==""){
		ok=false;
		$("#warning_1 span").html("用户名为空");
		$("#warning_1").show();
	}
	//检测密码
	if(password==""){
		ok=false;
		$("#warning_2 span").html("密码为空");
		$("#warning_2").show();
	}else if(password.length<6){
		ok=false;
		$("#warning_2 span").html("密码长度小于6位");
		$("#warning_2").show();
	}
	//检测确认密码
	if(final_password!=password){
		ok=false;
		$("#warning_3 span").html("密码不一致");
		$("#warning_3").show();
	}
	//发送请求
	if(ok){
		$.ajax({
			url:path+"/user/regist.do",
			type:"post",
			data:{
				"name":name,
				"nick":nick,
				"password":password
			},
			dataType:"json",
			success:function(result){
				if(result.state==0){
					//接收data数据
					var user=result.data;
					//返回登录页面
					$("#back").click();
					//显示注册用户名
					$("#count").val(user.name);
					$("#password").focus();
					//用户名被占用提示
				}else if(result.sate==2){
					$("#warning_1 span").html(result.message);
					$("#warning_1").show();
				}else{
					alert(result.message);
				}
			},
			error:function(){
				alert("注册失败");
			}
		});
	}
}

