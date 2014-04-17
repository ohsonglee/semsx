package servlets.subject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.SubjectVo;
import dao.SubjectDao;

// 목록으로 가기, 삭제하기 링크 추가

@WebServlet("/subject/detail.bit")
@SuppressWarnings("serial")
public class SubjectDetailServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		try {
			
			SubjectDao dao = (SubjectDao)this.getServletContext().getAttribute("subjectDao");
			
			int no = Integer.parseInt(request.getParameter("no"));

			SubjectVo subject = dao.detail(no);
			
			request.setAttribute("subject", subject);
			
			RequestDispatcher rd = request.getRequestDispatcher("/subject/detail.jsp");
			rd.forward(request, response);

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
