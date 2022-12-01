package servlet.exam08;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.apache.tomcat.util.buf.UEncoder;

import dto.User;
import service.UserService;

@WebServlet(name="exam08.UserJoinController", urlPatterns="/exam08/UserJoinController")
public class UserJoinController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/exam08/joinForm.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 클라이언트가 보낸 요청 얻기
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
//		int userAge = Integer.parseInt(request.getParameter("userAge"));
//		String userEmail = request.getParameter("userEmail");
		
		User user = new User();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setUserPassword(userPwd);
		
		// 서비스 통해 회원 가입 요청하기
		ServletContext application = request.getServletContext();
		// ServletContext 에 저장된 서비스를 가져와서 사용한다
		UserService userService = (UserService) application.getAttribute("userService");
		userService.join(user); 
		
		response.sendRedirect("ContentController");
	}
	
}
