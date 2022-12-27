# day 01

# 一、不知道叫什么



# 二、HTML标签学习

## 1 排版标签

## 2 文本格式化标签

> 让文字加粗、下划线、倾斜、删除线

|       说明        | 突出重要性的 | 非突出重要性的 |
| :---------------: | :----------: | :------------: |
|    <b>加粗</b>    |    strong    |       b        |
| <ins>下划线</ins> |      u       |      ins       |
|   <em>倾斜</em>   |      i       |       em       |
| <del>删除线</del> |      s       |      del       |

## 3 媒体标签

### 3.1 图片标签

```html
<img src="" alt="我是替换文本" title="我是提示文本" width="" heigh="">
```

- 替换文本：图片加载失败时显示的
- 提示文本：鼠标悬停出现 其他标签都可以用
- 宽高：可以只设置一个 等比例缩放

### 3.2 路径

#### 3.2.1 绝对路径

#### 3.2.2 相对路径

- 同级目录

  ```html
  <img src="./img.jpg">
  <img src="img.jpg">
  ```

- 下级目录

  ```html
  <img src="./img_dir/img.jpg">
  <img src="/img_dir/img.jpg">
  ```

- 上级目录

  返回上一级是 ../

  ```html
  <img src="../img.jpg">
  ```

### 3.3 音频标签

```html
<audio src="" controls autoplay loop></audio>
```

- controls：显示音频控件
- autoplay：自动播放（部分浏览器不支持）
- loop：循环播放
- 只支持：.mp3 .wav .ogg

### 3.4 视频标签

```html
<video src="" controls autoplay muted loop></video>
```

- controls：显示音频控件
- autoplay：自动播放（谷歌浏览器需要配合 muted 实现静音自动播放）
- loop：循环播放
- 只支持：.mp4 .webM .ogg

## 4 链接标签

```html
<a href="">这是一个超链接</a>
```

- 不知道跳转地址就是**空链接**： #

- target 属性：目标网页打开形式

  |  取值  |        效果        |
  | :----: | :----------------: |
  | _self  | 默认值，覆盖原网页 |
  | _blank |     保留原网页     |

# day 02

# 一、列表标签

## 1 列表的应用场景

pass

## 2 无序列表

```html
<ul>
    <li>榴莲</li>
    <li>香蕉</li>
    <li>苹果</li>
</ul>
```

- ul 标签只能包含 li 标签
- li 标签可以包含任何内容

## 2 有序列表

```html
<ol>
    <li>张三：100</li>
    <li>李四：80</li>
    <li>王五：60</li>
    <li>赵六：30</li>
</ol>
```

- ol 标签只能包含 li 标签
- li 标签可以包含任何内容

## 4 自定义列表

```html
<dl>
    <dt>帮助中心</dt>
    <dd>购买指南</dd>
    <dd>服务政策</dd>
    <dd>信息中心</dd>

    <dt>联系我们</dt>
    <dd>手机</dd>
    <dd>邮箱</dd>
    <dd>传真</dd>
</dl>
```

| 标签名 |          说明           |
| :----: | :---------------------: |
|   dl   | 整体，包裹 dt / dd 标签 |
|   dt   |          主题           |
|   dl   |     每一项的小内容      |

- dd 会默认缩进
- dl 标签只能包含 dt / dd 标签
- dt / dd 可以包含任何内容

# 二、表格标签

## 1 基本标签

| 标签名 |         说明         |
| :----: | :------------------: |
| table  |  表格整体，包裹 tr   |
|   tr   |  表格每行，包裹 td   |
|   td   | 表格单元格，包裹内容 |

## 2 相关属性

- border：边框宽度
- width：
- height：
- 一般是 css 里面设置宽高

```html
<table border="5" width="500" height="200">
        <tr>
            <td>姓名</td>
            <td>成绩</td>
            <td>评语</td>
        </tr>

        <tr>
            <td>小哥哥</td>
            <td>100</td>
            <td>好看诶</td>
        </tr>

        <tr>
            <td>小姐姐</td>
            <td>100</td>
            <td>好看诶</td>
        </tr>

</table>
```

## 3 表格标题和表头的单元格标签

| 标签名  |    名称    |                           说明                           |
| :-----: | :--------: | :------------------------------------------------------: |
| caption | 表格大标题 |                 表格大标题，顶部居中显示                 |
|   th    | 表格单元格 | 表示一列小标题，通常位于表格第一行，默认内部文字加粗居中 |

```html
<table border="5" width="500" height="200">
        <caption><strong>学生成绩单</strong></caption>
        <tr>
            <th>姓名</th>
            <th>成绩</th>
            <th>评语</th>
        </tr>

        <tr>
            <td>小哥哥</td>
            <td>100</td>
            <td>好看诶</td>
        </tr>

        <tr>
            <td>小姐姐</td>
            <td>100</td>
            <td>好看诶</td>
        </tr>

</table>
```

## 4 表格的结构标签*

| 标签名 | 名称     |
| ------ | -------- |
| thead  | 表格头部 |
| tbody  | 表格主体 |
| tfoot  | 表格底部 |

```html
<table border="5" width="500" height="200">
        <caption><strong>学生成绩单</strong></caption>
        
        <thead>
            <tr>
                <th>姓名</th>
                <th>成绩</th>
                <th>评语</th>
            </tr>
        </thead>

        <tbody>
            <tr>
                <td>小哥哥</td>
                <td>100</td>
                <td>好看诶</td>
            </tr>
    
            <tr>
                <td>小姐姐</td>
                <td>100</td>
                <td>好看诶</td>
            </tr>
        </tbody>

        <tfoot>
            <tr>
                <td>评语</td>
                <td>评语1</td>
                <td>评语2</td>
            </tr>
        </tfoot>
        
</table>
```

## 5 合并单元格

- 明确合并哪几个
- 左上原则，确定删谁留谁
- 给保留的单元格添加属性
  - 跨行合并：```rowspan="num"```
  - 跨列合并：```colspan="num"```
- 注意：
  - 只有同一结构标签可以合并，不能跨表结构合并

```html
<table border="5" width="500" height="200">
        <caption><strong>学生成绩单</strong></caption>
        
        <thead>
            <tr>
                <th>姓名</th>
                <th>成绩</th>
                <th>评语</th>
            </tr>
        </thead>

        <tbody>
            <tr>
                <td>小哥哥</td>
                <td rowspan="2">100</td>
                <td>好看诶</td>
            </tr>
    
            <tr>
                <td>小姐姐</td>
                <td>好看诶</td>
            </tr>
        </tbody>

        <tfoot>
            <tr>
                <td>评语</td>
                <td colspan="2">评语</td>
            </tr>
        </tfoot>
        
</table>
```

# 三、表单标签

# 1 input 标签

### 1.1 类型



### 1.2 占位符

```html
账号：<input type="text" placeholder="邮箱/手机号/账号">
<br>
密码：<input type="password" name="" id="" placeholder="请输入密码">
```

### 1.3 单选框

```html
<!-- name 属性实现分组 约束单选 -->
<!-- checked 属性默认选中 -->
性别：<input type="radio" name="gender" id="">男 <input type="radio" name="gender" checked>女

<p></p>

<!-- checked 属性默认选中 -->
这是一个默认选中的复选框：<input type="checkbox" checked>
```

### 1.4 上传文件

```html
<input type="file" name="" id="" multiple>
```

- multiple：默认是单个文件，加上```multiple```就可以上传多个

## 2 button 按钮

| type属性值 | 说明                                                     |
| ---------- | -------------------------------------------------------- |
| submit     | 提交按钮，点击后提交数据给很多服务器                     |
| reset      | 重置按钮，点击后恢复表单默认值                           |
| button     | 普通按钮，默认无功能，之后配合 ```JavaScript``` 添加功能 |

- 要放到一个表单域标签```<form></form>```

## 3 select 下拉菜单标签

```html
<select name="" id="">
    <option value="">语文</option>
    <option value="">数学</option>
    <option value="" selected>英语</option>
</select>
```

- 标签组成
  - select 标签：下拉菜单整体
  - opinion 标签：下拉菜单每一项
- 常见属性
  - selected：下拉菜单默认选中

## 4 textarea 文本域

- 常见属性
  - cols：可见宽度
  - rows：可见行数
- 注意点
  - 右下角可以拖拽改变大小
  - 实际开发针对与样式效果**推荐CSS设置**

