package servlet.exam04;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.File;
import org.json.JSONObject;

@WebServlet(name="exam04.FileResponseController", urlPatterns="/exam04/FileResponseController")
public class FileResponseController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = "사진1.jpg";
		String filePath = "C:/Temp/사진1.jpg";
		String contentType = "image/jpeg";
		
		// http 응답의 Content-type 헤더를 추가
		response.setContentType(contentType);
			// 위와 동일한 설정이다
			// response.setHeader("Content-type", contentType);
		
		// http 요청을 통해 사용자의 browser 종류 얻기
		String userAgent = request.getHeader("User-Agent");
		if(userAgent.contains("Trident") || userAgent.contains("MSIE")) {// 이 경우는 인터넷 익스플로어일 경우이다.
			fileName = URLEncoder.encode(fileName, "UTF-8");
			
		} else { // chrome, Edge, FireFox, Safari 일 경우
			fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}
			
		System.out.println(fileName);
		
		// http 응답의 Content-Disposition 헤더 추가
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		
		// http 응답 본문에 파일 데이터 출력하기
		ServletOutputStream sos = response.getOutputStream();
		
//		방법 1
//		FileInputStream fis = new FileInputStream(filePath);
//		
//		byte[] data = new byte[1024];
//		while(true) {
//			int readByteNum = fis.read(data);
//			if(readByteNum == -1) break;
//			sos.write(data, 0, readByteNum);
//		}
//		
//		sos.flush();
//		fis.close();
//		sos.close();
		
		
//		방법 2
		Path path = Paths.get(filePath);
		Files.copy(path, sos);
		sos.flush();
		
		
		
		
//		request.getRequestDispatcher("/WEB-INF/views/exam04/html.jsp").forward(request, response);
	}
}
