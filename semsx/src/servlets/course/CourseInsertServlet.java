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
		
		
		try {
			CourseDao dao = (CourseDao)this.getServletContext()
					.getAttribute("CourseDao");
			
			CourseVo course = new CourseVo();
			course.setTitle(request.getParameter("title"));
			course.setDescription(request.getParameter("description"));
			course.setHours(Integer.parseInt(request.getParameter("hours")));
			
			dao.insert(course);
			
			RequestDispatcher rd = request.getRequestDispatcher("/course/insert.jsp");
			rd.forward(request, response);
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
















