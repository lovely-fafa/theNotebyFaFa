# day 01 面向对象高级编程

## 1 static 关键字

```static```是静态的意思，可以修饰成员变量，也可以修饰成员方法

### 1.1 特点

- 被类的所有对象所共享
- 多了一种调用的方法（之前是实例化后的```对象.```），可以通过类名进行调用。也推荐这种方式。
- 随着类的加载而加载，优先于对象存在

```java
public class Student {
    String name;
    int age;
    static String school;  // 这个地方 static 静态修饰了
}

public static void main(String[] args) {
    System.out.println(Student.school);  // 随着类的加载而加载，优先于对象存在

    Student stu1 = new Student();

    stu1.name = "fafa";
    stu1.age = 22;
    stu1.school = "双流一带专";
    System.out.println(stu1.name + "---" + stu1.age + "---" + stu1.school);

    Student stu2 = new Student();
    stu2.name = "fafafa";
    stu2.age = 24;
    // stu2.school = "双流一带专";  // 可以不需要 因为可以共享
    System.out.println(stu2.name + "---" + stu2.age + "---" + stu2.school);
    System.out.println(Student.school);  // 多了一种调用方法 类名.
}
```

### 1.2 内存图

![image-20230122191328759](assets/image-20230122191328759.png)

### 1.3 修饰成员方法

常用于工具类

```java
package com.itheima.tools;

public class ArrayTools {

    // 私有构造方法 没有必要暴露
    private ArrayTools() {}

    // 加了 static 就可以直接调
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void printArray(int[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length - 1] + "}");
    }
}
```

```java
package com.itheima.tools;

public class Test {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 58};

        // ArrayTools tools = new ArrayTools();  // 私有了构造方法

        // 直接 对象名. 调用
        System.out.println(ArrayTools.getMax(arr));
        System.out.println(ArrayTools.getMin(arr));
        ArrayTools.printArray(arr);

        // 比如说这个就是
        System.exit(0);
    }
}
```

### 1.4 注意事项

- ```static```方法中，只能访问静态成员（直接访问）
- ```static```中不允许使用```this```关键字

### 1.5 重新认识main方法

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("HelloWorld");
    }
}
```

- ```public```：被```JVM```调用，访问权限足够大。
- ```static```：被```JVM```调用，不用创建对象。因为```main```方法是静态的，所以测试类中其他方法也需要是静态的。
- ```void```：被```JVM```调用，不需要给```JVM```返回值。
- ```main```：一个通用的名称，虽然不是关键字，但是被```JVM```识别。
- ```String[] args```：以前用于接收键盘录入数据的，现在没用。

## 2 继承

继承：让**类与类之间产生关系**（子父类关系），**子类**可以**直接使用**父类中**非私有的成员**

### 2.1 格式

- 格式：```public class 子类名 extends 父类名```
- 范例：```public class Zi extends Fu {}```
- ```Fu```：是父类，也被称为基类、超类
- ```Zi```：是子类，也被称为派生类

```java
public class ExtendsDemo1 {
    public static void main(String[] args) {
        Coder c = new Coder();
        c.setAge(2);
        c.setName("fafa");

        System.out.println(c.getName() + "---" + c.getAge());
    }
}

class Employee {
    private String name;
    private int age;

    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

// 继承
class Coder extends Employee {

}
class Manager extends Employee {

}
```

### 2.2 什么时候使用继承

- 当类与类之间，存在相同（共性）的内容，并且产生了 is a 的关系，就可以考虑使用继承，来优化代码。

### 2.3 成员变量

- 子父类，如果出现了重名的成员变量，使用的时候会优先使用？

  - 根据就近原则，必定是使用子类的

  - 但是非要使用父类的，可以用```super```关键字

    ```java
    public class ExtendsDemo2 {
        public static void main(String[] args) {
            Zi z = new Zi();
            z.method();
        }
    }
    
    class Fu {
        int num = 10;
    }
    
