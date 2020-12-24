package com.whosly.api.page.core;

import java.util.Arrays;

import com.whosly.api.page.IPageable;
import lombok.Getter;

/**
 * 分页对象<br>
 * MYSQL 分页:<br>
 * limit beginIndex, pageSize <br>
 * limit (currentPage - 1) * pageSize, pageSize<br>
 * DB2 分页:<br>
 *
 * @author 袁洋 2014年8月4日
 */
public class PageCond implements IPageable {
	private static final long serialVersionUID = 3688506614705500726L;

	/**
	 * 每页项数
	 */
	private static final int DEFAULT_PAGE_SIZE_PER_PAGE = 10;
	/**
	 * 滑动窗口默认的大小(7)。
	 */
	public static final int DEFAULT_SLIDER_SIZE = 7;

	/**
	 * 默认当前页起始位置.mysql中缺省为"1"
	 */
	private static final int DEFAULT_START = 1;

	/**
	 * 表示总项数未知(<code>Integer.MAX_VALUE</code>)。
	 */
	public static final long UNKNOWN_ITEMS = -1L;

	/**
	 * start<br>
	 * 当前页码。缺省为"1"。
	 */
	@Getter
	private int currentPage;
	/**
	 * 表示查询分页结果的总条数。总共项数.
	 * 缺省统计。-1代表未知。
	 */
	@Getter
	private Long items = UNKNOWN_ITEMS;
	/** limit,表示每页显示数据的条数,每页项数。缺省为“10”。 */
	@Getter
	private int pageSize;

	/**
	 * 创建一个分页器，每页项数取默认值，初始总项数为无限大<code>UNKNOWN_ITEMS</code>
	 * 默认每页显示DEFAULT_PAGE_SIZE_PER_PAGE<code>10</code>项。
	 */
	public PageCond() {
		this(DEFAULT_PAGE_SIZE_PER_PAGE);
	}

	/**
	 * 创建一个分页器，指定每页项数，并设置总项数为无限大<code>UNKNOWN_ITEMS</code>。
	 *
	 * @param pageSize
	 *            每页项数。
	 */
	public PageCond(final int pageSize) {
		this(pageSize, UNKNOWN_ITEMS);
	}

	/**
	 * 创建一个分页器，指定当前页和每页项数，并设置总项数为无限大<code>UNKNOWN_ITEMS</code>。
	 *
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            每页项数。
	 */
	public PageCond(final int currentPage, final int pageSize) {
		this(currentPage, pageSize, UNKNOWN_ITEMS);
	}

	/**
	 * 创建一个分页器，指定当前页和每页项数，并设置总项数
	 *
	 * @param currentPage
	 *            当前页,缺省为"1"
	 * @param pageSize
	 *            每页项数。
	 * @param items
	 *            总项数
	 */
	public PageCond(final int currentPage, final int pageSize, final Long items) {
		this.currentPage = (currentPage >= 1) ? currentPage : 1;
		this.pageSize = (pageSize > 0) ? pageSize : DEFAULT_PAGE_SIZE_PER_PAGE;
		this.items = (items >= 0) ? items : 0;
	}

	/**
	 * 创建一个分页器，指定每页项数，并设置总项数。当前页取默认值
	 *
	 * @param pageSize
	 *            每页项数。
	 * @param items
	 *            总项数
	 */
	public PageCond(final int pageSize, final Long items) {
		// calcPage(DEFAULT_START) 是不是等于默认值1呢？？？
		this(DEFAULT_START, pageSize, items);
		System.out.println("返回正确的页码(保证不会出边界):" + calcPage(DEFAULT_START));
	}

	/**
	 * 计算页数，但不改变当前页。
	 *
	 * @param page
	 *            页码
	 *
	 * @return 返回正确的页码(保证不会出边界)
	 */
	private int calcPage(final int page) {
		final int pages = getPages();
		if (pages > 0) {
			return (page < 1) ? 1 : ((page > pages) ? pages : page);
		}

		return 0;
	}

