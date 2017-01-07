package com.tim.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * Title: LBS
 * </p>
 * <p>
 * Description:服务器端验证类
 * </p>
 * <p>
 * Company: isoftstone
 * </p>
 *
 * @author lt
 * @date 2011-11-22
 */
public class ValidateUtils {

    private static Pattern pattern = null;
    private static Matcher matcher = null;

    /**
     * 该方法把HTML标签的"<"等转换成圆角符号。方法主要用来入对字符串入库前的格式化
     * 这样让字符串取出来在前台显示的时候就不会把一些HTML元素解析成HTML的标签了。
     *
     * @author suyanghua
     */
    public static String transferString(String str) {
        str = str.replaceAll("<", "＜");
        str = str.replace(">", "＞");
        str = str.replace("'", "＇");
        str = str.trim();
//		str   =   str.replace("<","&lt;");
//		str   =   str.replace( ">","&gt;");
//		str   =   str.replace( "'","' '");
//		str   =   str.replace( " ","&nbsp;");
//		str   =   str.replace( "\n","<br/>");
//		str   =   str.replace( "\r\n","<br/>");
        return str;
    }

    /**
     * 验证邮箱是否合法
     *
     * @return boolean
     */
    public static boolean emailValidate(String email) {
        boolean b = false;
        if (email.length() > 5 && email.length() < 50) {
            String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
            b = publicFunction(email, regex);
        }
        return b;
    }

    /**
     * 验证手机号码是否合法
     *
     * @return boolean
     */
    public static boolean phoneValidate(String phone) {
        boolean b = false;
        String regex = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
        b = publicFunction(phone, regex);
        return b;
    }

    /**
     * WGT验证方法
     */
    public static boolean wgtValidate(String text) {
        String subStr = text.substring(0, text.length() - 4);
        boolean b = false;
        String regex = "(.*)(\\.wgt|\\.WGT)$";
        b = publicFunction(subStr, regex);
        return b;
    }

    /**
     * 正则表达式公共方法
     *
     * @return boolean
     */
    public static boolean publicFunction(String text, String regex) {
        boolean b = false;
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(text);
        b = matcher.matches();
        return b;
    }

    /**
     * 将需要校验的信息中的特殊字符转换成空格返回
     *
     * @return String
     */
    public static String describeValidate(String text) {
        String s = "";
        if (text.length() > 0 && text.length() < 512) {
            String regex = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~";
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(text);
            s = matcher.replaceAll("").trim();
        }
        return s;
    }
}
