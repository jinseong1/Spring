package moteltest;

public class MemberDTO {
	private String name;
	private String tel;
	private String age;
	
	public MemberDTO() {
		super();
	}

	public MemberDTO(String name, String tel, String age) {
		this.name = name;
		this.tel = tel;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	
	
	
}
