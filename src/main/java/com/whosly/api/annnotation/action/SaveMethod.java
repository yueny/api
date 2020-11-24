/**
 * 指定action的类型
 */
//指定action的类型
package com.whosly.api.annnotation.action;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @category 保存方法
 * 
 * @author <a href="mailto:yueny09@126.com"> 袁洋 2014年11月26日
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SaveMethod {
	//
}
