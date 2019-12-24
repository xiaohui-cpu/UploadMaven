### 灵犀外卖（Spring版）
灵犀外卖受益于开源，也会回馈于开源。灵犀外卖会秉承“拥抱开放、合作共赢、创造价值”的理念，在开源的道路上继续砥砺前行，和更多的社区开发者一起为国内外开源做出积极贡献。

官网：暂无

论坛：没有

演示地址：等待开发

Spring版QQ群交流群①群：静等



灵犀外卖是一套实用的外卖订餐系统，除了具备外卖订餐系统的通用功能，如菜肴展示、菜肴评论、订单、接单等， 灵犀外卖还有许多独有功能


## 开发环境
Eclipse + VMware Workstation Pro + 微信开发者工具


## 背景介绍环境

餐饮领域一直是备受人们关注的一个领域，在这一领域的移动应用有着广泛的市场。一些中档或者高档的饭店，为了吸引更多的顾客，不断提高饭店的服务质量，提高用户体验。而在移动互联网浪潮的推动下，智能化的生活方式及体验逐渐进入了人们生活，因此为了顺应时代发展，餐饮业需要适当改变原有的人工服务方式，这时候就急需一款适用于餐饮行业的软件，能够实现人员管理、点餐管理、支付等操作，使餐饮业的工作效率提升、工作方式智能化、便捷化。

因此期末答辩写了一个餐饮管理系统，这个系统拥有系统的管理后台，供饭店管理人员使用，用于人员管理以及菜单管理等多方面内容的管理；同时还有移动客户端，供送餐员和顾客使用，能够实现餐桌管理（等待后续开发）、点餐、网银支付（等待后续开发）、后厨打印菜单（等待后续开发）等功能。并且界面设计美观，很适用于一般饭店。


## 功能描述
- 微信客户端
1. 查看菜单
2. 菜品详情
3. 点餐（包括切换购物车，生成订单，支付等功能）
4. 查询已完成菜单
4. 评分反馈，对菜品、服务评分
5. 查询商家信息
6. 设置送餐地址


- 管理后台
1. 商品管理（包含新增商品、所有商品）
2. 菜单管理（包含菜单管理、菜单分类）
3. 订单管理（包含订单总览）
4. 老板查账（包含收入统计）
5. 评价管理（包含评价总览）
6. 系统管理（包含店铺信息）
7. 系统管理（包含用户管理、角色管理、菜单管理、角色权限管理、用户角色管理）



## 主要技术栈

核心框架：Spring MVC

缓存：redis

图片上传：FastDFS

数据库连接池：mysql

工具类：JsonUtils,PropertyUtils,PIPIUtils

项目构建工具：maven

Web容器：tomcat 

数据交互：AJAX 

UI框架：Easy-ui 



## 安装说明

1、配置java运行环境，redis环境，FastDFS环境，tomcat环境，mysql环境。 
 
2、创建数据库（看数据库说明）。

3、导入maven项目 。

4、修改`/termend-manager-service/src/main/resources/properties/db.properties`下的数据库配置文件。

5、修改`/termend-manager-service/src/main/resources/properties/redis.properties`下的redis连接文件。

6、修改`/termend-manager-service/src/main/resources/spring/applicationContext-redis.xml`下的redis单机版连接文件。

7、修改`/termend-manager-service/src/main/resources/spring/applicationContext-service.xml`下的dubbo服务器连接文件。

8、修改`/termend-manager-web/src/main/resources/resource/fdfs_client.conf`下的FastDFS连接文件。

9、tomcat启动端口号在`/termend-manager-web/pom.xml`、`/termend-manager-service/pom.xml`下修改。  

默认账号 admin 默认密码 admin  


