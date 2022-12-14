#  day 01

# 一、字体图标

展示的是图标，本质上是字。处理简单的、颜色单一的图片

## 1 使用

- 引入字体图标样式表

  ```html
  <link rel="stylesheet" href="./iconfont/iconfont.css">
  ```

- 调用图标对应的类名，需要两个类名

  - iconfont类：基本样式
  - icon-xxx：图标对应的类名

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./iconfont/iconfont.css">
    <style>
        .iconfont {
            font-size: 300px;
            color: skyblue;
        }
    </style>
</head>
<body>
    <span class="iconfont icon-fabulous"></span>
</body>
</html>
```

## 2 案例：淘宝购物车

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./iconfont/iconfont.css">
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        a {
            color: #333;
            text-decoration: none;
        }
        li {
            list-style: none;
        }
        .nav {
            width: 300px;
            margin: 50px auto;
        }
        .icon-ashbin {
            color: orange;
        }
        .icon-ashbin, 
        .icon-arrow-right {
            font-size: 50px;
        }
        .nav a span {
            font-size: 50px;
        }
    </style>
</head>
<body>
    <div class="nav">
        <ul>
            <li>
                <a href="#">
                    <span class="iconfont icon-ashbin"></span>
                    <span>购物车</span>
                    <span class="iconfont icon-arrow-right"></span>
                </a>
            </li>
        </ul>
    </div>
</body>
</html>
```

# 二、平面转换

## 1 介绍

- 使用```transform```属性实现元素的位移、旋转、缩放等效果
- 平面转换
  - 改变盒子在平面内的形态（位移、旋转、缩放）
  - 也叫 2D转换
- 属性名：```transform```



## 2 位移

### 2.1 位移简介

```transform: translate(水平移动距离, 垂直移动距离)```

- 取值（正负都可）

  - 像素单位

  - 百分百（参考盒子自身的尺寸计算）

  - X轴正向为右，Y轴正向为下

    ![image-20221127144526933](assets/image-20221127144526933.png)

  - 技巧

    - 只给一个值，表示X轴的
    - 单独设置某个方向的
      - ```translateX()```
      - ```translateY()```

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .father {
            width: 500px;
            height: 300px;
            margin: 50px auto;
            border: 1px solid #000;
        }
        .son {
            width: 200px;
            height: 100px;
            background-color: pink;
            /* 加一个过渡 */
            transition: all 0.4s;
        }
        .father:hover .son {
            transform: translate(50px, 100px);
            /* 百分百参考自身的尺寸计算结果 */
            transform: translate(100%, 100%);
            /* 由于有层叠性，只有最后一个生效 */

            transform: translateX(50px);
        }
    </style>
</head>
<body>
    <div class="father">
        <div class="son">
        </div>
    </div>
</body>
</html>
```

### 2.2 绝对定位元素居中的两个方法

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .father {
            position: relative;
            width: 500px;
            height: 300px;
            margin: 50px auto;
            border: 1px solid #000;
        }
        .son {
            position: absolute;
            left: 50%;
            top: 50%;
            
            /* 以前学的 */
            /* margin-left: -100px;
            margin-top: -50px; */

            /* 位移实现 */
            transform: translate(-50%, -50%);

            width: 200px;
            height: 100px;
            background-color: pink;
        }
    </style>
</head>
<body>
    <div class="father">
        <div class="son">
        </div>
    </div>
</body>
</html>
```

### 2.3 案例：双开门

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
            margin: 0;
            padding: 0;
        }
        .box {
            /* 超出父级的隐藏 */
            overflow: hidden;
            width: 1366px;
            height: 600px;
            margin: 0 auto;
            background-image: url(./images/bg.jpg);
        }
        .box::before,
        .box::after {
            float: left;
            content: '';
            width: 50%;
            height: 100%;
            background-image: url(./images/fm.jpg);
            transition: all 0.4s;
        }
        .box::after {
            background-position: right 0;
        }
        .box:hover::before {
            transform: translateX(-100%);
        }
        .box:hover::after {
            transform: translateX(100%);
        }
    </style>
</head>
<body>
    <div class="box">
    </div>
</body>
</html>
```

## 3 旋转

### 3.1 旋转简介

- 语法：```transform: rotate deg```
- 取值正负都可
  - 正为顺时针
  - 负为逆时针

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        img {
            width: 250px;
            transition: all 5s;
        }
        img:hover {
            transform: rotate(-360deg);
        }
    </style>
</head>
<body>
    <img src="./images/rotate.png" alt="">
</body>
</html>
```

