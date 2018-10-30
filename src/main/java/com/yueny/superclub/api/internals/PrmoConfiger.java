/**
 * 
 */
package com.yueny.superclub.api.internals;

/**
 * @author yueny09 <yueny09@163.com>
 *
 * @DATE 2018年9月5日 上午11:15:23
 */
public class PrmoConfiger {
    /**
     * @param prmoFile  如根目录下的 "rapid_lang_util.prmo";
     * @return
     */
	public static PrmoPojo get(String prmoFile){
        return PrmoConfigLocator.get(prmoFile);
    }
	
}
