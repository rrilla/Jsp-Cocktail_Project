package vo;

import java.util.Date;

public class Member_MyCock {
	private String id;
	private int no;
	private String img_name;
	private String name;
	private String base;
	private Date add_date;
	
	public Member_MyCock() {}

	public Member_MyCock(String id, int no) {
		super();
		this.id = id;
		this.no = no;
	}

	public Member_MyCock(String id, int no, Date add_date) {
		super();
		this.id = id;
		this.no = no;
		this.add_date = add_date;
	}
	
	public Member_MyCock(String id, int no, String img_name, String name, String base) {
		super();
		this.id = id;
		this.no = no;
		this.img_name = img_name;
		this.name = name;
		this.base = base;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getImg_name() {
		return img_name;
	}

	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Date getAdd_date() {
		return add_date;
	}

	public void setAdd_date(Date add_date) {
		this.add_date = add_date;
	}

	
	
}
