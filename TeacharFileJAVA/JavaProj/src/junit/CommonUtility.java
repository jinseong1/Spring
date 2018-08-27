package junit;

/*
 * JUnit라이브러리 추가
 * 프로젝트 마우스 우클릭->Build Path->Configue Build path
 * -> Add Library에서 JUnit선택
 * 
 */
public class CommonUtility {
	//[멤버변수]
	private int value;
	//기본 생성자]
	public CommonUtility() {
		value=1;
	}////////////////
	//[인자 생성자]
	public CommonUtility(int value) {		
		this.value = value;
	}/////////////////////
	public int add(int value) {		
		return this.value += value;
	}//////////////////////////////////////////////
	public int minus(int value) {		
		return this.value -= value;
	}//////////////////////////////////////////////
	public int multiple(int value) {		
		return this.value *= value;
	}//////////////////////////////////////////////
	public int divide(int value) {		
		return this.value /= value;
	}//////////////////////////////////////////////
	public void error() {
		Integer.parseInt("백");
	}///////////////////////////////
	public boolean isBool() {
		return 10 > 1;
	}///////////////////////////
	//게터
	public int getValue() {
		return value;
	}/////////////////////////////
	
}
