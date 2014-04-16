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
			out.println("<h1>강의 상세정보</h1>");
			
			CourseDao dao = (CourseDao)this.getServletContext()
					.getAttribute("CourseDao");
			
			int no = Integer.parseInt(request.getParameter("no")); 
			
			CourseVo course = dao.detail(no);
			
			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("	<th>번호</th>");
			out.println("	<td>" + course.getNo() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("	<th>수업명</th>");
			out.println("	<td>" + course.getTitle() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("	<th>수업내용</th>");
			out.println(" <td><textarea rows='5' cols='60'>"
					+ course.getDescription()
					+ "</textarea></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("	<th>수업시간</th>");
			out.println("	<td>" + course.getHours() + "</td>");
			out.println("</tr>");
			
			
			out.println("</table>");
			out.println("<a href='list.bit?pageNo=1&pageSize=10'>목록</a>");
			out.println("<a href='delete.bit?no="
					+  course.getNo() 
					+ "'>삭제</a>");
			
			out.println("<a href='update.bit?no="
					+  course.getNo() 
					+ " '>변경</a><br>");
			
		} catch (Throwable e) {
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}
















