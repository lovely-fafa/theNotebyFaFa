指定编码

```sql
CREATE DATABASE reggie CHARACTER SET utf8mb4;
```

通过sql文件执行sql代码，不能有中文路径

```sql
source fileRoad;
```





# 锁

## 行级锁

介绍

行级锁，每次操作锁住对应的行数据。锁定粒度最小，发生锁冲突的概率最低，并发度最高。应用在lnnoDB存储引擎中。

InnoDB 的数据是基于索引组织的，行锁是通过对索引上的索引项加锁来实现的，而不是对记录加的锁。对于行级锁，主要分为以下三类:



























