package method05;

public class CallbyReference {
	//총점 및 평균을 구하는 메소드
	static void setTotalNAvg(double[][] score) {
		for(int i=0; i<score.length ; i++) {
			//총점 구하기
			for(int k=0; k<3 ; k++) {
				score[i][3]+=score[i][k];
			}//in for
			//평균 구하기
			
			score[i][4] = score[i][3]/3;
		}//for
	}//method
	//출력용 메소드
	static void print(double[][] score) {
		
		String[] title = {"국어","영어","수학","총점","평균"};
		for(int i=0; i<score.length ; i++) {
			System.out.printf("%d번째 성적] ",i+1);
			for(int k=0;k<score[i].length;k++) {
				if(score[i].length-1 != k)
				System.out.printf("%s:%.0f,",title[k],score[i][k]);
				else
				System.out.printf("%s:%.2f",title[k],score[i][k]);
			}//in for
			//줄바꿈
			System.out.println();
		}//for
			
		
		
	}//method
	
	
	
	public static void main(String[] args) {
		
		double[][] score =
				{{100,100,100,0,0},
				{90,90,90,0,0},
				{95,95,95,0,0}};	
		
		//총점 및 평균 출력
		setTotalNAvg(score);
		//출력
		print(score);

		
	}//main
}//class
