package servlet.course;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.CourseVo;
import dao.CourseDao;
/*
 * Vies(JSP) 적용
 *  -  이 클래스가 하던 일 중에서 출력 부분을 JSP가 함
 * - 
 */
@WebServlet("/course/list.bit")
@SuppressWarnings("serial")
public class CourseListServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		try {
			CourseDao dao = (CourseDao)this.getServletContext()
																							.getAttribute("CourseDao");
			
			int pageNo = Integer.parseInt(request.getParameter("pageNo")); 
			int pageSize = Integer.parseInt(request.getParameter("pageSize")); 
			
			List<CourseVo> list = dao.list(pageNo, pageSize);
			
			//ServletRequest보관소에 DAO 리턴 결과를 보관한다.
			//JSP가 사용할 수 있도록.
			request.setAttribute("list", list);
			
			//JSP에 실행을 위임하기 => getRequestDispatcher 를 얻는다. 
			// - 파라미터 값은 반드시 현재 컨텍스트(웹어플리케이션)를 기준으로 할 것
			RequestDispatcher rd = request.getRequestDispatcher("/course/list.jsp");
			rd.forward(request, response);
			
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
















