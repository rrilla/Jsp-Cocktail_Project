package controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import dao.CockDao;
import dao.ListCommDao;
import dao.MemberDao;
import dao.MyCockDao;
import vo.CockList;
import vo.CockListComm;
import vo.Member;
import vo.Member_MyCock;

@WebServlet("*.do")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FILE_REPO = "E:\\src\\jsp_pro\\BoardProject\\WebContent\\image\\temp";
	private String[] data;
	
	public void init(ServletConfig config) throws ServletException {
		//���� ����� �ѹ��� ����, ����� Ĭ���� ����Ʈ���� �̸������� �迭�� ����
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
			request.setAttribute("rName", data[(int)(Math.random()*data.length)]);
			request.getRequestDispatcher("web/tasteSearch.jsp").forward(request, response);
			
		}else if(action.equals("login.do")) {
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			int n=MemberDao.getInstance().login(id,pw);
			writer.print(n);
			if(n==1) {
				System.out.println(id + " ���� �α��� �Ͻ�.");
				HttpSession session=request.getSession();
				session.setAttribute("session_id", id);
			}
			
		}else if(action.equals("logout.do")) {
			HttpSession session=request.getSession();
			System.out.println(session.getAttribute("session_id") + " ���� �α׾ƿ� �Ͻ�.");
			session.removeAttribute("session_id");
			request.getRequestDispatcher("p_main.do").forward(request, response);
			
		}else if(action.equals("overappedId.do")) {
			String id=request.getParameter("id");
			int n = MemberDao.getInstance().overappedId(id);
			writer.print(n);
			
		//ȸ������ ��ư Ŭ����
		}else if(action.equals("eamilCheck.do")) {
			String email = request.getParameter("email");
			String authNum = "";
			authNum = RandomNum();
			
			sendEmail(email, authNum);
			
		//ȸ������ ��ư Ŭ����
		}else if(action.equals("join.do")) {
			String email=request.getParameter("email");
			String name=request.getParameter("name");
			String pw=request.getParameter("pw");
			String address = request.getParameter("area1") + 
					  ", " + request.getParameter("area2");
			String one_s = request.getParameter("one_s");
			boolean flag = MemberDao.getInstance().insert(new Member(email,pw,name,address,one_s));
			if(flag) {
				HttpSession session = request.getSession();
				session.setAttribute("session_id", email);
				System.out.println(email + "���� ȸ������ �Ͻ�.");
				writer.print("<script>alert('ȸ������ ����');location.href='p_main.do';</script>");
			}else {
				writer.print("<script>alert('ȸ������ ����');location.href='p_join.do';</script>");
			}
			
		//���������� �̵�
		}else if(action.equals("mypage.do")) {
			String id = (String)request.getSession().getAttribute("session_id");
			List<Member_MyCock> myList = MyCockDao.getInstance().selectAll(id);
			request.setAttribute("myList", myList);
			request.getRequestDispatcher("web/mypage.jsp").forward(request, response);
			
		//�̸����� �˻���ư Ŭ����
		}else if(action.equals("search.do")) {
			String cName = request.getParameter("cName");
			List<CockList> nameResult = CockDao.getInstance().searchName(cName);
			request.setAttribute("cName", cName);
			request.setAttribute("nameResult", nameResult);
			request.getRequestDispatcher("web/n_searchList.jsp").forward(request, response);
			 
		//��� ����Ʈ ����
		}else if(action.equals("list.do")) {
			CockDao cockDao=CockDao.getInstance();
			List<CockList> list=cockDao.selectAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("web/allList.jsp").forward(request, response);
			
		//�󼼺��� ������ �̵�
		}else if(action.equals("detail.do")) {
			int no = Integer.parseInt(request.getParameter("no"));
			CockList cock = CockDao.getInstance().SelectOne(no);
			List<CockList> relevant = CockDao.getInstance().relevantCock(cock.getBase(), no);
			List<CockListComm> listComm = ListCommDao.getInstance().selectAll(no);
			request.setAttribute("listComm", listComm);
			request.setAttribute("cock", cock);
			request.setAttribute("relevant", relevant);
			request.getRequestDispatcher("web/detail.jsp").forward(request, response);
			
		//���ã�� �߰�	
		}else if(action.equals("addmycock.do")) {
			HttpSession session=request.getSession();
			int n = -1;
			int no = Integer.parseInt(request.getParameter("no"));
			String id = null;
			id = (String)session.getAttribute("session_id");
			if(id != null) {
				boolean flag = MyCockDao.getInstance().checkAdd(id, no);	//�̹� ����� �ִ��� Ȯ��
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
			
		//��۾��� ��ư Ŭ����	
		}else if(action.equals("addComm.do")) {
			int n = 0;
			String id = null;
			id = request.getParameter("id");
			String content = request.getParameter("content");
			int no = Integer.parseInt(request.getParameter("no"));
			CockListComm cockListComm = new CockListComm(no,id,content);
			boolean flag = ListCommDao.getInstance().insertComm(cockListComm);
			if(flag) {
//				List<CockListComm> listComm = ListCommDao.getInstance().selectAll(no);
//				Gson gson = new Gson();
//				String strJson = "";
//				strJson = gson.toJson(listComm);
//				response.setContentType("application/json; charset=UTF-8");
//				writer.print(strJson);
//				writer.close();
				n=1;
			}
			writer.print(n);
			
			
		}else if(action.equals("rName.do")) {
			writer.print(data[(int)(Math.random()*data.length)]);
		
			
			
			
			
			
			
			//test ��
		}else if(action.equals("test.do")) {
			System.out.println("testdo ����");
			
		}else if(action.equals("test2.do")) {
			request.getRequestDispatcher("web/search.jsp").forward(request, response);
		}
			
	}
    
    private void sendEmail(String email, String authNum) {
    	String host = "smtp.gmail.com";
    	String subject = "JaeHyeon`s Web 인증번호";	//제목
    	String fromName = "JaeHyeon`s Web 관리자";	//보낸사람 이름
    	String from = "rrilla01@gmail.com";			//보낸사람 메일
    	String to1 = email;
    	
    	String content = "재현이가 만든 웹사이트에서 재현이가 요청해서 재현이가 보낸 재현이가 입력해야 할 재현이를 위한 인증번호는<br><h3>[" + authNum + "]</h3><br>입니다.";
    	
    	try {
    		Properties props = new Properties();
    		
//    		props.put("mail.smtp.starttls.enable", "true");
//    		props.put("mail.transport.protocol", "smtp");
//    		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//    		props.put("mail.smtp.port", "465");
//    		props.put("mail.smtp.user", from);
//    		props.put("mail.smtp.auth", "true");
    		props.put("mail.smtp.host","gmail-smtp.l.google.com"); // 네이버 SMTP
    		
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
    				return new PasswordAuthentication("rrilla01@gmail.com", "zz529587!");
    			}
    		});
    		//session_mail.setDebug(true);	//디버그
    		MimeMessage msg = new MimeMessage(session_mail);
    		msg.setFrom(new InternetAddress(from, MimeUtility.encodeText(fromName, "UTF-8", "B")));	//보내는 사람 설정
    		
    		Address address1 = new InternetAddress(to1);
    		msg.addRecipient(Message.RecipientType.TO, address1);
    		msg.setSubject(subject);
    		msg.setSentDate(new java.util.Date());
    		msg.setContent(content, "text/html;charset=utf-8");
    		
    		Transport.send(msg);
    		System.out.println("인증번호 전송");
    	}catch(MessagingException e) {
    		System.out.println("catch오류");
    		e.printStackTrace();
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
