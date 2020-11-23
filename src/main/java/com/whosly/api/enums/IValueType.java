package com.whosly.api.enums;

import com.whosly.api.enums.core.IEnumType;

/**
 * 带值的枚举
 * 
 * @author <a href="mailto:yueny09@126.com"> 袁洋 2015年1月29日 下午11:18:22
 * @param <V>
 *            值类型
 * 
 * @category tag
 */
public abstract interface IValueType<V> extends IEnumType {
	/**
	 * @return 枚举所代表的 value 值的描述性文字.
	 */
	String getDescribe();

	/**
	 * @return 枚举所代表的 value 值,该值可以为数字,也可以为字符串.
	 */
	V getValue();

}
