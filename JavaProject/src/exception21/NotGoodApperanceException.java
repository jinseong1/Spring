package exception21;

public class NotGoodApperanceException extends Exception {


//	생성자 정의
//	기본생성자
	public NotGoodApperanceException() {
		super("복장 불량은 입장 불가");
		
	}
	
	
//	인자생성자
	public NotGoodApperanceException(String message) {
		super(message);
		
		
	}
	
	
	
	
}
