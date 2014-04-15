package servlets.course;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.CourseVo;
import dao.CourseDao;

@WebServlet("/course/list.bit")
@SuppressWarnings("serial")
public class CourseListServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>강의목록</title></head><body>");
		//out.println("<body style="width:320px; height: 100px; overflow:auto">");
		
		try {
			out.println("<h1 style=color:#5fb636>강의 목록</h1>");
			
			CourseDao dao = (CourseDao)this.getServletContext()
																							.getAttribute("CourseDao");
			
			int pageNo = Integer.parseInt(request.getParameter("pageNo")); 
			int pageSize = Integer.parseInt(request.getParameter("pageSize")); 
			
			List<CourseVo> list = dao.list(pageNo, pageSize);
			
		
			out.println("<table cellpadding='4' border='1'>");
			out.println("<tr style='background-color:red;'>");
			out.println("	<th>번호</th>");
			out.println("	<th>수업명</th>");
			out.println("</tr>");
			
			for (CourseVo course : list) {
				out.println("<tr style='background-color:lightyellow;color:blue'>");
				out.println("	<td>" + course.getNo() + "</td>");
				out.println("	<td>" + course.getTitle() + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		} catch (Throwable e) {
			out.println("<div style=color:red>오류 발생 했음!</div>");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}
















