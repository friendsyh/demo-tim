package com.tim.common.myutils;

/**
 * <p>Title: aspire xPortal project</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: www.aspire-tech.com</p>
 *
 * @author achang
 * @some functions added by Zhang Zhongguang
 * @version 1.0
 */

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * This is where common String manipulation routines should go.
 *
 * @author <a href="mailto:jon@latchkey.com">Jon S. Stevens</a>
 * @author <a href="mailto:dlr@finemaltcoding.com">Daniel Rall</a>
 * @author <a href="mailto:gcoladonato@yahoo.com">Greg Coladonato</a>
 * @version $Id: StringMyUtils.java,v 1.3 2002/07/11 16:53:21 mpoeschl Exp $
 */
public class StringMyUtils { // implements BaseErrorCode

    private final static boolean isISO;

    public final static String REG_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";

    static {
        String fileEncode = System.getProperty("file.encoding");
        if (fileEncode != null) {
            isISO = (fileEncode.indexOf("GB") >= 0);
        } else {
            isISO = false;
        }

    }

    /**
     * 该方法将应用名称超过N-1的字符串分割，每N个字符之后添加一个空格，让其在报表显示的时候分行显示
     * 比如当N为15时，
     * 如果传入aaaaabbbbbcccccdddeeefffggghhhiii
     * 则返回字符串aaaaabbbbbccccc dddeeefffggghhh iii
     * 如果没有超过16的长度，则应用名称不变
     */
    public String changeAppName(String str, int N) {
        if (str.length() >= N + 1) {
            String result = "";
            int i = 0;
            int j = str.length() / N;
            for (i = 0; i < j; i++) {
                result += str.substring(N * i, N * (i + 1)).concat(" ");
            }
            result += str.substring(N * i);
            return result;
        } else {
            return str;
        }
    }

    /**
     * @param src         String 原始字符�?
     * @param maxLen      int 待截取的固定字节数目
     * @param charsetName String 字符集名�? �?��使用Java系统的UTF-8
     * @return String
     * @CheckLine@ Add-Zhangzg-20050603-patch200506-add15 添加按固定字节长度截断的函数
     */
    public static String trunc(String src, int maxLen, String charsetName) {
        if ((src == null)) {
            return src;
        }

        int fixedLen = maxLen;
        try {
            byte[] bSrc = src.getBytes(charsetName);
            if (bSrc.length <= fixedLen) {
                return src;
            }

            String r = new String(bSrc, 0, fixedLen, charsetName);
            return r;
        } catch (UnsupportedEncodingException e) {
            byte[] bSrc = src.getBytes();
            if (bSrc.length <= (fixedLen / 3)) {
                return src;
            }

            byte[] b = new byte[fixedLen / 3];
            for (int i = 0; i < b.length; i++) {
                b[i] = bSrc[i];
            }
            String r = new String(b);
            return r;
        }
    }

    /**
     * 按固定字节长度截断的函数, 以GBK为编解码字符�?
     *
     * @param src    String
     * @param maxLen int
     * @return String
     */
    public static String truncInUTF8(String src, int maxLen) {
        return trunc(src, maxLen, "UTF-8");
    }

    /**
     * 将byte数组转换为表�?6进制值的字符串， 如：byte[]{8,18}转换为：0813�?和public static byte[]
     * hexStr2ByteArr(String strIn) 互为可�?的转换过�?
     *
     * @param arrB �?��转换的byte数组
     * @return 转换后的字符�?
     * @throws Exception 本方法不处理任何异常，所有异常全部抛�?
     * @author <a href="mailto:zhangji@aspire-tech.com">ZhangJi</a>
     */
    public static String byteArr2HexStr(byte[] arrB) throws Exception {
        int iLen = arrB.length;
        // 每个byte用两个字符才能表示，�?��字符串的长度是数组长度的两�?
        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            int intTmp = arrB[i];
            // 把负数转换为正数
            while (intTmp < 0) {
                intTmp = intTmp + 256;
            }
            // 小于0F的数�?��在前面补0
            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }

