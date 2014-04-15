package vo;

public class CourseVo {
	int 				no;				
	String			title;   
	String			description;
	int 				hours;


	public int getNo() {
		return no;
	}
	public CourseVo setNo(int no) {
		this.no = no;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public CourseVo setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public CourseVo setDescription(String description) {
		this.description = description;
		return this;
	}
	public int getHours() {
		return hours;
	}
	public CourseVo setHours(int hours) {
		this.hours = hours;
		return this;
	}
}


