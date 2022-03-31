
# 说明

代码源地址：
https://gitee.com/dtl/kettle-core

修改：
pom文件
增加测试类 Client

使用步骤：
1、docs/maven导入kettle包 
2、maven 构建项目成功
3、运行测试类

# kettle-core

#### 介绍
基于kettle 8.3 开源版 集成java调用
java调用 Trans及 Job

kettle基础的jar存放在lib在

#### 使用说明

1.  添加插件
有时kettle脚本需要自身插件,可将需要用到的插件统一放到一个目录下,然后指定目录.
kettle插件存放路径 在跟目录下的plugins文件夹内.
添加插件方法:
KettleConfig.getInstance().addPluginFolder(插件的目录路径);
2.  添加Jndi
对于某些特殊的服务连接,例如:mysql8 就会用到 jndi
添加jndi文件夹路径
KettleConfig.getInstance().setJndi(jndi文件目录路径)
3.  执行 Trans
fname:执行的ktr脚本文件地址
params:参数
KettleImplement.runKtr(fname,params);
4.  执行 Job
fname:执行的job脚本文件地址
params:参数
KettleImplement.runKjb(filename, params);

