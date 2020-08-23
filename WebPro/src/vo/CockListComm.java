package vo;

import java.util.Date;

public class CockListComm {
	private int no;
	private int cocklist_no;
	private String id;
	private String content;
	private Date write_date;
	
	public CockListComm() {}
	
	public CockListComm(int no, int cocklist_no, String id, String content) {
		super();
		this.no = no;
		this.cocklist_no = cocklist_no;
		this.id = id;
		this.content = content;
	}

	public CockListComm(int no, int cocklist_no, String id, String content, Date write_date) {
		super();
		this.no = no;
		this.cocklist_no = cocklist_no;
		this.id = id;
		this.content = content;
		this.write_date = write_date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCocklist_no() {
		return cocklist_no;
	}

	public void setCocklist_no(int cocklist_no) {
		this.cocklist_no = cocklist_no;
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
		return "CockListComm [no=" + no + ", cocklist_no=" + cocklist_no + ", id=" + id + ", content=" + content
				+ ", write_date=" + write_date + "]";
	}

}
