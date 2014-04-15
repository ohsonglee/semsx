package dao;

import java.util.List;

import vo.CourseVo;

public interface CourseDao {
	
	int insert(CourseVo course) throws Throwable;
	List<CourseVo> list(int pageNo, int pageSize) throws Throwable;
	CourseVo detail(int no) throws Throwable;
	int update(CourseVo course) throws Throwable;
	int delete(int no) throws Throwable;
}