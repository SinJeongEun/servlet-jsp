package context;

import javax.sql.DataSource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dao.BoardDao;
import dao.UserDao;
import service.BoardService;
import service.UserService;


public class WebAppContext implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Web Application이 배치 완료 됨, ServletContext 가 생성 완료 됨");
		
		// Servlet Context 객체  얻기
		ServletContext application = sce.getServletContext();
		
		// ConnectionPool 객체 얻기
		DataSource dataSource = ConnectionProvider.getDataSource();
		application.setAttribute("dataSource", dataSource );
		
		
		// Servlet Context 객체에 데이터(객체) 저장하기 , 모든 쿨라이언트들이 사용 가능한 공유 객체가 된다.
		application.setAttribute("boardDao", new BoardDao());
		application.setAttribute("userDao", new UserDao());
		
		application.setAttribute("userService", new UserService(application));
		application.setAttribute("boardService", new BoardService(application));
		
	}
}
