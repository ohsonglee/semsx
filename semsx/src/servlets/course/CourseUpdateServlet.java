package servlets.course;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.CourseVo;
import dao.CourseDao;

@WebServlet("/course/update.bit")
@SuppressWarnings("serial")
public class CourseUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int no=Integer.parseInt(request.getParameter("no"));
			CourseDao dao = (CourseDao)this.getServletContext()
					.getAttribute("CourseDao");
			
			CourseVo course = dao.detail(no);

			request.setAttribute("course", course);
			
			RequestDispatcher rd = request.getRequestDispatcher("/course/update.jsp");
			rd.forward(request, response);

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}


	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		try {

			CourseDao dao = (CourseDao)this.getServletContext()
					.getAttribute("CourseDao");

			CourseVo course = new CourseVo();
			course.setNo(Integer.parseInt(request.getParameter("no")));
			course.setTitle(request.getParameter("title"));
			course.setDescription(request.getParameter("description"));
			course.setHours(Integer.parseInt(request.getParameter("hours")));

			dao.update(course);

			response.sendRedirect("detail.bit?no="+ course.getNo());

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
















