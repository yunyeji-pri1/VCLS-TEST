package com.neonexsoft.vclstest.util;

import org.apache.commons.lang3.StringUtils;

import java.net.URLEncoder;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;


public class StringUtil {

    static final String AB = "0123456789abcdefghijklmnopqrstuvwxyz";

    /**
     * 정규식 패턴 검증
     * @param pattern
     * @param str
     * @return
     */
    public static boolean checkPattern(String pattern, String str) {
        boolean okPattern = false;
        String regex = null;

        pattern = pattern.trim();

        // 숫자 체크
        if (StringUtils.equals("num", pattern)) {
            regex = "^[0-9]*$";
        }

        // 숫자,영문자 체크
        if (StringUtils.equals("numeng", pattern)) {
            regex = "^[a-zA-Z0-9]*$";
        }

        // 영문자 체크
        if (StringUtils.equals("eng", pattern)) {
            regex = "^[a-zA-Z]*$";
        }

        // 이메일 체크
        if (StringUtils.equals("email", pattern)) {
            regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
        }

        // 전화번호 체크
        if (StringUtils.equals("tel", pattern)) {
            regex = "^\\d{2,3}-\\d{3,4}-\\d{4}$";
        }

        // 휴대폰번호 체크
        if (StringUtils.equals("phone", pattern)) {
            regex = "^01(?:0|1[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
        }

        okPattern = Pattern.matches(regex, str);
        return okPattern;
    }

    /**
     * UID 2자리씩 끊어서 String 생성하기(복원)
     * @param pattern
     * @param str
     * @return
     */
    public static String twoDigitReverse(String inString, String reverse) {
        String returnString = "";
        String tempString = ((int)(inString.length() % 2) == 0 ? "" : " ");
        int startIndex = (int)(Math.ceil(inString.length() / 2.0));

        if(inString.length() <= 0) return returnString;

        if(reverse.equals("Reverse")) { // Reverse
            inString = inString + tempString;
        } else { // Original
            inString = tempString + inString;
        }

        for(int i=startIndex ; i > 0 ; i--) {
            if( i==startIndex)
                returnString += inString.substring(i*2-2);
            else
                returnString += inString.substring(i*2-2, i*2);
        }

        return returnString.replace(" ", "");
    }

    /**
     * 체크 Empty
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * 랜덤 String
     * @param len
     * @return
     * @throws Exception
     */
    public static String randomString(int len) throws Exception {
        //Random rnd = new Random();
        SecureRandom rnd  = new SecureRandom();
        StringBuilder sb = new StringBuilder( len );
           for( int i = 0; i < len; i++ )
              sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
           return sb.toString();
    }

    /**
     * null값을 빈문자열로 반환
     * @param str
     * @return str
     */
    public static String nullToBlank(String str) {
        if (str == null || str.equals(""))
            str = "";
        return str;
    }

    /**
     * null값을 빈문자열로 반환
     * @param str
     * @return ret
     */
    public static String nullToBlank(Object str) {
        String ret = "";
        if (str == null)
            ret = "";
        else
            ret = str.toString();
        return ret;
    }
    /**
     * null값을 특정 문자열로 반환
     * @param str
     * @return ret
     */
    public static String nullToStr(Object str , String toString) {
        String ret = "";
        if (str == null)
            ret = toString;
        else
            ret = str.toString();
        return ret;
    }

    /**
     * null값을 숫자로 반환
     * @param str
     * @return ret
     */
    public static int nullToInt(Object str) {
        int ret = 0;
        if (str == null)
            ret = 0;
        else if (str == "")
            ret = 0;
        else
            ret = (int)str;
        return ret;
    }

    /**
     * 공백이거나 널인 경우 true 반환
     *
     * @param o
     *            검사할 객체
     * @return 공백이나 널인경우 true 아닌 경우는 false
     */
    public static boolean isEmpty2( Object o )
    {
        if( o == null ) return true;
        else if( "".equals( o ) ) return true;
        else return false;
    }

    /**
     *  string 여러개가 빈값인지 체크
     * @param strings
     * @return
     */
    public static boolean hasEmpty (String ...strings) {

        for(String str : strings) {
            if(isEmpty2(str)) return true;
        }
        return false;
    }

    /**
     * 날짜타입으로 변경
     *
     * @param val
     * @param format
     * @return
     */
    public static String getDateMask(String val, String format) throws Exception {
        String str = "";

        if (isEmpty(val)) {
            str = "";
        } else {
            if (val != null && val.trim().length() >= 8) {
                str = val.substring(0, 4) + format + val.substring(4, 6) + format + val.substring(6, 8);
            } else {
                str = val;
            }
        }

        return str;
    }

