<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <!--??????????list-->
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

demo1
    <!--a没钱，可以让b本人去取了钱后帮a付钱(a、b在此协商<通过隐藏的iframe让a和b在这里交汇>)，
	利用demo1登陆成功的一瞬间把demo2的cookie也写一写！  利用隐藏框架存储cookie -->
    <c:forEach var="url" items="${hiddenUrl}">  <!--遍历 hiddenUrl集合  -->
        <iframe src="${url}" width="0px" height="0px" style="display: none"></iframe><!--让子项都在iframe里面run  -->
    </c:forEach>
</body>
</html>
