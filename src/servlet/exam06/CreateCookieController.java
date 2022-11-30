package servlet.exam06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="exam06.CreateCookieController", urlPatterns="/exam06/CreateCookieController")
public class CreateCookieController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 쿠키 생성
		Cookie cookie1 = new Cookie("useremail", "winter@mycompany.com");
//		cookie1.setDomain("localhost"); // 해당 도메인으로 갈때만 쿠키를 전달한다.
//		cookie1.setPath("/"); 			// 해당 결로로 요청할때만 쿠키를 전달한다.
//		cookie1.setMaxAge(10);			// 쿠키의 유지 기잔을 설정하여 브라우저의 파일 시스템에 저장한다
//		cookie1.setHttpOnly(true); 		// java script 코드로 cookie 읽는 코드 무력화 시키기
//		cookie1.setSecure(true); 		// https 에서만 쿠키를 전달한다는 의미
		
		// 쿠키를  HTTP 응답 헤더에 추가하기                                  
		response.addCookie(cookie1);
		
		Cookie cookie2 = new Cookie("userid", "winter");
		response.addCookie(cookie2);
		
		response.sendRedirect("ContentController");
	}
	
}