## 5 label 标签

```html
用 label 标签，这个地方实现了可以点字

<br><br>

方法一
<hr>
性别：
<input type="radio" name="" id="nan"><label for="nan">男</label>
<input type="radio" name="" id="">女

<br><br>

方法二
<hr>
性别：
<label><input type="radio" name="" id="">男</label>
<input type="radio" name="" id="">女
```

- 场景：用于绑定内容与表单标签的关系
- 使用方法一
  - 用```<label></label>```标签把内容（例如：文本）包裹
  - 表单标签添加```id```属性
  - ```<label></label>```标签的```for```属性设置对应的```id```属性值
- 使用方法二
  - 直接用```<label></label>```标签把内容（例如：文本）和**表单标签一起**包裹
  - `<label></label>`标签的```for```属性**删掉**

# 四、语义化标签

## 1 没有语义的标签

```html
<h2>div 标签默认换行</h2>
<div>这是 div 标签</div>
<div>这是另一个 div 标签</div>

<h2>span 标签默认<strong>不换行</strong></h2>
<span>这是一个 span 标签</span>
<span>这是另一个 span 标签</span>
```

## 2 有语义的布局标签*

> 手机端使用，这里仅了解
>
> 与```<div></div>```一样，只是有更多的语义

```html
<!-- 手机端使用 都默认换行 -->
<head>网页头部</head>
<nav>网页导航</nav>
<footer>网页底部</footer>
<aside>网页侧边栏</aside>
<section>网页区块</section>
<article>网页文章</article>
```

# 五、字符实体

```html
<div>浏览器只认识单个    空格</div>
<div>可以用字符实体&nbsp;&nbsp;</div>
```

# day 03

# 一、基础认知

## 1 CSS 初识

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        /* css 写介个地方 */
        p  {
            /* 文字颜色变 */
            color: red;
            /* 字变大 */
            font-size: 30px;
            /* 背景 */
            background-color: green;
            /* 因为 p 是一行的，所以调一下长宽 */
            width: 400px;
            height: 40px;
        }
    </style>
</head>
<body>
    <p>这是一个p标签</p>
</body>
</html>
```

## 2 CSS 引入方式

- 内嵌式：

  CSS 写在```style```标签里面。

  ```style```标签可以在任意位置，但是通常约定在**```head```**标签里面

- 外联式：

  CSS 写在 .CSS 文件

  通过```link```标签在网页中引入

  ```html
  <!DOCTYPE html>
  <html lang="en">
  <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Document</title>
      <!-- 样式表 -->
      <link rel="stylesheet" href="./static/myCSS.css">
  </head>
  <body>
      <p>这个样子</p>
  </body>
  </html>
  ```

- 行内式：

  CSS 写在```style```标签

  基础班不建议使用，后面结合```JavaScript```

  ```html
  <!DOCTYPE html>
  <html lang="en">
  <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Document</title>
      <!-- 样式表 -->
      <link rel="stylesheet" href="./static/myCSS.css">
  </head>
  <body>
      <p>这个样子</p>
  
      <!-- 行内式 -->
      <p style="color: green; font-size: 20px">行内式引入 css</p>
  </body>
  </html>
  ```

# 二、基础选择器

## 1 标签选择器

> 标签选择器会选择<strong>所有的</strong>指定的标签

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        p {
            color: palevioletred;
        }
    </style>
</head>
<body>
    <p>ppppppp</p>
    <p>ppppppp2</p>
    <p>标签选择器会选择<strong>所有的</strong>指定的标签</p>
</body>
</html>
```

## 2 类选择器

> 结构：
>
> ```html
> .类名 {
>   color: red;
> }
> ```
>
> 一个标签可以有**多个**类名

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .red {
            color: red;
        }

        .green {
            color: aquamarine;
        }
        
        .size_66 {
            font-size: 66px;
        }
    </style>
</head>
<body>
    <p class="red">111</p>
    <p class="green">222</p>

    <div class="green size_66">还可以多个类名</div>
</body>
</html>
```

## 3 id 选择器

> 结构：
>
> ```html
> #id属性值 {
>   属性名: 属性值;
> }
> ```
>
> id 属性值在一个页面**不能重复**

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        #blue {
            color: coral;
        }
    </style>
</head>
<body>
    <div id="blue">蓝色</div>
</body>
</html>
```

## 4 通配符选择器

> 结构：
>
> ```html
> * {
>   属性名: 属性值;
> }
> ```
>
> 通常只有取消标签默认属性时使用。

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        * {
            color: blueviolet;
        }
    </style>
</head>
<body>
    <div>div</div>
    <p>ppp</p>
    <h1>h1</h1>
</body>
</html>
```

# 三、字体和文本样式

## 1 字体样式

### 1.1 字体字号

- 属性名：```font-size```

- 谷歌浏览器默认```16px```

- ```html
      <style>
          p {
              font-size: 20px;
          }
      </style>
  </head>
  <body>
      <p>谷歌浏览器默认值都是16px</p>
  </body>
  </html>
  ```

### 1.2 字体粗细

- 属性名：```font-weight```

- 取值:

  - 关键字:
    - 正常：```normal```
    - 加粗：```bold```
  - 纯数字：
    - ```100```到```900```的整百数
    - 正常：```400```
    - 加粗：```700```

- ```html
      <style>
          div {
              font-weight: 700;
          }
  
          h1 {
              font-weight: normal;
          }
      </style>
  </head>
  <body>
      <div>这是div</div>
      <h1>一级标题</h1>
  </body>
  </html>
  ```

- 注意：

  - 不是所有的字体都有九中粗细
  - 实际开发：正常、加粗两种取值使用更多

### 1.3 字体样式（是否倾斜）

- 属性名：```font-style```

- 取值：

  - 正常：```noraml```
  - 倾斜：```italic```

- ```html
  <style>
      div {
          font-style: italic;
      }
      em {
          font-style: normal;
      }
  </style>
  <body>
      <div>这是div</div>
      <em>这是em</em>
  </body>
  </html>
  ```

### 1.4 字体

- 如果用户电脑没有这些字体，就往后选，最最最后是无衬线字体的意思

```html
    <style>
        div {
            /* 如果用户电脑没有这些字体，就往后选，最最最后是无衬线字体的意思 */
            font-family: 微软雅黑, Arial, Helvetica, sans-serif;
        }
    </style>
</head>
<body>
    <div>这是一个字体</div>
</body>
</html>
```

### 1.5 字体系列

- 无衬线字体（sans-serif）
- 衬线字体
- 等宽字体

### 1.6 样式的层叠问题

```html
    <style>
        p {
            color: blue;
            color: aqua;
        }
    </style>
</head>
<body>
    <p>
        ppppppppp
    </p>
</body>
</html>
```

### 1.7 字体相关属性的连写

- font属性的简写：```font: style weight size/line-height family```

- 比如说：```font: italic, 700, 66px, 宋体```

- 注意

  - 单独样式可以写到复合属性下面
  - 只能省略前两个，不能省略字号和字体。如果省略了，就是默认值。

- ```html
      <style>
          p {
              font: italic 200 66px 宋体;
              font-style: normal;
          }
      </style>
  </head>
  <body>
      <p>这是p标签</p>
  </body>
  </html>
  ```

## 2 文本样式

### 2.1 文本缩进

- 属性名：text-indent
- 单位：
  - ```px```：不推荐
  - ```em```：**推荐使用**1em = 当前标签的font-size的大小

```html
    <style>
        p {
            text-indent: 2em;
            /* text-indent: 32px;  首行缩进两个字符，所以是 2*16px 但是这个地方就要跟着字号的变动二变动，麻烦 */
            font-size: 25px;
        }
    </style>
</head>
<body>
    <p>本套课程设计为零基础快速入门Linux操作系统系列课程，服务零基础学员为设计基石。课程在基础的Linux系统知识之外，规划了《全方向》涉及到的Linux所需软件服务的部署实战，无论从事Java后端、大数据开发、测试、运维等方向，均可从中受益。</p>
        <p>课程以Shell脚本、Python脚本自动化为基点，设计了大规模大数据集群部署、运维、监控、自动化项目实战，一站式收获知识和经验。并且课程结合了当下最新的云平台技术，为大家带来了Linux操作系统云上实践环节。</p>
