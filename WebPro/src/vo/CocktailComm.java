package vo;

import java.util.Date;

public class CocktailComm {
	private int no;
	private int cocktail_no;
	private int rno;
	private String id;
	private String content;
	private Date write_date;
	private String nickname;
	private String img_name;
	
	
	public CocktailComm() {}
	
	public CocktailComm(int cocklist_no, String id, String content) {
		super();
		this.cocktail_no = cocklist_no;
		this.id = id;
		this.content = content;
	}

	public CocktailComm(int cocklist_no, int rno, String id, String content) {
		super();
		this.cocktail_no = cocklist_no;
		this.rno = rno;
		this.id = id;
		this.content = content;
	}
	
	public String getImg_name() {
		return img_name;
	}

	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCocktail_no() {
		return cocktail_no;
	}

	public void setCocktail_no(int cocktail_no) {
		this.cocktail_no = cocktail_no;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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
		return "CocktailComm [no=" + no + ", cocktail_no=" + cocktail_no + ", rno=" + rno + ", id=" + id + ", nickname="
				+ nickname + ", content=" + content + ", write_date=" + write_date + "]";
	}

}
