package servlets.subject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.SubjectVo;
import dao.SubjectDao;

@WebServlet("/subject/insert.bit")
@SuppressWarnings("serial")
public class SubjectInsertServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		// POST 요청의 값에 대해 적용. GET 요청의 값은?
		//  - 서블릿 컨테이너의 안내에 따라 설정한다.
		//	- getParameter()를 호출하기 전에 실행해야 한다.
		//	- 단, 한번이라도 getParameter()를 호출했다면 적용 안됨.
		
		// CharsetEncodingFilter로 대체함
		//request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>과목등록</title></head><body>");
		
		try {
			out.println("<h1>과목 등록결과</h1>");
			
			SubjectDao dao = (SubjectDao)this.getServletContext().getAttribute("subjectDao");
			
			SubjectVo vo = new SubjectVo();
			vo.setTitle(request.getParameter("title"));
			vo.setDescription(request.getParameter("description"));

			dao.insert(vo);

			out.println("등록 성공");
			
			// out.println()이 버퍼에 저장되고 함수가 끝나면 flush 되기에 아래에 
			// setHeader()를 설정해도 된다.
			response.setHeader("Refresh", "1;url=list.bit?pageNo=1&pageSize=10");

		} catch (Throwable e) {
			out.println("오류 발생 했음.");
			e.printStackTrace();
		}
		
		out.println("</body></html>");
		
	}
	
}
