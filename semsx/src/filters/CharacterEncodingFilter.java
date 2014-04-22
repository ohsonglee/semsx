package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/* 클라이언트가 보낸 데이터가 어떤 문자 집합으로 되어 있는지 설정하는 필터
 *	- chain of responsibility 패턴을 적용한 것임.
 *	- 특징: 임의로 기능을 추가하고 뺄 수 있다. 
 */
public class CharacterEncodingFilter implements Filter {
	
	FilterConfig config;
	final String defaultCharSet = "UTF-8";

	/* 필터 생성 시 호출됨 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain next) throws IOException, ServletException {
		
		// 1) service() 호출 전 작업
		// 클라이언트에서 넘어오는 데이터를 서블릿에게 알려주지 않으면
		// 서버에서는 클라이언트에서 넘어오는 데이터가 무조건 영어라고 생각하고 처리하게 된다.
		// 이게 다시 DB로 들어가면 깨진 글자가 들어가게 된다.
		// 그래서 반드시 이걸 잘 맞춰줘야 한다.(우리는 한글이니까 UTF-8로 맞춤)
		String charset = config.getInitParameter("charset");
		if (charset != null) {
			request.setCharacterEncoding(charset);
		} else {
			request.setCharacterEncoding(defaultCharSet);
		}
		
		// 최종적으로 서블릿의 service()가 호출된다.
		next.doFilter(request, response);
		
		// 2) 서블릿의 서비스 호출 후 수행할 작업
	}

	/* 웹 애플리케이션 종료 시 호출됨 */
	@Override
	public void destroy() {

	}

}
