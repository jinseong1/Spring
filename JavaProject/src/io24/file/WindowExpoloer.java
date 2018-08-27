package io24.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WindowExpoloer {

	public static void main(String[] args) {
		File f = new File("src/io24/node");
		/* 문 윈도우 탐색기처럼 상기 디렉토리에 안에 있는 하위 디렉토리나 파일을 출력하여라 단 디렉토리부터...*/
		File[] files = f.listFiles();
		System.out.println("============================================");
		System.out.println(String.format("%-30s%-20s%-10s%s", "이름","수정한 날짜","유형","크기"));
		System.out.println("============================================");
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd a h:mm");
		StringBuffer sbDir = new StringBuffer();
		StringBuffer sbFile = new StringBuffer();
		
		for(File file:files) {
			String name = file.getName();
			String lastString = simple.format(new Date(file.lastModified()));
			if(file.isFile()) {//파일인 경우
				String ext = name.substring(name.lastIndexOf(".")+1).toUpperCase(); // 확장자 구하는 것
				int size=(int)Math.ceil(file.length()/1024.0);
				sbFile.append(String.format("%-30s%-20s%-10s%dKB%n", name,lastString,ext+"파일",size));
			}
			else {//파일이 아닌 경우
				sbDir.append(String.format("%-30s%-20s%-10s", name,lastString,"파일폴더"));
			}
		}
		System.out.println(sbDir.toString()+sbFile);
		
	}//main
}//class
