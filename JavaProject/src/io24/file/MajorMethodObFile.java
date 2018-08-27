package io24.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MajorMethodObFile {

	private static String getName(File fwExistFile) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public static void main(String[] args) {
		String wExistFile="D:\\PJS\\workspace\\JavaProject\\src\\Helloworld.java";
		String wNoExistFile="D\\PJS\\NOEXIST.TXT";
		String uRelativeDir="src/io24/node";
		String uAbsoluteDir="D:/PJS/NODIR";
//		파일 객체 생성
		File fwExistFile = new File(wExistFile);
		File fwNoExisFile = new File(wNoExistFile);
//		디렉토리에 대한 정보를 가진 File객체
		File fuRelativeDir=new File(uRelativeDir);
		File fuAbsoluteDir=new File(uAbsoluteDir);
//		파일명 혹은 디렉토리명 얻기
		System.out.println("fwExistFile의 파일 명 : "+fwExistFile.getName());
		System.out.println("fwNoExisFile의 파일 명 : "+fwNoExisFile.getName());
		System.out.println("fuRelativeDir의 디렉토리명 명 : "+fuRelativeDir.getName());
		System.out.println("fuAbsoluteDir의 디렉토리명 : "+fuAbsoluteDir.getName());
		
		System.out.println("[My making getName() Method]");
		System.out.println("fwExistFile의 파일 명 : "+getName(fwExistFile));
		System.out.println("fwNoExisFile의 파일 명 : "+getName(fwNoExisFile));
		System.out.println("fuRelativeDir의 디렉토리명 명 : "+getName(fuRelativeDir));
		System.out.println("fuAbsoluteDir의 디렉토리명 : "+getName(fuAbsoluteDir));
		
		System.out.println(fwExistFile.isFile()?"파일이다":"파일이 아니다");
		System.out.println(fwNoExisFile.isFile()?"파일이다":"파일이 아니다");
		System.out.println(fuRelativeDir.isDirectory()?"디렉토리다":"디렉토리가 아니다");
		System.out.println(fuAbsoluteDir.isDirectory()?"디렉토리다":"디렉토리가 아니다");
//		파일존재 여부는 boolean exists() 항상 존재 여부 확인 후 디렉터리인지 판단하자
		System.out.println(fwExistFile.exists()?"존재한다":"존재하지 않는다");
		System.out.println(fuAbsoluteDir.exists()?"존재한다":"존재하지 않는다");
		if(fuRelativeDir.exists()) {
			if(fuRelativeDir.isFile()) {
				System.out.println("파일이다");
			}//if
			else {
				System.out.println("디렉토리다");
			}//else
		}//if
		System.out.println(fwExistFile.exists()?fwExistFile.isDirectory()?"디렉토리다":"파일이다":"존재하지 않는다");
//		절대경로 (변하지 않는다)
		System.out.println("fuRelativeDir의 상대경로 : "+fuRelativeDir.getPath());
		System.out.println("fuRelativeDir의 절대경로 : "+fuRelativeDir.getAbsolutePath());
		
		System.out.println("fuAbsoluteDir의 상대경로"+fuAbsoluteDir.getPath());
		System.out.println("fuAbsoluteDir의 절대경로"+fuAbsoluteDir.getAbsolutePath());
		
		System.out.println("fwExistFile의 파일 크기 : "+fwExistFile.length()+"바이트");
		System.out.println("fwNoExisFile의 파일 크기 : "+fwNoExisFile.length()+"바이트");
		System.out.println("fuRelativeDir의 디렉토리 크기 : "+fuRelativeDir.length()+"바이트");
		System.out.println("fuAbsoluteDir의 디렉토리 크기 : "+fuAbsoluteDir.length()+"바이트");
		
		System.out.println("fwExistFile의 부모 경로"+fwExistFile.getParent());
		System.out.println("fwNoExisFile의 부모 경로"+fwNoExisFile.getParent());
		System.out.println("fuRelativeDir의 부모 경로"+fuRelativeDir.getParent());
		System.out.println("fuAbsoluteDir의 부모 경로"+fuAbsoluteDir.getParent());
		
		File fone = new File("io24");
		System.out.println("io24의 부모 경로 : "+fone.getParent());
		
		File ftwo = new File("src","node");
		System.out.println("node의 부모 경로 : "+ftwo.getParent());
		
		ftwo = new File("src/node");
		System.out.println("node의 부모 경로 : "+ftwo.getParent());
		
//		파일 혹은 디렉토리 삭제
		System.out.println(fwNoExisFile.delete()?"삭제성공":"삭제실패");
		File fexist = new File("D:/PJS/A.txt");
		System.out.println(fexist.delete()?"삭제성공":"삭제실패");
		System.out.println(fuRelativeDir.delete()?"디렉토리 삭제 성공":"디렉토리 삭제 실패");
		
		System.out.println(new File("D:/PJS/test").delete()?"디렉토리 삭제 성공":"디렉토리 삭제 실패");
		
//		부모 디렉토리가 존재하지 않으면 생성 실패 
		File fmkdir = new File("src/io24/node/temp");
		System.out.println(fmkdir.mkdir()?"디렉토리 생성 성공":"디렉토리 생성 실패");
		
		
		File fmkdirs = new File("src/io24/node/nofir/temp");
		System.out.println(fmkdirs.mkdirs()?"디렉토리 생성 성공":"디렉토리 생성 실패");
		
		File fcan = new File("D:/PJS/CAN.TXT");
		System.out.println(fcan.canRead()?"읽기가능":"읽기불가능");
		System.out.println(fcan.canWrite()?"쓰기가능":"쓰기불가능");
		System.out.println(fcan.canExecute()?"실행가능":"실행불가능");
		
//		시간을 반환해줌
		long time= fcan.lastModified();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd a h:mm");
		String lastString=dateFormat.format(new Date(time));
		System.out.println("최근 수정된 날짜 : "+lastString);
		
//		파일 이름 변경
		File fchange=new File("D:/PJS/CANCHANGE.TXT");
		
		System.out.println(fchange.renameTo(new File("D:/CANA.TXT")));
		
		String[] names=fuRelativeDir.list();
		System.out.println("[파일명 혹은 디렉토리명만]");
		for(String name:names)System.out.println(name);
		
		System.out.println("[File객체로 얻기]");
		File[] files=fuRelativeDir.listFiles();
		for(File file:files) {
			String name=file.getName();
//			최근 시정된 시간
			String lastModified = dateFormat.format(new Date(file.lastModified()));
			if(file.isFile()) {
				System.out.printf("파일명 :%s",name);
				
			}
			else {
				System.out.printf("디렉토리명 :%s",name);
			}
			System.out.printf(" ,최근 수정된 시간 : %s%n",lastModified);
		}
		
		
		
	}//main
}//class
