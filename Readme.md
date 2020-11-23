# API
================

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
<a href="">
  <img alt="Coverity Scan Build Status" src="https://img.shields.io/coverity/scan/8244.svg"/>
</a>


# 基础数据源定义
* **Maven依赖管理**
   ```
   <dependency>
        <groupId>com.yueny</groupId>
        <artifactId>api</artifactId>
	    <version>1.2.0-SNAPSHOT</version>
   </dependency>
   ```
   
* **依赖传递**
   * org.projectlombok#lombok
   * org.apache.commons#commons-lang3
   * com.google.guava#guava

# Features
* **基础pojo对象抽离对象AbstractBo, QueryCondition抽离至 resp中**


# 版本发布历史
================
## 1.0.1-SNAPSHOT/RELEASE   <groupId>com.yueny</groupId>
* 所有的非数据实体， 实现 IBo;

## 1.1.0-SNAPSHOT/RELEASE   <groupId>com.yueny</groupId>
* parent 依赖升级为yueny-parent#1.2.0-RELEASE

## 1.2.0-SNAPSHOT/RELEASE   <groupId>com.whosly</groupId>
* parent 依赖升级为com.whosly#yueny-parent#1.3.0-RELEASE， 并只发布中央仓库。
