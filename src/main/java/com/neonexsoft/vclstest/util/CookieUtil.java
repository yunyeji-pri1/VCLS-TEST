package com.neonexsoft.vclstest.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public final class CookieUtil {

    private static final Logger logger = LoggerFactory.getLogger(CookieUtil.class);

    private CookieUtil() {}

    public static String getCookieValue(Cookie cookie) {
        try {
            return URLDecoder.decode(cookie.getValue(), "utf-8");
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 쿠키값 조회
     * @param request
     * @param cookieName
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName) {
        try {
            Cookie cookie = getCookie(request, cookieName);
            if (null == cookie) {
                return null;
            } else {
                return URLDecoder.decode(cookie.getValue(), "utf-8");
            }
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 해당 쿠키리턴
     * @param request
     * @param name
     * @return
     */
    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        Cookie returnCookie = null;

        if (cookies == null) { return returnCookie; }
        for (int i = 0; i < cookies.length; i++) {
            Cookie thisCookie = cookies[i];
            if (thisCookie.getName().equals(name) && !thisCookie.getValue().equals("")) {
                returnCookie = thisCookie;
                break;
            }
        }
        return returnCookie;
    }

    /**
     * 쿠키 세팅
     * @param request
     * @param response
     * @param name
     * @param value
     * @param path
     * @param age
     */
    public static void addCookie(HttpServletRequest request, HttpServletResponse response, String name,
            String value, String path, int age) {
        /* 수정 전 */
//        logger.debug("add cookie[name:{},value={},path={}]", name, value, path);
//        Cookie cookie = null;
//        try {
//            cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
//        } catch (UnsupportedEncodingException e) {
//            throw new RuntimeException(e);
//        }
//        cookie.setSecure(false);
//        cookie.setPath(path);
//        cookie.setMaxAge(age);
//        response.addCookie(cookie);

        /* 수정 후 */
        logger.debug("add cookie[name:{},value={},path={}]", name, value, path);
        if(name == null || "".equals(name)) return; // 유효성 점검
        String filtered_name = name.replaceAll("\r", "");
        Cookie cookie = new Cookie(name, filtered_name);
        try {
            cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        // 수정 : 민감 정보 가진 쿠키 전송시 보안 속성 설정해야 함
        cookie.setSecure(true);
        cookie.setPath(path);
        cookie.setMaxAge(age);
        response.addCookie(cookie);
    }

    /**
     * 쿠키세팅
     * @param request
     * @param response
     * @param name
     * @param value
     * @param age
     */
    public static void addCookie(HttpServletRequest request, HttpServletResponse response, String name,
            String value, int age) {
        String contextPath = request.getContextPath();
        if (!contextPath.endsWith("/")) {
            contextPath += "/";
        }
        addCookie(request, response, name, value, contextPath, age);
    }

    public static void deleteCookieByName(HttpServletRequest request, HttpServletResponse response,
            String name) {
        deleteCookie(response, getCookie(request, name), "");
    }

    /**
     * 쿠키삭제
     * @param response
     * @param cookie
     * @param path
     */
    public static void deleteCookie(HttpServletResponse response, Cookie cookie, String path) {
        if (cookie != null) {
            cookie.setMaxAge(0);
            cookie.setPath(path);
            response.addCookie(cookie);
        }
    }

    /**
     * 쿠키삭제
     * @param response
     * @param cookie
     * @param path
     */
    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, Cookie cookie) {
        if (cookie != null) {
            String contextPath = request.getContextPath();
            if (!contextPath.endsWith("/")) {
                contextPath += "/";
            }
            cookie.setMaxAge(0);
            cookie.setPath(contextPath);
            response.addCookie(cookie);
        }
    }
}