# 模式的秘密 代理模式 

视频来源：https://www.imooc.com/learn/214

## 章节目录
### 第1章 代理模式概念介绍 
* 1-1 代理模式概念及分类
### 第2章 常用代理模式原理 
* 2-1 静态代理概念及实现
* 2-2 聚合比继承更适合代理模式
* 2-3 了解 JDK 动态代理
* 2-4 使用 cglib 动态产生代理
### 第3章 自定义类模拟 JDK 动态代理的实现 
* 3-1 模拟 JDK 动态代理实现思路分析及简单实现
* 3-2 完善动态代理实现
* 3-3 动态代理实现添加 InvocationHandler
### 第4章 代理模式总结 
* 4-1 课程总结

## 注意

* 项目是基于 [Maven](https://maven.apache.org/ "https://maven.apache.org/") 构建的，不需要一个个添加 jar 包了
* 所有测试都是基于 [Junit4](http://junit.org/junit4/ "http://junit.org/junit4/") 编写的，目录为`src/test/java`
* 第3章目录在 `com.imooc.myproxy` 下
* 生成代理类源码方式为 [Velocity](http://velocity.apache.org/engine/2.0/index.html) (基于字符串拼接方式太不友好啦😁)
* 可以根据 Commits 或 Tags 切换到相关章节源码

感谢 [David](https://www.imooc.com/u/461086 "https://www.imooc.com/u/461086") 大神奉献的视频

[![David](https://ws4.sinaimg.cn/large/006tNc79ly1fnrtl22e04j305k05ka9z.jpg)](https://www.imooc.com/u/461086 "https://www.imooc.com/u/461086")

** 祝大家学习愉快！**