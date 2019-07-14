package org.jit.sose.util;

/**
 * 自定义String工具类
 *
 * @author: 王越
 * @date: 2019-06-06 16:20:12
 */
public class StringUtil {

    /**
     * 判断是否为空字符串
     *
     * @param str
     * @return 如果为空，则返回true
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str) || str.trim().length() == 0;
    }

    /**
     * 判断字符串是否非空
     *
     * @param str 如果不为空，则返回true
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 去除String空格
     *
     * @param str
     * @return 去除空格后的字符串
     */
    public static String trim(String str) {
        return str == null ? null : str.trim();
    }

}
