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
      <h5 class="mt-3">Request -> Session -> ServletContext 범위에 저장된 값 출력</h5>
      ${user.userId }
      ${user.userName }
      <br/>
      ${board.bno },
      ${board.btitle },
      ${board.bcontent }
      <br/>
      ${info }
    </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>