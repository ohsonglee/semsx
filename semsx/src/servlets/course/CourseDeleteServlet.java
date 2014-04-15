package servlets.course;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDao;

@WebServlet("/course/delete.bit")
@SuppressWarnings("serial")
public class CourseDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>과목삭제정보</title></head></body>");

		try {
			out.println("<h1>수업삭제 결과</h1>");
			
			CourseDao dao = 	(CourseDao)this.getServletContext()
					.getAttribute("CourseDao");

			int no = Integer.parseInt(request.getParameter("no"));

			dao.delete(no);
			out.println("삭제 성공!");
		} catch (Throwable e) {
			out.println("오류발생!");
		}
		out.println("</body></html>");
	}
}