### 3.2 转换原点

- 语法
  - 默认原点是盒子中心点
  - ```transform-origin: 原点水平位置 原点垂直位置```
  - 添加给标签本身，而不是```hover```
- 取值
  - **方位名词**
    - ```left```、```top```、```bottom```、```right```、```center```
  - 像素单位数值
  - 百分比

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        img {
            width: 250px;
            border: 1px solid #503;
            transition: all 2s;
            transform-origin: right bottom;
        }
        img:hover {
            transform: rotate(360deg);
        }
    </style>
</head>
<body>
    <img src="./images/rotate.png" alt="">
</body>
</html>
```

### 3.3 多重转换

```transform: translate(600px) rotate(360deg);```

> 旋转会改变指标轴向，所以如果先是旋转，再位移，就会奇奇怪怪
>
> 也不能分开写，否则会发生层叠
>
> ```css
> transform: translate(600px)
> transform: rotate(360deg)
> ```

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .box {
            width: 800px;
            height: 200px;
            margin: 50px auto;
            border: 1px solid #000;
        }
        img {
            height: 200px;
            transition: all 2s;
        }
        .box:hover img {
            transform: translate(600px) rotate(360deg);
        }
    </style>
</head>
<body>
    <div class="box">
        <img src="./images/tyre.png" alt="">
    </div>
</body>
</html>
```

## 4 缩放

### 4.1 缩放简介

- 语法
  - ```transform: scale(X轴缩放倍数, Y轴缩放倍数)```
- 提示
  - 如果只有一个，就是x和y


```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .box {
            width: 300px;
            height: 210px;
            margin: 100px auto;
            background-color: pink;
        }
        .box img {
            width: 100%;
            transition: all 0.5s;
        }
        .box:hover img {
            transform: scale(1.2);
        }
    </style>
</head>
<body>
    <div class="box">
        <img src="./images/product.jpg" alt="">
    </div>
</body>
</html>
```

### 4.2 案例：和平精英

> 绝对定位的盒子如何居中？
>
> 如何处理```transform```层叠的bug

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
            margin: 0;
            padding: 0;
        }
        li {
            list-style: none;
        }
        img {
            width: 100%;
        }
        .box {
            width: 249px;
            height: 210px;
            margin: 50px auto;
            /* .box 外的看不见 */
            overflow: hidden;
        }
        .box p {
            color: #3b3bb3;
            padding: 10px 10px 0 10px;
        }
        .box .pic {
            position: relative;
        }
        .box ul li .pic::after {
            position: absolute;
            content: "";
            left: 50%;
            top: 50%;

            /* 定位的居中：移回去 */
            margin-left: -29px;
            margin-top: -29px;
            /* 如果 transform: translate(-50%, -50%) 不会生效 因为会被下面的层叠 只能这样 */
            /* transform: translate(-50%, -50%) scale(5); */
            
            width: 58px;
            height: 58px;
            background-image: url(./images/play.png);

            /* 特别大 */
            transform: scale(5);
            opacity: 0;
            transition: all 0.2s;
        }
        .box ul li:hover .pic::after {
            transform: scale(1);
            /* 解决上面那个 bug  */
            /* transform: translate(-50%, -50%) scale(1); */
            opacity: 100%;
        }
    </style>
</head>
<body>
    <div class="box">
        <ul>
            <li>
                <div class="pic">
                    <img src="./images/party.jpeg" alt="">
                    <!-- 伪元素 -->
                </div>
                <p>【和平精英】“初火”音乐概念片：四圣觉醒</p>
            </li>
        </ul>
    </div>
</body>
</html>
```

# 三、渐变

## 1 简介

- 多个颜色逐渐变化的视觉效果
- 一般是盒子的背景

```html
<style>
    .box {
        width: 300px;
        height: 200px;
        background-image: linear-gradient(pink, green, blue);

        /* 工作中更这么用 */
        background-color: pink;
        background-image: linear-gradient(transparent, rgba(0, 0, 0, 0.6));
    }
