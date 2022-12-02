package servlet.exam10;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="exam10.NoExceptionHandlingController", urlPatterns="/exam10/NoExceptionHandlingController")
public class NoExceptionHandlingController extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         String data = "1oo";
         int num = Integer.parseInt(data); // 이 과정에서 요류 발생 -> 500 Error
         response.sendRedirect("ContentController");

         request.getRequestDispatcher("/WEB-INF/views/exam10/content.jsp").forward(request, response);           
   }
   
}