</body>
</html>
```

### 2.2 文本水平对齐

- 属性名：text-align

- 属性值：

  - 左对齐：```left```
  - 居中对齐：```center```
  - 右对齐：```right```

- 其实所有标签，都可以用这个东西

- ```html
      <style>
          h1 {
              text-align: center;
          }
          div {
              text-align: center;
          }
      </style>
  </head>
  <body>
      <h1>新闻标题</h1>
      <div><img src="./static/学生数学建模协会logo  2.0_背景透明.png" alt="" width="180" height="180"></div>
  </body>
  </html>
  ```

### 2.3 文本修饰

- 属性名：text-decoration

- 取值：

  - 下划线：```underline```
  - 删除线：```line-through```
  - 上划线：```overline```
  - 无装饰线：```none```

- 比如说可以用**无装饰线**去掉超链接的线

- ```html
      <style>
          div {
              text-decoration: underline;
          }
          p {
              text-decoration: line-through;
          }
          h2 {
              text-decoration: overline;
          }
          a {
              text-decoration: none;
          }
      </style>
  </head>
  <body>
      <div>div</div>
      <p>ppp</p>
      <h2>h2</h2>
      <a href="https://www.baidu.com">百度一下</a>
  </body>
  </html>
  ```

## 3 行高

### 3.1 行高

- 控制行与行之间的间距

- 属性名：```line-height```

- 属性值：

  - 数字+px
  - 倍数（当前标签```font-size```值的倍数）

- ```css
  p {
      /* 方法一： */
      line-height: 50px;
      /* 方法二： */
      line-height: 1.5;
      text-indent: 2em;
  
      /* 连写 */
      font: italic 700 66px/2 宋体;
  }
  ```

- font属性的简写：```font: style weight size/line-height family```

## 4 Chrome 浏览器调试工具

有手就行

## 5 颜色

- 关键词
- RGB
- RGBa
- 十六进制

## 拓展

```html
    <style>
        div {
            width: 800px;
            height: 800px;
            background-color: pink;
            /* 水平居中 */
            margin: 0 auto;
        }
    </style>
</head>
<body>
    <div></div>
</body>
</html>
```

# 五、综合案例

有手就行

#  day04

# 一、选择器进阶

## 1 后代选择器

- 语法：选择器1 选择器2 { CSS }
- 后代选择器会选择他的儿子、孙子、重孙子

```html
    <style>
        div p {
            color: blueviolet;
        }
    </style>
</head>
<body>
    <p>p标签</p>
    
    <div>
        <p>这是div的儿子p</p>
    </div>
</body>
</html>
```

## 2 子代选择器

- 语法：选择器1 > 选择器2 { CSS }
- 只会选择儿子

```html
    <style>
        /* div a {
            color: blue;
        } */

        div > a {
            color: aquamarine;
        }
    </style>
</head>
<body>
    <div>
        父级
        <a href="">div的a</a>
        <p>
            <a href="">p的a</a>
        </p>
    </div>
</body>
</html>
```

## 3 并集选择器

有手就行

```html
    <style>
        /* 一行一个显的专业 */
        div, 
        span, 
        h1, 
        p {
            color: brown;
        }
    </style>
</head>
<body>
    <div>div</div>
    <span>span</span>
    <h2>h2</h2>
    <h1>h1</h1>
    <p>ppp</p>
</body>
</html>
```

## 4 交集选择器

```html
    <style>
        /* 额 为什么交集选择器什么都不加 */
        p.box {
            color: aquamarine;
        }
    </style>
</head>
<body>
    <p class="box">这是p标签：box</p>
    <p>ppppp</p>
    <div class="box">这是div标签：box</div>
</body>
</html>
```

## 5 hover伪类选择器

- 鼠标悬停在元素上的状态

- 语法：选择器:hover { css }  **冒号前后都没有空格**

- 任何标签都可以添加伪类

- ```html
      <style>
          a:hover{
              color: royalblue;
              background-color: aqua;
          }
      </style>
  </head>
  <body>
      <a href="">这是一个超链接</a>
  </body>
  </html>
  ```

## 6 emment语法

```html
<style>
        div {
            /* 单词的首字母 */
            font-size: 20px;
            font-weight: 700;
            background-color: #fff;

            /* w300+h200+bgc */
            width: 300px;
            height: 200px;
            background-color: #fff;
        }
    </style>
</head>
<body>
    <div class="box"></div>
    <div id="box"></div>
    <div class="box" id="one"></div>

    <!-- 同级 + -->
    <p></p>
    <li></li>

    <!-- 父子 > -->
    <li>
        <p></p>
    </li>

    <!-- 多个 * -->
    <ul>
        <li></li>
        <li></li>
        <li></li>
    </ul>

    <!-- 文字 {xxx} -->
    <ul>xxx</ul>

    <!-- ul>li{$}*3 -->
    <ul>
        <li>1</li>
        <li>2</li>
        <li>3</li>
    </ul>
</body>
</html>
```

# 二、背景相关属性

## 1 背景颜色

```html
    <style>
        div {
            width: 300px;
            height: 300px;

            background-color: pink;
            background-color: #ccc;
            background-color: rgba(red, green, blue, 0.3);
        }
    </style>
</head>
<body>
    <div>div</div>
</body>
</html>
```

## 2 背景图片

- 背景平铺

- 参数

  - 0
  - 0
  - 0
  - 0

- ```html
      <style>
          div {
              width: 1000px;
              height: 1000px;
              background-image: url(static/发发的头像.jpg);
              /* 背景平铺 */
              /* background-repeat: no-repeat; */
              background-repeat: repeat-x;
          }
      </style>
  </head>
  <body>
      <div>这是文字</div>
  </body>
  </html>
  ```

## 3 背景位置

- background-position：水平位置 垂直位置

- 取值

  - 方位名词
    - 水平方向
      - left
      - center
      - right
    - 垂直方向
      - top
      - center
      - bottom
  - 数字+px
    - 坐标系
      - 原点左上角
      - X轴：水平向右
      - Y轴：垂直向下
  - 可以混用

- ```html
      <style>
          div {
              width: 700px;
              height: 700px;
              background-color: pink;
              
              background-image: url(static/发发的头像.jpg);
              background-repeat: no-repeat;
              /* 方法 */
              background-position: center center;
              background-position: 50px center;
              background-position: center -300px;
          }
      </style>
  </head>
  <body>
      <div>这是文字</div>
  </body>
  ```

## 4 背景属性连写

- background: color image repeat posistion（只是推荐这样写）

- ```html
      <style>
          div {
              width: 700px;
              height: 700px;
              background: pink url(./static/发发的头像.jpg) no-repeat center center;
          }
      </style>
  </head>
  <body>
      <div>文字</div>
  </body>
  </html>
  ```

- 位置那，如果是英文，可以不管先后顺序，但是数字就要先```X```后```Y```

## 5 背景图片大小

- 属性名：```background-size```
- 属性值
  - ```contain```：图片等比例缩放，当宽或高达100%停止
  - ```cover```：图片等比例缩放，完全铺满位置

## 6 设置网页大背景

```html
<sytle>
    html {
        height: 100%;
    }
    body {
        height: 100%;
        background: url(../images_全民出游季/f1_1.jpg) no-repeat center;
        /* 缩放背景图 */
        background-size: cover;
    }
