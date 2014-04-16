package vo;


public class UsersVo {
	
	int no;
	String name;
	String email;
	String password;
	String tel;
	String fax;
	String addr;
	String postNo;
	String phot;
	
	public UsersVo() {
		this.phot = "등록된 사진이 없습니다.";
    }
	public int getNo() {
		return no;
	}
	public UsersVo setNo(int no) {
		this.no = no;
		return this;
	}
	public String getName() {
		return name;
	}
	public UsersVo setName(String name) {
		this.name = name;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public UsersVo setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public UsersVo setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getTel() {
		return tel;
	}
	public UsersVo setTel(String tel) {
		this.tel = tel;
		return this;
	}
	public String getFax() {
		return fax;
	}
	public UsersVo setFax(String fax) {
		this.fax = fax;
		return this;
	}
	public String getAddr() {
		return addr;
	}
	public UsersVo setAddr(String addr) {
		this.addr = addr;
		return this;
	}
	public String getPostNo() {
		return postNo;
	}
	public UsersVo setPostNo(String postNo) {
		this.postNo = postNo;
		return this;
	}
	public String getPhot() {
		return phot;
	}
	public UsersVo setPhot(String phot) {
		this.phot = phot;
		return this;
	}


	
}


