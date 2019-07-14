package org.jit.sose.util;


import com.alibaba.fastjson.JSON;
import org.jit.sose.constant.ResponseConstant;
import org.jit.sose.response.CommonResp;

/**
 * 统一请求返回结果封装工具类
 * 
 * @author: 王越
 * @date: 2019年6月5日 上午10:50:13
 */
public class ResponseUtil {
	
	/**
	 * 返回成功结果
	 * 
	 * @param obj 返回参数对象
	 * @return 成功结果集
	 */
	public static String success(Object obj) {
		CommonResp resp = new CommonResp();
		resp.setCode(ResponseConstant.SUCCESS);
		resp.setMsg("请求成功");
		resp.setObj(obj);
		return JSON.toJSONString(resp);
	}

	/**
	 * 返回成功结果
	 * 
	 * @param obj 返回参数对象
	 * @param msg 返回信息
	 * @return 成功结果集
	 */
	public static String success(String msg, Object obj) {
		CommonResp resp = new CommonResp();
		resp.setCode(ResponseConstant.SUCCESS);
		resp.setMsg(msg);
		resp.setObj(obj);
		return JSON.toJSONString(resp);
	}

	/**
	 * 返回错误结果
	 * 
	 * @param obj  返回参数对象
	 * @param code 状态码
	 * @param msg  返回信息
	 * @return 失败结果集
	 */
	public static String error(Integer code, String msg, Object obj) {
		CommonResp resp = new CommonResp();
		resp.setCode(ResponseConstant.SUCCESS);
		resp.setMsg(msg);
		resp.setObj(obj);
		return JSON.toJSONString(resp);
	}

	/**
	 * 返回错误结果
	 * 
	 * @param code 状态码
	 * @param msg  返回信息
	 * @return 失败结果集
	 */
	public static String error(Integer code, String msg) {
		CommonResp resp = new CommonResp();
		resp.setCode(code);
		resp.setMsg(msg);
		return JSON.toJSONString(resp);
	}

	/**
	 * 返回错误结果
	 * 
	 * @param code 状态码
	 * @return
	 */
	public static String error(Integer code) {
		CommonResp resp = new CommonResp();
		resp.setCode(code);
		return JSON.toJSONString(resp);
	}

}