    /**
     * 시간타입으로 변경(시,분,초)
     *
     * @param val
     * @param format
     * @return
     */
    public static String getTimeMask(String val, String format) throws Exception {
        String str = "";

        if (isEmpty(val.trim())) {
            str = "";
        } else {
            if (val != null && val.length() >= 6) {
                str = val.substring(0, 2) + format + val.substring(2, 4) + format + val.substring(4, 6);
            } else {
                str = val;
            }
        }

        return str;
    }

    /**
     * 기간목록 조회
     *
     * @param sDate
     * @param eDate
     * @param flag
     * @return
     * @throws Exception
     */
    public static String getDayListByQuart(String sDate, String eDate, boolean flag) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date beginDate = formatter.parse(sDate);
        Date endDate = formatter.parse(eDate);
        long diff = endDate.getTime() - beginDate.getTime();
        int diffDays = (int) (diff / (24 * 60 * 60 * 1000));

        String dayList = "";

        for(int i =0;i <= diffDays; i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(beginDate);
            cal.add(Calendar.DATE, i);
            if(flag) {
                dayList = dayList +"\""+ (dateFormat.format(cal.getTime())+"\",");
            } else {
                dayList = dayList + (dateFormat.format(cal.getTime())+",");
            }
        }

        dayList = dayList.substring(0,dayList.lastIndexOf(","));

