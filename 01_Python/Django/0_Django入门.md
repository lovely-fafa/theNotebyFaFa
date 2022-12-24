# 静态文件配置







# URL 控制器

## 正则匹配



## 有名分组



## 路由分发



## 反向解析

### 模板

> 登录验证示例

```python
def login(request):
    
    # 用 GET 请求获得登录的 html 页面
    if request.method == 'GET':
        return render(request, login.html)  # 会去渲染这个 html 里面的东西
    
    # 客户端 POST 请求提交登录的数据
	else:
        user = request.POST.get('user')
        pwd = request.POST.get('pwd')
        
        if user == 'fafa' and pwd == '123':
            return HttpResponse('登陆成功')
        else:
            return HttpResponse('登陆失败')
```

```python
url_patterns = [
    path('login/', view.login, name='log')  # 取个别名
]
```

```html
// <form action='http://127.0.0.1:8080/login', method='post'>  // 这个地方的 action 写死了，应该这样
<form action="{% url 'log' %}", method='post'>  // 应该这样
    用户名<input, type='text', name='user'>
</form>
```

### 用 python 脚本

> 只要给了**别名**，就可以解析出这个别名所指向的 url。与在哪个视图函数**无关**。

```python
from django.urls import reverse

def xxx(request):
    
    # 反向解析
    url = reverse('别名')
    
    # 如果这个 url 用了正则
    url = reverse('别名', args=(4000, ))
```

## 命名空间

如果两个 app 里面的两个路由有相同的别名，就会发生覆盖，应该这样：

```python
reverse('app01:index')  # /app01/index/
reverse('app02:index')  # /app02/index/
```

## 转换器

### 内置的转换器

举个例子

```python
url_pattern = [
    path_re('article/(?P<year>\d{4})/', view.xxx)  # 这个地方提取到的 year 是字符串，所以可以这个样子
]

def xxx(request, year):
    type(year)  # str
```

```Python
url_pattern = [
    path('article/<int:year>/', view.xxx)  # 这个地方提取到的 year 是字符串，所以可以这个样子
]

def xxx(request, year):
    type(year)  # <class 'int'>
```

其他的转换器：

- str：匹配字符串
- int：匹配正整数
- slug：匹配字母、数字、横杠、下划线
- uuid：匹配格式化的uuid
- path：匹配任何非空字符串，包含路径分隔符

### 自定义转换器

显而易见，自带的是不够的。所可以新建一个 py 文件，专门存储

```python
# url_convert.py

class MonConvert:
    
    regex = '[0-9]{2}'
    
    def to_python(self, value):
        return int(value)
	
    # 用于反向解析
    def to_url(self, value):
        return '%04d' % value
```

使用的地方

```python
from xxx.url_convert import MonConvert

# 1. 注册定义的转换器
register_converter(MonConvert, 'mm')  # 别名

# 2. 使用
url_patterns = [
    path('article/<mm:month>/', view.xxx)
]
```

# 视图函数

## 请求对象

- 请求方法

    ```python
    def index(request):

        print(request.method) # GET POST
        rethrn HttpResponse('ok')
    ```

- 请求数据

    ```python
    request.GET.get('key')  # values
    request.POST.get('key')  # values
    ```

- full_path()
- is_ajax()

## 响应对象

- HttpResponse

  返回字符串

  ```python
  def index(request):
      
      rethrn HttpResponse('ok')
      rethrn HttpResponse('<h1>hello World</h1>')
  ```

- render

  ```python
  def index(request):
      
      ctime = time.time()
      rethrn render(request, 'file.html', {'html里面的值':ctime})  # 需要把变量放入页面，使用第三个参数
      
      # 也可以
      rethrn render(request, 'file.html', local())  # 这个时候，需要 html 里面的变量名和 py 里面的变量名一样
  ```
  



## 响应对象之模板语法

