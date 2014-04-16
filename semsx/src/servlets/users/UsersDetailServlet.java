package servlets.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.UsersVo;
import dao.UsersDao;

@WebServlet("/user/detail.bit")
@SuppressWarnings("serial")
public class UsersDetailServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>사용자상세정보</title></head><body>");
		try {
			out.println("<h1>사용자 상세정보</h1>");
			
			UsersDao dao = (UsersDao)this.getServletContext()
					.getAttribute("UsersDao");
			
			int no = Integer.parseInt(request.getParameter("no")); 
			
			UsersVo users = dao.detail(no);
			
			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("	<th>번호</th>");
			out.println("	<td>" + users.getNo()+ "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("	<th>이메일</th>");
			out.println("	<td>" + users.getEmail()+ "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("	<th>비밀번호</th>");
			out.println("	<td>" + users.getPassword()+ "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("	<th>이름</th>");
			out.println("	<td>" + users.getName() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("	<th>전화번호</th>");
			out.println("	<td>" + users.getTel() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("	<th>팩스</th>");
			out.println("	<td>" + users.getFax()+ "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("	<th>우편번호</th>");
			out.println("	<td>" + users.getPostNo() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("	<th>주소</th>");
			out.println("	<td>" + users.getAddr()+ "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("	<th>사진여부</th>");
			out.println("	<td>" + users.getPhot()+ "</td>");
			out.println("</tr>");
			
			out.println("</table>");
			out.println("<a href='list.bit?pageNo=1&pageSize=10'>목록</a>");
			out.println("<a href='delete.bit?no="
					+  users.getNo() 
					+ "'>삭제</a>");
			
			out.println("<a href='update.bit?no="
					+  users.getNo() 
					+ " '>변경</a><br>");
			
		} catch (Throwable e) {
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}
















