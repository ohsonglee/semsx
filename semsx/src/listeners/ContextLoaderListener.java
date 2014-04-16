package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import util.DBConnectionPool;
import dao.MysqlCourseDao;
import dao.MysqlSubjectDao;
import dao.MysqlUsersDao;

/* ServletContextListener
 * - 웹 애플리케이션의 시작/종료 이벤트 처리 
 * - 구현체 작성 => web.xml 등록
 * - <listener></listener> 
 */
public class ContextLoaderListener implements ServletContextListener {
	DBConnectionPool dbConnectionPool;
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("contextDestroyed....");
		dbConnectionPool.closeAll();

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("contextInitialized....");
		ServletContext sc = event.getServletContext();
		dbConnectionPool = new DBConnectionPool();
		dbConnectionPool.setDriver(sc.getInitParameter("driver"));
		dbConnectionPool.setUrl(sc.getInitParameter("url"));
		dbConnectionPool.setUsername(sc.getInitParameter("username"));
		dbConnectionPool.setPassword(sc.getInitParameter("password"));
		
		MysqlSubjectDao subjectDao = new MysqlSubjectDao();
		subjectDao.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("subjectDao", subjectDao);
		
		MysqlCourseDao courseDao = new MysqlCourseDao();
		courseDao.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("CourseDao", courseDao);
		
		MysqlUsersDao userDao = new MysqlUsersDao();
		userDao.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("UserDao", userDao);
	}

}









