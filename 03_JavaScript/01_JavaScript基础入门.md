https://developer.mozilla.org/zh-CN/docs/Web/JavaScript

# day 03

## 一、运算符

### 1 运算符

所谓的```+```、```-```、```*```、```/```、取余的```%```、取模的```//```。

浮点数还是会有精度问题的

```javascript
console.log(0.1 + 0.2) // 0.30000000000000004
```

### 2 递增递减运算符

#### 2.1 前置递增/递减运算符

- ```++变量```：递增运算符
- ```--变量```：递减运算符

```javascript
var age = 10;
console.log(++age + 10)  // 21
++age;
console.log(age)  // 11
```

#### 2.2 后置递增/递减运算符

