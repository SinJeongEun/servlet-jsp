<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
   <div class="card-header">
      content.jsp 22
   </div>
   <div class="card-body">
      <a  href="${pageContext.request.contextPath}/exam10/ExceptionHandlingController" class="btn btn-info btn-sm">예외처리(try-catch)</a>
	  <a  href="${pageContext.request.contextPath}/exam10/NoExceptionHandlingController" class="btn btn-info btn-sm">예외처리(web.xml)</a> 
   </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>