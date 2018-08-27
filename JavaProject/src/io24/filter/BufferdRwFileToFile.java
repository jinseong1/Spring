package io24.filter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BufferdRwFileToFile {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
								new InputStreamReader(
										new FileInputStream("src/io24/filter/BufferInOutFileToFile.java")));
//		출력
		PrintWriter pw = new PrintWriter(
								new FileOutputStream("src/io24/filter/BufferInOutFileToFile.txt"),true);
		
		String data;
		while((data=br.readLine())!=null) {
			pw.println(data);
		}
		br.close();
		pw.close();
	}//main
}//class
