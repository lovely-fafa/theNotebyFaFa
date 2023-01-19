  来源：

【黑马程序员Git全套教程，完整的git项目管理工具教程，一套精通git】 https://www.bilibili.com/video/BV1MU4y1Y7h5

【十分钟学会正确的github工作流，和开源作者们使用同一套流程】 https://www.bilibili.com/video/BV19e4y1q7JJ

# 1 基本配置

## 1.1 设置用户信息

```git
git config --global user.username "fafa"
git config --global user.email "fafa@163.com"
```

## 1.2 查看用户信息

```git
git config --global user.username
git config --global user.email
```

## 1.3 设置别名（可选）

- 用户目录下新建文件```.bashrc```或在```gitBash```使用```Linux```命令```touch ~/.bashrc```

- 输入

  ```
  # 用于输出git提交日志
  alias git-log='git log --pretty=oneline --abbrev-commit --all --graph'
  # 用于输出当前目录所有文件及基本信息
  alias ll='ls -al'
  ```

- ```gitBash```输入```source ~/.bashrc```

## 1.4 解决gitBash乱码问题

- 打开GitBsah执行

  ```git config --global core.quotepath false```

- ```${git_home}/ect/bash.bashrc```文件最后加入

  ```
  export LANG='zh_CN, UTF-8'
  export LC_ALL='zh_CN, UTF-8'
  
  # vim /etc/profile.d/locale.sh
  export LC_CTYPE=zh_CN.UTF-8
  export LC_ALL=zh_CN.UTF-8
  
  # vim /etc/locale.conf
  LANG=zh_CN.UTF-8
  
  # vim /etc/sysconfig/i18n
  LANG=zh_CN.UTF-8
  
  # vim /etc/environment
  LANG=zh_CN.UTF-8
  LC_ALL=zh_CN.UTF-8
  ```
  

# 2 基础指令

## 2.1 创建本地仓库

- 鼠标右键新建文件夹或```Ctrl+N```或```gitBash```新建文件夹
- ```gitBash```中输入指令```git init```

## 2.2 文件的过程

- 创建并修改某文件

- 文件进入暂存区

  工作区 ——》暂存区

- 文件从储存区进入本地仓库

  暂存区——》本地仓库
  

![image-20221104180813052](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221104180813052.png)

![image-20221107200238185](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221107200238185.png)

## 2.3 实操

- 初始化

  ![image-20221103203725795](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221103203725795.png)

- 创建文件（可以不用命令行）

  ![image-20221103203809166](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221103203809166.png)

- 查看一下状态

  ![image-20221103203906001](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221103203906001.png)

- 添加到暂存区

  介个地方的```.```是通配符

  ![image-20221103204003318](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221103204003318.png)

- 提交到本地仓库

  ```
  git commit -m "介个地方写上你对这次提交的备注，比如说..."
  ```

  ![image-20221103204240747](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221103204240747.png)
  
  再来看看状态，嘿嘿，干净了
  
  ![image-20221103204422515](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221103204422515.png)

- 来看看提交记录

  ![image-20221103204547383](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221103204547383.png)

- 来编辑编辑这个文件

  嚯嚯嚯，编辑了

- 看看状态

  ![image-20221103204757741](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221103204757741.png)

- 那就提交暂存区、看看状态、提交仓库、看看状态和日志

  ![image-20221103205059906](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221103205059906.png)

## 2.4 ```git log```更多参数

- 总述：

  - ```--all```显示所有分支
  - ```--pretty=oneline```将提交信息显示为一行
  - ```--abbrev-commit```使得输出的```commitId```更简短
  - ```--graph```以图的形式显示

- 只看一行```log```：```git log --pretty=oneline```

  ![image-20221104104019083](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221104104019083.png)

- 优化```commit```：```git log --pretty=oneline --abbrev-commit```

  ![image-20221104104200290](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221104104200290.png)

- 显示更清晰：```git log --pretty=oneline --abbrev-commit --all --graph```

  ![image-20221104104450593](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221104104450593.png)

## 2.5 版本切换

```git reset --hard commitID```

![image-20221104105804494](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221104105804494.png)

得到所有的```commitId```：```git-reflog```

![image-20221104105916462](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221104105916462.png)

## 2.6 不让git管理

- 创建不想背管理的文件

  ```torch file02.a```或手动新建

- 创建文件

  ```torch .gitignore```或手动新建

- 把不需要git管理的东西输入进去

  ```*.a```

- 这个时候就可以发现git忽略了```file02.a```

  ![image-20221104110702066](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221104110702066.png)

## 暂存区

- 查看暂存区还是本地仓库啊？

  ```git ls-files```

- 删除的是暂存区还是本地仓库的？

  ```git rm --cached <file>```

  

# 3 分支

## 3.1 基础指令

- 查看分支

  ```git branch```

- 创建分支

  ```git branch 分支名```

  ![image-20221104113838937](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221104113838937.png)

