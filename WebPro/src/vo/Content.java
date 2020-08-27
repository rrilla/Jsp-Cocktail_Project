package vo;

import java.util.Date;

public class Content {
	private int no;
	private String writer;
	private String title;
	private String content;
	private String img_name;
	private Date write_date;
	
	public Content() {}
	
	public Content(int no, String writer, String title, String content, String img_name) {
		super();
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.img_name = img_name;
	}

	public Content(int no, String writer, String title, String content, String img_name, Date write_date) {
		super();
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.img_name = img_name;
		this.write_date = write_date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg_name() {
		return img_name;
	}

	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}

	public Date getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}

	@Override
	public String toString() {
		return "Content [no=" + no + ", writer=" + writer + ", title=" + title + ", content=" + content + ", img_name="
				+ img_name + ", write_date=" + write_date + "]";
	}
	
}
