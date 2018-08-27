package controller.dataroom;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PagingUtil;
import model.dataroom.DataRoomDAO;
import model.dataroom.DataRoomDTO;

//1]사용자 요청을 받을 수 있도록 서블릿 클래스로 만들기(HttpServlet상속)
//즉 컨트롤러로 만들기
public class ListController extends HttpServlet{
	/*
	 2]사용자 요청이 get방식이면 doGet(),
	 	post방식이면 doPost()
	 
	*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("포스트방식으로 요청 들어옴");
		//가]사용자 요청을 받는다
		//나]요청을 분서한다.
		//다]모델에서 필요한 로직 호출해서 결과값이 있으면 받기
		DataRoomDAO dao = new DataRoomDAO(req.getServletContext());
		Map map = new HashMap();
		//전체 레코드 수
		int totalRecordCount = dao.getTotalRecordCount();
		//페이지 사이즈
		int pageSize =Integer.parseInt(this.getInitParameter("PAGESIZE_DATAROOM"));
		//블락 페이지
		int blockPage = Integer.parseInt(this.getInitParameter("BLOCKPAGE_DATAROOM"));
		//전체페이지 수
		int totalPage = (int)Math.ceil(((double)totalRecordCount/pageSize));
		//현재 페이지를 파라미터로 받기]
		int nowPage = req.getParameter("nowPage") ==null?1:Integer.valueOf(req.getParameter("nowPage"));
		//시작 및 끝 rownum구하기]
		int start =(nowPage-1)*pageSize+1;
		int end = nowPage*pageSize;
		map.put("start", start);
		map.put("end", end);
		
		List<DataRoomDTO> list = dao.selectList(map);
		dao.close();
		//라] 결과값이 있으면 리크ㅔ스트 영역에 저장
		req.setAttribute("list", list);
		req.setAttribute("active", "DATAROOM");
		//페이징 문자열을 리퀘스트 영역에 저장
		String pagingString = PagingUtil.pagingBootStrapStyle(
				totalRecordCount, 
				pageSize, 
				blockPage, 
				nowPage, 
				req.getContextPath()+"/DataRoom/List.kosmo?");
		//페이징과 관련된 속성들
		req.setAttribute("pagingString", pagingString);
		req.setAttribute("totalRecordCount", totalRecordCount);
		req.setAttribute("nowPage", nowPage);
		req.setAttribute("pageSize", pageSize);
		//마] 결과값을 뿌려주거나 이동할 뷰 (JSP페이지) 선택 후 포워딩
		//뷰선택]
		RequestDispatcher dispatcher = req.getRequestDispatcher("/DataRoom13/List.jsp");
		//포워딩]
		dispatcher.forward(req, resp);
	}///////
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("겟방식으로 요청 들어옴");
		doPost(req, resp);
	}////////
}///////////class
