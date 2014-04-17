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
/*
 * 과목명에 상세보기 링크 추가
 * 
 */
@WebServlet("/course/list.bit")
@SuppressWarnings("serial")
public class CourseListServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>강의목록</title>"
				+ "<LINK href='/semsx/user/css.css' rel='stylesheet' type='text/css'>"
				+ "</head><body>");
		
		try {
			out.println("<h1 >강의 목록</h1>");
			
			CourseDao dao = (CourseDao)this.getServletContext()
																							.getAttribute("CourseDao");
			
			int pageNo = Integer.parseInt(request.getParameter("pageNo")); 
			int pageSize = Integer.parseInt(request.getParameter("pageSize")); 
			
			List<CourseVo> list = dao.list(pageNo, pageSize);
			
			out.println("<a href='course.html'>새강좌 등록</a><br>");
			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("	<th>번호</th>");
			out.println("	<th>수업명</th>");
			out.println("</tr>");
			
			for (CourseVo course : list) {
				out.println("<tr>");
				out.println("	<td>" + course.getNo() + "</td>");
				out.println("	<td><a href ='detail.bit?no="
						+ course.getNo() 
						+ " '>"  + course.getTitle() + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		} catch (Throwable e) {
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}
















