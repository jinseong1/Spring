package question;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;



public class Range {	

	public static void main(String[] args) {
		Scanner sc =  new  Scanner(System.in);
		Vector vec = new Vector();
		for(int i=0;i<5;i++) {
			System.out.println(i+"번째 숫자를 입력하여주세요");
			vec.add(sc.nextInt());			
		}
		//순차정렬
		Collections.sort(vec);
		//뒤집기
		Collections.reverse(vec);

		
		/*
		for(int i=0;i<num.length;i++) {
			for(int j=i+1;j<num.length;j++) {
				if(num[i]<num[j]) {
					int temp = num[i];
					num[i]=num[j];
					num[j]=temp;					
				}//if
			}//for			
		}//for
		*/
		
		for(Object vecs:vec) {
			System.out.println(vecs);
		}
		
	}

}
