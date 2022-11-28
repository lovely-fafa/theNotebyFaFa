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





# 三、渐变











