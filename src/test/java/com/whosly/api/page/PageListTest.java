/**
 *
 */
package com.whosly.api.page;

import com.whosly.api.page.core.PageCond;
import org.junit.Test;

/**
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2017年1月23日 上午11:29:26
 *
 */
public class PageListTest {
	@Test
	public void testPage() {
		final PageList<String> pages = new PageList<String>();
		System.out.println(pages);

		pages.getPaginator().setItems(500L);
		System.out.println(pages);

		final PageList<String> pages1 = PageList.<String> builder()
				.paginator(new PageCond()).build();
		System.out.println(pages1);
	}

}
