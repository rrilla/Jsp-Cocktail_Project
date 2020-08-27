package vo;

public class Member {
	private int no;
	private String id;
	private String pw;
	private String name;
	private String address;
	private String one_s;
	
	public Member() {}
	
	public Member(String id, String pw, String name, String address, String one_s) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.address = address;
		this.one_s = one_s;
	}
	
	public Member(int no, String id, String pw, String name, String address, String one_s) {
		super();
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.address = address;
		this.one_s = one_s;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOne_s() {
		return one_s;
	}

	public void setOne_s(String one_s) {
		this.one_s = one_s;
	}
		
}
