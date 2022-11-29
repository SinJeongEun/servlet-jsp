package servlet.exam04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="exam04.HtmlResponseController", urlPatterns="/exam04/HtmlResponseController")
public class HtmlResponseController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//		
//		// byte 기반 스트림
//		ServletOutputStream sos = response.getOutputStream();
//		
//		// 문자 기반 
//		PrintWriter pw = response.getWriter();
//		pw.write("<! DOCTYPE html>");
//		pw.write("<html>");
//		pw.write("<body>");
//		pw.write("<h4> Title </h4>");
//		pw.write("<hr/>");
//		pw.write("</body>");
//		pw.write("/html>");
//		
//		pw.flush();
//		pw.close();
		
		request.getRequestDispatcher("/WEB-INF/views/exam04/html.jsp").forward(request, response);
	}
}
