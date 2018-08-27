<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	//[선언부(declaration)]
	//멤버 상수]
	public static final int INT_MAX=Integer.MAX_VALUE;
	//멤버 변수]
	String memberVariable ="<h3>선언부에서 선언한 변수</h3>";
	//멤버 메소드]
	int getMaxNumber(int num1, int num2){
		return num1 > num2? num1:num2;
	}
	/*
	선언부안에서는 jsp내장객체를 사용 못함으로 
	1]
	
	*/
	//멤버변수 선언]
	JspWriter out;
	
	void showMessage(String message){
		try{
			out.println(message);
		}
		catch(Exception e){e.printStackTrace();}
	}
	//방법2]
 	void showMessage(String message,JspWriter out){
		try{
			out.println(message);
		}
		catch(Exception e){e.printStackTrace();}
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8" />
<title>ScriptingBasic.jsp</title>
</head>
<body>
	<fieldset>
		<legend>스크립팅 원소(요소)</legend>
		<%
			//[스크립트릿(Scriptlet)]
			/*
			스크립트릿 안에 작성한 자바 코드는 서블릿으로 변환시 
			_jspService() 메소드 안에 생성됨, 고로 스크립트릿 안에서는 메소드 정의 불가
			 
			jsp에서 제공하는 내장 객체는 메소드 안에 선언됨 변수 (지역변수)로 고로 
			선언부에서는 사용 불가
			*/
			//void method(){}//[x]메소드 정의 불가
			String localVariable = "<h4>스크립틀릿안에서 선언한 지역변수</h4>";
			out.println(INT_MAX);
			out.println(memberVariable);
			out.println(localVariable);
			out.println("최댓값: " + getMaxNumber(10, 100));
			
			this.out = out;
			showMessage("<h4>this.out = out내장객체 전달</h4>");
			//두번째 인자는 메소드에서 선언된 내장객체
			showMessage("<h4>매개변수에 내장객체 전달</h4>");
		%>
		<h3>표현식으로 출력</h3>
		<!-- 
			<%--=hello--%>
			
			표현식은 _jspService()메소드 안에서 out.print("EXPRESSION");로 변환됨
			고로 표현식 안에서 ;을 붙이면 에러
		 -->
		 <%=INT_MAX %>
		 <%=memberVariable %>
		 <%="최댓값:"+getMaxNumber(10, 100) %>
	</fieldset>
</body>
</html>