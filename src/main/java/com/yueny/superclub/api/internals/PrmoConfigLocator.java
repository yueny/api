/**
 *
 */
package com.yueny.superclub.api.internals;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentMap;

import com.google.common.collect.MapMaker;

/**
 * prmo 文件加载
 *
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2018年9月5日 上午10:46:14
 */
class PrmoConfigLocator {
	// 使用WeakValueMap，当Value被垃圾回收时会将此value在map中的entry清除，防止内存溢出
	private static ConcurrentMap<String, PrmoPojo> prmoPojoConcurrentMap = new MapMaker().weakValues().makeMap();

	/**
	 * @param prmoFile
	 *            如根目录下的 "rapid_lang_util.prmo";
	 * @return
	 */
	public static PrmoPojo get(final String prmoFile) {
		if (!prmoPojoConcurrentMap.containsKey(prmoFile)) {
			try {
				PrmoPojo pojo = loadProps(prmoFile);
				prmoPojoConcurrentMap.putIfAbsent(prmoFile, pojo);
			} catch (final Exception e) {
				System.err.println("PrmoConfigLocator 出现异常！" + e);
			}
		}
		return prmoPojoConcurrentMap.get(prmoFile);
	}

	synchronized static private PrmoPojo loadProps(final String prmoFile) {
		if (prmoPojoConcurrentMap.containsKey(prmoFile)) {
			return null;
		}

		System.out.println("开始加载文件 "+prmoFile+" 内容.......");
		final Long startTime = System.currentTimeMillis();

		final PrmoPojo pojo = new PrmoPojo();

		Properties props = new Properties();
		InputStream in = null;
		try {
			// 通过类加载器进行获取properties文件流
			in = PrmoConfigLocator.class.getClassLoader().getResourceAsStream(prmoFile);

			props.load(in);
			for (final Map.Entry<Object, Object> entry : props.entrySet()) {
				pojo.putIfAbsent(entry.getKey().toString(), entry.getValue());
			}
		} catch (Exception e) {
			//.
		} finally {
			try {
				if(null != in) {
					in.close();
				}
			} catch (Exception e) {
				//.
			}
		}

		final Long endTime = System.currentTimeMillis();
		System.out.println("加载文件 "+prmoFile+" 内容 "+pojo+" 完成。耗时 " + (endTime - startTime) + " ms.");

		in = null;
		props.clear();
		props = null;

		return pojo;
	}

	private PrmoConfigLocator() {
		// .
	}

}
