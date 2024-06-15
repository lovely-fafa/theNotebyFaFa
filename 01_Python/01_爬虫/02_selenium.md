# 1 webdriver 下载地址

http://npm.taobao.org/mirrors/chromedriver/

# 2 代码

## 2.1 js滑动加载

```python
def down(count: Union[int, None] = None):
    """
    下滑加载
    :param count: 下滑次数 None 则为无限下滑
    :return:
    """
    count = count if count else 2
    js = "return document.documentElement.scrollHeight;"
    height = 0

    down_count = 0
    while down_count < count:
        if count:
            down_count += 1
        new_height = driver.execute_script(js)
        # 每执行一次滚动条拖到最后，就进行一次参数校验，并且刷新页面高度
        if new_height > height:
            driver.execute_script('window.scrollTo(0, document.body.scrollHeight)')
            height = new_height
            sleep(1)
        else:
            # 当页面高度不再增加的时候，我们就认为已经是页面最底部，结束条件判断
            # print("滚动条已经处于页面最下方!")
            driver.execute_script('window.scrollTo(0, 0)')  # 把滚动条拖到页面顶部
            break
```

## 2.2 多标签 / 多窗口之间的切换

在页面操作过程中有时候点击某个链接会弹出新的窗口，这时就需要切换到新打开的窗口上进行操作。这种情况下，需要识别多标签或窗口的情况。

- `switch_to.window()`方法：切换窗口。可以实现在不同的窗口之间切换。
- `current_window_handle`： 获得当前窗口句柄。
- `window_handles`： 获取所有窗口句柄。

句柄就可以理解成浏览器窗口的id值。

- 获取所有窗口的句柄

  `handles = driver.window_handlers`

  调用该方法会得到一个列表，在selenium运行过程中的每一个窗口，都有一个对应的值存放在里面。（换句话说，有多少个窗口，就有多少个句柄）

- 通过窗口的句柄进入的窗口

  `driver.switch_to_window(handles[n])`或`driver.switch_to.window(handles[n])`

## 2.3 窗口最大化

```python
driver.maximize_window()
```

