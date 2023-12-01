<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<h2>로그인 화면 </h2>
<form class="form-signin" action="/login" method="post" >

    <input type="text" id="" name="id" class="form-control" placeholder="아이디" autofocus="" />
    <input type="text" id="" name="password" class="form-control" placeholder="비밀번호" />

    <div class="etc">
        <c:if test="${!empty errorMsg}">
            <c:choose>
                <c:when test="${errorMsg eq 'TOKEN_EXPIRED'}">
                    <p class="ft-color__red ft-i__15 mt10">Your account token has expired. Please contact your administrator.</p>
                </c:when>
                <c:when test="${errorMsg eq 'USER_NOT_FOUND'}">
                    <p class="ft-color__red ft-i__15 mt10">is not exist.</p>
                </c:when>
                <c:when test="${errorMsg eq 'Bad_credentials'}">
                    <p class="ft-color__red ft-i__15 mt10">아이디 또는 비밀번호를 잘못 입력했습니다. 입력하신 내용을 다시 확인해주세요.</p>
                </c:when>
                <c:when test="${errorMsg eq 'denied'}">
                    <p class="ft-color__red ft-i__15 mt10">You do not have access permission.</p>
                </c:when>
                <c:otherwise>
                    <p class="ft-color__red ft-i__15 mt10">An error occurred. Please try again.</p>
                </c:otherwise>
            </c:choose>
        </c:if>
    </div>

    <button type="submit" type="submit" class="btn btn-secondary active"  id=""/>



</form>