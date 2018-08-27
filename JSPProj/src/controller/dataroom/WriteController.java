package controller.dataroom;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import model.PBKDF2;
import model.dataroom.DataRoomDAO;
import model.dataroom.DataRoomDTO;
import model.dataroom.FileUtils;

//1]HttpServlet상속-컨트롤러가 됨 즉 서블릿이 됨
public class WriteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//5]결과값이 있으면, 리퀘스트 영역에 저장
		req.setAttribute("active", "DATAROOM");
		
		//포워드
		//req.getRequestDispatcher("/DataRoom13/Write.jsp").forward(req, resp);
		//리다이렉트
		resp.sendRedirect(req.getContextPath()+"/DataRoom13/Write.jsp");
	}///doGet
	//입력처리 즉 파일 업로드 및 데이타 베이스 입력]
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//한글 처리
		req.setCharacterEncoding("UTF-8");
		//3]요청 분석-입력처리 ㅇ청
		//4]모델 호출 및 결과값 받기
		//파일 업로드와 관련된 모델(비지니스 로직)호출
		MultipartRequest mr= FileUtils.upload(req, req.getServletContext().getRealPath("/Upload"));
		//DB입력 성공시에는 1, 실패는 0, 파일용량 초과시에는 -1 저장
		int successFail;
		//오류시 입력값 보존을 위한 변수 선언]
		String name, title, pass=null, content; 
		if(mr!=null) {//파일 업로드 성공일때 DB입력 처리
			//기타 파라미터 받아서 테이블에 입력처리]
			name  = mr.getParameter("name");
			title = mr.getParameter("title");
			//비밀번호는 암호화
			try {
				pass = PBKDF2.createHash(mr.getParameter("pass"));
			} catch (Exception e) {e.printStackTrace();	}
			content = mr.getParameter("content");
			String attachedfile = mr.getFilesystemName("attachedfile");
			//데이타 베이스 crud작업과 관련된 모델 호출]
			DataRoomDAO dao = new DataRoomDAO(req.getServletContext());
			DataRoomDTO dto = new DataRoomDTO();
			dto.setAttachedfile(attachedfile);
			dto.setContent(content);
			dto.setName(name);	
			dto.setPass(pass);
			dto.setTitle(title);
			successFail = dao.insert(dto);
			if(successFail==0) {//데이터 입력 실패시 업로드된 파일 삭제
				//파일 삭제 로직 호출 
				FileUtils.deleteFile(req, "/Upload", attachedfile);
			}
			dao.close();
		}///if
		else successFail=-1;
		//5]리퀘스트 영역에 결과값 혹은 필요한 값 저장
		//5-1]DB입력 성공 여부 및 파일 용량 초과 판단용 속성 저장
		req.setAttribute("successFail",successFail);
		//5-2]컨트롤러 구분용-입력:INS ,수정:EDT ,삭제:DEL
		req.setAttribute("WHERE", "INS");
		//6]뷰로 이동
		if(successFail ==1) {//파일 업로드 및 Db입력 성공
			//[이동방법1]-바로 목록으로 이동:반드시 List.jsp가 아닌 List.kosmo로
			//req.getRequestDispatcher("/DataRoom/List.kosmo").forward(req, resp);
			//[이동방법2]-메시지 뿌려주는 페이지로 이동후 목록으로 이동
			req.getRequestDispatcher("/DataRoom13/Message.jsp").forward(req, resp);
			
		}
		else {//파일용량 초과 혹은 파일 업로드는 됬으나 DB입력 실패한 경우
			//[이동방법1]-자스의 history.back()으로 입력 폼으로 이동
			//서블릿에서 브라우저로 직접 출력시 -한글처리
			/*resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out =resp.getWriter();
			out.println("<script>");
			out.println("alert('"+(successFail==0?"DB입력 실패":"파일용량 초과")+"');");
			out.println("history.back();");
			out.println("</script>");*/
			//[이동방법2]-메시지 뿌려주는 페이지로 이동후 다시 입력폼으로 이동
			req.getRequestDispatcher("/DataRoom13/Message.jsp").forward(req, resp);
		}
	}/////////doPost
}////////////////class
