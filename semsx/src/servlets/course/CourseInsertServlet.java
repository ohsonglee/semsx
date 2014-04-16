package servlets.course;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.CourseVo;
import dao.CourseDao;

@WebServlet("/course/insert.bit")
@SuppressWarnings("serial")
public class CourseInsertServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    doGet(request, response);
	}
	
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		// POST 요청의 값에 대해 적용. GET 요청의 값은?
		// - 서블릿 컨테이너의 안내에 따라 설정한다.
		// - getParameter()를 호출하기 전에 실행해야 한다.
		//   단, 한번이라도 getParameter()를 호출했다면 적용안됨. 
		
		//CharacterEncodingFilter로 대체함
		//request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>수업등록</title></head><body>");
		
		try {
			out.println("<h1>수업 등록 결과</h1>");
			
			CourseDao dao = (CourseDao)this.getServletContext()
					.getAttribute("CourseDao");
			
			CourseVo vo = new CourseVo();
			vo.setTitle(request.getParameter("title"));
			vo.setDescription(request.getParameter("description"));
			vo.setHours(Integer.parseInt(request.getParameter("hours")));
			
			dao.insert(vo);
			
			out.println("등록 성공!");
			response.setHeader("Refresh", "1;url=list.bit?pageNo=1&pageSize=10");
			
		} catch (Throwable e) {
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}
















