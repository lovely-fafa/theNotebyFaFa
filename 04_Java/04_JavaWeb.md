2023年3月23日开始学习

# day 02

## 2 Vue

### 2.1 简介

- Vue 是一套前端框架，免除原生JavaScript中的DOM操作，简化书写
- 基于MVVM（Model-View-ViewModel）思想，实现数据的双向绑定，将编程的关注点放在数据上。
- [官网](https://v2.cn.vuejs.org/)

```html
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="js/vue.js"></script>
</head>

<body>
    <div id="app">
        <input type="text" v-model="message"> {{ message }}
    </div>
</body>

<script>
    // 定义一个 Vue 对象
    new Vue({
        el: "#app", // Vue 接管的区域
        data: {
            message: "Hello Vue"
        }
    })
</script>
```

### 2.2 常用属性

指令：HTML 标签上带有 v-前缀 的特殊属性，不同指令具有不同含义。例如：`v-if`，`v-for`...

|    指令     |                         作用                          |
| :---------: | :---------------------------------------------------: |
|  `v-bind`   |    为HTML标签绑定属性值，如设置`href`，`css`样式等    |
|  `v-model`  |             在表单元素上创建双向数据绑定              |
|   `v-on`    |                  为HTML标签绑定事件                   |
|   `v-if`    |  条件性的渲染某元素，判定为`true`时渲染，否则不渲染   |
| `v-else-if` |  条件性的渲染某元素，判定为`true`时渲染，否则不渲染   |
|  `v-else`   |  条件性的渲染某元素，判定为`true`时渲染，否则不渲染   |
|  `v-show`   | 根据条件展示某元素，区别在于切换的是`display`属性的值 |
|   `v-for`   |        列表渲染，遍历容器的元素或者对象的属性         |

### 2.3 v-bind v-model

```html
<body>
    <div id="app">
        <!-- 为HTML标签绑定属性值 -->
        <a v-bind:href="url">链接1</a>
        <a :href="url">简写形式</a>

        <!-- 在表单元素上创建双向数据绑定 -->
        <input type="text" v-model="url">
    </div>
</body>
<script>
    new Vue({
        el: "#app",
        data: {
            url: "https://www.baidu.com"
        }
    })
</script>
```

### 2.4 v-on

```html
<body>
    <div id="app">
        // 绑定事件
        <input type="button" name="" id="" value="点我一下" v-on:click="handle()">
        // 简写
        <input type="button" name="" id="" value="点我一下" @click="handle()">
    </div>
</body>

<script>
    new Vue({
        el: "#app",
        data: {
        },
        methods: {
            handle: function() {
                alert("点我一下")
            },
        },
    })
</script>
```

### 2.5 条件渲染

```html
<body>
    <div id="app">
        年龄：<input type="text" name="" id="" v-model="age">经判定为：
        <span v-if="age <= 35">年轻人</span>
        <span v-else-if="age > 35 && age < 50">中年人</span>
        <span v-else>老年人</span>
        
        <br><br>
		
        <!-- 不满足条件 则 display: none -->
        年龄：<input type="text" name="" id="" v-model="age">经判定为：
        <span v-show="age <= 35">年轻人</span>
        <span v-show="age > 35 && age < 50">中年人</span>
        <span v-show="age >= 50">老年人</span>
    </div>
    
</body>
<script>
    new Vue({
        el: "#app",
        data() {
            return {
                age: 20,
            };
        },
    })
</script>
```

### 2.6 列表渲染

```html
<body>
    <div id="app">
        <div v-for="addr in addres">{{addr}}</div>
        <div v-for="(addr, index) in addres">{{addr}}  --  {{index}}</div>
    </div>
</body>

<script>
    new Vue({
        el: "#app",
        data: {
            addres: ["北京", "成都", "上海"]
        }
    })
</script>
```

### 2.7 小例子

```html
<body>
    <div id="app">
        <table border="1" width="60%">
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>性别</th>
                <th>成绩</th>
                <th>等级</th>
            </tr>
        
            <tr align="center" v-for="(user, index) in users">
                <td>{{index + 1}}</td>
                <td>{{user.name}}</td>
                <td>{{user.age}}</td>
                <td>
                    <span v-show="user.gender == 1">男</span>
                    <span v-show="user.gender == 0">女</span>
                </td>
                <td>{{user.score}}</td>
                <td>
                    <span v-if="user.score >= 85">优秀</span>
                    <span v-else-if="user.score >= 60">及格</span>
                    <span style="color: red;" v-else>不及格</span>
                </td>
            </tr>
        </table>
    </div>
</body>
<script>
    new Vue ({
        el: "#app",
        data: {
            users: [
                {
                    name: "Toxm", 
                    age: 12,
                    gender: 1,
                    score: 80
                },
            ]
        }
    })
</script>
```

### 2.8 Vue 的生命周期

- 生命周期：指一个对象从创建到销毁的整个过程
- 生命周期的八个阶段：每触发一个生命周期事件，会自动执行一个生命周期方法（钩子）。

|      状态       |   阶段周期   |
| :-------------: | :----------: |
| `beforeCreate`  |    创建前    |
|    `created`    |    创建后    |
|  `beforeMount`  |    挂载前    |
|  **`mounted`**  | **挂载完成** |
| `beforeUpdate`  |    更新前    |
|    `updated`    |    更新后    |
| `beforeDestroy` |    销毁前    |
|   `destroyed`   |    销毁后    |

![image-20230325194345836](assets/image-20230325194345836.png)

```javascript
new Vue({
    el: "#app",
    mounted () {
        alert("vue 已挂载完成")
    }
})
```

# day 03

## 1 Ajax

### 1.1 简介

- 概念：**A**synchronous **J**avaScript **A**nd **X**ML，**异步**的JavaScript和XML。
- 作用
  - 数据交换：通过Ajax可以给服务器发送请求，并获取服务器响应的数据。
  - 异步交互：可以在**不重新加载整个页面**的情况下，与服务器交换数据并**更新部分网页**的技术，如：搜索联想、用户名是否可用的校验等等。

### 1.2 同步与异步

![image-20230325200540785](assets/image-20230325200540785.png)

### 1.3 原生 Ajax

- [W3C官网](https://www.w3school.com.cn/js/js_ajax_http.asp)

```javascript
function getData() {
    var xmlHttpRequest = new XMLHttpRequest();

    xmlHttpRequest.open('GET', 'http://yapi.smart-xwork.cn/mock/169327/emp/list');
    xmlHttpRequest.send();

    xmlHttpRequest.onreadystatechange = function() {
        if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
            document.getElementById('div').innerHTML = xmlHttpRequest.responseText;
        }
    }
}
```

### 1.4 Axios

- 介绍：Axios 对原生的Ajax进行了封装，简化书写，快速开发

- [官网](https://www.axios-http.cn/)：https://www.axios-http.cn/

- 使用步骤

  - 引入Axios的js文件

  - 发送请求`GET`请求与`POST`请求

    ```javascript
    function get() {
        // 通过 axios 发送异步请求 get
        axios({
            method: "get",
            url: "http://yapi.smart-xwork.cn/mock/169327/emp/list"
        }).then(result => {
            console.log(result.data)
        })
    }
    
    function post() {
        // 通过 axios 发送异步请求 post
        axios({
            method: "POST",
            url: "http://yapi.smart-xwork.cn/mock/169327/emp/deleteByld",
            data: "id=1",
        }).then(result => {
            console.log(result)
        })
    }
    ```

- axios 别名

  - `axios.get(url[, config])`
  - `axios.delete(url[, config])`
  - `axios.post(url[, data[, config]])`
  - `axios.put(url[, datal, config]])`

### 1.5 综合案例

```html
<body>
    <div id="app">
        <table border="1" width="60%">
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>头像</th>
                <th>性别</th>
                <th>职位</th>
                <th>入职时间</th>
                <th>最后操作时间</th>
            </tr>
        
            <tr align="center" v-for="(emp, index) in emps">
                <td>{{index + 1}}</td>
                <td>{{emp.name}}</td>
                <td>
                    <img v-bind:src="emp.image" width="70px" height="50px">
                </td>
                <td>
                    <span v-show="emp.gender == 1">男</span>
                    <span v-show="emp.gender == 0">女</span>
                </td>
                <td>{{emp.job}}</td>
                <td>{{emp.entrydate}}</td>
                <td>{{emp.updata}}</td>
            </tr>
        </table>
    </div>
</body>

<script>
    new Vue({
        el: "#app",
        data: {
            emps: []
        },
        mounted(){
            axios.get('http://yapi.smart-xwork.cn/mock/169327/emp/list').then(result => {
                this.emps = result.data.data
            })
            console.log(this.emps)
        }
    })
</script>
```

## 2 前后端分离开发

### 2.1 介绍

### 2.2 YApi

- 介绍：YApi 是高效、易用、功能强大的 api 管理平台，旨在为开发、产品、测试人员提供更优雅的接口管理服务
- [地址](http://yapi.smart-xwork.cn/)：http://yapi.smart-xwork.cn/

## 3 前端工程化

- 模块化

  JS、CSS

- 组件化

  UI结构、样式、行为、

- 规范化

  目录结构、编码、接口

- 自动化

  构建、部署、测试

### 3.1 Vue 脚手架环境准备

- 介绍：Vue-cli 是 Vue 官方提供的一个脚手架，用于快速生成一个 Vue 的项目模板
- Vue-cli 提供了如下功能
  - 统一的目录结构
  - 本地调试
  - 热部署
  - 单元测试
  - 集成打包上线
- 依赖环境：NodeJS

### 3.2 Vue 项目简介与凯风珑城

- Vue 项目 - 创建

  - 命令行：`vue create vue-projectName`
  - 图形化界面：`vue ui`

- Vue 项目 - 目录结构

  ![image-20230326180859447](assets/image-20230326180859447.png)

- Vue 项目 - 启动

  - 图形化界面
  - 命令行：`npm serve`

- Vue 项目 - 配置端口

  更改`vue.config.js`文件

  ```javascript
  const { defineConfig } = require('@vue/cli-service')
  module.exports = defineConfig({
    transpileDependencies: true,
    // 更改端口号
    devServer: {
      port: 7000
    }
  })
  ```

- Vue 的组件文件以`.vue`结尾，每个组件由三个部分组成：`<template>`、`<script>`、`<style>`。

## 4 Vue 组件库 Element

### 4.1 简介

- Element：是饿了么团队研发的，一套为开发者、设计师和产品经理准备的基于 Vue 2.0 的桌面端**组件**库。
- 组件：组成网页的部件，例如 超链接、按钮、图片、表格、表单、分页条等等。
- 官网：https://element.eleme.cn/#/zh-CNListener

### 4.2 快速入门

- 安装 ElementUI 组件库

  **项目文件夹下**`npm install element-ui@2.15.3`。（组件库文件会下载到项目文件夹的 node_modules 文件夹。）

- 在`main.js`引入 ElementUI 组件库

  ```javascript
  import ElementUI from 'element-ui'
  import 'element-ui/lib/theme-chalk/index.css';
  
  Vue.use(ElementUI);
  ```

- 访问官网，复制组件代码

### 4.3 常见组件

- 按钮

- 表格

- 分页器

- 对话框

  Dialog 对话框：在保留当前页面状态的情况下，告知用户并承载相关操作

- From 表单

## 5 Vue 路由

> 前端路由：URL中的hash(#号)与组件之间的对应关系

### 5.1 Vue Router
- 介绍：Vue Router 是 Vue 的官方路由。
- 组成
  - VueRouter：路由器类，根据路由请求在路由视图中动态渲染选中的组件
  - `<router-link>`：请求链接组件，浏览器会解析成`<a>`
  - `<router-view>`：动态视图组件，用来染展示与路由路径对应的组件

## 6 打包部署

### 6.1 打包

- `npm run build`

### 6.2 部署

- 介绍：Nginx 是一款轻量级的Web服务器/反向代理服务器及电子邮件（IMAP / POP3）代理服务器。其特点是占有内存少，并发能力强，在各大型互联网公司都有非常广泛的使用。
- 官网: https://nginx.org/

- 部署：将打包好的 dist 目录下的文件，复制到nginx安装目录的html目录下
- 启动：双击 nginx.exe 文件即可，Nginx服务器默认占用80端口号
- 查进程：`netstat -ano | finsStr 80`
- 改端口号：conf 文件夹下的 nginx.conf 文件中更改端口号

# day 04

## 1 Maven

### 1.1 概述

- 介绍

  Maven 是 apache 旗下的一个开源项目，是一款用于管理和构建 Java 项目的工具。

  Apache Maven 是一个项目管理和构建工具，它基于项目对象模型（POM：Project Object Model）的概念，通过一小段描述信息来管理项目的构建。

- 作用

  - 依赖管理
  - 项目结构
  - 项目构建

- 官网：https://maven.apache.org/

- 仓库：用于存储资源，管理各种 jar 包。

  - 本地仓库：自己计算机上的一个目录。
  - 中央仓库：由 Maven 团队维护的全球唯一的。仓库地址：https://repo.maven.org/maven2
  - 远程仓库（私服）：一般由公司团队搭建的私有仓库。

- 安装与配置

  - 配置本地仓库：修改 conf/settings.xml 中的`<localRepository>`为一个指定目录

    ```
    <localRepository>D:\install\apache-maven-3.9.1\mvn_repo</localRepository>
    ```

  - 配置阿里云私服：修改conf/settings.xml 中的`<mirrors>`标签，为其添加如下子标签
  
    ```
    <mirror>
        <id>alimaven</id>
        <mirrorOf>central</mirrorOf>
        <name>aliyun maven</name>
        <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
    </mirror>
    ```
  
  - 配置环境变量：MAVEN_HOME 为 maven 的解压目录，并将其 bin 目录加入 PATH 环境变量
  
  - 查看版本：`mvn -v`

### 1.2 IDEA 集成  Maven

#### 1.1.2 配置Maven环境

- 局部配置：在项目里面
- 全局配置：在 close project 后的弹窗里面选择 settings

![image-20230327161140246](assets/image-20230327161140246.png)

![image-20230327162608962](assets/image-20230327162608962.png)

#### 1.2.3 创建Maven项目

![image-20230327175619118](assets/image-20230327175619118.png)

![image-20230327180913130](assets/image-20230327180913130.png)

- 什么是Maven坐标?

  - Maven 中的坐标是**资源的唯一标识，通过该坐标可以唯一定位资源位置**
  - 使用坐标来定义项目或引入项目中需要的依赖

- Maven 坐标主要组成

  - groupld：定义当前Maven项目隶属组织名称（通常是域名反写，例如:com.itheima）
  - artifactld：定义当前Maven项目名称（通常是模块名称，例如 order-service、goods-service）
  - version：定义当前项目版本号

- 举个栗子

  ```xml
  <groupld>com.itheima</groupld>
  <artifactld>maven-project01</artifactld>
  <version>1.0-SNAPSHOT</version>
  ```

  ```xml
  <dependency>
  	<groupld>ch.qos.logback</groupld>
      <artifactld>logback-classic</artifactld>
      <version>1.2.3</version>
  </dependency>
  ```

好棒好棒，终于解决啦![image-20230327233157794](assets/image-20230327233157794.png)

#### 1.2.4 导入Maven项目

- 方式一：打开IDEA，选择右侧 Maven 面板，点击+号，选中对应项目的 pom.xml 文件，双击即可。
- 方式二：打开IDEA，【File】-【Project Structure】-【Modules】- 【+号】-【Import Module】- 选中对应项目的pom.xm文件，双击即可。

### 1.3 依赖管理

依赖配置
依赖传递
依赖范围
生命周期



## 2 Web 入门

### 2.1 SpringBootWeb 入门

### 2.2 HTTP 协议

### 2.3 Web 服务器-Tomcat





