- 渲染变量

  ```
  {{  }}
  ```

  - 深度查询

  > 如果需要渲染列表，字典，对象等，可以直接在 html 里面用 句点符

  ```html
  <h4>{{age.1}}</h4>
  <h4>{{person_list.1.age}}</h4>  // person_list 里面的第二个元素，是对象，.age取到该对象的属性
  ```

	- 过滤器

	> 管道符 过滤器名字
	
	```html
	<h4>{{datetime.datetime.now()|date:"Y-m-d"}}</h4>
	<h4>{{person_list|default:"提示语：数据为空"}}</h4>
	<h4>{{file_size|filesizeformat}}</h4>
	<h4>{{text|truncatechars:9}}</h4>  // 数据截断
	
	<h4>{{link|safe}}</h4>
	<h4>{{}}</h4>
	```

- 渲染标签

  {% tag %}
  
  - for 标签
  
    ```html
    // 遍历输出 列表、字典
    {% for i in l %}
    <p>
        {{ i }}
    </p>
    {% endfor %}
    ```
  
    ```html
    // 循环序号
    {% for i in l %}
    <p>
        {{ forloop.counter0}} {{ i }}
    </p>
    {% endfor %}
    ```
  
    ```html
    // 提醒
    {% for i in None_list %}
    <p>
        {{ forloop.counter0}} {{ i }}
    </p>
    
    {% empty %}
    <p>循环一次都不运行，发出提示语：列表为空</p>
    
    {% endfor %}
    ```
  
  - if 标签
  
    ```html
    {% if user %}
    <p>
        <a herf=''>hi {{user}}</a>
        <a herf=''>注销</a>
    </p>
    
    {% else %}
    <p>
        <a herf=''>登录</a>
        <a herf=''>注册</a>
    </p>
    {% end if %}
    ```
  
  - with标签
  
    ```html
    {% wuth person.name as n %}
    <p>{{n}}</p>
    {% endwith %}
    ```
  
  - csrf_token标签
  
    ```html
    <form action='', method='post'>
        {% csrf_token %}
        <input typr='text' name='user'>
        <input type='submit'>
    </form>
    ```
  
    

- 自定义标签与过滤器

  1. 注册 app

  2. 创建 templatetags 模块

  3. 随意创建 py 文件

     ```Python
     from django import templat
     
     register = templat.library()
     
     # 自定义过滤器
     @register.filter
     def multi_fliter(x, y):  # 过滤器最多两个参数
         
         return x * y
     
     # 自定义标签
     @register.simply_tag
     def multi_fliter(x, y):  # 标签可以多个参数
         
         return x * y
     ```

  4. 在 html 里面

     ```html
     {% load my_tag_filter %}
     <p>{{ i multi_fliter:20}}</p>  // 过滤器最多两个参数
     
     <p>{% simply_tag 7 9 %}</p>  // 标签可以多个参数
     ```

     - 举个例子

       ```html
       {% if i|multi_fliter:10 > 100%}
       <p>大于100</p>
       {% else %}
       <p>没有大于100</p>
       {% end if %}
       ```

       

- 继承

  ```html
  {% include 'htmlfile.html' %}
  ```

  ```
  extend...
  ```

# 数据库

```python
py manage.py makemigrations [appName]
py manage.py migrate
```





# ORM

## 单表增

- 方式一

  ```python
  book_obj = Book(id=1, name='php')
  book_obj.save()  # 一定要保存
  ```

- 方式二

  ```python
  book_obj = Book.objects.creat(id=2, name='oho')  # 自动保存
  
  book_obj.id  # 2
  book_obj.name  # 'oho'
  ```

- 批量插入

  ```python
  book_list = []
  for i in range(100):
      book = Book(name='book_%s' % i, pwd=i * i)
      book_list.append(book)
  Book.objects.bulk_create(book_list)
  ```

## 单表查

