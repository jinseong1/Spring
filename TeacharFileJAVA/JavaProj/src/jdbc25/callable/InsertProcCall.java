package jdbc25.callable;

import java.sql.Types;

import jdbc25.service.IConnectImpl;
/*
CREATE OR REPLACE PROCEDURE SP_INSERT_MEMBER
(
	PID MEMBER.ID%TYPE,
	PNAME MEMBER.NAME%TYPE,
	PPWD MEMBER.PWD%TYPE,
	RTVAL OUT NVARCHAR2

)
IS
BEGIN
	INSERT INTO MEMBER(ID,PWD,NAME)
	VALUES(PID,PPWD,PNAME);
	IF SQL%FOUND THEN
		RTVAL :='입력 성공';
		COMMIT;
	END IF;


	EXCEPTION
		WHEN OTHERS THEN
		BEGIN
			ROLLBACK;
			RTVAL:='입력 실패-중복키거나 입력값이 크다';			

		END;


END;
/
 */
public class InsertProcCall extends IConnectImpl {
	
	@Override
	public void execute() throws Exception {
		try {
			connect(ORACLE_URL, "SAMPLE", "SAMPLE");
			//1]프로시저를 실행하기 위한 CallableStatement객체 얻기
		    /*
		     * Connection객체의 prepareCall("{call 프로시저명(?,?,...)}")
		    *메소드 호출
		    *-인 파라미터 설정시에는 setXXXX(파라미터인덱스,값)로
		    *-아웃 파라미터 설정시에는 
		    *registerOutParameter(파라미터인덱스,java.sql.Types클래스의 int형상수)
		    */
			csmt = conn.prepareCall("{call SP_INSERT_MEMBER(?,?,?,?)}");
			/*2]파라미터 설정
		    2-1]인파라미터(?) 설정
		        오라클의 IN 파라미터에 해당하는 ? 설정
		        setXXXX()로*/
			csmt.setString(1, getValue("아이디"));
			csmt.setString(2, getValue("이름"));
			csmt.setString(3, getValue("비밀번호"));
			//2-2]오라클의 OUT 파라미터에 해당하는 ? 설정
			//    registerOutParameter()로
			csmt.registerOutParameter(4, Types.NVARCHAR);
			//3]프로시저 실행-execute()
			csmt.execute();
			//4]out파라미터에 저장된 값 읽어 오기
			//  CallableStatement객체의 getXXX()계열 메소드.
			System.out.println("결과 값:"+csmt.getString(4));
			
		} finally {close();}
	}///////////////////////////////////////
	public static void main(String[] args) throws Exception {
		new InsertProcCall().execute();
	}////////////////main

}///////////////////class