</style>
```

# 四、综合案例：华为新闻

> 平面转换+缩放

# day 02

# 一、空间转换

## 1 介绍

![image-20221129135457044](assets/image-20221129135457044.png)

## 2 位移

- 语法

  - ```transform: translate3d(x, y, z)```
  - ```transform: translateX(x)```
  - ```transform: translateY(x)```
  - ```transform: translateZ(x)```
- 取值
  - 像素单位数值
  - 百分百

## 3 透视

- 近大远小，近实远虚
- 加给父级
- 属性名：```perspective```
- 属性值：像素单位数值，一般是800-1200
- 透视距离也称视距，就是人的眼睛到屏幕的距离

![image-20221130122749908](assets/image-20221130122749908.png)

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            perspective: 1000px;
        }
        .box {
            width: 200px;
            height: 200px;
            margin: 100px auto;
            background-color: coral;
            transition: all 0.5s;
        }
        .box:hover {
            transform: translateZ(200px);
        }
    </style>
</head>
<body>
    <div class="box"></div>
</body>
</html>
```

## 4 空间旋转

- 语法

  - ```transfrom: rotateX(值)```
  - ```transfrom: rotateY(值)```
  - ```transfrom: rotateZ(值)```（和```rotate```效果一样）

- x轴

  ```python
  <!DOCTYPE html>
  <html lang="en">
  <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Document</title>
      <style>
          .box {
              width: 200px;
              margin: 100px auto;
              perspective: 1000px;
          }
          img {
              width: 300px;
              transition: all 0.7s;
          }
          .box img:hover {
              transform: rotateX(60deg);
          }
      </style>
  </head>
  <body>
      <div class="box">
          <img src="../images/hero.jpeg" alt="">
      </div>
  </body>
  </html>
  ```

- y轴

  一样的

- 拓展

  自定义旋转轴的位置及旋转角度

  ```rotate3d(x, y, z 角度度数)```

  x, y, z取值为0-1之间的数字

## 5 立体呈现

- 实现方法
  - 父级添加```transform-style: preserve-3d```
  - 子元素则处于真正的3d空间
  - 默认是```flat```，即子元素处于2d平面呈现

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .cube {
            position: relative;
            width: 200px;
            height: 200px;
            margin: 100px auto;
            /* background-color: palegreen; */
            transition: all 1s;
            transform-style: preserve-3d;
        }
        .cube div {
            width: 200px;
            height: 200px;
        }
        .front {
            position: absolute;
            background-color: bisque;
        }
        .back {
            position: absolute;
            background-color: cadetblue;
            transform: translateZ(-200px);
        }
        .cube:hover {
            transform: rotateY(180deg);
        }
    </style>
</head>
<body>
    <div class="cube">
        <div class="front">前面</div>
        <div class="back">后面</div>
    </div>
</body>
</html>
```

## 6 空间缩放

- ```transform: scaleX(倍数)```
- ```transform: scaleY(倍数)```
- ```transform: scaleZ(倍数)```
- ```transform: scale3d(x, y, z)```

# 二、动画

## 1 简介

- 两个状态是过渡
- 多个状态就是动画效果了
- 过程可控：重复播放、最终画面、是否暂停

## 2 语法

- 属性名

  - ```animation```

- 定义动画

  - 方法一

    ```html
    @keyframes 动画名称 {
      from {}
      to {}
    }
    ```

  - 方法二

    ```html
    @keyframes 动画名称 {
      0% {}
      10% {}
      15% {}
      100% {}
    }
    ```

- 使用动画

  ```html
  animation: 动画名称 动画花费时长;
  ```

## 3 简单使用

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .box {
            width: 200px;
            height: 100px;
            background-color: antiquewhite;
            /* 使用动画 */
            animation: change2 1s;
        }
        /* 定义动画 1 */
        @keyframes change1 {
            from {
                width: 200px;
            }
            to {
                width: 600px;
            }
        }
        /* 定义动画 2 */
        @keyframes change2 {
            0% {
                width: 200px;
                height: 100px;
            }
            30% {
                width: 500px;
                height: 300px;
            }
            100% {
                width: 800px;
                height: 300px;
            }
        }
    </style>
</head>
<body>
    <div class="box"></div>
</body>
</html>
```

## 4 动画属性

- 属性名：```animation: 动画名称 动画时长 速度曲线 延迟时间 重复次数 动画方向 执行完毕时状态```
- 属性值：
  - 速度曲线
    - ```lines```：匀速
    - ```steps(num)```：类似于帧
    
  - 重复次数
  
    - ```num```：具体次数
    - ```infinite```：无限循环
  
  - 动画方向
  
    - ```alternate```：反复
  
  - 执行完毕时状态
  
    > 删掉```infinite```和```alternate```
  
    - ```backward```：默认值，第一帧状态
    - ```forrwards```：最后一帧状态