- 所有数据

  ```python
  res = Book.objects.all()
  ```

  返回值是 QuerySet 数据对象。QuerySet 数据对象类似于 列表，可以 索引 切片

  如果在定义表里面加上

  ```python
  class Book(models.model):
  	
      pass
      
      def __init__self(self):
          return self.title
  
  # 返回的 res 是
  <QuerySet [<Boos: title1>, <Boos: title2>]>
  ```

  遍历结果

  ```python
  for i in Book.objects.all():
      
      print(i.title)
      print(i.id)
  ```

- 开头结尾

  ```python
  Book.objects.all().first()
  Book.objects.all().last()
  ```

  调用者是 QuerySet 对象，返回值是 QuerySet 对象里面的 modle 对象

- filter 过滤

  ```python
  Book.objects.filter(price=100)
  
  # 因此可以在 QuerySet 对象的基础上，使用 first() 方法
  Book.objects.filter(price=100).first()
  
  # 多个条件
  Book.objects.filter(price=100, title='php')
  ```

  返回值是 QuerySet 对象

- get

  ```python
  Book.objects.get(price=100)
  ```

  有且只有一个时，才能用 get()  方法，其他情况都 报错

  返回值是 一个 model 对象

- exclude 排除

  ```python
  # 价格不是 100 的
  Book.objects.filter(price=100)
  ```

  返回值是 QuerySet 对象

- order_by

  ```python
  # 默认是升序
  Book.objects.all().order_by('id')
  
  # 降序
  Book.objects.all().order_by('-id')
  
  # 多条件排序
  Book.objects.all().order_by('price', 'id')
  ```

  调用者是 QuerySet 对象，返回值是 QuerySet 对象

- reverse 逆序

  ```python
  Book.objects.all().reverse()
  ```

- count

  ```python
  Book.objects.count()
  ```

  返回值是 int 对象

- exist

  ```python
  # 判断 QuerySet 对象里面是否存在
  Book.objects.all().exist()
  ```

- values

  ```python
  # 拿所有的名称 但是不建议
  for i in Book.objects.all():
      print(i.price)
      
  # 也可以这样
  res = Book.objects.all().values('price')
  res = Book.objects.all().values('price', 'title')
  ```
  
  返回值是 QuerySet，调用者是 QuerySet
  
  ```python
  <QuerySet [{'price': Decimal('100.00')}, {'price': Decimal('110.00')}]>
  <QuerySet [{'price': Decimal('100.00'), 'title': 'xxx'}, {'price': Decimal('110.00'), 'title': 'xxx'}]>
  
  # 取值
  res[0].get('price')  # 100.00
  ```
  
- values_list

  ```python
  res = Book.objects.all().values('price')
  res = Book.objects.all().values('price', 'title')
  ```

  返回值是 QuerySet

  ```python
  <QuerySet [(Decimal('100.00')), (Decimal('110.00'))]>
  <QuerySet [(Decimal('100.00'), 'xxx'), (Decimal('110.00'), 'xxx')]>
  ```

- distinct 去重

  ```python
  res = Book.object.all().values('price').distinct()
  ```

## 单表模糊查询

- 大小于

  ```python
  # 大于 10 小于 200
  Book.object.filter(price__gt=10, price__lt=200)
  ```

- 开头

  ```python
  Book.object.filter(price__startswitch=10)
  ```

- 包含

  ```python
  Book.object.filter(price__contains='h')
  Book.object.filter(price__icontains='h')  # 忽略大小写
  ```

- 在里面

  ```python
  Book.object.filter(price__in=[100, 200])
  ```

- 日期

  ```python
  # 2018 年的 6 月份的
  Book.object.filter(date__year=2018, date__month=6)
  ```

## 删除与修改

- delete

  QuerySet 调用

  ```python
  ret = Book.objects.filter(pricr=100).delet()
  
  # ret (删的个数, {表名})  ？？？
  ```

  mode 调用

  ```python
  ret = Book.objects.filter(pricr=100).first().delet()
  ```

