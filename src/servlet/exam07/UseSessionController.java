package servlet.exam07;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="exam07.UseSessionController", urlPatterns="/exam07/UseSessionController")
public class UseSessionController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 객체 가져오기
		HttpSession session = request.getSession();
		
		// 세션에 저장된 데이터 (객체) 가져오기
		String loginId = session.getAttribute("loginId").toString();
		Date loginDate = (Date) session.getAttribute("loginDate");
		System.out.println("loginId : " + loginId);
		System.out.println("loginDate : " + loginDate);
		
		List<String> cart = (List<String>) session.getAttribute("cart");
		int index = 0;
		if(cart != null) {
			for(String pname : cart) {
				System.out.println(index + "  " + pname);
				++index;
			}			
		}
		
		response.sendRedirect("ContentController");
	}

}