- 注意

  - 动画名称和动画时长必须赋值
  - 不分先后顺序
  - 两个时间值，则第一个是动画时长 第二个是延迟时间

## 5 拆分写法*

|              属性               |        作用        |                             取值                             |
| :-----------------------------: | :----------------: | :----------------------------------------------------------: |
|      ```animation-name```       |      动画名称      |                                                              |
|    ```animation-duration```     |      动画时长      |                                                              |
|      ```animation-delay```      |      延迟时间      |                                                              |
|    ```animation-fill-mode```    | 动画执行完毕是状态 | ```backward```：默认值，第一帧状态<br> ```forrwards```：最后一帧状态 |
| ```animation-timing-function``` |      速度曲线      |                 ```steps(数字)```：逐帧动画                  |
| ```animation-iteration-count``` |      重复次数      |                   ```infinite```：无限循环                   |
|    ```animation-direction```    |    动画执行方向    |                    ```alternate```：反向                     |
|   ```animation-play-state```    |      暂停动画      |         ```paused```为暂停，通常搭配```:hover```使用         |

## 6 逐帧动画

- 补间动画和逐帧动画
  - 补间动画不配合精灵图，使用更多
  - 逐帧动画配合精灵图
  
- 使用

  - ```animation-timing-function: steps(N)```

    - 将动画过程等分为N份

  - 步骤

    - 准备显示区域

      盒子大小是精灵图一个图的大小，背景图为当前精灵图

    - 定义动画

      改变背景图位置，移动距离是精灵图的宽度

    - 使用动画

      - 速度曲线```step(N)```，N和精灵图上小图个数相同
      - 添加无限重复效果

  - 多个动画

    ```html
    animation: 
      动画1,
      动画2,
      动画N
    ;
    ```

  - 如果动画的开始状态和盒子的默认样式相同，可以省略开始状态的代码


```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .box {
            width: 140px;
            height: 140px;
            /* border: 1px solid; */
            background-image: url(../images/bg.png);
            animation: 
              move 1s steps(12) infinite, 
              run 2s forwards
            ;
        }
        @keyframes move {
            /* 可以不加这个东西哦 */
            /* from {
                background-position: 0 0;
            } */
            to {
                background-position: -1680px 0;
            }
        }
        @keyframes run {
            /* from {
                transform: translateX(0);
            } */
            to {
                transform: translateX(800px);
            }
        }
    </style>
</head>
<body>
    <div class="box"></div>
</body>
</html>
```







# 三、综合案例

## 1 3D导航

![image-20221130214302889](assets/image-20221130214302889.png)

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        ul {
            margin: 0;
            padding: 0;
            list-style: none;
        }
        .navs {
            width: 300px;
            height: 40px;
            margin: 50px auto;
        }
        .navs li {
            float: left;
            width: 100px;
            height: 40px;
            line-height: 40px;
            transform-style: preserve-3d;
            transition: all 0.5s;
            /* 辅助 */
            /* transform: rotateX(-20deg) rotateY(30deg); */
            /* 3d 缩放 */
            transform: scale3d(0.5, 1.1, 5);
        }
        .navs li a {
            position: absolute;
            display: block;
            width: 100%;
            height: 100%;
            text-align: center;
            text-decoration: none;
            color: aliceblue;
        }
        .navs li a:first-child {
            background-color: green;
            /* 移动 */
            transform: translateZ(20px);
        }
        .navs li a:last-child {
            background-color: orange;
            /* 放倒 移动 */
            transform: rotateX(90deg) translateZ(20px);
        }
        .navs li:hover {
            transform: rotateX(-90deg);
        }
    </style>
</head>
<body>
    <div class="navs">
        <ul>
            <li>
                <a href="#">首页</a><a href="#">index</a>
            </li>
            <li>
                <a href="#">登录</a><a href="#">login</a>
            </li>
            <li>
                <a href="#">注册</a><a href="#">register</a>
            </li>
        </ul>
    </div>
