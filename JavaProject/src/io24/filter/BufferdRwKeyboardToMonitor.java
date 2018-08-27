package io24.filter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class BufferdRwKeyboardToMonitor {
//	키보드로 입력받아 모니터로 출력 단 브릿지 스트림으로 문자로 변화
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String data;
//		스트림 끝에 도달하면 null을 반환 및 엔터값을 읽지 않는다
//		readLine은 줄바꿈 기능이 없다
//			방법 1
//			강제로 줄바꿈 기능 추가
//			bw.write(data+"\r\n");
//			bw.flush();
			
//			방법 2
//			bw.write(data);
//			줄바꿈 해줌
//			bw.newLine();
//			bw.flush();
			
//			방법 3
			PrintWriter pw = new PrintWriter(System.out, true);
//			br로 읽고 pw로 출력한다
			while((data=br.readLine())!=null) {
				pw.write(data);
				pw.flush();
		}//while		
	}//main
}//class
