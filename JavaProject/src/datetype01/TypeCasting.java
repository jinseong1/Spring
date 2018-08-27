package datetype01;

public class TypeCasting {

	public static void main(String[] args) {
		
		
		byte b1=65;
		short s1;
		s1=b1; 
		System.out.printf("b1은%d s1는 %d%n",b1, s1);
		//int num1=s1+b1; // 이건 형변환 X
		
		
		//char ch1 = b1; //char과 byte 형변환은 안된다. 이때 char형으로 강제 형변환
		char ch1 = (char)b1;// 강제적 형변환
		
		System.out.printf("ch1는%c%n",ch1);
		
		short s2=100;
		byte b2=(byte)s2;
		System.out.printf("[데이터 미손실]s2는 %d b2는 %d%n",s2,b2);
		
		int num3;
		double d1 = 3.14;
		//num3=d1; //[x]
		num3=(int)d1; //[O] 강제적 형변환으로 소수점이 버려짐
		System.out.printf("[데이터 손실]d1는 %s num3는 %s%n",d1,num3);
		
		//int num4 = num3+d1; //[X]
		int num4 = (int)(num3+d1); //[O] 이 방식 적극 권장
		int num5 = num3+(int)d1; //[O] 위험성이 큼
		
		System.out.printf("num4:%d,num5:%d%n",num4,num5);
		
		int num6 = 1;
		char ch2='A', ch3;
		//ch3= ch2+num6; //[X] 
		ch3=(char)(ch2+num6);
		
		System.out.printf("ch3는%c",ch3);
		//ch3=ch2+(char)num6; [X] char+char=int	
		
		
		
		
		
		
		

	}

}