- update

  ```python
  # 查到多个，就改多个
  Book.objects.filter(pricr=100).update(price=150)
  ```

  只能 QuerySet 调用

# 多表

> 多表的目的是为了减少不必要的数据存储，节约存储空间

## 一对多

> 一对多的关联字段放在**多对**应的表中







## 多对多

> 专门创建一个**对应的关系表**
>
> 除了有自己的主键id外，还需要其他两个字段
>
> |  id  | book_id | author_id |
> | :--: | :-----: | :-------: |
> |  1   |    2    |     5     |
>
> 意思是，id为2的book，的作者是id为5





## 一对一

> 本质上是一个表拆开了...
>
> 两张表里面任意一个加一个**关联字段**，但是加一个 unique 约束











# Ajax

## 发起请求的方式

- 浏览器地址栏：默认 get 请求
- form 表单
  - get 请求
  - Post 请求
- a 标签：默认 get 请求
- Ajax
  - 特点一：异步请求
  - 特点二：局部刷新

## 简介



## 案例

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.3.min.js"></script>
</head>
<body>
    <h2>this is Index</h2>
    <button class="ajax">Ajax</button>
    <p class="content"></p>
    <hr>
    <input type="text" id="num1"> + <input type="text" id="num2"> = <input type="text" id="res"> <button class="cal">计算</button><span type="error"></span>
    <hr>
    <form action="">
        用户名 <input type="text" id="user">
        密码 <input type="text" id="pwd">
        <input type="button" value="submit" class="login">
    </form>

    <script>
        // 发送 Ajax 请求
        $('.ajax').click(
            function(){
                $.ajax({
                    url: "/test_ajax/",  // 请求 url
                    type: "GET",  // 请求方式
                    // 发送数据
                    data: {
                        a: 1,
                        b: 2
                    },
                    success: function(res){
                        console.log(res)
                        $(".content").html(res)
                    }
                })
            }
        )
        
        // 小案例
        $('.cal').click(function(){
            $.ajax({
            url: "/cal/",
            type: "post",
            data: {
                "num1": $("#num1").val(),
                "num2": $("#num2").val(),
            },
            success: function(res){
                console.log(res)

                $("#res").val(res)
            }
        })
        })

        // 登录验证
        $(".login").click(function(){
            $.ajax({
                url: '/login/',
                type: 'post',
                data: {
                    'user': $('#user').val(),
                    'pwd': $('#pwd').val()
                },
                success: function(){
                    console.log(res)
                    console.log(typeof res)  // 字符串

                    // 数据转换
                    console.log(JSON.parse(res))
                    console.log(typeof JSON.parse(res))  // object
                    res = JSON.parse(res)

                    if (res.user) {
                        location.href='http://www.baidu.com'
                    }
                    else {
                        $(".error").html(res.msg).css({'color': 'red', 'margin-left':'10px'})
                    }
                }
            })
        })
    </script>
</body>
</html>
```

## 文件上传









# 分页器

## 简单的效果

```python
from django.http import HttpResponse
from django.shortcuts import render
from django.core.paginator import Paginator, EmptyPage

from .models import Book

# Create your views here.


def index(request):
    # 批量插入
    book_list = []
    for i in range(100):
        book = Book(name='book_%s' % i, pwd=i * i)
        book_list.append(book)
    Book.objects.bulk_create(book_list)

    return HttpResponse('123')


