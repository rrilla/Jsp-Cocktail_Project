package vo;

import java.util.Date;

public class Member_MyCock {
	private String id;
	private String name;
	private Date add_date;
	
	public Member_MyCock() {}

	public Member_MyCock(String id, String name, Date add_date) {
		super();
		this.id = id;
		this.name = name;
		this.add_date = add_date;
	}

	public Member_MyCock(String id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public Date getAdd_date() {
		return add_date;
	}

	public void setAdd_date(Date add_date) {
		this.add_date = add_date;
	}

	@Override
	public String toString() {
		return "Member_MyCock [id=" + id + ", name=" + name + ", add_date=" + add_date + "]";
	}
	
}
