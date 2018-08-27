package controller.dataroom;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import model.PBKDF2;
import model.dataroom.DataRoomDAO;
import model.dataroom.DataRoomDTO;
import model.dataroom.FileUtils;

public class EditController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청 분석
		if(req.getParameter("EDIT_FORM")!=null) {//수정 폼으로 이동
			//파라미터 받기
			String no = req.getParameter("no");
			//모델 호출및 결과값 받기
			DataRoomDAO dao = new DataRoomDAO(req.getServletContext());
			DataRoomDTO record = dao.selectOne(no);
			dao.close();
			//리퀘스트 영역에 저장
			req.setAttribute("record", record);
			req.setAttribute("active", "DATAROOM");
			//포워드
			req.getRequestDispatcher("/DataRoom13/Edit.jsp").forward(req, resp);
		}
		else {//수정처리]
			//한글처리
			req.setCharacterEncoding("UTF-8");
			//3]요청 분석- 수정처리 요청
			//4]
			//파일 업로드와 관련된 모델 (비)
			// 한글처리
	        
	        MultipartRequest mr= FileUtils.upload(req,req.getServletContext().getRealPath("/Upload"));
	        
	        // DB입력 성공시에는 1,실패시 0, 파일용량 초과시에는 -1 저장
	        int successFail;
	        // 오류시 입력값 보존을 위한 변수 선언]
	        if(mr !=null) {//파일을 첨부했거나 안했거나
	        	// 기타 파라미터 받아서 테이블에 입력처리]
	           String no = mr.getParameter("no");
	           req.setAttribute("no", no);
	           String name = mr.getParameter("name");
	           String title= mr.getParameter("title");
	           // 비밀번호는 암호화]
	           String pass = null;
	           try {
	              pass = PBKDF2.createHash(mr.getParameter("pass"));
	           } 
	           catch (Exception e) {   e.printStackTrace();}
	           String content = mr.getParameter("content");
	           String attachedfile = mr.getFilesystemName("attachedfile");
	           if(attachedfile ==null) {//파일 미 첨부 즉 수정시 기존 파일을 기존 파일로 미 교체
	        	   attachedfile = mr.getParameter("originalfilename");
	           }
	           //데이타베이스 CRUD작업과 관련된 모델 호출]
	           DataRoomDAO dao = new DataRoomDAO(req.getServletContext());
	           DataRoomDTO dto = new DataRoomDTO();
	           dto.setAttachedfile(attachedfile);
	           dto.setContent(content);
	           dto.setName(name);
	           dto.setPass(pass);
	           dto.setTitle(title);
	           dto.setNo(no);
	           successFail= dao.update(dto);   
	           //DB업데이트 성공 및 파일 교체시 기존 업로드된 파일 삭제
	           if(successFail==1 && mr.getFilesystemName("attachedfile")!=null) {
	              FileUtils.deleteFile(req, "/Upload", mr.getParameter("originalfilename"));
	           }
	            
	           dao.close();
		        }//if
		        else successFail=-1;
		         //5]리퀘스트 영역에 결과값 혹은 필요한 값 저장
		         //5-1]DB입력 성공 여부 및 파일용량 초과 판단용 속성 저장
	       		 req.setAttribute("active", "DATAROOM");
		         req.setAttribute("successFail", successFail);
		         
		         //5-2]컨트롤러 구분용-입력:INS,수정:EDT,삭제:DEL
		         req.setAttribute("WHERE", "EDT");
		         req.getRequestDispatcher("/DataRoom13/Message.jsp").forward(req, resp);
	        
	         
	      

		}
	
	}
	
}////////////////
