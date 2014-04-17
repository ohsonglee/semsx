package servlets.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.UsersVo;
import dao.UsersDao;

@WebServlet("/user/insert.bit")
@SuppressWarnings("serial")
public class UserInsertServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		try {
			
			UsersDao dao = (UsersDao)this.getServletContext().getAttribute("UsersDao");
			
			UsersVo vo = new UsersVo();
			vo.setName(request.getParameter("name"));
			vo.setEmail(request.getParameter("email"));
			vo.setPassword(request.getParameter("password"));
			vo.setTel(request.getParameter("tel"));
			vo.setFax(request.getParameter("fax"));
			vo.setPostNo(request.getParameter("postNo"));
			vo.setAddr(request.getParameter("addr"));
//		vo.setPhot(request.getParameter("photo"));

			dao.insert(vo);

			RequestDispatcher rd = request.getRequestDispatcher("/course/insert.jsp");
			rd.forward(request, response);

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
