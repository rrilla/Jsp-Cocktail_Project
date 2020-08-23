package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CockDao;
import dao.MemberDao;
import dao.MyCockDao;
import vo.CockList;
import vo.Member;
import vo.Member_MyCock;

@WebServlet("*.do")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FILE_REPO = "E:\\src\\jsp_pro\\BoardProject\\WebContent\\image\\temp";
	private String[] data;
	
	public void init(ServletConfig config) throws ServletException {
		//서버 실행시 한번만 실행, 저장된 칵테일 리스트에서 이름가져와 배열로 저장
		List<String> list = CockDao.getInstance().rName();
		data = list.toArray(new String[list.size()]);
	}
       
    protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
		String requestURI = request.getRequestURI();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		String contextPath = request.getContextPath();
		String action = requestURI.substring(contextPath.length()+1);
		
		if(action.equals("p_main.do")) {
			String rName = data[(int)(Math.random()*data.length)];
			request.setAttribute("rName", rName);
			request.getRequestDispatcher("web/main.jsp").forward(request, response);
			
		} /*
			 * else if(action.equals("start.do")) { Cookie c = new Cookie("cNameList",
			 * URLEncoder.encode(cNameList, "utf-8")); c.setComment("이름 검색용 칵테일");
			 * response.addCookie(c);
			 * 
			 * request.getRequestDispatcher("web/main.jsp").forward(request, response);
			 * 
			 * }
			 */else if(action.equals("p_login.do")) {
			request.setAttribute("rName", data[(int)(Math.random()*data.length)]);
			request.getRequestDispatcher("web/login.jsp").forward(request, response);
			
		}else if(action.equals("p_join.do")) {
			request.setAttribute("rName", data[(int)(Math.random()*data.length)]);
			request.getRequestDispatcher("web/join.jsp").forward(request, response);
			
		}else if(action.equals("p_tasteSearch.do")) {
			request.setAttribute("rName", data[(int)(Math.random()*data.length)]);
			request.getRequestDispatcher("web/tasteSearch.jsp").forward(request, response);
			
		}else if(action.equals("login.do")) {
			request.setAttribute("rName", data[(int)(Math.random()*data.length)]);
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			int n=MemberDao.getInstance().login(id,pw);
			writer.print(n);
			if(n==1) {
				System.out.println(id + " 님이 로그인 하심.");
				HttpSession session=request.getSession();
				session.setAttribute("session_id", id);
			}
			
		}else if(action.equals("logout.do")) {
			request.setAttribute("rName", data[(int)(Math.random()*data.length)]);
			HttpSession session=request.getSession();
			System.out.println(session.getAttribute("session_id") + " 님이 로그아웃 하심.");
			session.removeAttribute("session_id");
			request.getRequestDispatcher("p_main.do").forward(request, response);
			
		}else if(action.equals("overappedId.do")) {
			request.setAttribute("rName", data[(int)(Math.random()*data.length)]);
			String id=request.getParameter("id");
			int n = MemberDao.getInstance().overappedId(id);
			writer.print(n);
			
		}else if(action.equals("join.do")) {
			request.setAttribute("rName", data[(int)(Math.random()*data.length)]);
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			String pw=request.getParameter("pw");
			String address = request.getParameter("area1") + 
					  ", " + request.getParameter("area2");
			String one_s = request.getParameter("one_s");
			boolean flag = MemberDao.getInstance().insert(new Member(id,pw,name,address,one_s));
			if(flag) {
				HttpSession session = request.getSession();
				session.setAttribute("session_id", id);
				System.out.println(id + "님이 회원가입 하심.");
				writer.print("<script>alert('회원가입 성공');location.href='p_main.do';</script>");
			}else {
				writer.print("<script>alert('회원가입 실패');location.href='p_join.do';</script>");
			}
			
		}else if(action.equals("mypage.do")) {
			request.setAttribute("rName", data[(int)(Math.random()*data.length)]);
			String id = (String)request.getSession().getAttribute("session_id");
			List<Member_MyCock> myList = MyCockDao.getInstance().selectAll(id);
			request.setAttribute("myList", myList);
			request.getRequestDispatcher("web/mypage.jsp").forward(request, response);
			 
		}else if(action.equals("search.do")) {
			request.setAttribute("rName", data[(int)(Math.random()*data.length)]);
			String cName = request.getParameter("cName");
			List<CockList> nameResult = CockDao.getInstance().searchName(cName);
			request.setAttribute("cName", cName);
			request.setAttribute("nameResult", nameResult);
			request.getRequestDispatcher("web/n_searchList.jsp").forward(request, response);
			 
		}else if(action.equals("list.do")) {
			request.setAttribute("rName", data[(int)(Math.random()*data.length)]);
			CockDao cockDao=CockDao.getInstance();
			List<CockList> list=cockDao.selectAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("web/allList.jsp").forward(request, response);
			
		}else if(action.equals("detail.do")) {
			request.setAttribute("rName", data[(int)(Math.random()*data.length)]);
			int no = Integer.parseInt(request.getParameter("no"));
			CockList cock = CockDao.getInstance().SelectOne(no);
			List<CockList> relevant = CockDao.getInstance().relevantCock(cock.getBase(), no);
			request.setAttribute("cock", cock);
			request.setAttribute("relevant", relevant);
			request.getRequestDispatcher("web/detail.jsp").forward(request, response);
			
		}else if(action.equals("addmycock.do")) {
			request.setAttribute("rName", data[(int)(Math.random()*data.length)]);
			HttpSession session=request.getSession();
			int n = -1;
			int no = Integer.parseInt(request.getParameter("no"));
			String id = null;
			id = (String)session.getAttribute("session_id");
			if(id!=null) {
				boolean flag = MyCockDao.getInstance().checkAdd(id, no);	//이미 저장되 있는지 확인
				if(!flag) {
					boolean add = MyCockDao.getInstance().addMyCock(id, no);
					if(add) {
						n = 0;
					}
				}else {
					boolean del = MyCockDao.getInstance().delMyCock(id, no);
					if(del) {
						n = 1;
					}
				}
			}writer.print(n);
			
			
			
			
		//test 중
		}else if(action.equals("test.do")) {
			request.setAttribute("rName", data[(int)(Math.random()*data.length)]);
			System.out.println("testdo 실행");
			
		}else if(action.equals("test2.do")) {
			request.setAttribute("rName", data[(int)(Math.random()*data.length)]);
			request.getRequestDispatcher("web/search.jsp").forward(request, response);
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
