package servlet.exam02;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "exam02.ContentController", urlPatterns = "/exam02/ContentController")
public class ContentController extends HttpServlet {
	
	// 서블릿 객체가 생성한 후 한번만 호출된다.
	// 서블릿 객체의 초기화 작업
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 서블릿 객체 초기화 코드
		System.out.println("exam02.ContentController.init()   시작");
	}
	
	// 쿨라이언트가 요청할 때 마다 콜백
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/exam02/content.jsp").forward(request, response);;
	}

	
	// 클라이언트가 GET 방식으로 호출할 때 마다 출력
	// 요청 처리
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/exam02/get.jsp").forward(request, response);;
	}
	
	
	// 클라이언트가 POST 방식으로 요청할 때 마다 출력한다.
	// 요청 처리
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/exam02/post.jsp").forward(request, response);;
	}
}
