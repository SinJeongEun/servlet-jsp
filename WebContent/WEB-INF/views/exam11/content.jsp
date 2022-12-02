<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
   <div class="card-header">
      content.jsp 11
   </div>
   <div class="card-body">
      1. ${5} <br/>
      2. ${"홍길동" } <br/>
      3. ${2+5 } <br/>
      4. ${2>5 } <br/>
      <hr/>
      <h4 class="mt-3">>Request 범위에 저장된 값 출력</h4>
      
      
      <h4 class="mt-3">Session 범위에 저장된 값 출력</h4>
       
       
       <h4 class="mt-3">ServletContext 범위에 저장된 값 출력</h4>
    </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>