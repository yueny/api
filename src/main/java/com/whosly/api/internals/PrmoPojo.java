/**
 * 
 */
package com.whosly.api.internals;

import com.google.common.collect.MapMaker;
import lombok.ToString;

import java.util.concurrent.ConcurrentMap;


/**
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2018年9月5日 上午10:55:18
 */
@ToString
public class PrmoPojo {
	/**
	 * 自定义属性值
	 */
	// 使用WeakValueMap，当Value被垃圾回收时会将此value在map中的entry清除，防止内存溢出
	private ConcurrentMap<String, Object> concurrentMap =
			new MapMaker().weakValues().makeMap();

	public Object putIfAbsent(String key, Object value) {
		if(!concurrentMap.containsKey(key)){
			return concurrentMap.putIfAbsent(key, value);
		}

		return null;
	}

	public Object get(String key) {
		return concurrentMap.get(key);
	}

}
