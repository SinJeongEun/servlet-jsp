<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ page import="java.util.*, dto.*" %>

      <div class="card">
         <div class="card-header">exam01.jsp</div>
         <div class="card-body">
            <%List<Board> boards = new ArrayList<>(); %>
            <%for(int i=1; i<=10; i++){
               Board board = new Board();
               board.setBno(i);
               board.setBtitle("제목" + i);
               board.setBcontent("내용" + i);
               board.setBwriter("홍길동");
               board.setBdate(new Date());
               boards.add(board);
            } %>
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
                  <%for (Board board : boards) { %>
                     <tr>
                        <td><%=board.getBno() %></td>
                        <td><%=board.getBtitle() %></td>
                        <td><%=board.getBcontent() %></td>
                        <td><%=board.getBwriter() %></td>
                        <td><%=board.getBdate() %></td>
                     </tr>
                  <%} %>
               </tbody>
            </table>
         </div>
      </div>
   <%@ include file="/WEB-INF/views/common/footer.jsp" %>