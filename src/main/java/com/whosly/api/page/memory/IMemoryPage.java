package com.whosly.api.page.memory;

import com.whosly.api.page.IPageable;
import com.whosly.api.pojo.IBo;

/**
 * 内存分页接口或注解
 *
 * @author <a href="mailto:yueny09@126.com"> 袁洋 2014年12月12日 下午6:06:16
 *
 * @category tag
 */
public interface IMemoryPage extends IBo {
	/**
	 * 获取分页条件
	 *
	 * @return 分页条件
	 */
	IPageable getPageable();

	// /**
	// * 此接口一般不建议使用.只为满足某些特殊需求而开放的接口.
	// *
	// * @param page
	// * 分页对象
	// */
	// void setPage(final IPageable page);

}
