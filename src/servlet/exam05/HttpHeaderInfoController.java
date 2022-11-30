package servlet.exam05;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

@WebServlet(name="exam05.HttpHeaderInfoController", urlPatterns="/exam05/HttpHeaderInfoController")
public class HttpHeaderInfoController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 시작행 정보 얻기
		String method = request.getMethod();
		System.out.println("요청 방식 : " + method);
		
		String requestURL = request.getRequestURL().toString();
		System.out.println("request URL : " + requestURL);
		
		String requestURI = request.getRequestURI();
		System.out.println("request URI : " + requestURI);
		
		String contextPath = request.getContextPath();
		System.out.println("context path : " + contextPath);
		
		// 요청 경로 uri 뒤에 ? 이후의 값들 : query string
		String queryString = request.getQueryString();
		System.out.println("query string : " + queryString);
		
		
		// 헤더행 정보 얻기
		String userAgent = request.getHeader("User-Agent");
		System.out.println("User-Agent : " + userAgent);
		
		// 클라이언트의 ip 정보 얻기
		String clientIp = request.getRemoteAddr();
		System.out.println("client ip : " + clientIp);
		
		response.sendRedirect("ContentController");
	}

}
