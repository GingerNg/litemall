
### class1 2023-02-25
- spring生态介绍
- 启动这个项目-前端
- node:v14.0.0

### class2
- 数据库配置
- 安装java-11 可参考:https://blog.csdn.net/qq_42148563/article/details/124668739
- apt 安装java-11
sudo apt install -y openjdk-11-jdk
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar

- maven(Maven 3.6.3)
mvn clean package # 在项目根目录打包
前后端连接http:配置IP和port
- java -jar litemall-admin-api-0.1.0-exec.jar


### class3
- Shiro: doGetAuthorizationInfo, doGetAuthenticationInfo, getSessionId
- 使用Shiro实现login的过程

### class4
- 图片上传
- 显示服务器上的一张图片
- java.io.File vs java.nio.file.Files
- AdminStorageController.create()
- WxStorageController.fetch()
- litemall-core/src/main/java/org/linlinjava/litemall/core/storage/config
通过配置文件, 设置文件的存储方式
接口-class

org.springframework.core.io.Resource

- WxAuthController

- BCryptPasswordEncoder 加密算法

### class5
- 复习
- AOP


### class6
- AOP服务 复习
- url中的#符号
在VUE中，路由的实现方式有两种，其中一种就是通过#标识符进行页面内导航从而实现路由切换
[Vue路由切换的两种方式](https://blog.csdn.net/qq_51133939/article/details/126282421)
- 读写CSV
- 领域模型




### 权限管理
- Shiro
- 登陆前，登陆后，哪些页面是不登陆就可以访问的？如何设置？Why？
- 后端
- 前端，

### Mybatis
- Configure
- Create your MyBatis mapper interfaces and XML files that define your SQL queries.
- Annotate your mapper interfaces with @Mapper to make them discoverable by Spring





kickoff

login-register + 文件上传+显示+下载 ---> 大作业1
                            + 分页  ---> 大作业2

请求外部接口