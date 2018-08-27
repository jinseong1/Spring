package encapsulation13;

public class EncapsulationDTO {
	//은닉화 과정
	private String name; //예금주
	private String accountNo;//계좌번호
	private int balance;//잔액
	
	//Getter 외부에서 값을 가져가게 만드는 것
	public String getName() {
		return name;
	}
	public int getBalance() {
		return balance;
	}
	public String getAccountNo() {
		return accountNo;
	}
	//Setter 외부에서 세팅하게 만드는 것
	public void setName(String name) {
		this.name = name;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
}//class EncapsulationDTO
