<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
   <div class="card-header">
      content.jsp
   </div>
   <div class="card-body">
      <a href="/servletjsp/exam06/CreateCookieController" class="btn btn-warning btn-sm">쿠키 생성 및 설정</a>
      <a href="/servletjsp/exam06/UseCookieController" class="btn btn-warning btn-sm">쿠키 사용</a>
      
      <hr/>
      <button class="btn btn-info btn-sm" onclick="readCookie()"></button>
      <script>
      	function readCookie() {
			console.log(document.cookie);
		}
      </script>
   </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>