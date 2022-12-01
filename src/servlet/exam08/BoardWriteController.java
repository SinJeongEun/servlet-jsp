package servlet.exam08;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import service.BoardService;

@WebServlet(name="exam08.BoardWriteController", urlPatterns="/exam08/BoardWriteController")
public class BoardWriteController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/exam08/writeForm.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 클라이언트가 보낸 요청 얻기
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		Board board = new Board();
		board.setBtitle(btitle);
		board.setBcontent(bcontent);
		
		// 서비스 통해 회원 가입 요청하기
		ServletContext application = request.getServletContext();
		// ServletContext 에 저장된 서비스를 가져와서 사용한다
		BoardService boardService = (BoardService) application.getAttribute("boardService");
		boardService.write(board); 
		
		response.sendRedirect("ContentController");
	}
	
}
