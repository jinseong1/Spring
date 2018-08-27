package jdbc25.callable;

import java.sql.Types;

import jdbc25.service.IConnectImpl;
/*
CREATE OR REPLACE PROCEDURE SP_DELETE_MEMBER
(
	PID IN MEMBER.ID%TYPE,
	AFFECTED OUT NUMBER
)
IS

BEGIN 
	DELETE FROM MEMBER WHERE ID=PID;
	IF SQL%FOUND THEN
		DBMS_OUTPUT.PUT_LINE(PID ||'가 삭제 되었습니다');
		AFFECTED :=SQL%ROWCOUNT;
	ELSE
		DBMS_OUTPUT.PUT_LINE('존재하지 않는 아이디');
		AFFECTED :=-1;
	END IF;

	EXCEPTION
	WHEN OTHERS THEN
	BEGIN
		DBMS_OUTPUT.PUT_LINE('자식이 참조하고 있어요');
		AFFECTED :=-2;
		ROLLBACK;
	END;
END;
/
 */
public class DeleteProcCall extends IConnectImpl {
	
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
			csmt = conn.prepareCall("{call SP_DELETE_MEMBER(?,?)}");
			/*2]파라미터 설정
		    2-1]인파라미터(?) 설정
		        오라클의 IN 파라미터에 해당하는 ? 설정
		        setXXXX()로*/
			csmt.setString(1, getValue("아이디"));			
			//2-2]오라클의 OUT 파라미터에 해당하는 ? 설정
			//    registerOutParameter()로
			csmt.registerOutParameter(2, Types.NUMERIC);
			//3]프로시저 실행-execute()
			csmt.execute();
			//4]out파라미터에 저장된 값 읽어 오기
			//  CallableStatement객체의 getXXX()계열 메소드.
			int affected = csmt.getInt(2);
			switch(affected) {
				case 1:System.out.println("1행이 삭제됨");break;
				case -1:System.out.println("존재하지 않는 아이디 입니다");break;
				case -2:System.out.println("자식이 참조하고 있습니다.");
			}
			
		} finally {close();}
	}///////////////////////////////////////
	public static void main(String[] args) throws Exception {
		new DeleteProcCall().execute();
	}////////////////main

}///////////////////class
