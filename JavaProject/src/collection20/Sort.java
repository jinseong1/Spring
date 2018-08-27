package collection20;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Sort {

	public static void main(String[] args) {
		String[] srt= {"홍길동","가길동","도길동","나길동"};
		Arrays.sort(srt);
		System.out.println("[배열 정렬 후 출력]");
		System.out.println(Arrays.toString(srt));
		
		List list = new Vector();
		list.add(20);
		list.add(40);
		list.add(30);
		list.add(25);
//		컬렉션 정렬
		Collections.sort(list);
//		컬렉션을 배열로 변환하기
		Object[] obejctArrays= list.toArray();
		System.out.println("컬렉션 정렬 후 배열로 변환");
		System.out.println(obejctArrays);
		System.out.println("그냥 출력");
		System.out.println(Arrays.toString(obejctArrays));
		
		
	}//main
}//class
