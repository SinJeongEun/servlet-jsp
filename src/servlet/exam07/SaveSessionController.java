package servlet.exam07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="exam07.SaveSessionController", urlPatterns="/exam07/SaveSessionController")
public class SaveSessionController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/exam07/loginForm.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		System.out.println("userId : " + userId);
		System.out.println("userPwd : " + userPwd);
		
		
		 if(userId.equals("winter") && userPwd.equals("12345")) {
			 // 세션 가져오기
			 HttpSession session = request.getSession();
			 // 세션에 데이터를 저장
			 session.setAttribute("loginId", userId);
			 session.setAttribute("loginDate", new Date());
			 
			 // 세션을 사용한 장바구니 담기 예제
			 List<String> cart = new ArrayList<>();
			 session.setAttribute("cart", cart);
			 
			 
			 response.sendRedirect("ContentController");
		  	} else {
		     request.getRequestDispatcher("/WEB-INF/views/exam07/loginForm.jsp");
	      }
		 
	   }
	   
	


}
