package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CockDao;
import dao.MemberDao;
import vo.CockList;
import vo.Member;

@WebServlet("*.do")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FILE_REPO = "E:\\src\\jsp_pro\\BoardProject\\WebContent\\image\\temp";
       
    protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
		String requestURI = request.getRequestURI();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		String contextPath = request.getContextPath();
		String action = requestURI.substring(contextPath.length()+1);
		
		if(action.equals("main.do")) {
			response.sendRedirect("web/main.jsp");
			
		}else if(action.equals("login.do")) {
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			int n=MemberDao.getInstance().login(id,pw);
			writer.print(n);
			if(n==1) {
				HttpSession session=request.getSession();
				session.setAttribute("session_id", id);
			}
			
		}else if(action.equals("logout.do")) {
			HttpSession session=request.getSession();
			session.removeAttribute("session_id");
			writer.print("success");
			
		}else if(action.equals("search.do")) {
			String cName = request.getParameter("cName");
			request.setAttribute("cName", cName);
			request.getRequestDispatcher("web/list.jsp").forward(request, response);
			 
		}else if(action.equals("overappedId.do")) {
			String id=request.getParameter("id");
			int n = MemberDao.getInstance().overappedId(id);
			writer.print(n);
			
		}else if(action.equals("join.do")) {
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			String pw=request.getParameter("pw");
			String address = request.getParameter("area1") + 
					  ", " + request.getParameter("area2");
			String one_s = request.getParameter("one_s");
			boolean flag=MemberDao.getInstance().insert(new Member(id,pw,name,address,one_s));
			if(flag) {
				HttpSession session=request.getSession();
				session.setAttribute("session_id", id);
				writer.print("<script>alert('회원가입 성공');location.href='web/main.jsp';</script>");
			}else {
				writer.print("<script>alert('회원가입 실패');location.href='web/join.jsp';</script>");
			}
			
		}else if(action.equals("list.do")) {
			CockDao cockDao=CockDao.getInstance();
			List<CockList> list=cockDao.selectAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("web/list.jsp")
			.forward(request, response);
			
		}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

}
