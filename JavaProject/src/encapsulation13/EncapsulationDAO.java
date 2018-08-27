package encapsulation13;

public class EncapsulationDAO {
	private EncapsulationDTO capsule = new EncapsulationDTO();
	public void intialize(String name, String accountNo, int balance) {
		capsule.setAccountNo(accountNo);
		capsule.setBalance(balance);
		capsule.setName(name);
		
	}
	public void deposite(int money) {
		capsule.setBalance(capsule.getBalance()+money);
		System.out.println(money+"가 입금되었어요");
	}//deposite
	public void withDraw(int money) {
		if(money>capsule.getBalance()) {
			System.out.println("잔액이 부족합니다");
			return;
		}//if
		capsule.setBalance(capsule.getBalance()-money);
		System.out.println(money+"가 출금되었어요");
	}//withDraw
	
	public void print() {
		System.out.println(String.format("%s님의 계좌번호", capsule.getName()));
		System.out.println(String.format("계좌번호 : %s", capsule.getAccountNo()));
		System.out.println(String.format("계좌잔액 : %s", capsule.getBalance()));
	}
	
	
	
	
	
	
}//class
