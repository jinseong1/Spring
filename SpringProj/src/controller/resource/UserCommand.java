package controller.resource;

public class UserCommand {
	//속성들(멤버변수)
	private String user;
	private String pass;
	private String name;
	//게터/세터
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {		
		return String.format("[이름:%s,아이디:%s,비번:%s]",name,user,pass);
	}
}
