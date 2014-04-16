package servlets.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.UsersVo;
import dao.UsersDao;

@WebServlet("/user/list.bit")
@SuppressWarnings("serial")
public class UsertListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>사용자 정보 목록</title></head><body>");
		
		try {
			out.println("<h1>사용자 정보 목록</h1>");
			
			UsersDao dao = (UsersDao)this.getServletContext().getAttribute("UersDao");
			
			int pageNo = Integer.parseInt(request.getParameter("pageNo"));
			int pageSize = Integer.parseInt(request.getParameter("pageSize"));

			List<UsersVo> list = dao.list(pageNo, pageSize);
			
			out.println("<a href='form.html'>새과목</a><br>");

			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("	<th>번호</th>");
			out.println("	<th>이름</th>");
			out.println("	<th>이메일</th>");
			out.println("	<th>전화번호</th>");
			out.println("</tr>");

			for (UsersVo user : list) {
				out.println("<tr>");
				out.println("	<td>" + user.getNo()	+ "</td>");
				out.println("	<td><a href='detail.bit?no="
						+ user.getNo()
						+ "'>" + user.getName() + "</a></td>");
				out.println("	<td>" + user.getEmail()	+ "</td>");
				out.println("	<td>" + user.getTel()	+ "</td>");
				out.println("</tr>");
			}
			out.println("</table>");


		} catch (Throwable e) {
			out.println("오류 발생 했음.");
			e.printStackTrace();
		}
		
		out.println("</body></html>");
		
	}
	
}