        return dayList;
    }

    public static String getDayOfWeek(String inputDate) throws Exception {
        if (inputDate == null || inputDate.length() < 8) {
            return "";
        }

        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        DateFormat ddf = new SimpleDateFormat("EEE");
        return ddf.format(df.parse(inputDate));
    }

    /**
     * 해당 수만큼 탭 들여쓰기된 문자열을 반환(최대 10번)
     *
     * @param    n    들여쓸 탭수
     * @return    탭수만큼 들여쓴 문자열
     */
    public static String tabIndent(int n) {
        if (n<0)
            n = 0;
        else if (n>10)
            n = 10;

        StringBuffer sbuf = new StringBuffer();
        for (int i=0; i<n; i++) {
            sbuf.append('\t');
        }
        return sbuf.toString();
    }

    /**
     * 문자열을 포맷팅함. 원본문자열을 좌우정렬하고 최대길의의 나머지공간은 공백문자로 채움.
     * 참고 : 바이트 길이(한글은 2바이트가 문자열길이 1임)
     *
     * @param    orgStr    원본문자열
     * @param    align    좌/우/중 정렬(-1=좌, 0=중, 1=우)
     * @param    totalLen    반환문자열의 길이
     * @return
     */
    public static String align(String orgStr, int align, int totalLen) {
        if (orgStr==null)
            orgStr = "";

        int lenBytes = orgStr.getBytes().length; //문자열 바이트의 길이
        if (lenBytes>= totalLen)
            return orgStr;

        int lenSpace = totalLen - lenBytes;
        int lenHalf  = lenSpace / 2; //공백으로 채울 문자열 길이의 절반

        StringBuffer sbuf = new StringBuffer();
        if (align<0) { ///왼쪽정렬
            sbuf.append(orgStr);
            sbuf.append( spaces(lenSpace) );
        }
        else if (align>0) { //오른쪽정렬
            sbuf.append( spaces(lenSpace) );
            sbuf.append(orgStr);
        }
        else { //가운데정렬
            sbuf.append( spaces(lenHalf) );
            sbuf.append(orgStr);
            sbuf.append( spaces(lenSpace - lenHalf) );
        }
        return sbuf.toString();
    }
    public static String align(int value, int align, int totalLen) {
        String tmp = "" + value;
        return align(tmp, align, totalLen);
    }

    /**
     * 공백문자(space)를 해당 길이로 반복하여 만든 문자열을 반환
     *
     * @param     len    원하는 길이
     * @return    ' '으로 된 문자열
     */
    public static String spaces(int len) {
        return chars(' ', len);
    }

    /**
     * 해당 길이의 '0'으로 된 문자열을 만들어 반환
     *
     * @param     len    원하는 길이
     * @return    '0'으로 된 문자열
     */
    public static String chars(char c, int len) {
        if (len<=0)
            return "";

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            sb.append(c);
        }

        return sb.toString();
    }

    /**
     * If string is null or empty string, return false. <br>
     * If not, return true.
     *
     * <pre>
     * StringUtil.isNotEmpty("")    = false
     * StringUtil.isNotEmpty(null)  = false
     * StringUtil.isNotEmpty("abc") = true
     * </pre>
     *
     * @param str
     *            original String
     * @return which empty string or not.
     */
    public static boolean isNotEmpty(Object obj) {

        if(obj == null) return false;

        if ((obj instanceof String) && (((String)obj).trim().length() == 0)) { return false; }
        if (obj instanceof Map) { return !((Map<?, ?>) obj).isEmpty(); }
        if (obj instanceof Map) { return !((Map<?, ?>)obj).isEmpty(); }
        if (obj instanceof List) { return !((List<?>)obj).isEmpty(); }
        return true;
    }

    /*Query String Parameter */
    public static String urlEncodeUTF8(String s) {
        try {
            if(s.indexOf("https://") != -1 || s.indexOf("http://") != -1 ) {
                return s;
        }
            return URLEncoder.encode(s, "UTF-8");
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public static String urlEncodeUTF8(Map<?,?> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<?,?> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(String.format("%s=%s",
                urlEncodeUTF8(entry.getKey().toString()),
                urlEncodeUTF8(entry.getValue().toString())
            ));
        }
        return sb.toString();
    }

    public static void setMask(List<LinkedHashMap<String, Object>> resultList) {

        for(int i=0; i<resultList.size(); i++) {

    /*
        if(resultList.get(i).getUserMobile()!=null && resultList.get(i).getUserMobile().length()>4){
             resultList.get(i).setUserMobile(resultList.get(i).getUserMobile().substring(0, resultList.get(i).getUserMobile().length()-4).concat("****"));
        }
    */
            if(resultList.get(i).get("USER_MOBILE")!=null && ((String)(resultList.get(i).get("USER_MOBILE"))).length()>3){
                String userMobile = (String)resultList.get(i).get("USER_MOBILE");
                userMobile = userMobile.substring(0, userMobile.length()-3).concat("***");
                resultList.get(i).put("USER_MOBILE", userMobile);
            }

            if(resultList.get(i).get("ADDR")!=null && ((String)(resultList.get(i).get("ADDR"))).length()>3){
                String addr = (String)resultList.get(i).get("ADDR");
                addr = addr.substring(0, addr.length()-3).concat("***");
                resultList.get(i).put("ADDR", addr);
            }

            if(resultList.get(i).get("USER_EMAIL")!=null && ((String)(resultList.get(i).get("USER_EMAIL"))).length()>2){
                String userEmail = (String)resultList.get(i).get("USER_EMAIL");
                userEmail = "**" + userEmail.substring(2, userEmail.length());
                resultList.get(i).put("USER_EMAIL", userEmail);
            }

        }

    }

    /**
     * 번호외의 문자 제거
     * @param str
     */
    public static String onlyNumber(String str) {

        if(isNotEmpty(str))
            return str.replaceAll("[^0-9]","");
        else return "";

    }
    /**
     * 마스킹 처리(이메일, 주소, 전화번호)
     * @param  targetName : email , addr , phone
     * @return
     *
     * */
    public static String setMask(String targetName , String str) {

        if(isEmpty2(targetName) || isEmpty2(str)) return str;

        switch (targetName) {
            case "email":
                str = str.replaceAll("^.{2}(?=.+@)","**");
                break;
            case "phone":
                str = onlyNumber(str).replaceAll("(\\d{2,3})(\\d{3,4})(\\d{1})(\\d{3})","$1-$2-$3***");
                break;
            case "addr":
                str = str.substring(0, str.length()-3).concat("***");
                break;
            default:
                break;
        }

        return str;
    }

    /**
     * 파일 이름에 대한 특수분자를 제거 합니다. .. \ / “ & 등을 제거
     * @param fileName 파일 이름
     * @return 특수문자가 제거된 파일 이름
     */
    public static String fileNameReplace(String fileName) {
        if(fileName != null && !"".equals(fileName)) {
            fileName = fileName.replaceAll("/", "");
            fileName = fileName.replaceAll("\\\\", "");
            fileName = fileName.replaceAll("\\.\\.", "");
            fileName = fileName.replaceAll("&", "");
            fileName = fileName.replaceAll("'","");
            fileName = fileName.replaceAll("\"","");
            fileName = fileName.replaceAll(":","");
            fileName = fileName.replaceAll("%", "");
            fileName = fileName.replaceAll(";", "");
            fileName = fileName.replaceAll("\\\\", "");
        }
        return fileName;
    }

    public static String dirNameReplace(String dirName) {

        if(dirName != null && !"".equals(dirName)) {
            dirName = dirName.replaceAll("\\\\", "");
            dirName = dirName.replaceAll("\\.", "");
            dirName = dirName.replaceAll("//", "");
            dirName = dirName.replaceAll("&", "");
        }
        return dirName;
    }

}



