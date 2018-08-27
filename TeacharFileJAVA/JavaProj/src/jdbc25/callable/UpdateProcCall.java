package jdbc25.callable;

import java.sql.Types;

import jdbc25.service.IConnectImpl;
/*
CREATE OR REPLACE PROCEDURE SP_UPDATE_MEMBER
(
	PID MEMBER.ID%TYPE,
	PPWD MEMBER.PWD%TYPE,
	PNAME MEMBER.NAME%TYPE,
	RTVAL OUT CHAR

)
IS
BEGIN
	UPDATE MEMBER SET PWD=PPWD,NAME=PNAME
	WHERE ID=PID;
	IF SQL%FOUND THEN
		RTVAL :='SUCCESS';
		COMMIT;
	ELSE --존재 하지 않은 아이디
		RTVAL :='FAIL:NOT ID';
	END IF;


	EXCEPTION
		WHEN OTHERS THEN
		BEGIN
			ROLLBACK;
			RTVAL:='FAIL:TOO MUCH VALUE';
		END;


END;
/
 */
public class UpdateProcCall extends IConnectImpl {
	
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
			csmt = conn.prepareCall("{call SP_UPDATE_MEMBER(?,?,?,?)}");
			/*2]파라미터 설정
		    2-1]인파라미터(?) 설정
		        오라클의 IN 파라미터에 해당하는 ? 설정
		        setXXXX()로*/
			csmt.setString(1, getValue("아이디"));
			csmt.setString(3, getValue("이름"));
			csmt.setString(2, getValue("비밀번호"));
			//2-2]오라클의 OUT 파라미터에 해당하는 ? 설정
			//    registerOutParameter()로
			csmt.registerOutParameter(4, Types.CHAR);
			//3]프로시저 실행-execute()
			csmt.execute();
			//4]out파라미터에 저장된 값 읽어 오기
			//  CallableStatement객체의 getXXX()계열 메소드.
			System.out.println("결과 값:"+csmt.getString(4).trim());
			
		} finally {close();}
	}///////////////////////////////////////
	public static void main(String[] args) throws Exception {
		new UpdateProcCall().execute();
	}////////////////main

}///////////////////class
