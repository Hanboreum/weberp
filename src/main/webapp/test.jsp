<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix ="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var = "cpath" value="%${pageContext.request.contextPath}"/>
<c:set var="sum" value ="11"/>



<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <a href ="${cpath}/hello"> 경로이동 </a>
    <h2>hello Java Spring Han</h2>
    http://localhost:8081/weberp/test.jsp<br/>

    <c:forEach var ="i" begin="1" end="10" step="1">
     <c:if test="${i % 2 == 0}">
        ${i}<br/>
     </c:if>
    </c:forEach>
    ${sum} <br/>
    <c:choose>
        <c:when test="${sum %2 ==0}">
            짝수입니다.
        </c:when>
        <c:otherwise>
        홀수입니다.
        </c:otherwise>
    </c:choose>

</body>
</html>