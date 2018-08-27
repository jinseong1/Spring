package comm.util;

public class CommonUtility {
	
	public static boolean isNumber(String value) {		
		for(int i=0; i < value.length();i++) {
			if(!(value.codePointAt(i)>='0' && value.codePointAt(i)<='9'))
				return false;
		}	
		return true;
	}///////////////isNumber
	//이름에서 초성을 구해 초성을 반환하는 메소드]
	public static char getFirstCharacter(String name) {
		//김길동->ㄱ,박길동->ㅂ,홍길동->ㅎ
		char[] names=name.trim().toCharArray();
		/*
		//방법1]
		if(names[0]>='가' && names[0] <= '깋') return 'ㄱ';
		else if(names[0]>='나' && names[0] <= '닣') return 'ㄴ';
		else if(names[0]>='다' && names[0] <= '딯') return 'ㄷ';
		else if(names[0]>='라' && names[0] <= '맇') return 'ㄹ';
		else if(names[0]>='마' && names[0] <= '밓') return 'ㅁ';
		else if(names[0]>='바' && names[0] <= '빟') return 'ㅂ';
		else if(names[0]>='사' && names[0] <= '싷') return 'ㅅ';
		else if(names[0]>='아' && names[0] <= '잏') return 'ㅇ';
		else if(names[0]>='자' && names[0] <= '짛') return 'ㅈ';
		else if(names[0]>='차' && names[0] <= '칳') return 'ㅊ';
		else if(names[0]>='카' && names[0] <= '킿') return 'ㅋ';
		else if(names[0]>='타' && names[0] <= '팋') return 'ㅌ';
		else if(names[0]>='파' && names[0] <= '핗') return 'ㅍ';
		else if(names[0]>='하' && names[0] <= '힣') return 'ㅎ';
		*/
		//방법2]
		char[] startChar = {'가','나','다','라','마','바','사','아','자','차','카','타','파','하'};
		char[] endChar = {'깋','닣','딯','맇','밓','빟','싷','잏','짛','칳','킿','팋','핗','힣'};
		char[] returnChar={'ㄱ','ㄴ','ㄷ','ㄹ','ㅁ','ㅂ','ㅅ','ㅇ','ㅈ','ㅊ','ㅋ','ㅌ','ㅍ','ㅎ'};
		
		for(int i=0 ; i < startChar.length;i++)
			if(names[0] >= startChar[i] && names[0] <= endChar[i])
				return returnChar[i];
		//한글이름이 아닌 경우
		return '0';
	}//////////////////////////
	
}//////////////////class
