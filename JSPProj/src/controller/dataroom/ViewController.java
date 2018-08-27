package controller.dataroom;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dataroom.DataRoomDAO;
import model.dataroom.DataRoomDTO;
//1]HttpServlet상속받는다
public class ViewController extends HttpServlet {
	//2]service()혹은 doGet()혹은 doPost()오버라이딩
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//3]요청분석
		String no= req.getParameter("no");
		//4]모델 호출 및 결과값 받기
		DataRoomDAO dao = new DataRoomDAO(req.getServletContext());
		DataRoomDTO record = dao.selectOne(no);
		//내용 줄바꿈
		record.setContent(record.getContent().replace("\r\n", "<br/>"));		
		dao.close();
		//5]필요한 값 리퀘스트에 저장
		req.setAttribute("record", record);
		req.setAttribute("active", "DATAROOM");
		//6]뷰 선택 후 포워딩
		req.getRequestDispatcher("/DataRoom13/View.jsp").forward(req, resp);
	}
}////////////////