    class Zi extends Fu {
        int num = 20;
        public void method() {
            System.out.println(num);  // 20
            System.out.println(super.num);  // 10
        }
    }
    ```

### 2.4 成员方法

- 子父类中，出现了方法声明一模一样的方法（方法名，参数，返回值）。在创建子类对象，调用方法的时候，会优先使用子类的方法。逻辑上这虽然是就近原则的现象，但其实是子类的方法，对父类的方法，进行了重写操作。
  - 区别
    - 方法重载（Overload）：在同一个类中，方法名相同，参数不同，与返回值无关。参数不同: 类型不同，个数不同，顺序不同。
    - 方法重写（Override）： 在子父类当中，出现了方法声明一模一样的方法（方法名，参数，返回值）。
- 注意事项
  - 父类中私有方法不能被重写
  - 子类重写父类方法时，访问权限必须大于等于父类

### 2.5 protected修饰符

用的很少...

![image-20230124165414808](assets/image-20230124165414808.png)

### 2.6 Java继承的特点

- Java只支持**单继承**，不支持**多继承**，但支持**多层继承**

```java
public class ExtendsDemo4 {
    public static void main(String[] args) {
        C c = new C();
        c.methodA();
        c.methodB();
        c.methodC();
    }
}

class A {
    public void methodA() {
        System.out.println("A...");
    }
}

class B extends A{
    public void methodB() {
        System.out.println("B...");
    }
}

class C extends B{
    public void methodC() {
        System.out.println("C...");
    }
}
```

### 2.7 构造方法

- 父类的构造方法 子类无法继承

- 子类在初始化前 需要先完成父类的初始化 因为子类的构造方法中可能会使用父类的数据

  所以，除了```object```类，在所有构造方法中，都默认隐藏一句```super()```。通过这行代码，访问父类的**空参**构造方法。

  细节：Java当中所有的类，都直接或者问接的继承到了```object```类。

```java
public class Test {
    public static void main(String[] args) {
        Zi z1 = new Zi();
        Zi z2 = new Zi(3);
    }
}

class Fu {
    public Fu() {
        System.out.println("Fu类的空参构造");
    }
    public Fu(int num) {
        System.out.println("Fu类的带参构造");
    }
}

class Zi extends Fu {
    public Zi () {
        // super();  // 默认隐藏的
        System.out.println("Zi类的空参构造");
    }
    public Zi (int num) {
        // super();  // 默认隐藏的
        System.out.println("Zi类的带参构造");
    }
}
```

### 2.8 继承中的构造方法内存图

- 子类中会专门开辟一块内存空间，继承父类的成员变量。就算是私有的，也是会继承的，只是说因为权限问题不能直接访问，但是可以通过```get()```进行访问。

![image-20230124194132391](assets/image-20230124194132391.png)

### 2.9 this和supper

- 概念

  - ```this```：代表**本类**对象的引用
  - ```supper```：代表**父类**存储空间的标识

- 调用格式

  |    关键字    |         访问成员变量         |        访问成员方法        |             访问构造方法             |
  | :----------: | :--------------------------: | :------------------------: | :----------------------------------: |
  |  ```this```  |  ```this.本类的成员变量;```  | ```this.本类的成员方法;``` | ```this(); this(...);```本类构造方法 |
  | ```supper``` | ```supper.父类的成员变量;``` | ```this.父类的成员方法;``` | ```this(); this(...);```父类构造方法 |

- ```supper```的省略

  从本质上来说，子类是继承了父类的成员变量和成员方法。所以```supper```的省略，其实是```this```的省略：子类没有重名的成员变量和成员方法，就可以省略。

- ```this()```调用本类构造方法的场景——版本升级

  ```java
  package com.itheima.myExtend;
  
  public class ExtendsDemos {
      public static void main(String[] args) {
          AA a1 = new AA(1, 2, 3);
          AA a2 = new AA(1, 2, 3);
          // 新需求
          AA a3 = new AA(1, 2, 6, 7);
      }
  }
  
  class AA {
      int a;
      int b;
      int c;
      // 需求多了一个 d
      int d;
  
      public AA(int a, int b, int c) {
          this.a = a;
          this.b = b;
          this.c = c;
          // 如果在这个地方给 d 赋值 会改其他使用这个构造方法的代码
          // this.d = d
      }
      
      // 解决办法 方法重载
      public AA(int a, int b, int c, int d) {
          // this.a = a;
          // this.b = b;
          // this.c = c;
          
          // 简写了...
          this(a, b, c);
          this.d = d;
      }   
  }
  ```

- 注意：```this()```和```super()```都在争夺构造方法第一行的位置，所以二者不能共存

## 3 final关键字

### 3.1 使用

- ```final```关键字是最终的意思，可以修饰（方法，类，变量）
- 修饰方法：表明该方法是最终方法，不能被重写
- 修饰类：表明该类是最终类，不能被继承
- 修饰变量：表明该变量是常量，不能再次被赋值

```java
public class FinalDemo {
    public static void main(String[] args) {
        final int num = 10;
        // num = 20;  // 不能修改
        System.out.println(num);

        final int[] arr = {1, 2, 3};
        // arr = new int[3];  // 不能改地址值
        arr[0] = 0;  // 可以改内容
        System.out.println(arr[0]);  // 0
    }
}

final class Fu extends Object {
    public final void method() {
        System.out.println("父类中的重要方法，不希望子类进行修改...");
    }
}

class Student {
    //final int num;  // final 修饰成员变量 不能修饰默认值 但是 可以在构造方法中赋值 则该句不报错
    final int num = 0;
}
```

### 3.2 细节补充

- 变量是基本类型：```final```修饰指的是基本类型的数据，值不能发生改变。
- 变量是引用类型：```final```修饰指的是引用类型，地址值不能发生改变，但是地址里面的内容是可以发生改变的。
- 成员变量如果被```final```修饰，需要在构造方法结束之前，完成赋值。

### 3.3```final```修饰变量名的规范

- 如果变量名是一个单词，所有字母大写：```MAX```
- 如果变量名是多个单词， 所有字母大写， 中间使用下划线分割```MAX_VALUE```

# day 02 面向对象高级

## 1 包

### 1.1 定义

- 包本质来说就是文件夹，用来管理类文件的

### 1.2 导包

- 相同包下的类可以直接访问，不同包下的类必须导包，才可以使用！导包格式：```import 包名.类名```
- 假如一个类中需要用到不同类，而这个两个类的名称是一样的，那么默认只能导入一个类，另一个类要带包名访问。

```java
public class Test {
    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.eat();

        // 使用全类名创建对象
        com.itheima.b.Student stu2 = new com.itheima.b.Student();
        stu2.sleep();
    }
}
```

```java
public class Scanner {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
    }
}
```

## 2 抽象类

- 抽象类是一种特殊的父类，内部可以编写抽象代码。
- 抽象方法：将共性的行为（方法）抽取到父类之后，发现该方法的**实现逻辑**无法在**父类中给出具体明确**，该方法就可以定义为抽象方法。

```java
public class AbstractDemo1 {
    public static void main(String[] args) {
        Cat c = new Cat();
        c.eat();

        Dog d = new Dog();
        d.eat();
    }
}

abstract class Animal {
    public abstract void eat();  // 每个动物吃什么 都不一样 干脆就抽象类吧
}

class Cat extends Animal{
    // 重写
    public void eat() {
        System.out.println("猫吃鱼");
    }
}

class Dog extends Animal {
    public void eat() {
        System.out.println("狗吃屎");
    }
}
```



## 3 接口



## 4 多态