- 切换分支

  ```git checkout dev01```

- （创建）切换分支

  ```git checkout -b 分支名```

## 3.2 合并分支

- 把```dev01```合并到```master```

  ![image-20221104174105574](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221104174105574.png)

  ![image-20221104174255214](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221104174255214.png)

## 3.3 删除分支

- 删除分支：```git branch -d 分支名```
- 强制删除：```git branch -D 分支名```

## 3.4 冲突

- 发生冲突时，文件里面

  ```
  <<<<<<< HEAD
  master
  =======
  updata count=2
  >>>>>>> dev
  ```

- 删掉需要的，保存文件

- 提交缓存区，提交本地仓库

- 看看

  ![image-20221104175330299](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221104175330299.png)

## 3.5 开发中分支使用原则与流程

- master (生产)分支
  线上分支，主分支，中小规模项目作为线上运行的应用对应的分支;
- develop (开发)分支
  是从master创建的分支，一般作为开发部门的主要开发分支，如果没有其他并行开发不同期上线要求，都可以在此版本进行开发，阶段开发完成后，需要是合并到master分支,准备上线。

- feature/xxxx分支
  从develop创建的分支，一般是同期并行开发，但不同期上线时创建的分支，分支上的研发任务完成后合并到develop分支。

- hotfix/xxxx分支，
  从master派生的分支，一般作为线上bug修复使用，修复完成后需要合并到master、test.develop分支。
- 还有一些其他分支，在此不再详述，例如test分支(用于代码测试)、pre分支(预上线分支)等等。

# 4 Git远程仓库

## 4.0 测试

```ssh -T git@github.com```

```Hi lovely-fafa! You've successfully authenticated, but GitHub does not provide shell access.```

## 4.1 添加远程仓库

- 命令：```git remote add <远端名称> <仓库路径>```
  - 远端名称：默认```origin```，取决于远端服务器设置
  - 仓库路径：远端服务器获取的URL
  - 例如：```git remote add origin xxx@xxx.com```

## 4.2 查看远程仓库

- 命令：```git remote```

## 4.3 推送到远程仓库

- 命令：```git push [-f] [--set-upstream] [远端名称[本地分支名][:远端分支名]]```
  - 如果远端分支名和本地分支名相同，则可以只写本地分支
    - ```git push origin master```
  - ```-f```表示强制覆盖
  - ```--set-upstream```推送到远端的同时并且建立和远端分支的关联关系
    - ```git push --set-upstream origin master```
  - 如果**当前分支已经和远端分支关联**，则可以省略分支名和远端名
    - ```git push```：将```master```分支推送到已关联的远端分支

## 4.4 本地分支和远程分支的对应关系

```git branch -vv```查看关联的情况

![image-20221107103759481](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221107103759481.png)

## 4.5 从远程仓库克隆

> 正常情况下，一个项目只会```clone```一次哦

```git clone ssh [文件夹名]```

![image-20221107104049762](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221107104049762.png)

## 4.6 从远程仓库抓取和拉取

- 抓取命令

  - ```git fetch [remote name][branch name]```
  - 抓取命令就是将仓库里的更新都抓取到本地，不会进行合并
  - 如果不指定远端名称和分支名，则抓取所有分支
  - 然后进行```merge```

- 拉取命令
  - ```git pull [remote name][branch name] ```
  - 拉取命令就是把远端仓库的修改拉到本地并自动进行合并，等同于```fetch+merge```
  - 如果不指定远端名称和分支名，则抓取所有并更新**当前分支**


## 4.7 解决合并冲突

 ![image-20221107191807062](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221107191807062.png)

# 5 在Idea中使用Git

## 5.1 在Idea中配置Git

![image-20221107192207881](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221107192207881.png)

## 5.2 创建远端仓库



## 5.3 初始化本地仓库

![image-20221107193610144](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221107193610144.png)

## 5.4 添加到暂存区

![image-20221107193909139](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221107193909139.png)

## 5.5 推送到远程仓库

![image-20221107194437939](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221107194437939.png)

## 5.6 克隆

![image-20221107194546572](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221107194546572.png)

## 5.7 解决冲突

无论什么时候，都先```pull```后```push```

## 5.8 分支

![image-20221107195312057](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221107195312057.png)

![image-20221107195332884](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221107195332884.png)



## 5.9 总结

![image-20221107195412651](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221107195412651.png)

![image-20221107195528129](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221107195528129.png)

# 6 铁令

- 切换分支前要提交本地的更改
- 代码及时提交，提交过了肯定不会丢失
- 无论怎样，千万不要删除文件目录

# 附：IDEA集成GitBash作为Terminal

> ```python```应该会用终端安库，所以这个东西仁者见仁智者见智啦

![image-20221107195957596](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20221107195957596.png)

# todo:

- ```git rebase main```

- ```square and merge```















