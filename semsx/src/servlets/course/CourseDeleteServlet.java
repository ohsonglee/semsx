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
		out.println("<html><head><title>강의삭제</title></head></body>");

		try {
			out.println("<h1 style=color:#5fb636>강의 삭제 결과</h1>");
			
			CourseDao dao = 	(CourseDao)this.getServletContext()
					.getAttribute("CourseDao");

			int no = Integer.parseInt(request.getParameter("no"));

			int result = dao.delete(no);
			if (result > 0)
				out.println("<div style=color:green>삭제 성공!</div>");
			else 
				out.println("<div style=color:red>삭제 실패!</div>");
		} catch (Throwable e) {
			out.println("<div style=color:red>오류 발생 했음!</div>");
		}
		out.println("</body></html>");
	}
}
