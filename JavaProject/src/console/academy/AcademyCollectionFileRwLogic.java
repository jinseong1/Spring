package console.academy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class AcademyCollectionFileRwLogic {
	Scanner sc = new  Scanner(System.in);
	//[멤버 상수]
	public static final int MAX_PERSON=3;//최대 인원수
	//[멤버 변수]
	List<Person> person;

	//[생성자]
	public AcademyCollectionFileRwLogic() throws IOException {
		//멤버 변수 초기화]
		person = new Vector<Person>();
		fileToCollection();
	}
//	}//////////////	
	private void fileToCollection() throws IOException{
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/console/academy/File.txt"));
			String data;
			while((data=br.readLine())!=null) {
				String[] comma=data.split(",");
				String name = comma[0].split(":")[1].trim();
				int age = Integer.parseInt(comma[1].split(":")[1].trim());
				
				String extend = comma[2].split(":")[1].trim();
				
				if(data.indexOf("학번")!=-1) {//학생
					person.add(new Student(name, age, extend));
					
				}
				else {//교사
					person.add(new Teacher(name, age, extend));
				}
			}
			br.close();

		}catch (IOException e) {}
	}
	
	
	//[멤버 메소드]
	/*
	 * 1]메뉴 출력용 메소드
	 * 매개변수:NO
	 * 반환타입:void
	 */
	public void printMainMenu() {
		System.out.println("==================메인 메뉴==================");
		System.out.println("1.입력 2.출력 3.수정 4.삭제 5.검색 6.파일저장 9.종료");
		System.out.println("===========================================");
		System.out.println("메인 메뉴번호를 입력하세요?");
	}/////////////////printMainMenu()
	/*
	 * 2]메뉴 번호 입력용 메소드
	 * 매개변수:NO
	 * 반환타입:int-메뉴번호
	 */	
	public int getMenuNumber() {
		/*문]메뉴번호를 숫자형식이 아닌 문자열을 입력시
		   "메뉴번호가 아닙니다"라는 메시지를 뿌려주고
		   정상적인 숫자형식의 문자열을 입력받을때까지
		   다시 메뉴번호를 입력받도록 하여라
		   힌트:CommonUtility클래스의 isNumber(String)메소드 사용
		*/
		Scanner scanner=new Scanner(System.in);
		/*
		String inputString;
		while(true) {
			inputString = scanner.nextLine();
			if(!CommonUtility.isNumber(inputString)) {
				System.out.println("메뉴 번호가 아닙니다");
				continue;
			}
			break;
		}
			
		return Integer.parseInt(inputString);*/
		int meunNumber=0;
		while(true) {
		try {
		meunNumber=Integer.parseInt(sc.nextLine());
		break;
		}
		catch (Exception e) {
			System.out.println("메뉴번호가 아닙니다");
		}
		}
		return meunNumber;
		
		
	}////////////////////////////////getMenuNumber()
	/*
	 * 3]메인 메뉴 번호에 따른 분기용 메소드
	 * 반환타입:void
	 * 매개변수:int(메인메뉴)
	 */
	public void seperateMainMenu(int mainMenu) {
		switch(mainMenu) {
			case 1://입력
				while(true) {
					//서브메뉴 출력]
					printSubMenu();
					//서브메뉴번호 입력받기]
					int subMenu=getMenuNumber();
					if(subMenu==3) break;
					//학생이나 교사인 경우 입력처리]
					switch(subMenu) {
						case 1:
						case 2:setPerson(subMenu);break;
						default:System.out.println("없는 서브메뉴 번호입니다");
					}
					
				}
				break;
			case 2://출력
				printPerson();
				break;
			case 3://수정
				updatePerson();
				break;
			case 4://삭제
				deletePerson();
				break;
			case 5://검색
				searchPerson();
				break;
			case 6://파일저장
				savePerson();
				break;
			case 9://종료
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
				break;
			default:System.out.println("없는 메뉴번호 입니다.");
		}////switch
		
	}/////////////////seperateMainMenu	
	/*
	 * 4]서브 메뉴 출력용 메소드
	 * 반환타입:void
	 * 매개변수:NO
	 */
	private void printSubMenu() {		
		System.out.println("========서브 메뉴=========");
		System.out.println("1.학생 2.교사 3.메인메뉴로 이동");
		System.out.println("========================");
		System.out.println("서브 메뉴번호를 입력하세요?");
	}///////////////printSubMenu() 
	/*
	 * 5]서브메뉴번호에 따른 학생 및 교사 데이타 입력용 메소드
	 * 반환타입:void
	 * 매개변수:int(서브메뉴)
	 */
	private void setPerson(int subMenu) {
		//정원 찼는지 여부 판단]
		if(person.size()==MAX_PERSON) {//이미 정원이 찬 경우
			System.out.println("정원이 찼어요. 더 이상 입력할 수 없어요");
			return;
		}
		//정원이 안찬 경우 즉 index 가 -1이 아닌 경우...
		//이름과 나이는 둘다 공통]
		Scanner scanner = new Scanner(System.in);
		System.out.println("이름을 입력하세요?");
		String name= scanner.nextLine();
//		문] 정상적인 숫자로 입력할때가지 계속 입력받아라
		int age=0;
		while(true) {
		try {
		System.out.println("나이를 입력하세요?");
		age= Integer.parseInt(scanner.nextLine());
		break;
		}
		catch (NumberFormatException e) {
			System.out.println("숫자만 입력하여주세요");
		}
		}

		
		//학생 과 교사 구분해서 입력 받기]
		switch(subMenu) {
			case 1://학생인 경우
				System.out.println("학번을 입력하세요?");
				String stNumber = scanner.nextLine();
				person.add(new Student(name, age, stNumber));
				break;				
			default://교사인 경우
				System.out.println("과목을 입력하세요?");
				String subject= scanner.nextLine();
				person.add(new Teacher(name, age, subject));
		}///switch
		
	}/////////////////////////setPerson(int subMenu) 
	/*
	 * 6]출력용 메소드
	 * 반환타입:void
	 * 매개변수:NO
	 */
	private void printPerson() {
		System.out.println("[학생.교사 구분없이 출력하기]");
		for(Person per:person) {
			per.print();
		}
		//문] 학생과 교사를 구분해서 출력하여라
		/*
		    [학생 목록]
		       이름:송정환,나이:28,학번:2014
		       이름:최연식,나이:28,학번:2015
		    [교사 목록]
		       이름:최철환,나이:30,과목:자바		
		 */
		System.out.println("[학생.교사 구분해서 출력하기]");
		
		StringBuffer studentList = new StringBuffer("[학생 목록]\r\n");
		StringBuffer teacherList = new StringBuffer("[교사 목록]\r\n");
		
		for(Person per:person) {
				if(per instanceof Student)
					studentList.append(per.get()+"\r\n");
				else
					teacherList.append(per.get()+"\r\n");
					
		}////for
		System.out.println(studentList.toString()+teacherList);
		
		
		
		
	}///////////////////printPerson()
	/*
	 * 7]이름으로 검색하는 메소드
	 * 매개변수:String(수정/삭제/검색용 타이틀)
	 * 반환타입:Person타입 
	 */
	private Person getPersonByName(String title) {
		System.out.println(title+"할 이름을 입력하세요?");
		Scanner scanner = new Scanner(System.in);
		String inputName = scanner.nextLine();
		
		for(Person per:person) {
				//이름이 검색된 경우]
				if(inputName.equals(per.name))
					return per;
			
		}
		//검색된 이름이 없는 경우]
		System.out.println(inputName+"으로 검색한 정보가 없습니다");
		//검색한 이름이 없을 경우 null반환]	
		return null;
	}//////////////////getPersonByName
	//8]검색용 메소드
	private void searchPerson() {
		Person findPerson=getPersonByName("검색");
		if(findPerson !=null) {
			System.out.println("[검색 결과]");
			findPerson.print();
		}		
	}////////////////////////searchPerson()
	//삭제용 ]
	private void deletePerson() {//삭제
		Person findPerson=getPersonByName("삭제");
		if(findPerson !=null) {		
			for(Person per:person) {
					if(per.equals(findPerson)) {
						System.out.println(person.indexOf(person.remove(per))+"님이 삭제되었어요");
						break;
					
				}
			}
		}
		
		
	}///////deletePerson()
	//수정용
	private void updatePerson() {
		Person findPerson=getPersonByName("수정");
		if(findPerson !=null) {
			
			
			int ageString=0;
			while(true) {
			try {
			System.out.println("수정할 나이를 입력하세요?");
			ageString= Integer.parseInt(sc.nextLine());
			break;
			}
			catch (NumberFormatException e) {
				System.out.println("숫자만 입력하여주세요");
			}
			}
			
			if(findPerson instanceof Student) {
				//학번수정
				System.out.println("수정할 학번을 입력하세요");
				((Student) findPerson).stNumber=sc.nextLine();
				
			}
			else {//교사
				//과목 수정
				System.out.println("수정할 과목을 입력하세요");
				((Teacher)findPerson).subject=sc.nextLine();
			}
			System.out.println("수정이 완료되었습니다");
//			수정내용 확인 및 출력
			findPerson.print();
			
		}
		
		
	}//////////updatePerson()
	
	private void savePerson() {
//		컬렉션에 저장된 데이타를 파일로 저장하는 로직 소스는 컬렉션 메모리 입력 스트림 불필요 데이타 목적지 파일 
//		파일로 저장하는 것은 아주 쉽다 하지만 파일을 불러오는 것은 매우 어렵다
		if(person.isEmpty()) {
			System.out.println("파일로 저장할 객체가 없어요");
			return;
		}
		PrintWriter out =null;
		try {
			out = new PrintWriter(new FileWriter("src/console/academy/File.txt") ,true);
			for(Person per:person) {
				out.println(per.get());
			}
			System.out.println("파일 저장이 완료되었습니다");		
		} catch (IOException e) {
			System.out.println("파일 저장 시 오류 발생 : "+e.getMessage());
		}
		finally {
			if(out==null) {
				out.close();
			}
		}
		
	}//save
	
}////////////////////class