</sytle>
```

# 三、元素显示模式

## 1 块级元素

- 特点：

  - 独占一行
  - 宽度是父元素的宽度，高度默认由内容撑开
  - 可自定义宽高

- 例如：```p```、```div```

- ```html
      <style>
          div {
              width: 200px;
              height: 300px;
              background-color: #ccc;
          }
      </style>
  </head>
  <body>
      <div>1111</div>
      <div>2222</div>
  </body>
  </html>
  ```

## 2 行内元素

- 特点：

  - 一行可以显示多个
  - 宽度、高度默认由内容撑开
  - 不可自定义宽高

- 例如：```a```、```span```

- ```html
      <style>
          /* - 一行可以显示多个
              - 宽度、高度默认由内容撑开
              - 不可自定义宽高 */
          span {
              width: 800px;
              height: 300px;
              background-color: aquamarine;
          }
      </style>
  </head>
  <body>
      <span>222</span>
      <span>222</span>
      <span>222</span>
  </body>
  </html>
  ```

## 3 行内块

- 显示特点

  - 一行多个
  - 可以设置宽高
  - 未设置宽高或没有东西撑开就是0？
  - **换行有间隙**

- 代表标签：```input```、```textarea```、```button```、```seleect```

- ```html
      <style>
          /* 显示特点
              - 一行多个
              - 可以设置宽高 */
          img {
              width: 100px;
              height: 100px;
          }
      </style>
  </head>
  <body>
      <img src="./static/发发的头像.jpg" alt="">
      <img src="./static/发发的头像.jpg" alt="">
  </body>
  </html>
  ```

## 4 元素显示模式转换 

- 目的：改变元素默认的显示特点，让元素符合布局要求
- 语法

|            属性             |         效果         | 使用频率 |
| :-------------------------: | :------------------: | :------: |
|    ```display: block```     |  转换为**块级**元素  |   较多   |
| ```display: inline-block``` | 转换为**行内块**元素 |   较多   |
|    ```display: inline```    |  转换为**行内**元素  |   极少   |
|     ```display: none```     |         隐藏         |          |

## 拓展 

1、块级元素一般作为**大容器**，可以嵌套：文本、块级元素

- 但是```p```标签不要嵌套```div```、```p```、```h```等块级元素

2、```a```标签内部可以嵌套除了```a```标签的其他任意元素

# 四、CSS特性

## 1 继承性

- 子元素默认继承父元素样式的特点（子承父业）

- 可以继承的常见属性

  - 文字都可以继承，其他的都不可以
  - ```color```
  - ```font```

- ```html
      <style>
          div {
              color: aqua;
              font-size: 20px;
  
              /* 不继承 */
              height: 200px;
              background-color: blanchedalmond;
          }
      </style>
  </head>
  <body>
      <div>
          div
          <sp>div里面的span</sp>
      </div>
  </body>
  ```

- 注意事项：自己没有的会继承，自己有的就不会继承。例如```p```标签的颜色，```h1```标签的大小

- ```html
      <style>
          div {
              color: green;
              font-size: 30px;
          }
      </style>
  </head>
  <body>
      <div>
          <h1>一级标题（有自己的字号，所以没有继承）</h1>
          <a href="">超链接（有自己的颜色，所以没有继承）</a>
          <p>所以可以不用继承，直接单独设置</p>
      </div>
  </body>
  </html>
  ```

## 2 层叠性

- 当个同一个标签设置不同的样式：层层叠加。例如```color```和```font-size```会层层叠加，都会生效。

- 当个同一个标签设置相同的样式：层叠覆盖。例如```color```和```color```就会最后一个生效。

- ```html
      <style>
          /* - 当个同一个标签设置不同的样式：层层叠加。例如```color```和```font-size```会层层叠加，都会有作用。
              - 当个同一个标签设置相同的样式：层叠覆盖。例如```color```和```color```就会最后一个生效。 */
          div {
              color: blue;
              color: blueviolet;
          }
          .box {
              font-size: 30px;
          }
      </style>
  </head>
  <body>
      <div class="box">文字</div>
  </body>
  </html>
  ```

# 五、综合案例

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        a {
            height: 50px;
            width: 100px;
            background-color: red;
            display: inline-block;
            
            text-decoration: none;
            color: #fff;
            text-align: center;
            line-height: 50px;
            font-weight: 700;
        }

        a:hover {
            background-color: orange;
        }
    </style>
</head>
<body>
    <a href="#">导航1</a>
    <a href="#">导航2</a>
    <a href="#">导航3</a>
    <a href="#">导航4</a>
    <a href="#">导航5</a>
</body>
</html>
```

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        a {
            width: 120px;
            height: 58px;
            display: inline-block;
            background-color: pink;
            
            text-decoration: none;
            text-align: center;
            line-height: 53px;
            color: #fff;
        }

        .a1 {
            background-image: url(./static/images/bg1.png);
        }
        .a2 {
            background-image: url(./static/images/bg2.png);
        }
        .a3 {
            background-image: url(./static/images/bg3.png);
        }
        .a4 {
            background-image: url(./static/images/bg4.png);
        }

        .a1:hover {
            background-image: url(./static/images/bg5.png);
        }
        .a2:hover {
            background-image: url(./static/images/bg6.png);
        }
        .a3:hover {
            background-image: url(./static/images/bg7.png);
        }
        .a4:hover {
            background-image: url(./static/images/bg8.png);
        }
    </style>
</head>
<body>
    <a href="#" class="a1">彩色的导航条</a>
    <a href="#" class="a2">彩色的导航条</a>
    <a href="#" class="a3">彩色的导航条</a>
    <a href="#" class="a4">彩色的导航条</a>
</body>
</html>
```

# day 05

# 一、CSS 三大特性

## 3.1 优先级

```继承 < 通配符选择器 < 标签选择器 < 类选择器 < id选择器 < 行内样式 < !important```

```html
    <style>
        #box {
            color: blueviolet;
        }
        .box {
            color: orange
        }
        div {
            color: red !important;
        }
        /* 测试 !important 时，不要给父级添加*/
        /* body {
            color: blue;
        } */
    </style>
</head>
<body class="box" id="box">
    <div style="color: pink;">测试优先级</div>
</body>
</html>
```

## 3.2 权重叠加计算

- 比较规则
  - 行内、```id```、类、标签
  - 先比较第一级数字，比较出来了，之后就不看了
  - 第一级相同，则比较第二级
  - ……
- 注意：```!important```如果不是继承，则权重最高，天下第一！

![image-20221107225008467](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221107225008467.png)

# 二、软件



# 三、盒子模型

## 1 盒子模型介绍

- 盒子模型由内容区域```content```、内边距区域```padding```、边框区域```border```、外边距区域```margin```构成

- ```html
      <style>
          div {
              width: 300px;
              height: 300px;
              background-color: pink;
  
              /* 边框线 */
              border: 1px solid #000;
              /* 内边距 */
              padding: 20px;
              /* 外边距 */
              margin: 20px;
          }
      </style>
  </head>
  <body>
      <div>内容电脑</div>
      <div>内容电脑</div>
  </body>
  </html>
  ```

## 2 内容区域的宽度和高度

- 利用```width```和```height```属性默认设置是盒子**内容区域**的大小
- 属性：```width```/```height```
- 常见取值：```数字+px```

## 3 边框 border

### 3.1 一般的边框

- 属性名：```border```
- 属性值：单个取值连写，之间空格隔开
  - ```border: 10px solid red;```
- 快捷键：```bd+tab```
- 种类
  - 实线：```solid```
  - 虚线：```dashed```
  - 点线：```dotted```

```html
    <style>
        div {
            width: 200px;
            height: 200px;
            background-color: pink;
            
            /* 实线 solid */
            /* 虚线 dashed */
            /* 点线 dotted */
            border: 5px dashed #554;
        }
    </style>
</head>
<body>
    <div>内容</div>
</body>
</html>
```

### 3.2 单方向设置

- 属性名：```border-方位名词```
- 属性值：同上
- ```border-left: 5px dashed orange;```

### 3.3 单个属性

> 一般不用

- 边框粗细：```border-width```
- 边框样式：```border-style```
- 边框颜色：```border-color```

### 3.4 小案例：尺寸计算

> 需要一个```400×400```的盒子

```html
    <style>
        div {
            width: 380px;
            height: 380px;
            background-color: orange;
            border: 10px solid bisque;
        }
    </style>
</head>
<body>
    <div>内容</div>
</body>
</html>
```

### 3.5 综合案例——新浪导航

![image-20221108172931202](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221108172931202.png)

```html
<style>
        .box {
            height: 40px;
            /* 不写高度，默认 100% */

            border-top: 3px solid #ff8500;
            border-bottom: 1px solid #edeef0;
        }

        .box a {  /* 用后代选择器 更安全 */
            width: 80px;
            height: 40px;

            color: #4c4c4c;
            font-size: 12px;
            text-align: center;
            text-decoration: none;
            line-height: 40px;
            /* 显示模式：撑开父标签 */
            display: inline-block;
        }

        .box a:hover {
            background-color: #edeef0;
            color: #ff8400;
        }
    </style>
</head>
<body>
    <div class="box">
        <a href="">新浪导航</a>
        <a href="">新浪导航</a>
        <a href="">新浪导航</a>
        <a href="">新浪导航</a>
    </div>
