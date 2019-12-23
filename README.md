### 灵犀外卖（Spring版）
灵犀外卖受益于开源，也会回馈于开源。灵犀外卖会秉承“拥抱开放、合作共赢、创造价值”的理念，在开源的道路上继续砥砺前行，和更多的社区开发者一起为国内外开源做出积极贡献。

官网：暂无

论坛：没有

演示地址：等待开发

Spring版QQ群交流群①群：静等



灵犀外卖是一套实用的外卖订餐系统，除了具备外卖订餐系统的通用功能，如菜肴展示、菜肴评论、订单、接单等， 灵犀外卖还有许多独有功能


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


### 一、Undertow（默认）


```
<dependency>
    <groupId>com.jfinal</groupId>
    <artifactId>jfinal-undertow</artifactId>
    <version>1.9</version>
</dependency>
```

取消以上代码的注释，将tomcat的pom依赖javax.servlet.javax.servlet-api注释掉，打包方式改为jar 运行maven package，打包完成后  
将上述打包命令生成的 crm9-release.zip 文件上传到服务器并解压,运行对应的72crm.sh/72crm.bat即可

### 二、Tomcat部署


```
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
    <scope>provided</scope>
</dependency>
```

取消以上代码的注释，将undertow的pom依赖com.jfinal.jfinal-undertow注释掉，并将com.kakarote.crm9.Application的main方法注释掉，打包方式改为war，  
运行maven package命令，将war包放在`tomcat/webapps`目录下

项目默认是ROOT.war，若需要携带项目名，需要修改 ux/config/prod.env.js的BASE_API为'"/项目名/"'，改动完成后需要重新打包替换到webapp下  


项目webapp下自带打包后的前端代码，如果不需要对前端代码更改，直接访问即可  
如果更改了前端代码，需要将打包后的dist下static文件夹和index.html替换到webapp下     
ps:可以使用`nginx`代理静态文件，后台只做接口响应，项目本身设计是前后端完全分离的  



### 前端部署

安装node.js 前端部分是基于node.js上运行的，所以必须先安装`node.js`，版本要求为6.0以上

使用npm安装依赖 下载悟空CRM9.0前端代码； 可将代码放置在后端同级目录ux，执行命令安装依赖：

    npm install

修改内部配置 修改请求地址或域名：config/dev.env.js里修改BASE_API（开发环境服务端地址，默认localhost） 修改自定义端口：config/index.js里面的dev对象的port参数（默认8090，不建议修改）

### 运行前端

     npm run dev

注意：前端服务启动，默认会占用8090端口，所以在启动前端服务之前，请确认8090端口没有被占用。
程序运行之前需搭建好Server端



## 系统介绍

以下为灵犀外卖Spring版部分功能系统截图
![](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/1.bmp)
![](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/2.bmp)
![](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/3.bmp)
![](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/4.bmp)
![](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/5.bmp)
![](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/6.bmp)
![](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/7.bmp)
![](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/8.bmp)

![](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/9.bmp)
![](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/10.bmp)
![](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/11.bmp)
![](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/12.bmp)
![](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/13.bmp)
![](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/14.bmp)
![](https://github.com/xiaohui-cpu/UploadMaven/blob/master/images/15.bmp)


