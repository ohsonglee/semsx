package servlets.subject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SubjectDao;

/* Refresh
 * 	- 일정 시간 후 서버에 지정된 URL을 요청하게 만듬.
 * 	1) 응답 헤더에 리프래시 정보 심기
 * 	2) HTML 헤더에 리플래시 정보 심기
 * 
 * Redirect
 * 	- 클라이언트에게 다시 요청할 주소를 알려줌.
 * 	- 경과 시간 지정불가.
 * 	- 콘텐츠를 보내지 않는다는 장점!
 */

@WebServlet("/subject/delete.bit")
@SuppressWarnings("serial")
public class SubjectDeleteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		// CharsetEncodingFilter로 대체함
		//request.setCharacterEncoding("UTF-8");
		
		// 1) 응답 헤더에 리프래시 명령어 심기 
		//response.setHeader("Refresh", "1;url=list.bit?pageNo=1&pageSize=10");
		
		// 2) 응답 내용에 Refresh 명령어 심기
		//out.println("meta http-equiv='Refresh'"
		//		+ " content='1;url=list.bit?pageNo=1&pageSize-10'>"); // 자동 지뢰
		
		try {
			SubjectDao dao = (SubjectDao)this.getServletContext().getAttribute("subjectDao");
			
			int no = Integer.parseInt(request.getParameter("no"));
			
			dao.delete(no);

			// 3. Redirect 처리
			//	- 콘텐츠를 출력하지 않기 때문에 => 이전에 출력은 취소된다.
			response.sendRedirect("list.bit?pageNo=1&pageSize=10");

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
