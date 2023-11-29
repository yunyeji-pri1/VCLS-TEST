<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div>
<!-- 		<script src="/style/vendor_components/moment/moment.js"></script> -->

  		<tiles:insertAttribute name="header" />
	  	<tiles:insertAttribute name="body"/>
  		<tiles:insertAttribute name="slide"/>
 	</div>
</body>
</html>