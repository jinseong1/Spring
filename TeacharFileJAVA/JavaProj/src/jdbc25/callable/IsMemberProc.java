package jdbc25.callable;

import java.sql.Types;

import jdbc25.service.IConnectImpl;

/*
OUT 파라미터값
	-회원인 경우 : 1
	-아이디는 일치하나 비번이 불일치: 0
	-아이디 불일치 : -1


CREATE OR REPLACE PROCEDURE SP_ISMEMBER
(
PID MEMBER.ID%TYPE,
PPWD MEMBER.PWD%TYPE,
RTVAL OUT NUMBER

)
IS
TMP NUMBER(1);	
BEGIN
SELECT COUNT(*) INTO TMP  FROM MEMBER	
WHERE ID=PID ;

IF TMP = 1 THEN -- 아이디 일치
	SELECT COUNT(*) INTO TMP  FROM MEMBER	
	WHERE ID=PID AND PWD = PPWD ;	
	IF TMP =1 THEN --회원
		RTVAL := 1;
	ELSE --비번 불일치
		RTVAL := 0;
	END IF;

ELSE -- 아이디 불일치
	RTVAL := -1;
END IF;


END;
/
 
 */
public class IsMemberProc extends IConnectImpl {

	@Override
	public void execute() throws Exception {
		try {
			connect(ORACLE_URL,"SAMPLE","SAMPLE");
			csmt = conn.prepareCall("{call SP_ISMEMBER(?,?,?)}");
			String username=getValue("아이디");
			csmt.setString(1, username);
			csmt.setString(2, getValue("비밀번호"));
			csmt.registerOutParameter(3, Types.NUMERIC);
			
			csmt.execute();
			int out =csmt.getInt(3);
			System.out.println( out==1                  ?
								username+ "님 즐감하세요"  :
								out==0 ? "비밀번호가 일치하지 않아요":"아이디가 불일치해요"	);
		} 
		finally {close();}
	}///////////////execute()
	public static void main(String[] args) throws Exception {
		new IsMemberProc().execute();
	}//////////main

}/////////////class
