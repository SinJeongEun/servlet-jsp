package servlet.exam04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet(name="exam04.JsonResponseController", urlPatterns="/exam04/JsonResponseController")
public class JsonResponseController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8"); // 응답이 json 타입이다라는 의미 한글 깨짐현상 방지를 위한 chartset 설정
		
		// {"bnon":1, "btitle": "java", "bcontent:"프로그래밍 언어"}
		JSONObject root = new JSONObject();
		root.put("bno", 1);
		root.put("btitle", "java");
		root.put("bcontent", "프로그래밍 언어");

		PrintWriter pw = response.getWriter();
		pw.println(root.toString());
		pw.flush();
		pw.close();
		
		request.getRequestDispatcher("/WEB-INF/views/exam04/html.jsp").forward(request, response);
	}
}
