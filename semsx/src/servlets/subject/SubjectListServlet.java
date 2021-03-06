package servlets.subject;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.SubjectVo;
import dao.SubjectDao;

// 과목명에 상세보기 링크 추가
/*
 *  View(JSP) 적용
 *  	- 이 클래스가 하던 일 중에서 출력 부분을 JSP에 위임함.
 *  	- MVC 구조의 완성!
 */

@WebServlet("/subject/list.bit")
@SuppressWarnings("serial")
public class SubjectListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		try {
			SubjectDao dao = (SubjectDao)this.getServletContext().getAttribute("subjectDao");
			
			int pageNo = Integer.parseInt(request.getParameter("pageNo"));
			int pageSize = Integer.parseInt(request.getParameter("pageSize"));

			List<SubjectVo> list = dao.list(pageNo, pageSize);
			
			// ServletRequest 보관소에 DAO 리턴 결과를 보관한다.
			// JSP가 사용할 수 있도록.
			request.setAttribute("list", list);
			
			// JSP에 실행을 위임하기 => RequestDispatcher를 얻는다.
			//  - 파라미터는 반드시 현재 컨텍스트(웹 애플리케이션 루트)를 기준으로 할 것.
			RequestDispatcher rd = request.getRequestDispatcher("/subject/list.jsp");
			rd.forward(request, response);
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
	
}
