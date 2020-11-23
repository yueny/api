/**
 *
 */
package com.yueny.superclub.api.constant;

/**
 * 常量配置类，主要是一些惯例的KEY
 *
 * @author yueny09 <deep_blue_yang@163.com>
 *
 * @DATE 2016年11月25日 下午10:04:06
 *
 */
public final class ConventionsX {
	/**
	 * 与前端统一的上下文
	 */
	public static final String CONTEXT_PATH = "ctx";
	/**
	 *
	 */
	public static final String CTX_LOG_ID_MDC = "ctxLogId";
	/**
	 * 在MDC中存放远程调用方系统名（系统来源）
	 */
	public static final String CTX_SRC_SYS_MDC = "ctxSrcSys";
	/**
	 * 在MDC中存放统一上下文LOGID的KEY
	 */
	public static final String CTX_TRACE_ID_MDC = "ctxTraceId";
	/**
	 * HTTP头中存放请求来源IP
	 */
	public static final String REAL_IP_HEADER = "X-Real-IP";
	/**
	 * REST操作服务URL的固定开头
	 */
	public static final String SERVICE_URL_PREFIX = "/service";

	/**
	 * REST数据服务URL的固定开头
	 */
	public static final String SERVICES_URL_PREFIX = "/services";
	/**
	 * HTTP头中存放客户真实IP
	 */
	public static final String X_CLIENT_IP_HEADER = "X-Client-IP";
	/**
	 * 远程调用时用来传递统一上下文logId的HTTP HEADER
	 */
	public static final String X_LOG_ID_HEADER = "X-LOG-ID";
	/**
	 * 远程调用时用于传递调用方系统名的HTTP HEADER
	 */
	public static final String X_SRC_SYS_HEADER = "X-SRC-SYS";
	/**
	 * 远程调用时用来传递统一上下文logId的HTTP HEADER
	 */
	public static final String X_TRACE_ID_HEADER = "X-TRACE-ID";
	/**
	 * 分布式事务的TXID
	 */
	public static final String X_TX_ID_KEY = "X-TX-ID";

}
