package com.whosly.api.page;

import com.whosly.api.pojo.IBo;

import java.io.Serializable;

/**
 * 分页对象的父类接口
 *
 * @author <a href="mailto:yueny09@126.com"> 袁洋 2014年12月9日 下午6:06:28
 *
 * @category tag
 */
public interface IPageable extends IBo, Serializable, Cloneable {

	/**
	 * @return 当前页码。缺省为"1"。
	 */
	int getCurrentPage();

	/**
	 * 表示查询分页结果的总条数。总共项数。缺省统计<br>
	 * Returns the total amount of elements.
	 *
	 * @return the total amount of elements
	 */
	Long getItems();

	/**
	 * 取得总页数。
	 *
	 * @return 总页数
	 */
	int getPages();

	/**
	 * @return 每页显示数据的条数,每页项数。缺省为“10”。
	 */
	int getPageSize();

	/**
	 * 设置并取得当前页。实际的当前页值被确保在正确的范围内。
	 *
	 * @param currentPage
	 *            当前页
	 *
	 * @return 设置后的当前页
	 */
	int setCurrentPage(final int currentPage);

	/**
	 *
	 * 设置并取得查询分页结果的总项数。如果指定的总项数小于0，则被看作0。自动调整当前页，确保当前页值在正确的范围内。
	 *
	 * @param items
	 *            总项数
	 *
	 * @return 设置以后的总项数
	 */
	Long setItems(final Long items);

	/**
	 * 设置并取得每页项数。如果指定的每页项数小于等于0，则使用默认值<code>DEFAULT_ITEMS_PER_PAGE</code>。
	 * 并调整当前页使之在改变每页项数前后显示相同的项。
	 *
	 * @param pageSize
	 *            每页项数
	 *
	 * @return 设置后的每页项数
	 */
	int setPageSize(final int pageSize);

	/**
	 * 取得当前页显示的项的起始序号(currentPage-1) * pageSize。
	 *
	 * @return 起始序号,表示当前页中的数据在结果集中的起始位置,从0开始。
	 */
	int getBeginIndex();

	/**
	 * @return 结束查询的数值
	 */
	Long getEndIndex();

	/**
	 * @return 前一页
	 */
	Integer getPrePageNo();

	/**
	 * 是否有前一页 Returns if there is a previous page.
	 *
	 * @return if there is a previous page
	 */
	boolean isHasPreviousPage();

	/**
	 * @return 下一页
	 */
	Integer getNextPageNo();

	/**
	 * 是否有下一页, Returns if there is a next page.
	 *
	 * @return if there is a next page
	 */
	boolean isHasNextPage();

	/**
	 * 判断指定页码是否被禁止，也就是说指定页码超出了范围或等于当前页码。
	 *
	 * @param page
	 *            页码
	 *
	 * @return boolean 是否为禁止的页码
	 */
	public boolean isDisabledPage(final int page);

	/**
	 * 是否为首页
	 *
	 * @return Returns whether the current page is the first one.
	 */
	boolean isFirstPage();

	/**
	 * 是否为尾页
	 *
	 * @return Returns whether the current page is the last one.
	 */
	boolean isLastPage();

}