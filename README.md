# MovieBooking
这是一个在线的影院订票网站，提供查阅正在上映与将要上映的电影信息与订票等服务。
1.本平台采用（JSP+Servlet+ SQL Server）三层框架，需要用到的 Java 相关技术有 jsp 技术、servlet 技术、jdbc 技术等。
2.本系统分为前台和后台两大模块
  前台模块功能：
  （1）影片信息展示模块：
       分为正在上映板块和即将上映板块，以图片形式滚动展示影片目录。点击图片可进入单个影片信息界面。（已登录的用户可查看该影片是否收藏）
  （2）收藏夹模块：
       在用户登录之后可查看已收藏的影片图片目录，点击图片可进入单个影片信息界面。
  （3）影片查询界面：可按片名关键字或演员名关键字进行检索。
  （4）用户登录注册界面：
       用户输入个人信息注册账号、使用账号密码登录系统。
  （5）用户模块：
       用户登录后可查看订票信息或进行退票操作；可修改个人信息资料；可修改账户密码；可进行注销操作。
  后台模块功能：
  （1）电影管理模块：
       管理员可看到各部电影列表，对各部电影的信息进行维护、修改，同时管理员可以及时更新电影；
  （2）影院管理模块：
       管理员可以浏览各影院，对影院的地区、地址、电话和名称等信息进行查看、修改和删除；
  （3）订单管理模块：
       管理员可以查看用户的订单详情、删除订单；
  （4）用户信息管理模块：
       管理员可从后台查看用户的整体信息，同时还能查看用户的收藏影片情况.
3.平台的软件环境配置为：
  Windows10 X64操作平台
  SQL Server 2017 数据库
  JDK1.8.0
  Eclipse2019-03开发工具包
  Tomcat9.0 服务器