## 数据库说明
1、address（送餐地址表 ） 
```
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动增长id',
  `openid` varchar(35) DEFAULT NULL COMMENT '用户唯一id',
  `name` varchar(50) NOT NULL COMMENT '收件人名字',
  `mobile` varchar(20) NOT NULL COMMENT '电话',
  `gender` int(11) DEFAULT '1' COMMENT '1-男士   2-女士',
  `address` varchar(500) NOT NULL COMMENT '地址详情',
  `is_default` int(11) DEFAULT '0' COMMENT '0、默认地址  1、非默认地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8

```
2、disk（菜品表）
```
CREATE TABLE `disk` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜id',
  `menu_id` int(11) NOT NULL COMMENT '菜单的id',
  `menu` varchar(500) DEFAULT NULL,
  `img` varchar(500) DEFAULT NULL COMMENT '图片地址',
  `title` varchar(100) DEFAULT NULL,
  `price` float NOT NULL COMMENT '原价',
  `dis_price` float DEFAULT '0' COMMENT '优惠价',
  `sell_point` varchar(500) DEFAULT NULL,
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  `updated` datetime DEFAULT NULL COMMENT '修改时间',
  `sellnum` int(11) DEFAULT '0',
  `status` int(4) NOT NULL DEFAULT '1' COMMENT '商品状态，1-正常，2-优惠中 3-下架，4-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8

```
3、evaluate（菜品评价表）
```
CREATE TABLE `evaluate` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评价id',
  `disk_id` int(11) DEFAULT NULL COMMENT '评价的菜id',
  `order_id` varchar(50) DEFAULT NULL COMMENT '订单的id',
  `openid` varchar(35) DEFAULT NULL COMMENT '微信用户的开放id唯一',
  `nickname` varchar(100) DEFAULT NULL COMMENT '评价人昵称',
  `avatar_url` varchar(500) DEFAULT NULL COMMENT '评价人头像',
  `content` varchar(500) DEFAULT NULL COMMENT '评价的描述',
  `imgs` varchar(500) DEFAULT NULL COMMENT '评价时加的照片',
  `is_anoymous` int(11) DEFAULT '1' COMMENT '是否匿名 1 - 匿名 0- 不匿名',
  `eval_Value` int(11) DEFAULT '3' COMMENT '评价值 1 - 差评 2 - 中评 3 - 好评',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  `updated` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8

```
4、menu
```
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `parent_id` int(11) DEFAULT '1',
  `is_parentId` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8

```
5、order_address（订单接受地址）
```
CREATE TABLE `order_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动增长id',
  `order_id` varchar(50) DEFAULT NULL COMMENT '订单id',
  `name` varchar(50) DEFAULT NULL COMMENT '收件人姓名',
  `mobile` varchar(20) DEFAULT NULL COMMENT '电话',
  `gender` int(11) DEFAULT '1' COMMENT '1 - 男士 2 - 女士',
  `address` varchar(500) DEFAULT NULL COMMENT '地址详情',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8

