package io24.filter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class BufferdRwFileToMonitor {
//		파일로 읽어서 모니터로 출력하자
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/io24/filter/BufferInOutFileToFile.java"));
		PrintWriter pw = new PrintWriter(System.out, true);
		
//		br로 읽고 pw로 출력
		String data;
		int line = 1;
		while((data =br.readLine())!=null) {
			pw.println(String.format("%-5d%s", line++,data.replace("java", "자바")));	
		}
		br.close();
//		라인번호를 붙여서 출력하고 java를 한글 자바로 바꿔서 출력하라
	}//main
}//class
