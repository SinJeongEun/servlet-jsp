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

@WebServlet(name="exam07.RemoveSessionController", urlPatterns="/exam07/RemoveSessionController")
public class RemoveSessionController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 객체 가져오기
		HttpSession session = request.getSession();
		
		// 세션에 저장된 데이터 삭제하기
		session.removeAttribute("loginId");
		session.removeAttribute("cart");
		
		// 세션 객체 자체!! 를 삭제한다. (잘 사용되지는 않는다., 삭제되더라고, 클라이언트가 요청하면 자동으로 다시 생성해준다.)
//		session.invalidate();
		response.sendRedirect("ContentController");
	}

}