</body>
</html>
```

## 2 走马灯

> 逐帧动画 无缝动画

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
        padding: 0;
        margin: 0;
      }
      li {
        list-style: none;
      }
      img {
        width: 200px;
      }
      .box {
        width: 600px;
        height: 112px;
        border: 5px solid #000;
        margin: 100px auto;
        overflow: hidden;
      }
      .box ul {
        width: 2000px;
        animation: move 5s infinite linear;
      }
      .box li {
        float: left;
      }
      @keyframes move {
        to {
            transform: translateX(-1400px)
        }
      }
      .box:hover ul {
        animation-play-state: paused
      }
    </style>
</head>
<body>
    <div class="box">
        <ul>
          <li><img src="./images/1.jpg" alt="" /></li>
          <li><img src="./images/2.jpg" alt="" /></li>
          <li><img src="./images/3.jpg" alt="" /></li>
          <li><img src="./images/4.jpg" alt="" /></li>
          <li><img src="./images/5.jpg" alt="" /></li>
          <li><img src="./images/6.jpg" alt="" /></li>
          <li><img src="./images/7.jpg" alt="" /></li>
          <!-- 第567移动的时候,显示区域不能留白 -->
          <li><img src="./images/1.jpg" alt="" /></li>
          <li><img src="./images/2.jpg" alt="" /></li>
          <li><img src="./images/3.jpg" alt="" /></li>
        </ul>
      </div>
</body>
</html>
```

## 3 全民出游季

> 动画综合使用

# day 03

# 一、移动端特点

## 1 PC网页和移动端网页的区别

- PC屏幕**大**，网页固定版心
- 手机屏幕**小**，网页宽度多为100%

## 2 谷歌模拟器

## 3 屏幕分辨率

## 4 视口

> 视口标签由vosecode自动生成
>
> 视口标签会默认HTML的宽度和设备宽度（逻辑分辨率）相同，若没有则宽度为```980px```

```html
<meta name="viewport" content="width=device-width, initial-scale=1.0">
```

## 5 二倍图





# 二、百分比布局

## 1 简介

- 百分比布局，也叫流式布局
- 效果：**宽度自适应，高度固定**
- 古老的布局方式

## 2 京东

```html
<style>
    * {
        margin: 0;
        padding: 0;
    }
    li {
        list-style: none;
    }
    .toolbar {
        /* 固定定位 */
        position: fixed;
        bottom: 0;
        /* 百分比布局 流式布局 */
        width: 100%;
        height: 50px;
        background-color: pink;
    }
    .toolbar li img {
        height: 100%;
    }
    .toolbar li {
        float: left;
        width: 20%;
        height: 50px;
    }
</style>
```

# 三、Flex布局

## 1 简介

- Flex布局/弹性布局

  - 是一种**浏览器提倡**的**布局模型**
  - 布局网页更**简单**、**灵活**
  - 避免**浮动脱标**问题
  - IE 不兼容

- 查询是否兼容

  https://caniuse.com/

## 2 使用方法

- 给父元素添加```display: flex```，则子元素可以自动的挤压或拉伸

- 组成部分

  - 弹性容器
  - 弹性盒子
  - **主轴**：默认水平方向。弹性盒子默认排列方向。
  - **侧轴/交叉轴**：默认垂直方向

  ![image-20221202151934111](assets/image-20221202151934111.png)



## 3 主轴对齐方式

> 通过调节主轴或侧轴的对齐方式，来设置盒子之间的间距

属性名：```justify-content```

|       属性值        |                        作用                        |
| :-----------------: | :------------------------------------------------: |
|  ```flex-start```   |              默认值，起点开始依次排列              |
|   ```flex-end```    |                  终点开始依次排列                  |
|    ```center```     |                   沿主轴居中排列                   |
| ```space-around```  |  弹性盒子沿主轴均匀排列，空白间距分在弹性盒子两侧  |
| ```space-between``` |  弹性盒子沿主轴均匀排列，空白间距分在相邻盒子之间  |
| ```space-evenly```  | 弹性盒子沿主轴均匀排列，弹性盒子与容器之间间距相等 |

## 4 侧轴对齐方式

- 属性名
  - ```align-items```：添加到弹性容器
  - ```align-self```：添加到弹性盒子，控制某个弹性盒子在侧轴的对齐方式

