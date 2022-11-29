package servlet.exam03;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentController extends HttpServlet {
	private String encoding;
	private String viewLocation;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println(config.getInitParameter("encoding"));
		System.out.println(config.getInitParameter("viewLocation"));
		
		if(config.getInitParameter("encoding") == null) {
			encoding = "UTF-8";
		} else {
			encoding = config.getInitParameter("encoding");
		}
		
		if(config.getInitParameter("viewLocation") == null) {
			viewLocation = "/WEB-INF/views";
		} else {
			viewLocation = config.getInitParameter("viewLocation");
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/exam03/content.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post 실행 ~~ ");
		
		request.setCharacterEncoding(encoding);
		
		request.getRequestDispatcher(viewLocation + "/exam03/content.jsp").forward(request, response);
		 
		String param1 = request.getParameter("param1");
		System.out.println("param1 : " + param1);
	}
}