</body>
</html>
```

## 4 内边距 padding

### 4.1 一般的内边距

- 属性名：```padding```

- 属性值

  - 单值

  - 多值

    - 四个值：上 右 下 左 => 顺时针

    - 三个值：上 左右 下

    - 两个值：上下 左右

```html
<style>
        div {
            height: 200px;
            width: 200px;
            background-color: pink;

            /* 内边距 */
            /* padding: 50px; */
            /* 四个值：上 右 下 左 => 顺时针*/
            padding: 10px 25px 80px 100px;

            /* 三个值：上 左右 下 */

            /* 两个值：上下 左右 */
            
        }
    </style>
</head>
<body>
    <div>文字</div>
</body>
</html>
```

### 4.2 小案例——尺寸计算

```html
    <style>
        div {
            /* 能够撑大盒子的有 border padding */
            width: 240px;
            height: 240px;
            background-color: pink;

            border: 10px solid black;
            padding: 20px;
        }
    </style>
</head>
<body>
    <div>文字</div>
</body>
</html>
```

### 4.3 新浪导航2.0

```html
/* width: 80px; */
padding: 0 16px;
```

### 4.4 CSS3的盒子模型可以不做减法

- 内减模式
- 属性名：```box-sizing```
- 属性值：```border-box```

```html
    <style>
        div {
            width: 100px;
            height: 100px;
            background-color: pink;
            
            border: 10px solid #000;
            padding: 20px;

            /* 变成 CSS3 的盒子模型 就不用做减法了 */
            box-sizing: border-box;
        }
    </style>
</head>
<body>
    <div>文字</div>
</body>
</html>
```

## 5 外边距 margin

### 5.1 一般的外边距

> 和```padding```一模一样

```html
    <style>
        div {
            width: 100px;
            height: 100px;
            background-color: pink;

            margin: 20px 100px 80px 200px;
        }
    </style>
</head>
<body>
    <div>内容</div>
