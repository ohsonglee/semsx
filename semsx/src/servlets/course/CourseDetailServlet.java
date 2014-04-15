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

@WebServlet("/course/detail.bit")
@SuppressWarnings("serial")
public class CourseDetailServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>강의상세정보</title></head><body>");
		try {
			out.println("<h1 style=color:#5fb636>강의 상세정보</h1>");
			
			CourseDao dao = (CourseDao)this.getServletContext()
					.getAttribute("CourseDao");
			
			int no = Integer.parseInt(request.getParameter("no")); 
			
			CourseVo course = dao.detail(no);
			
			out.println("<table cellpadding='4' border='1'>");
			out.println("<tr>");
			out.println("	<th style='background-color:red;'>번호</th>");
			out.println("	<td style='background-color:lightyellow;color:blue'>" + course.getNo() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("	<th style='background-color:red;'>수업명</th>");
			out.println("	<td style='background-color:lightyellow;color:blue'>" + course.getTitle() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("	<th style='background-color:red;'>수업내용</th>");
			out.println(" <td style='background-color:lightyellow;color:blue'><textarea rows='5' cols='60' style='background-color:lightyellow;color:blue'>"
					+ course.getDescription()
					+ "</textarea></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("	<th style='background-color:red;'>수업시간</th>");
			out.println("	<td style='background-color:lightyellow;color:blue'>" + course.getHours() + "</td>");
			out.println("</tr>");
			
			
			out.println("</table>");
		} catch (Throwable e) {
			out.println("<div  style=color:red>오류 발생 했음!</div>");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}
