def books(request):
    all_book_list = Book.objects.all()

    # 分页器
    paginator = Paginator(all_book_list, 3)

    print('count:', paginator.count)  # 数据总数
    print('num_pages:', paginator.num_pages)  # 总页数
    print('page_range:', paginator.page_range)  # 页码的列表

    # 某一页具体数据
    page1 = paginator.page(1)
    print(page1.object_list)
    # 亦可
    for i in paginator.page(1):
        print(i)

    current_page = int(request.GET.get('page', 1))  # 为了前端判断是否为当前页码

    # 为了左右不显示小于 0 或者大于 max 的
    if paginator.num_pages > 11:
        if current_page - 5 < 1:
            page_range = range(1, 11)
        elif current_page + 5 > paginator.num_pages:
            page_range = range(paginator.num_pages - 5, paginator.num_pages + 1)
        else:
            page_range = range(current_page-5, current_page + 5)

    else:
        page_range = paginator.page_range

    # 避免页数错误
    try:
        one_page_list = paginator.page(current_page)

    except EmptyPage as e:
        one_page_list = paginator.page(1)

    return render(request, 'book.html', locals())
```

## 页码标签

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>

<!-- 单纯显示分页器的数据 -->
<ul>
    {% for book in one_page_list %}
    <li>{{book.name}}:{{book.pwd}}</li>
    {% endfor %}
</ul>

<!-- 页码标签 -->
<nav aria-label="Page navigation">
  <ul class="pagination">
    
    <!-- 判断当前页面是否有前一页 -->
    {% if one_page_list.has_previous %}
      <!-- 当前页面有前一页则 上一页 标签有 href -->
      <li><a href="?page={{ one_page_list.previous_page_number }}" aria-label="Previous"><span aria-hidden="true">上一页</span></a></li>
    {% else %}
    <!-- 当前页面五前一页则 上一页 标签为 disable -->
      <li class="disabled"><a href="" aria-label="Previous"><span aria-hidden="true">上一页</span></a></li>
    {% endif %}

    {% for page_num in paginator.page_range %}
      <!-- // 选中的显示高亮 -->
      {% if current_page == page_num %} 
        <li class="active"><a href="?page={{ page_num }}">{{ page_num }}</a></li>
      {% else %}
        <li><a href="?page={{ page_num }}">{{ page_num }}</a></li>
      {% endif %}
    {% endfor %}

    {% if  one_page_list.has_next %}
      <li><a href="?page={{ one_page_list.next_page_number }}" aria-label="Next"><span aria-hidden="true">下一页</span></a></li>
    {% else %}
    <li class="disabled"><a href="" aria-label="Next"><span aria-hidden="true">下一页</span></a></li>
    {% endif %}

  </ul>
</nav>

</body>
</html>
```

# form 组件

## 校验字段值

```python
from django.http import HttpResponse
from django.shortcuts import render
from django import forms


# 表单组件 判断表单数据的合法性
class UserForm(forms.Form):
    # 默认有非空校验
    name = forms.CharField(min_length=4)
    pwd = forms.CharField(min_length=4)
    r_pwd = forms.CharField(min_length=4)
    email = forms.EmailField()
    tel = forms.CharField()


def reg(request):

    if request.method == 'POST':
        # UserForm 有的，下面这个必须要有，但是下面有的，UserForm 不一定要有哦
        # form = UserForm({
        #     'name': 'fa',
        #     # 'names': 'fafa',  # 键错了会找不到，就是 False
        #     'email': '123@qq.com'
        # })

        form = UserForm(request.POST)  # 虽然 request.POST 有一个 css_token 但是不会校验，也不会放到校验后的字典里面
        print(form.is_valid())  # 有一个错就是 False

        if form.is_valid():
            # 有所的字段校验成功，form 有一个属性 clean_data 全是正确的值
            print(form.cleaned_data)
        else:
            print(form.cleaned_data)  # 正确的
            print(form.errors)  # 错误的值  本质上是这个亚子 {key: errorReason}
            print(form.errors.get('name'))  # <ul class="errorlist"><li>This field is required.</li></ul>
            print(form.errors.get('name')[0])  # This field is required.

        return HttpResponse('OK')

    return render(request, 'reg.html')
```

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="" method="post">
        <p>用户名 <input type="text" name="name"></p>
        <p>密码 <input type="text" name="pwd"></p>
        <p>确认密码 <input type="text" name="r_pwd"></p>
        <p>邮箱 <input type="text" name="email"></p>
        <p> 手机号 <input type="text" name="tel"></p>
        <input type="submit">
    </form>
