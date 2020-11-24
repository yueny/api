package com.whosly.api.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.whosly.api.page.core.PageCond;
import com.whosly.api.pojo.instance.AbstractBo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

/**
 * 分页List，具体分页信息保存在 IPageable 中。
 *
 * @param <T>
 *            分页对象的实体
 *
 * @author 袁洋 <a href="mailto:yueny09@126.com">
 * @date 2015年3月17日 下午1:50:44
 * @category tag
 */
@Builder 
@AllArgsConstructor 
public class PageList<T> extends AbstractBo implements Serializable {
	private static final long serialVersionUID = 3688506612305500726L;
	/**
	 * 分页对象
	 */
	@Singular(value = "list")
	@Getter
	private List<T> list;
	/**
	 * 分页信息
	 */
	@Getter
	private IPageable paginator;

	/** 默认分页 */
	public PageList() {
		this.list = new ArrayList<T>();
		paginator = new PageCond();
	}

	/**
	 * @param c
	 *            collection
	 */
	public PageList(final Collection<? extends T> c) {
		this(c, null);
	}

	/**
	 * @param c
	 *            collection
	 * @param page
	 *            IPageable
	 */
	public PageList(final Collection<? extends T> c, final PageCond page) {
		this.list = new ArrayList<T>(c);
		this.paginator = page == null ? new PageCond() : page;
	}

	/**
	 * @param paginator
	 *            IPageable
	 */
	public void setPage(final IPageable paginator) {
		if (paginator != null) {
			this.paginator = paginator;
		}
	}

	@Override
	public String toString() {
		return "PageList [list=" + list + ", paginator=" + paginator + "]";
	}

}
