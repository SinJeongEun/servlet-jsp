package servlet.exam12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import dto.User;

@WebServlet(name="exam12.ContentController", urlPatterns="/exam12/ContentController")
public class ContentController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setUserId("summer");
		user.setUserName("홍길동");
		
		List<Board> list = new ArrayList<>();
		for(int i=1; i<12;i++) {
			Board board = new Board();
			board.setBno(i);
			board.setBtitle("제목 " + i);
			board.setBcontent("내용 " + i);	
			board.setBwriter("winter");
			board.setBdate(new Date());
			
			list.add(board);
		}
		
		request.getSession().setAttribute("loginUser", user);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/views/exam12/content.jsp").forward(request, response);
	}
	
}
