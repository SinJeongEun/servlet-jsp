package servlet.exam11;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.spi.protocol.RequestDispatcherRegistry;

import dto.Board;
import dto.User;

@WebServlet(name="exam11.ContentController", urlPatterns="/exam11/ContentController")
public class ContentController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setUserId("winter");
		user.setUserName("홍길동");
		
		Board board = new Board();
		board.setBno(1);
		board.setBtitle("금요일");
		board.setBcontent("6시 퇴근 원츄 ~");
		
		//request 범위
		request.setAttribute("user", user);
		
		//session 범위
		request.getSession().setAttribute("board", board);
		
		//servletContext 범위
		request.getServletContext().setAttribute("info", "Servlet/JSP 학습용 어플리케이션");
		
		request.getRequestDispatcher("/WEB-INF/views/exam11/content.jsp").forward(request, response);
	}
	
}
