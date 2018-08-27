package chatting.service;

public interface IConnect {
//	멤버상수
	String ORACLE_DRIVER="oracle.jdbc.OracleDriver";
	String ORACLE_URL="jdbc:oracle:thin://127.0.0.1:1521:orcl";
//	추상메소드 5개 생성
	void connect(String url,String user,String password);
	void execute() throws Exception;
	void close();
	String getValue(String title);
	String getQueryString();
}