|      属性值      |                            作用                            |
| :--------------: | :--------------------------------------------------------: |
| ```flex-start``` |                  默认值，起点开始依次排列                  |
|  ```flex-end```  |                      终点开始依次排列                      |
|   ```center```   |                       沿侧轴居中排列                       |
|  ```stretch```   | 默认值，弹性盒子沿主轴线被拉伸至铺满容器（但是要注释高度） |

- 注意
  - 当弹性盒子没给宽高，给了```stretch```或没给（此时仍是默认的```stretch```），则会默认拉伸铺满
  - 若没给宽高，是其他属性值，则高度和内容相同

## 5 伸缩比

- 属性名：```flex```
- 属性值：数值（整数）。占用父盒子剩余尺寸

# 四、小兔鲜儿移动端

支付页面

# day 04

# 一、Flex布局

## 1 主轴方向

属性名：```flex-direction```

|        属性值        |        作用        |
| :------------------: | :----------------: |
|      ```row```       | 行，水平（默认值） |
|   **```column```**   |    **列，垂直**    |
|  ```row-reverse```   |    行，从右到左    |
| ```column-reverse``` |    列，从下到上    |

## 2 居中

```html
<style>
    .box li {
        display: flex;
        /* 现在主轴在垂直方向 */
        flex-direction: column;
        /* 侧轴居中 此时侧轴横着的 即水平居中 */
        align-items: center;
        /* 主轴居中 此时主轴竖着的 即垂直居中 */
        justify-content: center;

        width: 80px;
        height: 80px;
        border: 1px solid #ccc;
    }
</style>
```

## 3 弹性盒子换行

- 使用
  - 属性：```flex-wrap```
  - 属性值：
    - ```wrap```：换行
    - ```nowrap```：不换行，默认值

- 行距
  - 换行后有默认的行距
  - 调整
    - 属性名：```align-content```
    - 属性值：和```justify-content```的属性值基本上一样

## 4 弹性盒子溢出省略号

> 在是什么东西 我看不懂 o(╥﹏╥)o

```css
.order li .goods .txt {
    flex: 1;
    /* 这个地方宽度为 0 为了溢出显示省略号 */
    width: 0;
}
.order li .goods .txt h5 {
    text-overflow: ellipsis;
    white-space: nowrap;
    overflow: hidden;
}
```

# day 05 移动适配

# 一、rem

## 1 媒体查询

> 屏幕宽度不同，网页元素尺寸不同（等比缩放）

### 1.1 rem单位

- 相对单位
- rem单位是相当于**HTML标签**（根）的字号的计算结果
- 1rem=1HTML字号大小

```html
<style>
    * {
        margin: 0;
        padding: 0;
    }
    html {
        font-size: 20px;
    }
    .box {
        width: 2rem;
        height: 3rem;
        background-color: aqua;
    }
</style>
```

### 1.2 媒体查询

> 媒体查询能够检测视口的宽度，然后编写差异化的CSS样式

- 写法

  ```css
  @media (媒体特征) {
      选择器 {
          CSS属性
      }
  }
  ```

### 1.3 rem适配

- 一般来说，HTML标签的字号为**视口宽度**的1/10

## 2 flexible.js

