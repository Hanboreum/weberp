<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix ="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <script src = "${cpath}/resources/js/list.js"></script>
  <script >
    bookList(); // 호출
  </script>
</head>
<body>

<div class="container mt-3">
  <h2>Spring MVC Framework</h2>
  <div class="card">
    <div class="card-header ">

   <c:if test="${empty dbmem}">
  <form class="form-inline" action="${cpath}/login" method="post">
    <label for="username">아이디:</label>
    <input type="text" class="form-control" placeholder="Enter username" id="username" name="username">
    <label for="password">패스워드:</label>
    <input type="password" class="form-control" placeholder="Enter password" id="password" name="password">
    <button type="submit" class="btn btn-primary btn-sm">로그인</button>
  </form>
   </c:if>

   <c:if test="${!empty dbmem}">
    <form class="form-inline" action="${cpath}/logout" method="post">
        <label>welcome! ${dbmem.name} 방문을 환영합니다. </label>
         <button type="submit" class="btn btn-primary btn-sm">로그아웃</button>
      </form>
   </c:if>

    </div>
    <div class="card-body"> 책 목록 </div>

    <h5>book list</h5>
    <table class = "table table-striped table-bordered table-hover">
        <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>가격</th>
            <th>저자</th>
            <th>페이지</th>
            <th>삭제</th>
        </tr>
        </thead>
        <tbody id ="tbody">
        <!-- restcontrollerd엥서 가져온 책 리스트 출력-->
        </tbody>
    </table>
   <button class="btn btn-sm btn-primary" onclick="location.href='${cpath}/restregister'">등록</button>
    <div class="card-footer">패스트캠퍼스 부트캠프 8기_한보름</div>
  </div>
</div>

</body>
</html>