	/**
	 * 创建复本。
	 *
	 * @return 复本
	 */
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (final java.lang.CloneNotSupportedException e) {
			return null; // 不可能发生
		}
	}

	@Override
	public int getBeginIndex() {
		// 计算公式:rowStart/beginIndex = (currentPage-1) * pageSize = (1-1) * 10=0
		if (currentPage > 0) {
			return (currentPage - 1) * pageSize;
		}
		return 0;
	}

	/**
	 * 取得首页页码。
	 *
	 * @return 首页页码
	 */
	public int getBeginPage() {
		return calcPage(1);
	}

	@Override
	public Long getEndIndex() {
		// * 结束查询的数值<br>
		// * 默认值为:currentPage * pageSize - 1=1*10-1=9.<br>
		// * 计算公式:rowEnd= currentPage * pageSize - 1 或者 rowStart + pageSize - 1.
		if (currentPage > 0) {
			return Math.min(currentPage * pageSize - 1, items);
		}
		return 0L;
	}

	/**
	 * 取得尾页页码。
	 *
	 * @return 尾页页码
	 */
	public int getEndPage() {
		return calcPage(getPages());
	}

	@Override
	public int getPages() {
		return (int) Math.ceil((double) items / pageSize);
	}

	/**
	 * 取得下一页页码。
	 *
	 * @return 下一页页码
	 */
	@Override
	public Integer getNextPageNo() {
		return getNextPageNo(1);
	}

	/**
	 * 取得后n页页码。
	 *
	 * @param n
	 *            后n面
	 *
	 * @return 后n页页码
	 */
	public int getNextPageNo(final int n) {
		return calcPage(currentPage + n);
	}

	/**
	 * @return 前一页
	 */
	@Override
	public Integer getPrePageNo(){
		return getPrePageNo(1);
	}

	/**
	 * 取得前n页页码
	 *
	 * @param n
	 *            前n页
	 *
	 * @return 前n页页码
	 */
	public int getPrePageNo(final int n) {
		return calcPage(currentPage - n);
	}

	/**
	 * 取得默认大小(<code>DEFAULT_SLIDER_SIZE</code>)的页码滑动窗口，并将当前页尽可能地放在滑动窗口的中间部位。参见
	 * {@link #getSlider(int n)}。
	 *
	 * @return 包含页码的数组
	 */
	public int[] getSlider() {
		return getSlider(DEFAULT_SLIDER_SIZE);
	}

	/**
	 * 取得指定大小的页码滑动窗口，并将当前页尽可能地放在滑动窗口的中间部位。例如: 总共有13页，当前页是第5页，取得一个大小为5的滑动窗口，将包括
	 * 3，4，5，6, 7这几个页码，第5页被放在中间。如果当前页是12，则返回页码为 9，10，11，12，13。
	 *
	 * @param width
	 *            滑动窗口大小
	 *
	 * @return 包含页码的数组，如果指定滑动窗口大小小于1或总页数为0，则返回空数组。
	 */
	public int[] getSlider(int width) {
		final int pages = getPages();

		if ((pages < 1) || (width < 1)) {
			return new int[0];
		}
		if (width > pages) {
			width = pages;
		}

		final int[] slider = new int[width];
		int first = currentPage - ((width - 1) / 2);

		if (first < 1) {
			first = 1;
		}

		if (((first + width) - 1) > pages) {
			first = pages - width + 1;
		}

		for (int i = 0; i < width; i++) {
			slider[i] = first + i;
		}

		return slider;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.yueny.codelets.api.condition.page.IPageable#hasNextPage()
	 */
	@Override
	public boolean hasNextPage() {
		// 当前页码是否小于总页数(大于等于都认为没有下一页)
		return getCurrentPage() < getPages();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.yueny.codelets.api.condition.page.IPageable#hasPreviousPage()
	 */
	@Override
	public boolean hasPreviousPage() {
		// 当前页码是否为第一页(首页)
		return getCurrentPage() > 1;
	}

	@Override
	public boolean isDisabledPage(final int page) {
		return ((page < 1) || (page > getPages()) || (page == this.currentPage));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.yueny.superclub.api.page.IPageable#isFirstPage()
	 */
	@Override
	public boolean isFirstPage() {
		return !hasPreviousPage();
	}

	@Override
	public boolean isLastPage() {
		return !hasNextPage();
	}

	@Override
	public int setCurrentPage(final int page) {
		return (this.currentPage = calcPage(page));
	}

	@Override
	public Long setItems(final Long items) {
		this.items = (items >= 0) ? items : 0;
		setCurrentPage(currentPage);
		return this.items;
	}

	@Override
	public int setPageSize(final int pageSize) {
		final int tmp = this.pageSize;

		this.pageSize = (pageSize > 0) ? pageSize : DEFAULT_PAGE_SIZE_PER_PAGE;

		if (currentPage > 0) {
			setCurrentPage((int) (((double) (currentPage - 1) * tmp) / this.pageSize) + 1);
		}

		return this.pageSize;
	}

	@Override
	public String toString() {
		return "PageCond [currentPage=" + currentPage + ", items=" + items + ", pageSize=" + pageSize
				+ ", getBeginIndex()=" + getBeginIndex() + ", getCurrentPage()=" + getCurrentPage() + ", getEndIndex()="
				+ getEndIndex() + ", getBeginPage()=" + getBeginPage() + ", getItems()=" + getItems()
				+ ", getEndPage()=" + getEndPage() + ", getNextPageNo()=" + getNextPageNo() + ", getPages()=" + getPages()
				+ ", getPageSize()=" + getPageSize() + ", getPrePageNo()=" + getPrePageNo() + ", getSlider()="
				+ Arrays.toString(getSlider()) + ", hasNextPage()=" + hasNextPage() + ", hasPreviousPage()="
				+ hasPreviousPage() + ", isFirstPage()=" + isFirstPage() + ", isLastPage()=" + isLastPage() + "]";
	}

}
