#注册功能

##处理流程
- 发送Ajax请求
- 服务器处理
- Ajax回调处理

##发送Ajax请求

- 事件绑定: "登录"按钮的单击事件

- 获取参数: 用户名 密码 昵称

- 格式的检测: 

  用户名 密码 确认密码不能为空

  密码长度不小于6位

  密码和确认密码是否一致

- 请求地址: user/regist.do

- 发送请求$.ajax();

##服务器处理

- Controller

  接收参数

  匹配请求

  调用service

  返回数据的处理

- Service

  接口:regist(String name,String password,String nick)

  实现类:

  判断用户名是否被占用

  格式检测(用户名 密码 昵称)

  生成id

  password加密

  创建对象:user

  调用dao.addUser(user)

  测试userService
  

- Dao:

  UserDao-void addUser(User user)

  mapper:insert语句

  测试方法


##Ajax回调处理

- 跳转到登录页面

- 默认显示用户名

- 用户名被占用

##UUID

- 为什么采用UUID

- 服务器生成ID

- 数据库生成ID

#作业

独立实现登录/注册需求功能(重点是流程).





