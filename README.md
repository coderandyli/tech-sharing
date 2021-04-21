分享主题 | 分享人 | 分享时间
---|---|---
设计模式 | 李振振 | 2021-04-22

# 设计模式

## 建造者模式
### 概念
- 将一个复杂对象的构建与其表示分离，使得同样的构建过程可以创建不同的表示
> The intent of the Builder design pattern is to separate the construction of a complex object from its representation. By doing so the same construction process can create different representations.

### 场景
- 类的构造函数必填属性很多，通过set设置，没有办法校验必填属性
- 如果类的属性之间有一定的依赖关系，构造函数配合set方式，无法进行依赖关系和约束条件校验
- 需要创建不可变对象，不能暴露set方法。

### 实现

```
    private ApiInfo devApiInfo() {
        return new ApiInfoBuilder()
                .title("ad-agg-app接口文档")
                .version("1.0")
                .termsOfServiceUrl("NO terms of service")
                .contact(new Contact("lizhenzhen", "http://www.e-ports.com", "zhenzhen@e-ports.com"))
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }
```

## 职责链模式
### 概念
- 【原始定义】将请求的发送与接收解耦，让多个接收对象（接收处理器）都有机会处理这个请求，将这些接收对象串成一条链，并沿着这调链传递这个请求，直到链上某个接收对象能够处理它为止
- 【职责链变体】请求会被所有的处理器都处理一遍，不存在终止的情况

### 场景
- Servlet Filter： 主要拦截 Servlet 请求
- Spring Interceptor： Spring Interceptor 主要拦截 Spring 管理的 Bean 方法（比如 Controller 类的方法等）
- Mybatis Plugin：MyBatis Plugin 主要拦截的是 MyBatis 在执行 SQL 的过程中涉及的一些方法
- Spring Security核心原理：通过数组实现

### 实现
- case01: 基于链表的实现
- case02: 基于数组的实现

## 装饰者模式
### 概念
- 在不改变原有对象的基础上，将功能附加到对象上，提供了比继承更有弹性的替代方案（扩展原有对象功能）
- 装饰器类和原始类继承同样的父类，这样我们可以对原始类“嵌套”多个装饰器类，亦可实现可插拔，可自由配置  
- 装饰器类是对功能的增强
### 场景
- 对原有类进行增强
### 实现

## 代理模式
### 概念
- 在不改变原始类代码的情况下，通过引入代理类来给原始类附加功能。
### 场景
### 实现


## 解释器模式
### 概念
- 解释器模式为某个语言定义它的语法（或者叫文法）表示，并定义一个解释器用来处理这个语法。
> Interpreter pattern is used to defines a grammatical representation for a language and provides an interpreter to deal with this grammar
### 场景
- case01：未使用解释器模式的加减乘除的实现
- case02：基于解释器模式的加减乘除的实现
- 项目应用场景：?

### 实现

## 单例模式
### 概念
- 一个类只允许创建一个对象（或者实例）
### 场景
- 表示全局唯一的类
> 从业务概念上，如果有些数据在系统中只应保存一份，那就比较适合设计为单例类。比如，配置信息类。在系统中，我们只有一个配置文件，当配置文件被加载到内存之后，以对象的形式存在，也理所应当只有一份。 如果有两个对象有可能会出现重复的数据

### 实现

## 模板方法模式
## 概念
- 模板方法模式在一个方法中定义一个算法骨架，并将某些步骤推迟到子类中实现。模板方法模式可以让子类在不改变算法整体结构的情况下，重新定义算法中的某些步骤。
- 模板模式把一个算法中不变的流程抽象到父类的模板方法 templateMethod() 中，将可变的部分 method1()、method2() 留给子类 ContreteClass1 和 ContreteClass2 来实现
## 场景
- Java Servlet：doGet()、doPost()是留给子类实现扩展
- Spring中的JdbcTemplate、RedisTemplate 、RabbitTemplate
- juc中的AQS
- mybatis中Executor的实现
## 实现

