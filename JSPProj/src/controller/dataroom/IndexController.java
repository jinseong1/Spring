package controller.dataroom;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//리퀘스트 영역에 저장]
		req.setAttribute("active","INDEX");
		//메인 페이지로 페이지 이동]
		req.getRequestDispatcher("/DataRoom13/Index.jsp").forward(req, resp);
	}
}//////////
