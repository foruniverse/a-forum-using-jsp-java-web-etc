# a-forum-using-jsp-java-web-etc

双流大学 数据库课程设计

## 介绍

-  **运行环境 **<br>

  > *Eclipse Java EE IDE for Web Developers.*    <br>
  >
  > *Version: Kepler Release* <br>
  >
  > *Build id: 20130614-0229*

- **JDK版本**  

  >JRE System Library[jre 1.8.0_231]

- **tomcat版本**  

  > Tomcat v 7.0  

- **SQL**  

  > pgsql  

- **pgsql的连接**  

  > 在***src/util*** 中在下列代码里填入你自己的pgsql **账户** 和 **密码** <br>
  >
  > ```java
  > private static final String USER = "账户";
  > private static final String PASSWORD = "密码";
  > ```

##  数据库&& table

- **评论**   （***comment***)  

  ```sql
  create table comment
  (
      postid int,
      username varchar(100),
      time timestamp,
      content varchar(1000),
      likecount int,
      height int
  )  
  ```

- **板块** （***plate***）

  ```sql
  create table plate(
      id int,
      name varchar(100),
      postCount int
  )
  ```

- **帖子** （***post***）

  ~~~sql
  create table post
  (
  	pid int, 					#标识id
  	creatorName varchar(20),
      plateid int, 				#板块ID
  	title varchar(200),
  	content varchar(10000),
  	createTime timestamp,
  	replyTime timestamp,
  	commentCount int
  )
  ~~~

- **用户** ***（users）***

   ~~~sql
  create table users
  (
  	sid int,					#用户ID
  	spwd varchar(18),			#用户密码
  	age int,
  	sname varchar(10),
      root int,					#管理员标识
  	primary key(sid)
  )
   ~~~

  > *在密码的处理上，直接将用户的密码存储在数据库里是不妥当的*
  >
  > *我的建议是哈希散列，保留散列后的值 至于为什么，没有这么做，~~当然是因为我太勤奋了~~*

- **注意事项**
  - *主码之类的自己设置*
  - 表可能没给全
  - 表项可能也没给全  

##  **关于代码**

- **网页框架**

  > bootstrap

- **模板**  

  > 套用的  

- **没用js**

  > 没用js的结果,代码异常混乱,非响应式,前后端耦合严重  

## **实现的功能**

- **帖子分类**
- **发帖** ~~*废话*~~  
- **帖子评论**
- **管理员操作**

- **搜索**  
- **用户登录/注册**
- **没有富文本编辑器**

## **截图**

- **登录**     

  ![login](https://github.com/foruniverse/a-forum-using-jsp-java-web-etc/blob/master/scr  eensnap/login.png)     <br>

  

  

  

  

  

  

  

  