package junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
//클래스 생성:new ->other에서 JUNIT으로 검색
//->Junit Test Case로 클래스 생성
//name - 클래스명-테스트 대상클래스명뒤에 Test를 붙인다
//class under test - 테스트 대상 클래스 브라우징
//아래 테스트 클래스 실행-Run As->JUnit Test
public class CommonUtilityTest {
	
	private CommonUtility comm;
	//테스트 클래스가 인스턴스화되서 모든 테스트 메소드가
    //실행되기 전에 딱 한번만 호출되는 메소드
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("[@BeforeClass]");
	}
	//모든 테스트 메소드가
	//끝나고(실행되고나서) 딱 한번만 호출되는 메소드
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("[@AfterClass]");
	}
	/* 각 테스트 대상 메소드가 실행되기 전에 호출되는 메소드*/
	@Before
	public void setUp() throws Exception {
		System.out.println("----@Before----");
		comm = new CommonUtility();
	}
	/* 각 테스트 대상 메소드가 실행된 후에 호출되는 메소드*/
	@After
	public void tearDown() throws Exception {
		System.out.println("----@After----");
	}
	/*@Test 어노테이션:아래 메소드는 테스트 대상이되는
           메소드임을 컴파일러에게 알려주는  어노테이션
	테스트 메소드명: test대상메소드명*/
	@Test
	@Ignore/*아래 메소드는 테스트 대상이지만 테스트 안하겠다라는 의미*/
	public void testCommonUtility() {//기본 생성자 테스트
		/*단정문:예상치와 실제치가 같다고 단정을 짓는다
    	같으면 성공 틀리면 실패
   		예]assertEquals:가장 많이 쓰고 데이타가 같은지 비교
		 */
		assertEquals(1, comm.getValue());
		System.out.println("기본생성자-testCommonUtility():"+comm);
	}//////////////////////
	
	@Test
	public void testCommonUtilityArgs() {//인자 생성자 테스트
		CommonUtility comm = new CommonUtility(10);
		assertEquals(10, comm.getValue());
		System.out.println("인자생성자-testCommonUtilityArgs():"+comm);
	}/////////////////////////////
	
	@Test
	public void testAdd() {
		System.out.println("testAdd():"+comm);
		assertEquals(10, comm.add(9));
	}

	@Test
	public void testMinus() {
		System.out.println("testMinus():"+comm);
		assertEquals(-1, comm.minus(2));
	}
	/* expected에 지정한 예외 클래스 발생시 성공,아니면 실패*/
	@Test(expected=NumberFormatException.class)
	public void testError() {
		comm.error();
	}//////////////////////
	/* 결과가 true면 성공,false면 실패*/
	@Test
	public void testIsBool() {
		assertTrue(comm.isBool());
	}//////////////
	//테스트 대상 클래스에 없는 메소드
	//객체 비교 단정문:assertSame()
	@Test
	public void testSame() {
		CommonUtility comm2 = new CommonUtility();
		comm = comm2;
		assertSame(comm, comm2);
	}
	//배열에 저장된 데이타 비교, 같으면 성공,다르면 실패
	@Test
	public void testArray() {
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {1,2,3,4,5};
		assertArrayEquals(arr1, arr2);
	}
	
}
