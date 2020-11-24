/**
 *
 */
package com.whosly.api.enums;

import com.whosly.api.enums.core.IEnumType;

/**
 * 结果标识<br>
 * cms: 6xyyyy<br>
 * imgui: 3xyyyy<br>
 *
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2016年6月7日 下午5:23:30
 *
 */
public interface IResultCodeType extends IEnumType {
	/**
	 * @return 结果码
	 */
	String getCode();

	/**
	 * @return 结果描述
	 */
	String getMessage();
}