</body>
</html>
```

## 渲染标签

```python
form = UserForm()  # 不传值，实例化一下，为了模板里面自动生成标签
```

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h3>html 语法</h3>
    <form action="" method="post">
        <p>用户名 <input type="text" name="name"></p>
        <p>密码 <input type="text" name="pwd"></p>
        <p>确认密码 <input type="text" name="r_pwd"></p>
        <p>邮箱 <input type="text" name="email"></p>
        <p> 手机号 <input type="text" name="tel"></p>
        <input type="submit">
    </form>

    <h3>Django 的 form 组件的渲染 1</h3>
    <form action="" method="post">
        <p>用户名 {{ form.name }}</p>
        <p>密码  {{ form.pwd }}</p>
        <p>确认密码  {{ form.r_pwd }}</p>
        <p>邮箱  {{ form.email }}</p>
        <p> 手机号  {{ form.tel }}</p>
        <input type="submit">
    </form>

    <h3>Django 的 form 组件的渲染 2</h3>
    <form action="" method="post">
        {% for field in form %}
            <p>
                <label for="">{{ field.label }}</label>
                {{ field }}
            </p>

        {% endfor %}
        <input type="submit">
    </form>

    <h3>Django 的 form 组件的渲染 3  不建议</h3>
    因为已经定死了...
    <form action="" method="post">
        {{ form.as_p }}
        <input type="submit">
    </form>
</body>
</html>
```

## 完整

views.py

```python
from django.http import HttpResponse
from django.shortcuts import render

from .myForms import *


def reg(request):

    if request.method == 'POST':
        # UserForm 有的，下面这个必须要有，但是下面有的，UserForm 不一定要有哦
        # form = UserForm({
        #     'name': 'fa',
        #     # 'names': 'fafa',  # 键错了会找不到，就是 False
        #     'email': '123@qq.com'
        # })

        form = UserForm(request.POST)  # 虽然 request.POST 有一个 css_token 但是不会校验，也不会放到校验后的字典里面
        # print(form.is_valid())  # 有一个错就是 False

        if form.is_valid():
            # 有所的字段校验成功，form 有一个属性 clean_data 全是正确的值
            print(form.cleaned_data)
            return HttpResponse('OK')

        else:
            # print(form.cleaned_data)  # 正确的
            # print(form.errors)  # 错误的值  本质上是这个亚子 {key: errorReason}
            # print(form.errors.get('name'))  # <ul class="errorlist"><li>This field is required.</li></ul>
            # print(form.errors.get('name')[0])  # This field is required.

            # 全局钩子错误
            print('error:', form.errors.get('__all__'))
            errors_global = form.errors.get('__all__')

            return render(request, 'reg.html', locals())

    form = UserForm()  # 不传值，实例化一下，为了模板里面自动生成标签

    return render(request, 'reg.html', locals())
```

myForms.py