- github地址：[https://github.com/amfe/lib-flexible](https://link.jianshu.com?t=https://github.com/amfe/lib-flexible)

- 官方文档地址：[https://github.com/amfe/article/issues/17](https://link.jianshu.com?t=https://github.com/amfe/article/issues/17)

  ```html
  <script src="http://g.tbcdn.cn/mtb/lib-flexible/0.3.2/??flexible_css.js,flexible.js"
  ></script>
  ```

# 二、Less语法

> 由于px单位转换到rem单位较为麻烦，所以可以使用Less语法

## 2.1 简介

- Less是CSS预处理器，Less文件后缀是.less
- 扩充了CSS语言，使CSS具备一定的逻辑性、计算能力
- vscode需要安装插件 Easy LESS
- 浏览器不识别Less代码，目前阶段，网页要引入CSS文件

```less
.father {
    color: aqua;
    width: (68 / 37.5rem);

    .son {
        background-color: aquamarine;
    }
}
```

```css
.father {
  color: aqua;
  width: 1.81333333rem;
}
.father .son {
  background-color: aquamarine;
}
```

## 2.2 Less注释

- 单行注释
  - 语法：```// 注释内容```
  - 快捷键：```ctrl + /```
- 块注释
  - 语法：```/* 注释内容 */```
  - 快捷键：```shift + alt + A```
- 由于CSS只支持```/* 注释内容 */```这种注释，所以转换后，单行注释就会无啦

## 2.3 Less计算

- 除法要注意

```less
.box {
    width: 10 + 10px;
    height: 100 - 20px;
    width: 100 * 2px;
    
    // 除法
    // 更推荐前者
    width: (68 / 37.5rem);
    height: 29 ./ 37.5rem;
}
```

## 2.4 Less嵌套

> 快速生成后代选择器

- &表示当前选择器，通常配合伪类或伪元素使用

```less
.father {
    width: 200px;
    &:hover {
        font-size: 10px;
    }
    .son {
        color: antiquewhite;
        &:hover {
            color: aquamarine;
        }
    }
}
```

```css
.father {
  width: 200px;
}
.father:hover {
  font-size: 10px;
}
.father .son {
  color: antiquewhite;
}
.father .son:hover {
  color: aquamarine;
}
```

## 2.5 Less变量

- 存储数据，方便修改和使用

- 语法

  - 定义变量

    ```@变量名: 值;```

  - 使用变量

    ```CSS属性: @变量名;```

```less
@colora: pink;

.box {
    color: @colora;
}

.father {
    background-color: @colora;
}
```

## 2.6 导入

- 语法

  ```@import 'road.less'```

- 注意

  - 如果是```.less```文件，可以不需要后缀
  - 一般都是放在文件开头

## 2.7 导出

- 方法一：配置Easy Less插件

  ```json
  "less.compile": {
      "out": "../css/"
  }
  ```

- 方法二：当前文件夹的导出路径

  在文件里面的第一行添加路径信息

  ```less
  // out: ./abc/fafa.css
  
  .box {
      color: aqua;
  }
  ```

## 2.8 禁止导出

在文件里面的第一行添加```// out: false```

# 三、项目演练：游乐园

搞定啦

# 四、vw/vh

## 1 简介

- 相对单位
- 相对**视口的尺寸**计算结果
- ```vw```: ```viewport width```
  - ```1vw=1/100视口宽度```
- ```vh```: ```viewport height```
  - ```1vh=1/100视口高度```

```html
<style>
    .box {
        width: 50vw;
        height: 50vh;
        background-color: aquamarine;
    }
</style>
```

## 2 vw和vh适配

```less
* {
    margin: 0;
    padding: 0;
}
.box {
    width: (68 / 3.75vw);
    height: (29 / 3.75vw);
    background-color: aquamarine;
}
.box2 {
    width: (68 / 6.67vh);
    height: (29 / 6.67vh);
    background-color: beige;
}
```

# day07

# 一、响应式

> 一套代码，兼容不同大小的设备。设备不同，布局也不同。

## 1 媒体查询

- 媒体查询

  ```css
  @media (媒体特征) {
      选择器 {
          CSS属性
      }
  }
  ```

- 采用写法

  - ```max-width```
  - ```min-width```

- 举个例子

  ```css
  /* 视口宽度小于等于 768px 背景颜色为粉色 */
  @media (max-width: 768px) {
      body {
          background-color: pink;
      }
  }
  
  /* 视口宽度大于等于 1200px 背景颜色为蓝色 */
  @media (min-width: 1200px) {
      body {
          background-color: skyblue;
      }
  }
  ```

## 2 书写顺序

- ```min-width```：从小到大
- ```max-width```：从大到小

## 3 媒体查询完整语法

```css
@media 关键词 媒体类型 and (媒体特征) {
    css代码
}
```

- 媒体类型

  - ```and```
  - ```only```
  - ```not```

- 媒体类型

  |  类型名称  |      值      |          描述           |
  | :--------: | :----------: | :---------------------: |
  |    屏幕    | ```screen``` |      带屏幕的设备       |
  |  打印预览  | ```print```  |      打印预览模式       |
  |   阅读器   | ```speech``` |      屏幕阅读模式       |
  | 不区分类型 |  ```all```   | 默认值，包括以上3种情况 |

- 媒体特征

  |      特征名称      |               属性                |                      值                      |
  | :----------------: | :-------------------------------: | :------------------------------------------: |
  |    视口的宽和高    |     ```width```、```heigth```     |                     数值                     |
  | **视口最大宽和高** | ```max-width```、```max-heigth``` |                     数值                     |
  | **视口最小宽和高** | ```min-width```、```min-heigth``` |                     数值                     |
  |      屏幕分享      |         ```orientation```         | ```portrait```：竖屏   ```landscape```：横屏 |

## 4 外链css引入

- 语法

  ```css
  <link rel="stylesheet" media="逻辑符 媒体类型 and (媒体特征)" href="xxx.css">
  ```

- 举个例子

  ```css
  <link rel="stylesheet" href="./one.css" media="(min-width: 992px)">
  <link rel="stylesheet"href="./two.css"  media="(min-width: 1200px)">
  ```

## 5 小案例：隐藏内容

> 比如说电商站：京东

```css
@media (max-width: 768px) {
    .left {
        display: none;
    }
}
```

# 二、BootStrap

## 1 简介

```BootStrap```框架由```Twitter```公司开发维护的前端```UI```框架，提供了大量编写好的```CSS```样式，允许开发者结合一定的```HTML```结构及```JavaScript```，快速编写功能完善的网页及常见的交互效果。

- 中文官网

  https://www.bootcss.com/

## 2 简单使用

1. 引入

   ```html
   <link rel="stylesheet" href="./bootstrap-3.4.1-dist/css/bootstrap.min.css">
   ```

2. 调用类

   - ```container```：响应式布局版心类

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./bootstrap-3.4.1-dist/css/bootstrap.min.css">
    <style>
        div {
            height: 50px;
            background-color: aquamarine;
        }
    </style>
</head>
<body>
    <div class="container">1</div>
</body>
</html>
```

## 3 栅格系统

### 3.1 体验

- bootstrap默认把网页分成12等份

![image-20230104000108402](assets/image-20230104000108402.png)

|          |    超小屏幕    |     小屏幕     |    中等屏幕    |     大屏幕     |
| :------: | :------------: | :------------: | :------------: | :------------: |
| 响应断点 |  ```<768px```  | ```>=768px```  | ```>=992px```  | ```>=1200px``` |
|   别名   |    ```xs```    |    ```sm```    |    ```md```    |    ```lg```    |
|  类前缀  | ```col-xs-*``` | ```col-sm-*``` | ```col-md-*``` | ```col-lg-*``` |
|   列数   |    ```12```    |    ```12```    |    ```12```    |    ```12```    |
|  列间隙  |   ```30px```   |   ```30px```   |   ```30px```   |   ```30px```   |

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./bootstrap-3.4.1-dist/css/bootstrap.css">
    <title>Document</title>
    <style>
        .container div {
            height: 50px;
            background-color: aqua;
        }
    </style>
</head>
<body>
    <!-- 大屏4个 小屏2个 -->
    <div class="container">
        <div class="col-lg-3 col-md-6">1</div>
        <div class="col-lg-3 col-md-6">2</div>
        <div class="col-lg-3 col-md-6">3</div>
        <div class="col-lg-3 col-md-6">4</div>
    </div>
</body>
</html>
```

### 3.2 左右内间距

> bootstrap框架默认有内边距，一般间距都是```15px```
>
> 比如说```container```类自带间距```15px```

- 解决办法一

  自己写css样式，把默认的层叠掉

- 解决办法二

  使用```row```类。```row```类自带间距```-15px```。

  ```html
  <div class="container">1</div>
  <div class="container">
      <div class="row">2</div>
  </div>
  ```

  看看css

  ```css
  .container {
      padding-right: 15px;
      padding-left: 15px;
      margin-right: auto;
      margin-left: auto;
  }
  .row {
      margin-right: -15px;
      margin-left: -15px;
  }
  ```

### 3.3 通栏

```html
<div class="container-fluid"></div>
```

```css
.container-fluid {
    padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;
}
```

## 4 全局样式

### 4.1 表格

```html
<div class="container">
    <table class="table table-striped table-bordered table-hover table-condensed">
        <tr>
            <th>数之一</th>
            <th>数之二</th>
            <th>数之三</th>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
    </table>
</div>
```

### 4.2 按钮

```html
<button class="btn btn-success btn-lg">成功</button>
<button class="btn btn-danger btn-xs">警告</button>
```

## 5 组件

### 5.1 下拉菜单

有手就行

### 5.2 字体图标

```html
<i class="glyphicon glyphicon-asterisk"></i>
```

## 6 插件

- 引入```jQuery```与```bootstrap```

  ```html
  <script src="./jq/jQuery.js"></script>
  <script src="./bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
  ```

# 三、AlloyTeam项目



























