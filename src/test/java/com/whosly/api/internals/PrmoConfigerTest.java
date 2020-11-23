/**
 *
 */
package com.whosly.api.internals;

import org.junit.Test;

/**
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2018年9月25日 上午11:53:57
 *
 */
public class PrmoConfigerTest {

	@Test
	public void testGet() {
		final PrmoPojo pojo = PrmoConfiger.get("rapid-lang-resp.prmo");
	}

}