```python
#!/usr/bin/python 3.10
# -*- coding: utf-8 -*- 
#
# @Time    : 2022-09-30 19:38
# @Author  : 发发
# @QQ      : 1315337973
# @File    : forms.py
# @Software: PyCharm
from django import forms
from django.forms import widgets
from django.core.exceptions import ValidationError, NON_FIELD_ERRORS

from .models import UserInfo


# 表单组件 判断表单数据的合法性
error_messages = {'required': '该字段不能为空'}


class UserForm(forms.Form):
    # 默认有非空校验
    name = forms.CharField(min_length=4,
                           label='用户名',
                           error_messages={'required': '该字段不能为空'},  # 必须是 required
                           # 直接加参数进去，就会在渲染的 html 里面出现
                           widget=widgets.TextInput(attrs={'class': 'form-control'}))
    pwd = forms.CharField(min_length=4,
                          label='密码',
                          # 直接加参数进去，就会在渲染的 html 里面出现
                          widget=widgets.PasswordInput(attrs={'class': 'form-control'}),
                          error_messages=error_messages)
    r_pwd = forms.CharField(min_length=4,
                            label='确认密码',
                            widget=widgets.PasswordInput,
                            error_messages=error_messages)
    email = forms.EmailField(label='电子邮箱',
                             error_messages=error_messages)
    tel = forms.CharField(label='电话')

    # 检验用户名是否重复
    def clean_name(self):

        val = self.cleaned_data.get('name')
        ret = UserInfo.objects.filter(name=val)
        # ret = True

        if not ret:
            return ret
        else:
            raise ValidationError('该用户已注册')

    def clean_tel(self):

        val = self.cleaned_data.get('tel')
        if len(val) == 11:
            return val
        else:
            raise ValidationError('手机号格式错误')

    def clean(self):
        # 全局钩子
        pwd = self.cleaned_data.get('pwd')
        r_pwd = self.cleaned_data.get('r_pwd')

        if pwd and r_pwd:
            # 判断密码是否一致的前提是是否有值
            if pwd == r_pwd:
                return self.cleaned_data
            else:
                raise ValidationError('两次密码不一样')

        else:
            return self.cleaned_data
```

reg.html

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
    <h3>html 语法</h3>
    <form action="" method="post">
        <p>用户名 <input type="text" name="name"></p>
        <p>密码 <input type="text" name="pwd"></p>
        <p>确认密码 <input type="text" name="r_pwd"></p>
        <p>邮箱 <input type="text" name="email"></p>
        <p> 手机号 <input type="text" name="tel"></p>
        <input type="submit">
    </form>

    <h3>Django 的 form 组件的渲染 1</h3>
    <form action="" method="post">
        <!-- span 标签显示错误信息 -->
        <p>用户名 {{ form.name }}<span>{{ form.name.errors.0 }}</span></p>
        <p>密码  {{ form.pwd }}<span>{{ form.pwd.errors.0 }}</span></p>
        <p>确认密码  {{ form.r_pwd }}<span>{{ errors_global.0 }}</span></p>
        <p>邮箱  {{ form.email }}<span>{{ form.email.errors.0 }}</span></p>
        <p> 手机号  {{ form.tel }}<span>{{ form.tel.errors.0 }}</span></p>
        <input type="submit">
    </form>

    <h3>Django 的 form 组件的渲染 2</h3>
    <form action="" method="post">
        {% for field in form %}
            <p>
                <label for="">{{ field.label }}</label>
                {{ field }}
            </p>

        {% endfor %}
        <input type="submit">
    </form>

    <h3>Django 的 form 组件的渲染 3  不建议</h3>
    因为已经定死了...
    <form action="" method="post">
        {{ form.as_p }}
        <input type="submit">
    </form>
</body>
</html>
```







# cookie

cookie：具体一个浏览器针对服务器储存的 key-values 数据。



# Auth 模块

## 比对用户名和密码是否正确

```python
user_obj = auth.authenticate(request, username=username, password=password)
user_obj.username
user_obj.password
```

## 保存用户状态

```python
# 只要执行了这个，任何地方用 request.user 都可以得到用户对象 即自动去 session 表里面查用户数据 并封装到 user 里面
auth.login(request, user_obj)
```

## 用户是否登录

```python
print(request.user.is_authenticated)
```

## 获取当前登录用户

```python
request.user
```

## 校验用户是否登录的装饰器

```python
from django.contrib.auth.decorators import login_required

# 局部配置
@login_required(login_url='/login/')  # 用户未登录则跳转到 login_url 指定的网址

