package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{
	private String encoding;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		if(filterConfig.getInitParameter("encoding") != null) {
			encoding = filterConfig.getInitParameter("encoding");
		} else encoding = "UTF-8";
		
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		// 전처리-----------------------
		System.out.println("전처리1 합니다");
		request.setCharacterEncoding(encoding);
		//------------------------------
		
		// 다음 필터나 서블릿으로 이동시키는 doFilter 메소드 호출 / doFilter() 전 후로 전처리 후처리가 된다.
		filterChain.doFilter(request, response); 

		// 후처리
		System.out.println("후처리1 합니다");
	}

}
