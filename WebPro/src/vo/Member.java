package vo;

public class Member {
	private int no;
	private String id;
	private String name;
	private String nickname;
	private String pw;
	private String address;
	private String one_s;
	private String img_name;
	
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
	
	public Member(String id, String name, String nickname, String pw, String address, String one_s,
			String img_name) {
		super();
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.pw = pw;
		this.address = address;
		this.one_s = one_s;
		this.img_name = img_name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
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

	public String getImg_name() {
		return img_name;
	}

	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}

	@Override
	public String toString() {
		return "Member [no=" + no + ", id=" + id + ", name=" + name + ", nickname=" + nickname + ", pw=" + pw
				+ ", address=" + address + ", one_s=" + one_s + ", img_name=" + img_name + "]";
	}

	
		
}
