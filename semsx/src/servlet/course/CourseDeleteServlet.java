package servlet.course;

import java.io.IOException;

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
		try {
			CourseDao dao = 	(CourseDao)this.getServletContext()
					.getAttribute("CourseDao");

			int no = Integer.parseInt(request.getParameter("no"));

			dao.delete(no);
			response.sendRedirect("list.bit?pageNo=1&pageSize=10");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