# 用户未登录跳转的全局配置
LOGIN_URL = '/login'
```

## 比对密码

```python
is_right = request.user.check_password(old_password)
```

## 修改密码

```python
request.user.set_password(new_password)  # 修改对象的属性
request.user.save()  # 修改数据库
```

## 注销

```python
auth.logout(request)
```

## 注册

```python
# 操作数据表 写入数据
User.objects.create_user(username=username, password=password)  # 不能用 create 否则不会加密
# 创建超级用户邮箱必填 但不应该在这个地方创建超级用户 应当在命令行创建才安全
# User.objects.create_superuser(username=username, password=password, email='123@163.com')
```

## 扩展 auth_user 表

```py
from django.db import models
from django.contrib.auth.models import User, AbstractUser


# 第一种：一对一关系 不推荐
class UserDetail(models.Model):
    phone = models.BigIntegerField()
    user = models.OneToOneField(to='User')


# 第二种：面向对象的继承
class UserInfo(AbstractUser):
    """
    如果继承了 AbstractUser
    那么在执行数据库迁移命令时 auth_user 就不会出现
    而 UserInfo 会出现 auth_user 的字段 + 补充的字段

    前提：
        1.继承之前没有执行过 数据库迁移命令 即 auth_user 未创建
        2.继承的类里面不要覆盖 AbstractUser 的字段名 只扩展
        3.需要在 配置文件 中告诉 Django 用 UserInfo 替代 auth_user
            AUTH_USER_MODEL = 'app01.UserInfo' 应用名.表名
    """
    phone = models.BigIntegerField()
    created_date = models.DateTimeField(auto_now_add=True)
    """
    如果替代了 auth_user
    但 auth 模块还是能正常使用 只是 Django 操作的表变了
    """
```







# 项目开发流程

## 1.需求分析

架构师 + 产品经理 + 开发者组长

## 2.项目设计

- 架构师
  - 编程语言选择
  - 框架选择
  - 数据库选择
    - 主库
    - 缓存数据库
  - 功能划分
    - 整个项目拆分几个功能模块
  - 找组长开会
    - 分发任务
  - 项目报价 （一个程序猿一天 1500-2000）
    - 时间 人力

## 3.分组开发

组长找组员开会发任务

## 4.测试

## 5.交付上线



# BBS

## 表设计

- 用户表
  - 继承 AbstractUser
  - phone 电话
  - avatar 用户头像
  - create_time 创建时间
  - 外键：一对一个人站点

- 个人站点表

  - site_name 站点名称
  - site_title 站点标题
  - site_theme 站点样式

- 文章分类表

  - name 分类名

- 文章标签表

  - name 标签名

- 文章表

  - title 文章标题

  - desc 文章简介

  - content 文章内容

  - create_time 发布时间

  - up_name 点赞数

  - down_num 点踩数

  - comment_num 评论数

    虽然可以跨表查询，但是会速度较慢，所以数据库优化，注意需要保持和点赞点踩表同步增减

  - 外键

    - 一对多个人站点表
    - 多对多文章标签表
    - 一对多文章分类表
    - 

- 点赞点踩表

  - user 用户
  - article 文章
  - is_up 是否点赞
  - is_down 是否点踩

- 文章评论表

  > 根评论
  >
  > 子评论
  >
  > 根评论与子评论一对多，所以可添加```parent```字段，实现**自关联**，注意需要```null=True```

  - user
  - article
  - content
  - create_time
  - parent FroeignKey

## 表创建及同步



# admin 后台管理

需要去 应用下面的 admin.py 注册模型表

```
admin.site.register(models.UserInfo)
```

admin 会给每一个注册了的模型表生成 增删改查 的 url





# 用户头像展示

一般来说，网站所用的静态文件在 static 文件夹下，用户上传的文件也应该在 static 文件夹下

## media 配置

```python
# setting.py
# 用户上传的文件
MEDIA_ROOT = os.path.join(BASE_DIR, 'media')
```

会自动创建多级目录

## 开启后端文件夹

在 view.py 暴露后端接口

```python
from django.views.static import serve
re_path(r'^media/(?P<path>.*)', serve, {'document_root': settings.MEDIA_ROOT})
```



