package chatting.model;

public class MemberDTO {
	private String id;
	private String pwd; 
	private String name; 
	private String age;
	private String gender;
	private String tel;
	private java.sql.Date date;
	
	public MemberDTO() {}
	
	public MemberDTO(String id, String pwd, String name, String age, String gender, String tel, java.sql.Date date) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.tel = tel;
		this.date = date;
	}//MemberDTO

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	
}
