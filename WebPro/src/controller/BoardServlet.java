package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dao.CockCommDao;
import dao.CockDao;
import dao.MemberDao;
import dao.MyCockDao;
import vo.Cocktail;
import vo.CocktailComm;
import vo.Member;
import vo.Member_MyCock;

@WebServlet("*.do")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FILE_REPO = "E:\\src\\jsp_pro\\BoardProject\\WebContent\\image\\temp";
	private String[] data;
	private boolean mailAdressCheck = true;
	private String authNum;
	
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
			request.getRequestDispatcher("web/main.jsp").forward(request, response);
		
		}else if(action.equals("p_login.do")) {
			request.getRequestDispatcher("web/login.jsp").forward(request, response);
			
		}else if(action.equals("p_join.do")) {
			request.getRequestDispatcher("web/join.jsp").forward(request, response);
			
		}else if(action.equals("p_tasteSearch.do")) {
			CockDao cockDao=CockDao.getInstance();
			List<Cocktail> list=cockDao.selectAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("web/searchOne.jsp").forward(request, response);
			
			//로그인
		}else if(action.equals("login.do")) {
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			int n=MemberDao.getInstance().login(id,pw);
			writer.print(n);
			if(n==1) {
				System.out.println(id + " 님이 로그인 하심.");
				HttpSession session=request.getSession();
				Member member = MemberDao.getInstance().SelectOne(id);
				session.setAttribute("session_id", id);
				session.setAttribute("session_nickname", member.getNickname());
				session.setAttribute("session_img_name", member.getImg_name());
			}
			
			//로그아웃
		}else if(action.equals("logout.do")) {
			HttpSession session=request.getSession();
			System.out.println(session.getAttribute("session_id") + " 님이 로그아웃 하심.");
			session.removeAttribute("session_id");
			String url = request.getHeader("referer");
			response.sendRedirect(url);
		
		//아이디(이메일) 중복확인
		}else if(action.equals("overappedId.do")) {
			String id = request.getParameter("id");
			int n = MemberDao.getInstance().overappedId(id);
			writer.print(n);
			
		//닉네임 중복확인
		}else if(action.equals("overappedNname.do")) {
			String nickname = request.getParameter("nickname");
			int n = MemberDao.getInstance().overappedNname(nickname);
			writer.print(n);
			
		//메일 인증번호 발송 클릭시
		}else if(action.equals("authNumSend.do")) {
			String email = request.getParameter("email");
			String authNum = RandomNum();
			sendEmail(email, authNum);
			if(mailAdressCheck) {
				writer.print(authNum);
				System.out.println("'" + email + "' 으로 인증메일 전송함.");
			}else {
				writer.print("0");
			}
			
		//회원가입 버튼 클릭시
		}else if(action.equals("join.do")) {
			String id = request.getParameter("email");
			String name = request.getParameter("name");
			String nickname = request.getParameter("nickname");
			String pw = request.getParameter("pw");
			String address = request.getParameter("area1") + 
					  ", " + request.getParameter("area2");
			String one_s = request.getParameter("one_s");
			String img_name = request.getParameter("img_name");
			boolean flag = MemberDao.getInstance().insert(new Member(id,name,nickname,pw,address,one_s,img_name));
			if(flag) {
				HttpSession session = request.getSession();
				session.setAttribute("session_id", id);
				session.setAttribute("session_nickname", nickname);
				session.setAttribute("session_img_name", img_name);
				System.out.println(id + "님이 회원가입 하심.");
				writer.print("<script>location.href='p_main.do';</script>");
			}else {
				writer.print("<script>alert('회원가입에 실패하였습니다.');location.href='p_join.do';</script>");
			}
			
		//마이페이지 이동
		}else if(action.equals("mypage.do")) {
			String id = (String)request.getSession().getAttribute("session_id");
	        List<Cocktail> myList = MyCockDao.getInstance().selectAll(id);
	        request.setAttribute("num", myList.size());
	        request.setAttribute("myList", myList);
	        request.getRequestDispatcher("web/mypage.jsp").forward(request, response);
			
		//이름으로 검색버튼 클릭시
		}else if(action.equals("search.do")) {
			String cName = request.getParameter("cName");
			List<Cocktail> nameResult = CockDao.getInstance().searchName(cName);
			request.setAttribute("cName", cName);
			request.setAttribute("nameResult", nameResult);
			request.getRequestDispatcher("web/n_searchList.jsp").forward(request, response);
			 
		//모든 리스트 보기
		}else if(action.equals("list.do")) {
			CockDao cockDao=CockDao.getInstance();
			List<Cocktail> list=cockDao.selectAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("web/allList.jsp").forward(request, response);
			
		//상세보기 페이지 이동
		}else if(action.equals("detail.do")) {
			int no = Integer.parseInt(request.getParameter("no"));
			Cocktail cock = CockDao.getInstance().SelectOne(no);
			List<Cocktail> relevant = CockDao.getInstance().relevantCock(cock.getBase(), no);
			List<CocktailComm> listComm = CockCommDao.getInstance().selectAll(no);
			String id = (String)request.getSession().getAttribute("session_id");
			if(id != null) {
				boolean flag = MyCockDao.getInstance().checkAdd(id, no);
				if(flag) {
						request.setAttribute("myCockImg", "0");
				}else {
						request.setAttribute("myCockImg", "1");
				}
			}
			
			
			request.setAttribute("listComm", listComm);
			request.setAttribute("cock", cock);
			request.setAttribute("relevant", relevant);
			request.getRequestDispatcher("web/detail.jsp").forward(request, response);
			
		//즐겨찾기 추가
		}else if(action.equals("addmycock.do")) {
			HttpSession session=request.getSession();
			int n = -1;
			int no = Integer.parseInt(request.getParameter("no"));
			String id = null;
			id = (String)session.getAttribute("session_id");
			if(id != null) {
				boolean flag = MyCockDao.getInstance().checkAdd(id, no);	//占싱뱄옙 占쏙옙占쏙옙占� 占쌍댐옙占쏙옙 확占쏙옙
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
			}
			writer.print(n);
			
		//댓글쓰기 버튼 클릭시
		}else if(action.equals("addComm.do")) {
			HttpSession session=request.getSession();
			String id = (String)session.getAttribute("session_id");
			String content = request.getParameter("content");
			int no = Integer.parseInt(request.getParameter("no"));
			CocktailComm cockListComm = new CocktailComm(no,id,content);
			boolean flag = CockCommDao.getInstance().insertComm(cockListComm);
			if(flag) {
				request.getRequestDispatcher("listComm.do").forward(request, response);
			}

			//detail페이지 댓글목록갱신
		}else if(action.equals("listComm.do")) {
			int no = Integer.parseInt(request.getParameter("no"));
			List<CocktailComm> listComm = CockCommDao.getInstance().selectAll(no);
			Gson gson = new Gson();
			String strJson = "";
			strJson = gson.toJson(listComm);
			response.setContentType("application/json; charset=UTF-8");
			writer.print(strJson);
			writer.close();
			
			//취향페이지 목록갱신
		}else if(action.equals("searchTaste.do")) {
			int abv = Integer.parseInt(request.getParameter("abv"));
			int color = Integer.parseInt(request.getParameter("color"));
			int taste = Integer.parseInt(request.getParameter("taste"));
			List<Cocktail> result = CockDao.getInstance().searchTaste(abv, color, taste);
			Gson gson = new Gson();
			String strJson = "";
			strJson = gson.toJson(result);
			response.setContentType("application/json; charset=UTF-8");
			writer.print(strJson);
			writer.close();
			
			//header2.jsp실행시 랜덤으로 칵테일 이름 뿌려줌	
		}else if(action.equals("rName.do")) {
			writer.print(data[(int)(Math.random()*data.length)]);		
			
			
		}
			
	}
    
    private void sendEmail(String email, String authNum) {
    	String host = "smtp.gmail.com";				//smtp 서버
    	String subject = "JaeHyeon`s Web 인증번호 ";	//메일 제목
    	String fromName = "JaeHyeon`s Web 관리자";	//보내는 이
    	String from = "rrilla01@gmail.com";			//보내는 메일
    	String to1 = email;
    	
    	String content = "재현이가 만든 웹사이트에<br>재현이가 요청해서<br>재현이가 보낸<br>재현이가 입력해야 할<br>재현이를 위한 인증번호는<br><h1>[" + authNum + "]</h1><br>입니다.";
    	
    	try {
    		Properties props = new Properties();
    		
//    		props.put("mail.smtp.starttls.enable", "true");
//    		props.put("mail.transport.protocol", "smtp");
//    		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//    		props.put("mail.smtp.port", "465");
//    		props.put("mail.smtp.user", from);
//    		props.put("mail.smtp.auth", "true");
    		props.put("mail.smtp.host","gmail-smtp.l.google.com");
    		
    		props.put("mail.smtp.port", "465");
    		props.put("mail.smtp.starttls.enable", "true");
    		props.put("mail.smtp.auth", "true");
    		props.put("mail.smtp.debug", "true");
    		props.put("mail.smtp.socketFactory.port", "465");
    		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    		props.put("mail.smtp.socketFactory.fallback", "false");
    		

    		Session session_mail = Session.getInstance(props,
    			new javax.mail.Authenticator() {
    				protected PasswordAuthentication getPasswordAuthentication() {
    					return new PasswordAuthentication("rrilla01@gmail.com", "jh940520");
    				}
    			});
    		//session_mail.setDebug(true);	//디버깅
    		MimeMessage msg = new MimeMessage(session_mail);
    		msg.setFrom(new InternetAddress(from, MimeUtility.encodeText(fromName, "UTF-8", "B")));	//보내는 사람설정
    		
    		Address address1 = new InternetAddress(to1);
    		msg.addRecipient(Message.RecipientType.TO, address1);	//받는 사람설정
    		msg.setSubject(subject);	//제목 설정
    		msg.setSentDate(new java.util.Date());	//보내는 날짜 설정
    		msg.setContent(content, "text/html;charset=utf-8");
    		
    		Transport.send(msg);	//메일보내기
    	}catch(MessagingException e) {
    		e.printStackTrace();
    		mailAdressCheck = false;
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public String RandomNum() {
    	StringBuffer buffer = new StringBuffer();
    	for(int i = 0; i <= 6; i++) {
    		int n=(int)(Math.random()*10);
    		buffer.append(n);
    	}
    	return buffer.toString();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

}
