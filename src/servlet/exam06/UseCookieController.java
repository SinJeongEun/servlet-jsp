package servlet.exam06;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="exam06.UseCookieController", urlPatterns="/exam06/UseCookieController")
public class UseCookieController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookies[] = request.getCookies(); // 클라이언트가 보낸 쿠키들 읽기
		
		for(Cookie cookie : cookies) {
			String name = cookie.getName(); // 쿠키 이름 익기
			
			if(name.equals("useremail")) {
				String value = cookie.getValue();		 // 쿠키 값 읽기	
				
				System.out.println("user email : " + value);
				
				request.setAttribute("useremail", value); // jsp 에서 읽도록 코드 작성
			}
			
			else if(name.equals("userid")) {
				request.setAttribute("userid", cookie.getValue());
			}
		}
		request.getRequestDispatcher("/WEB-INF/views/exam06/useCookie.jsp").forward(request, response);
	}
	
}