</body>
</html>
```

### 5.2 清除默认的内外边距

- 方法一：京东

  ```html
  * {
    margin: 0;
    padding: 0;
  }
  ```

- 方法二：淘宝

  ```html
  xx, xx, xx, xx {
    margin: 0;
    padding: 0;
  }
  ```

```html
    <style>
        * {
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>
    <p>ppppp</p>
    <div>div</div>
    <h1>h1</h1>
    <li>li</li>
</body>
</html>
```

### 5.3 版心居中

> 版心：网页的有效内容

属性值：```auto```

```html
margin: 0 auto;
```

### 5.4 外边距的折叠现象——合并问题

- 场景：**垂直布局**的**块级元素**，上下的```margin```会合并
- 结果：最终两者的距离为```magin```的最大值
- 解决办法：只设置一个啦

```html
    <style>
        div {
            width: 100px;
            height: 100px;
            background-color: pink;
        }

        .one {
            margin-bottom: 200px;
        }

        .two {
            margin-bottom: 100px;
        }

    </style>
</head>
<body>
    <div class="one">11</div>
    <div class="two">22</div>
</body>
</html>
```

### 5.5  外边距的折叠现象——塌陷问题

- 场景：**互相嵌套**的**块级元素**，子元素的```margin-top```会作用到父级上
- 结果：父级会一起往下移动
- 解决方法：
  - 父级添加```border-top```或```padding-top```
  - 父级设置```overflow: hidden;```最好的解决办法，没有任何额外的改动
  - 转化为**行内块元素**（这不是显而易见嘛）
  - 设置浮动

```html
<style>
        .father {
            width: 300px;
            height: 300px;
            background-color: pink;

            /* 解决方法一.二：父级添加 border-top */
            /* border-top: 1px solid #000; */

            /* 解决方法一.二：给父级添加内边距，子级就下来了 */
            /* padding-top: 50px; */

            /* 解决问题二：最好的，没有额外的任何东西 */
            /* overflow: hidden; */

            /* 解决方法三：转为行内块 */
            display: inline-block;

            /* 解决方法四：设置浮动 */
        }
        .son {
            width: 100px;
            height: 100px;
            background-color: skyblue;
            
            /* 想要里面的下来，结果都下来了 */
            margin-top: 50px;
        }
    </style>

</head>
<body>
    <div class="father">
        <div class="son">
            son
        </div>
    </div>
</body>
</html>
```

### 5.6  行内元素的内外边距的问题

- 问题：行内标签的```margin```和```padding```在垂直方向的不会生效
- 解决办法：设置```line-height```

```html
    <style>
        span {
            /* margin: 100px; */
            /* padding: 100px; */
            /* 解决办法 */
            line-height: 100px;
        }
    </style>
</head>
<body>
    <!-- 行内标签的 margin 和 padding 在垂直方向的不会生效 -->
    <span>span</span>
    <span>span</span>
</body>
</html>
```

# day 06

# 一、结构伪类选择器

## 1 作用与优势

### 1.1 作用

根据元素在```HTML```中的结构关系查找元素

### 1.2 优势

减少对```HTML```中类的依赖，有利于保持代码整洁

### 1.3 场景

在父级选择器中查找子元素

## 2 选择器

### 2.1 基本使用

- ```E:first-child {}```：匹配父级元素的第一个子元素，并且是```E```元素
- ```E:last-child {}```：匹配父级元素的最后一个子元素，并且是```E```元素
- ```E:nth-child(n) {}```：匹配父级元素的第```n```个子元素，并且是```E```元素
- ```E:nth-last-child(n) {}```：匹配父级元素的倒数第```n```个子元素，并且是```E```元素

```html
<style>
        /* 第一个 */
        li:first-child {
            background-color: green;
        }

        /* 最后一个 */
        li:last-child {
            background-color: pink;
        }

        /* 任意 */
        li:nth-child(5) {
            background-color: burlywood;
        }

        /* 倒数 */
        li:nth-last-child(3) {
            background-color: aquamarine;
        }
    </style>
</head>
<body>
    <ul>
        <li>这是li1</li>
        <li>这是li2</li>
        <li>这是li3</li>
        <li>这是li4</li>
        <li>这是li5</li>
        <li>这是li6</li>
        <li>这是li7</li>
        <li>这是li8</li>
    </ul>
</body>
</html>
```

### 2.2 公式

- ```n```为：```0```、```1```、```2```、```3```、...
  - 偶数：```2n```、```even```
  - 奇数：```2n+1```、```2n-1```、```odd```
  - 找到前5个：```-n+5```
  - 找到从第5个往后：```n+5```
  - 第4个和第8个：```4n```

```html
<style>
        li:nth-child(2n) {
            background: pink;
        }

        /* 前3个 */
        li:nth-child(-n+3) {
            background-color: aqua;
        }

        /* 第四和第八 */
        li:nth-child(4n) {
            background-color: orange;
        }
    </style>

</head>
<body>
    <ul>
        <li>第1个li</li>
        <li>第2个li</li>
        <li>第3个li</li>
        <li>第4个li</li>
        <li>第5个li</li>
        <li>第6个li</li>
        <li>第7个li</li>
        <li>第8个li</li>
    </ul>
</body>
</html>
```

# 二、伪元素

- 一般页面中的非主体内容可以使用伪元素
- 区别：
  - 元素：```HTML```设置的标签
  - 伪元素：由```CSS```模拟的标签效果
- 种类
  - ```::before```：父元素内容前添加一个伪元素
  - ```::after```：父元素内容后添加一个伪元素
- 注意点
  - **必须设置**```content```属性才能生效
    - 中文的话，属性值要字符串
    - 为了生效，但是不想要内容，可以空字符串：```content: '';```
  - 默认行内元素（所以可以转换一下）

```html
    <style>
        div {
            height: 300px;
            width: 300px;
            background-color: pink;
        }

        .father::before {
            content: '老鼠';
            color: green;
        }

        .father::after {
            content: '大米';
            /* 之所以宽高没生效，就是因为，这个是行内 */
            width: 200px;
            height: 30px;
            /* 转换一下 */
            display: inline-block;

            background-color: aquamarine;
        }
    </style>
</head>
<body>
    <div class="father">爱</div>
</body>
</html>
```

# 三、标准流

不知道写啥？

# 四、浮动

## 1 不用浮动

浏览器解析行内块时，如果标签换行，之间就会有间隙。

```html
<style>
        div {
            /* 浏览器解析行内块时，如果标签换行，之间就会有间隙 */
            width: 100px;
            height: 100px;
            display: inline-block;
        }
        .one {
            background-color: pink;
        }
        .two {
            background-color: skyblue;
        }

    </style>

</head>
<body>
    <div class="one">one</div><div class="two">two</div>
</body>
</html>
```

## 2 使用浮动

### 2.1 代码

- 属性名：```float```
- 属性值：比如说：```left```

### 2.2 浮动的作用一：图文环绕

```html
<style>
        img {
            width: 100px;
            height: 100px;
            float: left;
        }
    </style>
</head>
<body>
    <!-- 图文环绕 -->
    <img src="../day04/static/发发的头像.jpg" alt="">
    撒啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊撒擦出精彩靠猜测卡成安库cake查勘车撒啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊撒擦出精彩靠猜测卡成安库cake查勘车撒啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊撒擦出精彩靠猜测卡成安库cake查勘车撒啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊撒擦出精彩靠猜测卡成安库cake查勘车撒啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊撒擦出精彩靠猜测卡成安库cake查勘车撒啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊撒擦出精彩靠猜测卡成安库cake查勘车撒啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊撒擦出精彩靠猜测卡成安库cake查勘车撒啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊撒擦出精彩靠猜测卡成安库cake查勘车撒啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊撒擦出精彩靠猜测卡成安库
```

### 2.3 浮动的作用二：块在一行排列

```html
<style>
        div {
            /* 浏览器解析行内块时，如果标签换行，之间就会有间隙 */
            width: 100px;
            height: 100px;
            display: inline-block;
        }
        .one {
            background-color: pink;
            float: left;
        }
        .two {
            background-color: skyblue;
            float: left;
        }

    </style>

</head>
<body>
    <div class="one">one</div>
    <div class="two">two</div>
</body>
</html>
```

 ## 3 浮动的特点

- 浮动元素会脱离标准流（脱标），在标准流里面不占用位置
- 浮动元素比标准流高半个级别，可以覆盖标准流中的元素
- 浮动找浮动，下个浮动元素会在上一个浮动元素后面左右浮动
- 浮动元素有特殊的显示效果
  - 一行显示多个
  - 可以设置宽高
- 浮动是在一行排列，还可以设置宽高，意思是可以理解为行内块
- 注意
  - 浮动的元素，```margin```设置居中不会生效

```html
s<style>
        .one {
            width: 100px;
            height: 100px;
            background-color: rgb(255, 192, 203, 0.8);
            float: left;
            margin-top: 50px;
        }

        .two {
            width: 200px;
            height: 200px;
            background-color: rgb(135, 206, 235, 0.8);
            float: left;
            /* 有浮动，不会生效 */
            margin: 0 auto;
        }

        .three {
            width: 300px;
            height: 300px;
            background-color: rgb(255, 165, 0) ;
        }
    </style>
</head>
<body>
    <div class="one">one</div>
    <div class="two">two</div>
    <div class="three">three</div>
</body>
</html>
```

![image-20221109183818992](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221109183818992.png)

## 4 综合案例：小米布局

```html
<style>

        /* css书写规则
        
            - 0、定位
            - 1、浮动 / display
            - 2、盒子模型
                - margin
                - border
                - padding
                - 宽度高度背景色
            - 3、文字样式

        */

        .head {
            height: 40px;
            width: 100%;
            background-color: #333;
        }

        .box {

            width: 1226px;
            background-color: antiquewhite;
            margin: 0 auto;
        }
        
        .pink {
            width: 1226px;
            height: 100px;
            background-color: pink;
            margin: auto;
        }

        .content {
            width: 1226px;
            height: 460px;
            /* background-color: green; */
            margin: auto;
        }

        .orange {
            width: 234px;
            height: 460px;
            background-color: orange;
            float: left;
        }

        .blue {
            width: 992px;
            height: 460px;
            background-color: skyblue;
            float: left;
        }

    </style>
</head>
<body>
    <div class="head"></div>
    <div class="pink">头部</div>
    
    <div class="content">
        <div class="orange">left</div>
        <div class="blue">right</div>
    </div>

</body>
</html>
```

### ```CSS```书写顺序

- 0、定位
- 1、浮动 / display
- 2、盒子模型
  - margin
  - border
  - padding
  - 宽度高度背景色
- 3、文字样式

## 5 综合案例：小米产品

> 父级宽度够，才浮上得去 

```html
<style>
        * {
            margin: 0;
            padding: 0;
        }

        ul {
            list-style: none;
        }

        .box {
            margin: 0 auto;

            width: 1226px;
            height: 614px;
            /* background-color: pink; */
        }

        .left {
            float: left;

            width: 234px;
            height: 614px;
            background-color: #800080;
        }

        .right {
            float: right;

            width: 978px;
            height: 614px;
            /* background-color: aquamarine; */
        }

        .right li {
            /* 父级宽度够，才浮上得去 */
            float: left;

            margin-right: 14px;
            margin-bottom: 14px;

            width: 234px;
            height: 300px;
            background-color: skyblue;
        }

        .right li:nth-child(4n) {
            margin-right: 0px;
        }
        
    </style>

</head>
<body>
    <div class="box">
        <div class="left"></div>
        
        <div class="right">
            <ul>
                <li>li1</li>
                <li>li2</li>
                <li>li3</li>
                <li>li4</li>
                <li>li5</li>
                <li>li6</li>
                <li>li7</li>
                <li>li8</li>
            </ul>
        </div>
    </div>
</body>
</html>
```

## 6 综合案例：导航条

> 主导航：一定要```li```标签里面套```a```标签

```html
<style>
        * {
            margin: 0;
            padding: 0;
        }

        ul {
            list-style: none;
        }

        .nav {
            margin: 50px auto;

            width: 640px;
            height: 50px;
            background-color: pink;
        }

        .nav li {
            float: left;
        }

        .nav li a {
            display: inline-block;

            width: 80px;
            height: 50px;

            text-align: center;
            line-height: 50px;
            text-decoration: none;
            font-size: 16px;
            color: #fff;
        }

        .nav a:hover{
            background-color: #008000;
        }

    </style>

</head>
<body>
    <div class="nav">
        <ul>
            <li><a href="#">新闻1</a></li>
            <li><a href="#">新闻2</a></li>
            <li><a href="#">新闻3</a></li>
            <li><a href="#">新闻4</a></li>
            <li><a href="#">新闻5</a></li>
            <li><a href="#">新闻6</a></li>
            <li><a href="#">新闻7</a></li>
            <li><a href="#">新闻8</a></li>
        </ul>
    </div>
</body>
</html>
```

# 五、清除浮动

## 1 介绍

- 含义：清除浮动带来的影响
  - 如果子元素浮动了，此时子元素不能撑开标准流的块级父元素
- 原因：子元素浮动后脱标 ——>不占位置
- 发生时候：父子级标签，子级浮动，父级没有高度。后面的标准流就会收到影响，到上面来。
- 解决方法：
  - 父级加高度（但是这个是知道了父级的高度，如果不知道父级的高度，需要由子级撑开就不能用这个方法）
  - 所以：额外标签法

## 2 消除浮动的方法二：额外标签法

- 属性名：```clear```

- 属性值：```left```、```right```、```both```

- 使用方法：

  - 父级的内容后添加一个标签，```class```一般是```clearfix```

  - 然后添加```CSS```

    ```html
    .clearfix {
        clear: both;
    }
    ```

- 缺点：添加额外标签，结构混乱

## 3 消除浮动的方法三：单伪元素法

- 操作：用伪元素替代了额外标签

- 写法一

  ```html
  .clearfix::after {
  	content: '';
  	dispaly: block;
  	clear: both;
  }
  ```

- 写法二

  > 这个样子，网页中看不到元素

  ```html
  .clearfix::after {
      content: '';
      display: block;
      clear: both;
  
      /* 兼容 sb 甲方的落后浏览器 */
      height: 0;
      visibility: hidden;
  }
  ```

- 父元素的添加```class```属性

  ```html
  <div class="top clearfix">
      <div class="left"></div>
      <div class="right"></div>
  </div>
  ```

- 优点：项目中使用，直接给标签加类即可清除浮动

##  4 消除浮动的方法四：双伪元素法

- 操作

  ```html
  <style>
      /* 作用在于解决外边距塌陷问题 */
      /* 所以外边距塌陷与浮动都可以调用这个东西 */
      .clearfix::before,
      .clearfix::after {
          content: '';
          /* 转成 table 就不会塌陷 */
          display: table;
      }
      /* 正在清除浮动的标签 */
      .clearfix::after {
          clear: both;
      }
  </style>
  ```

- 父元素的添加```class```属性

  ```html
  <div class="top clearfix">
      <div class="left"></div>
      <div class="right"></div>
  </div>
  ```

## 5 清除浮动的方法五：给父元素设置```overflow```

- 操作：父级元素设置```overflow: hidden```

  ```html
  <style>
      .top {
          margin: 0 auto;
          width: 800px;
          /* 这个地方注释了 且子级是浮动，所以撑不开 所以父级就无了 下面的也上来了 */
          /* height: 300px; */
          background-color: pink;
  
          /* 清除浮动的第五种方法 */
          overflow: hidden;
      }
  </style>
  ```

- 优点：方便

# day 07



#day 08

# 一、定位

## 1 介绍

- 解决元素之间的层叠问题

## 2 基本使用

### 2.1 设置定位方式

- 属性名：```position```
- 属性值
  - 静态定位：```static```
  - 相对定位：```relative```
  - 绝对定位：```absolute```
  - 固定定位：```fixed```

### 2.2 设置偏移值

- 偏移值设置分为两个方向，水平和垂直各选一个即可

- 选取原则为就近原则

  | 方向 |    属性名    |      属性值      |      含义      |
  | :--: | :----------: | :--------------: | :------------: |
  | 水平 |  ```left```  | 数学+px / 数字+% | 距离左边的距离 |
  | 水平 | ```right```  | 数学+px / 数字+% | 距离右边的距离 |
  | 垂直 |  ```top```   | 数学+px / 数字+% | 距离上边的距离 |
  | 垂直 | ```bottom``` | 数学+px / 数字+% | 距离下边的距离 |

## 3 静态定位

之前那个？

## 4 相对定位

- 相对定位不会改变标签的显示模式（不会脱标）

- 代码：```position: relative;```

  ```html
  <style>
      .box {
          /* 模式是相对定位 */
          /* 相对定位仍然具备标签原有的显示模式特点 */
          position: static;
          /* 和左隔了 100px */
          left: 100px;
          /* 和上隔了 100px */
          top: 200px; 
  
          width: 200px;
          height: 200px;
          background-color: pink;
      }
  </style>
  ```

- 只设置了```posistion```，不设置偏移值没有用

- 如果都写了，水平以```left```为准，垂直以```top```为准

## 5 绝对定位

### 5.1 使用绝对定位

- 相对于**非静态定位**的**父元素**进行定位移动

- 代码：```position: absolute```

- 逻辑：

  - 先找已经定位的父级，有这样的父级，以其为参照物进行定位

    ```html
    <style>
            .father {
                width: 400px;
                height: 400px;
                background-color: antiquewhite;
            }
    
            .son {
                position: relative;
    
                width: 300px;
                height: 300px;
                background-color: aquamarine;
            }
    
            .sunzi {
                position: absolute;
    
                right: 20px;
                bottom: 30px;
    
                width: 200px;
                height: 200px;
                background-color: brown;
            }
            /* 
                一般来说，子绝父相（子级绝对定位，父级相对定位）
                绝对定位查找父级方式：逐级向上查找
            */
        </style>
    </head>
    <body>
        <div class="father">
            <div class="son">
                <div class="sunzi"></div>
            </div>
        </div>
    </body>
    </html>
    ```

  - 有父级，但父级没有定位 ，则以浏览器窗口为参照物进行定位（用的很少）

    ```html
    <style>
        .box {
            /* 绝对定位
            先找已经定位的父级，有这样的父级，以其为参照物进行定位
            有父级，但父级没有定位 ，则以浏览器窗口为参照物进行定位
            */
            position: absolute;
    
            /* 
            特点
            1. 脱标，不占位
            2. 改变标签的显示模式的特点为：行内块
            */
            top: 0;
            left: 0;
    
    
            width: 200px;
            height: 200px;
            background-color: pink;
        }
    </style>
    ```

- 一般来说，子绝父相（子级绝对定位，父级相对定位）

- 绝对定位查找父级方式：逐级向上查找

### 5.2 综合案例：子绝父相水平居中

> 需求：使用子绝父相，让子盒子在父盒子中水平居中
>
> 注意使用了子绝父相，绝对定位 左右 margin auto 居中会失效

- 思路一：
  - ```left```或```top```取```50%```
  - 手动计算，再通过外边距 移 盒子的一半

- 思路二：
  - 使用内置的

```html
<style>
        .box {
            /* 绝对定位不能 左右 margin auto 居中*/
            position: absolute;
            
            /* 先移50% */
            left: 50%;
            top: 50%;

            /* 方法一：手动计算，移一半回去 */
            /* margin-left: -150px;
            margin-top: -150px; */
            /* 方法二：内置的 */
            transform: translate(-50%, -50%);

            width: 300px;
            height: 300px;
            background-color: pink;
        }
    </style>
</head>
<body>
    <div class="box"></div>
</body>
</html>
```

### 5.3 综合案例：banner居中遮罩

```html
<style>
        .banner {
            position: relative;
            margin: 0 auto;
            width: 1226px;
            height: 600px;
        }
        .mask {
            position: absolute;
            left: 0;
            bottom: 0;
            /* 绝对定位的定位模式是行内块，所以未设置宽高就为0 */
            /* 如果子级的就是父级的，则可以 */
            width: 100%;
            height: 100px;
            background-color: rgba(0, 0, 0, 0.5);
        }
    </style>
</head>
<body>
    <div class="banner">
        <img src="./static/image/bg.jpg" alt="">
        <div class="mask"></div>
    </div>
</body>
</html>
```

## 6 固定定位

- 相对于浏览器进行定位移动
- 代码：```posistion: fixed;```
- 特点
  - 配合方位属性进行移动
  - 相当于浏览器可视化区域进行移动
  - 不占位置：脱标
- 应用场景：让盒子固定在屏幕某个位置

```html
<style>
    .box {
        position: fixed;
        left: 0;
        top: 0;

        width: 200px;
        height: 200px;
        background-color: pink;
    }
</style>
```

## 7 元素的层级关系

- 层级关系

  标准流<浮动<定位

- 不同定位之间的层级关系

  - 默认情况下，定位的盒子后来者居上

  - 如果非要，就添加属性
    - 属性名：```z-index```
    - 属性值：数字

  ```html
  <style>
          div {
              width: 200px;
              height: 200px;
          }
          .one {
              position: absolute;
              left: 20px;
              top: 50px;
              /* <!-- 如果非要，就 z-index: 数学 越大越在上 --> */
              z-index: 2;
              background-color: antiquewhite;
          }
          .two {
              position: absolute;
              left: 20px;
              top: 100px;
              /* z-index: 5; */
              background-color: aquamarine;
          }
      </style>
  </head>
  <body>
      <!-- 默认情况下，定位的盒子后来者居上 -->
      <!-- 如果非要，就 z-index: 数学 越大越在上 -->
      <div class="one">one</div>
      <div class="two">two</div>
  </body>
  </html>
  ```

# 二、装饰

## 1 垂直对齐

- 浏览器将行内和行内块标签当做文字处理，默认基线对齐，就有可能对不齐···········1	······
- 解决行内块与文字或行内块对齐的问题
- 属性名：```vertical-align```
  - 属性值
    - ```baseline```：默认，基线对齐
    - ```top```：顶部对齐
    - ```middle```：中部对齐
    - ```bottom```：底部对齐

## 2 光标类型

- 属性名：```cursor```
- 属性名：

|    属性值     |             效果             |
| :-----------: | :--------------------------: |
| ```default``` |      默认值，通常是箭头      |
| ```pointer``` |  小手效果，提示用户可以点击  |
|  ```text```   | 工字型，提示用户可以选择文字 |
|  ```move```   |  十字光标，提示用户可以移动  |

```html
<style>
        div {
            width: 200px;
            height: 300px;
            background-color: pink;

            /* 手型 */
            cursor: pointer;
            /* 工字型 */
            cursor: text;
            /* 十字形 */
            cursor: move;

        }
    </style>
```

## 3 边框圆角

### 3.1 基本使用

- 属性名：```border-radius```
- 常见取值：数学+px、百分比
- 取值个数
  - 总原则：左上角顺时针转一圈。如果没有值看对角线

```html
<style>
    div {
        margin: 50px auto;
        width: 200px;
        height: 200px;
        background-color: pink;

        /* 4个值 左上角顺时针转一圈 如果没有值看对角线 */
        /* border-radius: 100px 75px 50px 25px ; */

        /* 3个值 */
        border-radius: 10px 40px 100px;
    }
</style>
```

### 3.2 常见应用

- 正圆

- 胶囊

  ```html
  <style>
      /* 正圆 */
      .one {
          width: 200px;
          height: 200px;
          background-color: orange;
  
          /* border-radius: 100px; */
          border-radius: 50%;
      }
  
      /* 胶囊 */
      .tow {
          margin: 50px;
          width: 500px;
          height: 200px;
          background-color: skyblue;
  
          border-radius: 100px;
      }
  </style>
  ```

## 4 ```overflow```溢出部分显示效果

### 4.1 溢出部分显示效果

- 溢出部分：盒子的**内容部分**所超出盒子范围的区域
- 场景：控制内容溢出部分的显示效果，例如：显示、隐藏、滚动条...
- 属性名：```overflow```
- 属性值
  - ```visible```：默认值，溢出部分可见
  - ```hidden```：溢出部分隐藏
  - ```scroll```：无论是否溢出，都显示（横纵）滚动条（一般不会用）
  - ```auto```：根据是否溢出，自动显示或隐藏滚动条

```html
<style>
    div {
        width: 200px;
        height: 200px;
        background-color: skyblue;

        /* 溢出隐藏 */
        /* overflow: hidden; */

        /* 滚动 */
        /* overflow: scroll; */

        /* 自适应滚动 */
        overflow: auto;
    }
</style>
```

## 5 元素本身的隐藏

### 5.1 元素本身隐藏

- 场景：让某元素在屏幕中不可见。例如：鼠标```hover```之后元素隐藏

- 方法一：```visibility: hidde;```要占位，几乎不用

- 方法二：```display: none;```不占位，用的多

  ```html
  <style>
          div {
              width: 200px;
              height: 200px;
          }
          .one {
              /* 几乎不用 */
              /* visibility: hidden; */
  
              display: none;
              background-color: aquamarine;
          }
          .two {
              background-color: bisque;
          }
      </style>
  </head>
  <body>
      <div class="one">one</div>
      <div class="two">two</div>
  </body>
  </html>
  ```

### 5.2 小案例

```html
    .code {
      position: absolute;
      left: 50%;
      top: 41px;
      transform: translate(-50%);

      /* 隐藏 */
      display: none;
    }

    /* 鼠标悬停 a 标签 显示二维码 */
    .nav li a:hover img {
        display: block;
    }
```

## 拓展：元素整体透明度

- 场景：让元素整体（包括内容）一起透明
- 属性名：```opacity```
- 属性值：0 ~ 1
  - 1：完全不透明
  - 0：完全透明
- 会让元素整体透明，包括里面的内容

```html
    <style>
        div {
            width: 500px;
            height: 500px;
            background-color: aquamarine;

            opacity: 0.5;
        }
    </style>
</head>
<body>
    <div>
        <img src="./static/image/bg.jpg" alt="" height="150px">
        <p>这个字透明吗</p>
    </div>
</body>
</html>
```

# day 08

# 一、项目样式补充

## 1 精灵图

### 1.1 作用

降低服务器的压力

### 1.2 使用步骤

- 创建一个盒子，尺寸与小图相同
- 将精灵图设置为盒子的背景图片
- 修改背景图的位移
  - 属性名：```background-position```
  - 属性值（都是负值）：```-x -y```

```html
    <style>
        span {
            display: inline-block;
            width: 18px;
            height: 24px;

            background-image: url(./static/image/taobao.png);
            /* 背景图片唯一 */
            background-position: -2px 0;
        }
    </style>
</head>
<body>
    <span></span>
</body>
</html>
```

## 2 背景图片大小

### 2.1 使用方法

- 作用：设置背景图片大小
- 语法：```background-size: 宽度 高度```
- 取值
  - ```数字+px```：常用
  - 百分百：盒子自身的宽高百分百
  - ```contain```：包含，等比例缩放，直到**不超出盒子**的最大
  - ```cover```：覆盖，等比例缩放，刚好**填满整个盒子**
- 实际上在工作中，图与盒子的比例都是相同的

```html
<style>
    div {
        width: 400px;
        height: 300px;
        background-color: aqua;

        background-image: url(./static/image/1.jpg);
        background-repeat: no-repeat;
        /* 覆盖一部分 */
        /* background-size: 300px; */
        background-size: 80%;
        /* background-size: contain; */

        /* 全部覆盖 */
        /* background-size: cover; */
    }
</style>
```

### 2.3 复合属性

- 方法一：

  ```background: color image repeat posistion/size```

- 方法二：

  单独写成两个，用的更多

  ```background: color image repeat posistion```

  ```background-size: size```

## 3 文字阴影

## todo



## 4 盒子阴影

- 属性名：```box-shadow```

- 取值

  |      参数      | 是否可选 |         作用         |
  | :------------: | :------: | :------------------: |
  | ```h-shadow``` |    是    | 水平偏移量，允许负值 |
  | ```v-shadow``` |    是    | 水平偏移量，允许负值 |
  |   ```blur```   |    否    |        模糊度        |
  |  ```spread```  |    否    |       阴影扩大       |
  |  ```color```   |    否    |       阴影颜色       |
  |  ```inset```   |    否    |     改为内部阴影     |

```html
<style>
    .box {
        width: 200px;
        height: 200px;
        background-color: antiquewhite;

        box-shadow: 5px 10px 20px 10px skyblue;
    }
</style>
```

## 5 过渡

- 让元素的样式慢慢变化，常配合```hover```使用
- 属性名：```transition```
- 设置在不同状态
  - 设置在默认状态，移入移出都有效果
  - 给```hover```设置，移入有效果，移出没有效果


```html
<style>
    div {
        width: 200px;
        height: 300px;
        background-color: aqua;

        /* transition: width 1s, background-color 2s; */
        transition: all 5s;
    }
    div:hover {
        width: 600px;
        background-color: bisque;
    }
</style>
```

# 二、项目的前置认知

## 1 网页和网站的关系

## todo



## 2 骨架结构标签

```html
<!-- 文档类型说明，告诉浏览器该网页的 HTML版本 html是html5 -->
<!DOCTYPE html>
<!-- 搜索引擎归类+浏览器翻译 -->
<html lang="zh-CN">
<head>
    <!-- 编码 -->
    <meta charset="UTF-8">
    <!-- 解决 ie浏览器 兼容性 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- 宽度和设备宽度相同 移动端使用 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    
</body>
</html>
```

## 3 SEO 搜索引擎优化

- 作用：让网站在搜索引擎上的排名靠前
- 常见方法
  - 竞价排名
  - 网页制作成```html```后缀
  - 标签语义化

- SEO三大标签
  - ```title```
  - ```description```
  - ```keywords```


```html
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="京东JD.COM-专业的综合网上购物商城，为您提供正品低价的购物选择、优质便捷的服务体验。商品来自全球数十万品牌商家，囊括家电、手机、电脑、服装、居家、母婴、美妆、个护、食品、生鲜等丰富品类，满足各种购物需求。">
    <meta name="keywords" content="网上购物,网上商城,家电,手机,电脑,服装,居家,母婴,美妆,个护,食品,生鲜,京东">
    <title>京东(JD.COM)-正品低价、品质保障、配送及时、轻松购物！</title>
</head>
```

- 优化logo

```html
<div class="logo">
    <!-- 搜索引擎优化 -->
    <h1>
        <a href="#">
            小兔鲜儿
        </a>
    </h1>
</div>
```

```css
.logo {
    float: left;
}
.logo h1 a {
    display: block;
    width: 207px;
    height: 70px;
    background-image: url(../images/logo.png);
    background-size: contain;
    /* 字看不见 */
    font-size: 0;
}
```

## 4 ico 图标设置

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="京东JD.COM-专业的综合网上购物商城，为您提供正品低价的购物选择、优质便捷的服务体验。商品来自全球数十万品牌商家，囊括家电、手机、电脑、服装、居家、母婴、美妆、个护、食品、生鲜等丰富品类，满足各种购物需求。">
    <meta name="keywords" content="网上购物,网上商城,家电,手机,电脑,服装,居家,母婴,美妆,个护,食品,生鲜,京东">
    <title>京东(JD.COM)-正品低价、品质保障、配送及时、轻松购物！</title>
    <link rel="icon" href="./static/image/酷狗音乐.ico">
</head>
<body>
    
</body>
</html>
```































