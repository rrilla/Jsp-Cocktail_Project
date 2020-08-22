package vo;

import java.util.Date;

public class Comm {
	private int no;
	private String id;
	private String content;
	private Date write_date;
	
	public Comm() {}

	public Comm(int no, String id, String content, Date write_date) {
		super();
		this.no = no;
		this.id = id;
		this.content = content;
		this.write_date = write_date;
	}

	public Comm(int no, String id, String content) {
		super();
		this.no = no;
		this.id = id;
		this.content = content;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}

	@Override
	public String toString() {
		return "Comm [no=" + no + ", id=" + id + ", content=" + content + ", write_date=" + write_date + "]";
	}
	
}
