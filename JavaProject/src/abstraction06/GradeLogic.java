package abstraction06;

import java.util.Scanner;

import javax.security.auth.Subject;

public class GradeLogic {
	int numberOfStudent; // 학생수 저장용
	GradeRecode[] records; // 각 학생의 성적 저장용 배열
	String[] subjects= {"국어","영어","수학"}; // 과목 타이틀 출력용
	void setNumberOfSudent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("학생수를 입력하여주세요");
		numberOfStudent = sc.nextInt();
		//학생수만큰 배열의 메모리 할당
		records = new GradeRecode[numberOfStudent];
		//학생 수 만큼 graderecord타입의 메모리 생성해서 위의 배열에 주소 저장
		
		for(int i=0; i<records.length ; i++ ) {
			records[i] = new GradeRecode();
		}//for
		
	}//void setNumberOfSudent
	void setNameJumsu() {
		Scanner sc = new Scanner(System.in);
		for(int i=0 ; i<numberOfStudent ; i++) {
			System.out.printf("[%d번째 학생]%n",i+1);
			System.out.println("이름을 입력하여 주세요");
			records[i].name=sc.nextLine();
			for(int k=0 ; k < subjects.length ; k++) {
				System.out.println(subjects[k]+"점수입력");
				records[i].jumsu[k]=sc.nextInt();
				
				records[i].total+=records[i].jumsu[k];
				
				
				
				}//in for
			records[i].avg=records[i].total/subjects.length;
			sc.nextLine();
		}//out for
		
	}//void setNameJumsu
	void setRank() {
		for(int i=0;i<numberOfStudent-1;i++) {
			for(int k=i+1;k<numberOfStudent;k++) {
				if(records[i].total < records[k].total) {
					records[i].rank++;
				}//if
				else if(records[i].total > records[k].total)
					records[k].rank++;
			}//in for
		}//for
	}//void setRank
	void sort() {// 결과값을 출력하는 메소는 매개변수는 노 반환타입 보이드
		for(int i=0; i<records.length-1; i++){
			for(int j=i+1; j<records.length; j++){
				if(records[i].total < records[j].total){
					GradeRecode temp = records[i];
					records[i] = records[j]; 
					records[j] = temp;
				}//if
			}//in for
		}//out for
	}//void sort
	
	void print() {
		sort();
		System.out.println("============================================");
		System.out.printf("%-10s%-5s%-5s%-5s%-5s%-7s%s%n","NAME","KOR","ENG","MATH","SUM","AVG","RANK");
		System.out.println("============================================");
		for(int i=0; i<numberOfStudent ;i++) {
			System.out.printf("%-10s",records[i].name);
			for(int k=0; k < subjects.length ;k++) {
				System.out.printf("%-5d",records[i].jumsu[k]);
			}//in for
			System.out.printf("%-5d%-7.2f%d%n",records[i].total,records[i].avg,records[i].rank);
		}//out for		
	}//void print
}//class