```
6、order_item（购物车表）
```
CREATE TABLE `order_item` (
  `order_item` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动增长id',
  `disk_id` int(11) DEFAULT NULL COMMENT '菜品id',
  `order_id` varchar(50) DEFAULT NULL COMMENT '订单id',
  `num` int(10) DEFAULT NULL COMMENT '商品购买数量',
  `title` varchar(200) DEFAULT NULL COMMENT '商品标题',
  `price` float DEFAULT NULL COMMENT '商品单价',
  `dis_price` float DEFAULT NULL COMMENT '商品折扣价',
  `total_price` float DEFAULT NULL COMMENT '商品总金额',
  `img` varchar(200) DEFAULT NULL COMMENT '商品图片地址',
  PRIMARY KEY (`order_item`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8

```
7、order_main（订单状态表）
```
CREATE TABLE `order_main` (
  `id` varchar(50) NOT NULL COMMENT '订单id',
  `openid` varchar(35) DEFAULT NULL COMMENT '用户id',
  `total_money` varchar(50) DEFAULT NULL COMMENT '实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分',
  `status` int(10) DEFAULT NULL COMMENT '状态：1、未付款，2、已付款，3、已接单 ，4、已发货  5、交易成功，7、交易取消（未付款请款下取消）8、交易取消（付款情况下取消记得退款）',
  `create_time` datetime DEFAULT NULL COMMENT '订单创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '订单更新时间',
  `payment_time` datetime DEFAULT NULL COMMENT '付款时间',
  `consign_time` datetime DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime DEFAULT NULL COMMENT '交易完成时间',
  `close_time` datetime DEFAULT NULL COMMENT '交易关闭时间',
  `remarks` varchar(100) DEFAULT NULL COMMENT '买家留言',
  `is_evaluate` int(2) DEFAULT NULL COMMENT '买家是否已经评价1-未评价 2-评价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

```
8、sys_right
```
CREATE TABLE `sys_right` (
  `right_code` varchar(50) NOT NULL,
  `right_parent_code` varchar(50) DEFAULT NULL,
  `right_type` varchar(20) DEFAULT NULL,
  `right_text` varchar(50) DEFAULT NULL,
  `right_url` varchar(100) DEFAULT NULL,
  `right_tip` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`right_code`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312

```
9、sys_role（角色表）
```
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  `role_desc` varchar(50) DEFAULT NULL,
  `role_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gb2312
```
10、sys_role_right
```
CREATE TABLE `sys_role_right` (
  `rf_right_code` varchar(50) NOT NULL,
  `rf_role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`rf_right_code`,`rf_role_id`),
  KEY `FK550439C52683C738` (`rf_role_id`),
  KEY `FK550439C54693100E` (`rf_right_code`),
  KEY `FK550439C51D9DB87A` (`rf_right_code`),
  KEY `FK550439C5908C614C` (`rf_role_id`),
  KEY `FK550439C548544538` (`rf_right_code`),
  KEY `FK550439C5269244CE` (`rf_role_id`),
  CONSTRAINT `FK550439C51D9DB87A` FOREIGN KEY (`rf_right_code`) REFERENCES `sys_right` (`right_code`),
  CONSTRAINT `FK550439C52683C738` FOREIGN KEY (`rf_role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312

```
11、sys_user（用户表）
```
CREATE TABLE `sys_user` (
  `usr_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `usr_name` varchar(50) NOT NULL,
  `usr_password` varchar(50) NOT NULL,
  `true_name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `usr_flag` int(11) NOT NULL,
  `usr_role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`usr_id`),
  KEY `FK74A81DFD1A881E98` (`usr_role_id`),
  KEY `FK74A81DFD8490B8AC` (`usr_role_id`),
  KEY `FK74A81DFD1A969C2E` (`usr_role_id`),
  CONSTRAINT `FK74A81DFD8490B8AC` FOREIGN KEY (`usr_role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gb2312

```
默认账号 admin 默认密码 admin  


## 部署说明

本项目JDK要求JDK8及以上

### 一、Dubbo部署

单一工程中spring的配置
```
<bean id="xxxService" class="com.xxx.XxxServiceImpl" />
<bean id="xxxAction" class="com.xxx.XxxAction">
	<property name="xxxService" ref="xxxService" />
</bean>
```

远程服务：
在本地服务的基础上，只需做简单配置，即可完成远程化：

将上面的local.xml配置拆分成两份，将服务定义部分放在服务提供方remote-provider.xml，将服务引用部分放在服务消费方remote-consumer.xml。
并在提供方增加暴露服务配置<dubbo:service>，在消费方增加引用服务配置<dubbo:reference>。
发布服务：
```
<!-- 和本地服务一样实现远程服务 -->
<bean id="xxxService" class="com.xxx.XxxServiceImpl" />
<!-- 增加暴露远程服务配置 -->
<dubbo:service interface="com.xxx.XxxService" ref="xxxService" />
```

调用服务：
```
<!-- 增加引用远程服务配置 -->
<dubbo:reference id="xxxService" interface="com.xxx.XxxService" />
<!-- 和本地服务一样使用远程服务 -->
<bean id="xxxAction" class="com.xxx.XxxAction">
	<property name="xxxService" ref="xxxService" />
</bean>
```

Zookeeper的安装：

第一步：安装jdk 

第二步：解压缩zookeeper压缩包  tar zxf zookeeper-3.4.6.tar.gz

第三步：将conf文件夹下zoo_sample.cfg复制一份，改名为zoo.cfg    mv zoo_sample.cfg zoo.cfg

第四步：修改配置dataDir属性，指定一个真实目录

第五步：

启动zookeeper：bin/zkServer.sh start

关闭zookeeper：bin/zkServer.sh stop

查看zookeeper状态：bin/zkServer.sh status

注意要关闭linux的防火墙。

### 二、FastDFS部署

Maven环境：
```
<!-- 添加上传的相关依赖-->
		
		<dependency>
				<groupId>org.apache.commons</groupId>
				<artifactId>commons-io</artifactId>
			</dependency>
			
        <dependency>
            <groupId>commons-fileupload</groupId>
            <artifactId>commons-fileupload</artifactId>
        </dependency>
```

安装FastDFS

第一步：获取fdfs安装包：
     wget https://github.com/happyfish100/fastdfs/archive/V5.11.tar.gz

第二步：解压安装包：
     tar -zxvf V5.11.tar.gz


第三步：进入目录：
     cd fastdfs-5.11


第四步：执行编译：
     ./make.sh


第五步：安装：
     ./make.sh install

ps：查看可执行命令：ls -la /usr/bin/fdfs*



###  三、Redis部署

Redis是c语言开发的。
安装redis需要c语言的编译环境。如果没有gcc需要在线安装。yum install gcc-c++

安装步骤：

第一步：redis的源码包上传到linux系统。

第二步：解压缩redis。

第三步：编译。进入redis源码目录。

第四步：安装。make install PREFIX=/usr/local/redis

PREFIX参数指定redis的安装目录。一般软件安装到/usr目录下



## 系统介绍

本程序以用户体验为中心，界面简洁、明了、易于操作。即使第一次使用该应用，也可以流利的操作。

以下为灵犀外卖Spring版部分功能系统截图
![image](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/6.bmp)

![image](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/7.bmp)

![image](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/8.bmp)

![image](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/9.bmp)

![image](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/10.bmp)

![image](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/11.bmp)

![image](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/12.bmp)

![image](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/13.bmp)

![image](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/14.bmp)

![image](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/15.bmp)

![image](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/1.bmp)

![image](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/2.bmp)

![image](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/3.bmp)

![image](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/4.bmp)

![image](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/5.bmp)



