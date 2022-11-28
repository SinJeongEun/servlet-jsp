<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, dto.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

      <div class="card">
         <div class="card-header">boardList.jsp</div>
         <div class="card-body">
            <table class="table table-bordered">
               <!-- 테이블 헤드 -->
               <thead>
                  <tr>
                     <th>번호</th>
                     <th>제목</th>
                     <th>내용</th>
                     <th>글쓴이</th>
                  </tr>
               </thead>
               <!-- 테이블 바디 -->
               <tbody>
                  <c:forEach var="board" items="${boards}">
                     <tr>
                        <td>${board.bno}</td>
                        <td>${board.btitle}</td>
                        <td>${board.bcontent}</td>
                        <td>${board.bwriter}</td>
                        <td>${board.bdate}</td>
                     </tr>
                  </c:forEach>
               </tbody>
            </table>
         </div>
      </div>
  <%@ include file="/WEB-INF/views/common/footer.jsp" %>