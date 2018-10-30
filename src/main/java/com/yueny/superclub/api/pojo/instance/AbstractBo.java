package com.yueny.superclub.api.pojo.instance;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.yueny.superclub.api.pojo.IBo;

/**
 * 抽象bo<br>
 * 实现 Serializable接口<br>
 * 也可以使用mask bo(未实现 Serializable)
 * {@link com.yueny.rapid.lang.util.mask.pojo.instance.AbstractMaskBo}
 *
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2015年12月17日 下午1:37:09
 *
 */
public abstract class AbstractBo implements IBo, Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 80262842581006708L;

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// 常规输出
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		// Mask 输出
		// return MaskToStringBuilder.reflectionToString(this,
		// ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
