package com.whosly.api.annnotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 通过该注解在进行dozer转换枚举和其他类型时取值
 * 
 * @author <a href="mailto:yueny09@126.com"> 袁洋 2014年12月3日 上午12:29:29
 * 
 * @category tag
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
@Documented
public @interface EnumValue {
	// ..
}