    /**
     * 将表�?6进制值的字符串转换为byte数组�?和public static String byteArr2HexStr(byte[] arrB)
     * 互为可�?的转换过�?
     *
     * @param strIn �?��转换的字符串
     * @return 转换后的byte数组
     * @throws Exception 本方法不处理任何异常，所有异常全部抛�?
     * @author <a href="mailto:zhangji@aspire-tech.com">ZhangJi</a>
     */
    public static byte[] hexStr2ByteArr(String strIn) throws Exception {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;
        // 两个字符表示�?��字节，所以字节数组长度是字符串长度除�?
        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }

    /**
     * @param str   the string need to be parsed
     * @param delim the delimiter to seperate created by YanFeng at 14/5/2003
     */
    public static String[] parseToArray(String str, String delim) {
        ArrayList<String> arr = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(str, delim);
        while (st.hasMoreTokens()) {
            arr.add(st.nextToken());
        }
        String[] ret = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ret[i] = (String) arr.get(i);
        }
        return ret;
    }

    /**
     * replace a old substring with rep in str
     *
     * @return string replaced
     */
    public static String replace(String src, String str1, String str2) {
        /*
         * if ((str==null)||(old==null)||(rep==null)) {//if one is null return ""
		 * return ""; } int index=str.indexOf(old); if((index<0)||old.equals("")) {
		 * //if no old string found or nothing to replace,return the origin
		 * return str; } StringBuffer strBuf=new StringBuffer(str);
		 * while(index>=0) { //found old part
		 * strBuf.delete(index,index+old.length()); strBuf.insert(index,rep);
		 * index=strBuf.toString().indexOf(old); } return strBuf.toString();
		 */
        StringBuffer str_temp;
        int start;
        int position;
        if (!(src.length() > 0) || str1.equals("")) {
            return src;
        } else {
            str_temp = new StringBuffer().append(src);
            start = 0;
            position = str_temp.toString().indexOf(str1, start);
            while (position > -1 && position < str_temp.toString().length()) {
                str_temp = str_temp.replace(position, position + str1.length(), str2);
                start = position + str2.length();
                position = str_temp.toString().indexOf(str1, start);
            }
            return str_temp.toString();
        }

    }

    /**
     * replace a old substring with rep in str
     *
     * @param str the string need to be replaced
     * @param old the string need to be removed
     * @param rep the string to be inserted
     * @return string replaced
     * @CheckItem@ selfbug-yanfeng-20031023 only replace once ocurrence of old
     */
    public static String replaceOnlyOnce(String str, String old, String rep) {
        if ((old == null) || old.equals("")) { // if old is null or blank
            // return the original string
            return str;
        }
        if ((str == null) || str.equals("")) { // if str is null or blank
            // return the original string
            return str;
        }
        int leftIndex = str.indexOf(old);
        if (leftIndex < 0) { // if no old string found so nothing to
            // replace,return the origin
            return str;
        }
        String leftStr = str.substring(0, leftIndex);
        String rightStr = str.substring(leftIndex + old.length());
        return leftStr + rep + rightStr;
    }

    /**
     * get the string format of a date precise to millisecond
     *
     * @param date the input date
     * @return the string created by yanfeng at13/5/2003
     */
    public static String getTimeString(Date date) {
        String timePattren = "yyyyMMddHHmmssSSS";
        return toString(date, timePattren);
    }

    /**
     * convert a date to string according to the format pattern
     *
     * @return the formated string
     */
    public static String getDateString(long item) {
        Date date = new Date();
        date.setTime(item);
        return toString(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * convert a date to string according to the format pattern
     *
     * @param date    input date
     * @param pattern format pattern
     * @return the formated string
     */
    public static String toString(Date date, String pattern) {
        SimpleDateFormat fo = new SimpleDateFormat(pattern);
        return fo.format(date);
    }

    /**
     * Deal with null strings converting them to "" instead. It also invokes
     * String.trim() on the output.
     *
     * @param foo A String.
     * @return A String.
     */
    public static final String makeString(String foo) {
        return (null == foo ? "" : foo.trim());
    }

    /**
     * Validates that the supplied string is neither <code>null</code> nor the
     * empty string.
     *
     * @param foo The text to check.
     * @return Whether valid.
     */
    public static final boolean isValid(String foo) {
        return (foo != null && foo.length() > 0);
    }

    /**
     * Determine whether a (trimmed) string is empty
     *
     * @param foo The text to check.
     * @return Whether empty.
     */
    public static final boolean isEmpty(String foo) {
        return (null == foo || foo.trim().length() == 0);
    }

    /**
     * Returns the output of printStackTrace as a String.
     *
     * @param e A Throwable.
     * @return A String.
     */
    public static final String stackTrace(Throwable e) {
        String foo = null;
        try {
            // And show the Error Screen.
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            e.printStackTrace(new PrintWriter(buf, true));
            foo = buf.toString();
        } catch (Exception f) {
            // Do nothing.
        }
        return foo;
    }

    /**
     * Returns the output of printStackTrace as a String.
     *
     * @param e      A Throwable.
     * @param addPre a boolean to add HTML
     *
     *               <pre>
     *                               tags around the stacktrace
     *                             &#064;return A String.
     */
    public static final String stackTrace(Throwable e, boolean addPre) {
        if (addPre) {
            return "<pre>" + stackTrace(e) + "</pre>";
        } else {
            return stackTrace(e);
        }
    }

    /**
     * Compares two Strings, returns true if their values are the same.
     *
     * @param s1 The first string.
     * @param s2 The second string.
     * @return True if the values of both strings are the same.
     */
    public static boolean equals(String s1, String s2) {
        if (s1 == null) {
            return (s2 == null);
        } else if (s2 == null) {
            // s1 is not null
            return false;
        } else {
            return s1.equals(s2);
        }
    }

    public static final int PPKEY_CLASSNAME = 0;

    public static final int PPKEY_ID = 1;

    public static final int PPKEY_PROPERTY = 2;

    /**
     * Takes a String of the form substring[substring]subtring and returns the 3
     * substrings
     *
     * @return a three element String array
     */
    public static String[] parseObjectKey(String s) {
        String[] p = new String[3];
        StringTokenizer st = new StringTokenizer(s, "[]");
        int count = st.countTokens();
        if (count > 1) {
            p[0] = st.nextToken();
            p[1] = st.nextToken();
            if (count == 3) {
                p[2] = st.nextToken();
            }
        }
        return p;
    }

    /**
     * Remove Underscores from a string and replaces first Letters with
     * Capitals. foo_bar becomes FooBar
     */
    public static String removeUnderScores(String data) {
        String temp = null;
        StringBuffer out = new StringBuffer();
        temp = data;

        StringTokenizer st = new StringTokenizer(temp, "_");
        while (st.hasMoreTokens()) {
            String element = (String) st.nextElement();
            out.append(firstLetterCaps(element));
        }
        return out.toString();
    }

    /**
     * Makes the first letter caps and leaves the rest as is.
     */
    public static String firstLetterCaps(String data) {
        StringBuffer sbuf = new StringBuffer(data.length());
        sbuf.append(data.substring(0, 1).toUpperCase()).append(data.substring(1));
        return sbuf.toString();
    }

    /**
     * Splits the provided CSV text into a list.
     *
     * @param text      The CSV list of values to split apart.
     * @param separator The separator character.
     * @return The list of values.
     */
    public static String[] split(String text, String separator) {
        StringTokenizer st = new StringTokenizer(text, separator);
        String[] values = new String[st.countTokens()];
        int pos = 0;
        while (st.hasMoreTokens()) {
            values[pos++] = st.nextToken();
        }
        return values;
    }

    /**
     * Joins the elements of the provided array into a single string containing
     * a list of CSV elements.
     *
     * @param list      The list of values to join together.
     * @param separator The separator character.
     * @return The CSV text.
     */
    public static String join(String[] list, String separator) {
        StringBuffer csv = new StringBuffer();
        for (int i = 0; i < list.length; i++) {
            if (i > 0) {
                csv.append(separator);
            }
            csv.append(list[i]);
        }
        return csv.toString();
    }

    /**
     * Takes a block of text which might have long lines in it and wraps the
     * long lines based on the supplied wrapColumn parameter. It was initially
     * implemented for use by VelocityEmail. If there are tabs in inString, you
     * are going to get results that are a bit strange, since tabs are a single
     * character but are displayed as 4 or 8 spaces. Remove the tabs.
     *
     * @param inString   Text which is in need of word-wrapping.
     * @param newline    The characters that define a newline.
     * @param wrapColumn The column to wrap the words at.
     * @return The text with all the long lines word-wrapped.
     */

    public static String wrapText(String inString, String newline, int wrapColumn) {
        StringTokenizer lineTokenizer = new StringTokenizer(inString, newline, true);
        StringBuffer stringBuffer = new StringBuffer();

        while (lineTokenizer.hasMoreTokens()) {
            try {
                String nextLine = lineTokenizer.nextToken();

                if (nextLine.length() > wrapColumn) {
                    // This line is long enough to be wrapped.
                    nextLine = wrapLine(nextLine, newline, wrapColumn);
                }

                stringBuffer.append(nextLine);
            } catch (NoSuchElementException nsee) {
                // thrown by nextToken(), but I don't know why it would
                break;
            }
        }

        return (stringBuffer.toString());
    }

    /**
     * Wraps a single line of text. Called by wrapText(). I can't think of any
     * good reason for exposing this to the public, since wrapText should always
     * be used AFAIK.
     *
     * @param line       A line which is in need of word-wrapping.
     * @param newline    The characters that define a newline.
     * @param wrapColumn The column to wrap the words at.
     * @return A line with newlines inserted.
     */

    protected static String wrapLine(String line, String newline, int wrapColumn) {
        StringBuffer wrappedLine = new StringBuffer();

        while (line.length() > wrapColumn) {
            int spaceToWrapAt = line.lastIndexOf(' ', wrapColumn);

            if (spaceToWrapAt >= 0) {
                wrappedLine.append(line.substring(0, spaceToWrapAt));
                wrappedLine.append(newline);
                line = line.substring(spaceToWrapAt + 1);
            }

            // This must be a really long word or URL. Pass it
            // through unchanged even though it's longer than the
            // wrapColumn would allow. This behavior could be
            // dependent on a parameter for those situations when
            // someone wants long words broken at line length.
            else {
                spaceToWrapAt = line.indexOf(' ', wrapColumn);

                if (spaceToWrapAt >= 0) {
                    wrappedLine.append(line.substring(0, spaceToWrapAt));
                    wrappedLine.append(newline);
                    line = line.substring(spaceToWrapAt + 1);
                } else {
                    wrappedLine.append(line);
                    line = "";
                }
            }
        }

        // Whatever is left in line is short enough to just pass through,
        // just like a small small kidney stone
        wrappedLine.append(line);

        return wrappedLine.toString();
    }

    /**
     * convert the ISO char encoding to GBK
     *
     * @param str the ISO encoding string
     * @return the GBK encoding string created by yanfeng at 13/5/2003 modified by yanfeng
     * at14/7/2003 for recursive invoke of this function in log.error()
     * @CheckItem@ SELFBUG-yanfeng-20030714 可能产生循环调用
     */
    public static String UTF8toGBK(String str) {
        if (str == null) {
            return null;
        }
        byte[] by = null;
        try {
            by = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            return str;
        }
        try {
            String a = new String(by, "GBK");
            return a;
        } catch (UnsupportedEncodingException ex1) {
            return str;
        }
    }

    /**
     * 根据系统环境自动判断是否转码
     *
     * @param str String
     * @return String
     */
    public static String GBKtoUTF8ByEncode(String str) {
        if (str == null) {
            return null;
        }
        if (isISO) { // �?
            byte[] by = null;
            try {
                by = str.getBytes("GBK");
            } catch (UnsupportedEncodingException ex) {
                return str;
            }
            try {
                String a = new String(by, "UTF-8");
                return a;
            } catch (UnsupportedEncodingException ex1) {
                return str;
            }

        } else {
            return str;
        }

    }

    public static String GBKtoUTF8(String str) {
        if (str == null) {
            return null;
        }
        byte[] by = null;
        try {
            by = str.getBytes("GBK");
        } catch (UnsupportedEncodingException ex) {
            return str;
        }
        try {
            String a = new String(by, "UTF-8");
            return a;
        } catch (UnsupportedEncodingException ex1) {
            return str;
        }
    }

    /**
     * trim the string even when it's null
     *
     * @param str the string need to be trimmed
     * @return the trimmed string
     */
    public static String trim(String str) {
        if (str == null) {
            return "";
        }
        return str.trim();
    }

    /**
     * 判断str是否在strArr�?
     *
     * @return true:str在strArr中出�?;false otherwise.
     */
    public static boolean stringInArray(String str, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (str.equals(strArr[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 将带有格式的字符串转换成HTML方式
     */
    public static String convert2Html(String origine) {
        String outStr = null;
        if (origine != null) {
            String tmp = StringMyUtils.replace(origine, ">", "&gt;");
            String tmp2 = StringMyUtils.replace(tmp, "<", "&lt;");
            String tmp3 = StringMyUtils.replace(tmp2, " ", "&nbsp;");

            String tmp4 = StringMyUtils.replace(tmp3, "\r\n", "<br>");
            String tmp5 = StringMyUtils.replace(tmp4, "\n", "<br>");
            outStr = tmp5;
        } else {
            outStr = "";
        }
        return outStr;
    }

    /**
     * 找出字符串在数组中的位置(序号)，若不存在，返回数组的长?
     *
     * @param myStr  字符�?
     * @param myList 字符串数�?
     * @return int
     * @author Zhang Zhongguang
     */
    public static int getStringsIndex(String myStr, String[] myList) {
        int i = 0;
        for (i = 0; i < myList.length; i++) {
            if (myList[i].equals(myStr)) {
                break;
            }
        }
        return i;
    }

    /**
     * 将字符串src按format指定的格式转化为日期对象，本地中�?
     *
     * @param src    String
     * @param format String 格式，如yy/MM/dd hh:mm:ss
     * @return Date对象
     * @author Zhang Zhongguang
     */
    public static Date toDate(String src, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format, java.util.Locale.CHINESE);
        Date d = null;
        d = sdf.parse(src);
        return d;
    }

    /**
     * 去src数组中为null的元素，返回新的数组
     *
     * @return String[]
     * @author Zhang zhongguang
     */
    public static String[] trimNull(String[] src) {
        if (src == null) {
            return null;
        }

        String[] tmp = null;

        int count = 0;
        // 取null元素数目
        for (int i = 0; i < src.length; i++) {
            if (src[i] == null) {
                count++;
            }
        }
        // 剔除
        if (count == 0) {
            tmp = src;
        } else if (count < src.length) {
            tmp = new String[src.length - count];
            int j = 0;
            for (int i = 0; i < src.length; i++) {
                if (src[i] != null) {
                    tmp[j++] = src[i];
                }
            }
        }

        return tmp;
    }

    public static int parseInteger(String str) {
        int iReturn = 0;
        if (!(str == null || str.equals(""))) {
            iReturn = Integer.parseInt(str);
        }
        return iReturn;
    }

    /**
     * 将一位的数字变成两位的字符串，前面补0，主要用于时间格�?
     *
     * @param i int
     * @return String
     */
    public static String intToString(int i) {
        if (i < 10) {
            return "0" + i;
        } else {
            return "" + i;
        }
    }

    /**
     * 校验email格式
     *
     * @param src String
     * @return boolean
     */
    public static boolean checkEmail(String src) {
        return src.matches(REG_EMAIL);
    }

    /**
     * Transfer a string array to string, connected by separator string.
     *
     * @param arr       String[]
     * @param separator String
     * @return String
     */
    public static String strArrayToString(String[] arr, String separator) {
        if (arr == null) {
            return null;
        }
        StringBuffer strBuffer = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            strBuffer.append(arr[i]).append(separator);
        }
        String returnStr = strBuffer.toString();
        if (returnStr.length() > 0) {
            returnStr = returnStr.substring(0, returnStr.length() - separator.length());
        }
        return returnStr;
    }

    /**
     * Transfer a string array to string,connected by separator string if the
     * array element is not null.
     *
     * @param arr       String[]
     * @param separator String
     * @return String
     */
    public static String strArrayToStringIgnoreNull(String[] arr, String separator) {
        if (arr == null) {
            return null;
        }
        StringBuffer strBuffer = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].trim().equals("")) {
                strBuffer.append(arr[i]).append(separator);
            }
        }
        String returnStr = strBuffer.toString();
        if (returnStr.length() > 0) {
            returnStr = returnStr.substring(0, returnStr.length() - separator.length());
        }
        return returnStr;
    }

    /**
     * 判断�?��字符串是否为整型格式
     *
     * @param in String
     * @return boolean
     */
    public static boolean isInteger(String in) {
        try {
            Integer.parseInt(in);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断�?��字符串是否为布尔型格�?判断0�?)
     *
     * @param in String
     * @return boolean
     */
    public static boolean isBoolean(String in) {
        if (in == null) {
            return false;
        }
        if (in.equals("0") || in.equals("1")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断�?��字符串是否为符合timeFormat格式的时间字符串
     *
     * @param in         String
     * @param timeFormat String
     * @return boolean
     */
    public static boolean isDate(String in, String timeFormat) {
        try {
            toDate(in, timeFormat);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断字符串是否为float格式
     *
     * @param in String
     * @return boolean
     */
    public static boolean isFloat(String in) {
        try {
            float a = Float.parseFloat(in);
            return (!Float.isInfinite(a));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 格式化替换函�? added by Zhangzg
     *
     * @param formatHolder  String 格式化占位符, �?s
     * @param src           String 包含占位符的原始字符�? �?You are %s, %s"
     * @param formatStrings String[] 用于替换占位符的字符串数�? 如new String[] {""}
     * @return String
     */
    public static String formatReplace(String formatHolder, String src, String[] formatStrings) {
        if (formatStrings == null) {
            return src;
        }

        int len = 0;
        int i = 0, count = formatStrings.length;
        for (i = 0; i < count; i++) {
            if (formatStrings[i] != null)
                len += formatStrings[i].length();
        }

        StringBuffer sb = new StringBuffer(src.length() + len);

        sb.append(src);
        int j = 0;
        for (i = 0; i < count; i++) {
            j = sb.indexOf(formatHolder, j);
            if (j < 0) {
                break;
            }
            sb.delete(j, j + formatHolder.length());
            sb.insert(j, formatStrings[i]);
        }

        return sb.toString();
    }

    /**
     * 首字转为大写，只前只针对单个单词
     *
     * @param chr �?��转换的单�?
     * @return chr
     */
    public static String getFastCharToUpperCase(String chr) {
        return chr.substring(0, 1).toUpperCase() + chr.substring(1);
    }

    /**
     * 获取指定长度�?-9A-Za-z随机字符�?说明：随机长度小于等于零时默�?6
     */
    public static String getRandomString(int getLength) {
        int StringLength = 16;
        if (getLength > 0) {
            StringLength = getLength;
        }
        int[] number = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57};// 定义数字数组
        int[] lAlphabet = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85,
                86, 87, 88, 89, 90};// 定义小写字母数组
        int[] tAlphabet = {97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113,
                114, 115, 116, 117, 118, 119, 120, 121, 122};// 定义大小字母数组
        Random rd = new Random();
        int nowNum = 0;
        StringBuffer nowString = new StringBuffer();
        for (int j = 0; j < StringLength; j++) {
            nowNum = rd.nextInt(3);
            switch (nowNum) {
                case 0:
                    nowString.append((char) number[rd.nextInt(number.length)]);
                    break;
                case 1:
                    nowString.append((char) lAlphabet[rd.nextInt(lAlphabet.length)]);
                    break;
                case 2:
                    nowString.append((char) tAlphabet[rd.nextInt(tAlphabet.length)]);
                    break;
                default:
                    nowString.append((char) lAlphabet[rd.nextInt(lAlphabet.length)]);
                    break;
            }
        }
        return nowString.toString();
    }

    /**
     * 将long型数字转换成指定长度的字符串，长度不足时，左�?
     *
     * @param num 要转换字符串的数�?
     * @param len 要转换的字符串的长度
     * @return 数字转换成的指定长度的字符串
     */
    public static String formatLongToString(long num, int len) {

        String s = String.valueOf(num);
        int sLen = s.length();

        if (len > sLen) {
            for (int i = 0; i < len - sLen; i++) {
                s = "0" + s;
            }
        }

        return s;
    }

    /**
     * 加密方式base64(MD5( base64(MD5($user+$deviceID+密钥)) +":Nonce"))
     *
     * @param account $user+$deviceID+密钥
     */
    public static String encPassword(String account) {

        MessageDigest digest;
        String str = null;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(account.getBytes());

            str = Base64.byteArrayToBase64(digest.digest());
            digest = MessageDigest.getInstance("MD5");
            digest.update((str + ":Nonce").getBytes());
            str = Base64.byteArrayToBase64(digest.digest());
        } catch (NoSuchAlgorithmException e) {
        }
        return str;
    }

    /**
     * 加密方式base64(MD5( base64(MD5($guid+$accoutName))
     */
    public static String encTokenString(String str) {


        MessageDigest digest;
        String token = null;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(str.getBytes());
            token = URLEncoder.encode(Base64.byteArrayToBase64(digest.digest()), "utf-8");
        } catch (Exception e) {
        }

        return token;

    }


    /**
     * 通过Base64加密字节
     */
    public static String encDataByBase64(byte[] data) {
        if (data == null) return null;
        return Base64.byteArrayToBase64(data);
    }

    /**
     * 返回字符串对应的byte数组
     */
    public static byte[] getStringByUTF8(String str) {
        if (str == null) return null;
        byte[] retStr = null;
        try {
            retStr = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
        }

        return retStr;
    }

    /**
     * 转换byte[]为UTF-8字符
     */
    public static String traverseByteToString(byte[] data) {

        if (null == data) return null;
        String retStr = null;
        try {
            retStr = new String(data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }

        return retStr;
    }


    /**
     * 解密字符
     */
    public static String decDataByBase64(String data) {
        if (data == null)
            return null;

        String retStr = null;
        try {
            retStr = new String(Base64.base64ToByteArray(data), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return retStr;
    }

    /**
     * 加密字符
     *
     * @return byte数组
     */
    public static byte[] decDataToByteByBase64(String data) {
        return Base64.base64ToByteArray(data);
    }

    /**
     * 截取jessionid中出现的.node
     */
    public static String getSessionID(String str) {

        int idx = str.indexOf(".");
        if (null != str && idx > 0) {
            return str.substring(0, idx);
        }
        return str;

    }

    /**
     * 验证Integer > 0
     */
    public static boolean valInteger(Integer integer) {
        if (null == integer || integer < 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 判断是否是数字
     */
    public static boolean isNumber(String name) {
        String r = "^[0-9]+$";
        Pattern p = Pattern.compile(r);
        Matcher m = p.matcher(name);
        if (m.find()) {
            return true;
        } else
            return false;
    }

}
