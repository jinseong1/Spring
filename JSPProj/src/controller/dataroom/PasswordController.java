package controller.dataroom;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dataroom.DataRoomDAO;
import model.dataroom.FileUtils;

public class PasswordController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터 받기]
		String no = req.getParameter("no");
		String mode = req.getParameter("mode");
		String pass = req.getParameter("pass");
		String originalfilename = req.getParameter("originalfilename");
		//모델호출 및 결과값 받기]
		DataRoomDAO dao = new DataRoomDAO(req.getServletContext());
		boolean flag = dao.isCorrectPassword(no,pass);
		
		//결과값을 리퀘스트 영역에 저장
		req.setAttribute("PASSWORD_CORRECT", flag);
		//뷰 선택 후 포워딩]
		//비밀번호가 틀린경우는 이전 페이지로]
		if(!flag) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out =resp.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다');");
			out.println("history.back();");
			out.println("</script>");
			dao.close();
			return;
		}
		//비밀번호가 일치하는 경우]
		if("UPDATE".equals(mode)) {//수정을 누른 경우
			dao.close();
			//수정 폼으로 이동]
			req.getRequestDispatcher("/DataRoom/Edit.kosmo").forward(req, resp);
		}
		else {//삭제를 누른 경우-삭제 처리후 목록으로 이동]
			//삭제처리
			int successFail = dao.delete(no);
			dao.close();
			if(successFail==1) {//레코드 삭제 성공시 업로드된 파일 삭제
				FileUtils.deleteFile(req, "/Upload", originalfilename);
			}
			req.setAttribute("successFail", successFail);
			//메시지 뿌려주는 페이지로 이동
			req.getRequestDispatcher("/DataRoom13/Message.jsp").forward(req, resp);
		}
	}
}
