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

@WebServlet("/user/update.bit")
@SuppressWarnings("serial")
public class UsersUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int no=Integer.parseInt(request.getParameter("no"));
			UsersDao dao = (UsersDao)this.getServletContext()
					.getAttribute("UsersDao");
			UsersVo users = dao.detail(no);
			request.setAttribute("users", users);
			RequestDispatcher rd = request.getRequestDispatcher("/user/update.jsp");
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

			UsersDao dao = (UsersDao)this.getServletContext()
					.getAttribute("UsersDao");

			UsersVo vo = new UsersVo();
			vo.setNo(Integer.parseInt(request.getParameter("no")));
			vo.setEmail(request.getParameter("email"));
			vo.setPassword(request.getParameter("password"));
			vo.setName(request.getParameter("name"));
			vo.setTel(request.getParameter("tel"));
			vo.setFax(request.getParameter("fax"));
			vo.setPostNo(request.getParameter("postNo"));
			vo.setAddr(request.getParameter("addr"));
			vo.setPhot(request.getParameter("phot"));
			
			dao.update(vo);

			response.sendRedirect("detail.bit?no="+ vo.getNo());

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
















