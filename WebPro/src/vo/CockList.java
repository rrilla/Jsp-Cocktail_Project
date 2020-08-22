package vo;

public class CockList {
	private int no;
	private String img_name;
	private String name;
	private String alike;
	private String base;
	private String technique;
	private String taste;
	private String fitting;
	private String tmi;
	
	public CockList() {}
	
	public CockList(String img_name, String name, String alike, String base, String technique, String taste,
			String fitting, String tmi) {
		super();
		this.img_name = img_name;
		this.name = name;
		this.alike = alike;
		this.base = base;
		this.technique = technique;
		this.taste = taste;
		this.fitting = fitting;
		this.tmi = tmi;
	}

	public CockList(int no, String img_name, String name, String alike, String base, String technique, String taste,
			String fitting, String tmi) {
		super();
		this.no = no;
		this.img_name = img_name;
		this.name = name;
		this.alike = alike;
		this.base = base;
		this.technique = technique;
		this.taste = taste;
		this.fitting = fitting;
		this.tmi = tmi;
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

	public String getAlike() {
		return alike;
	}

	public void setAlike(String alike) {
		this.alike = alike;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getTechnique() {
		return technique;
	}

	public void setTechnique(String technique) {
		this.technique = technique;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public String getFitting() {
		return fitting;
	}

	public void setFitting(String fitting) {
		this.fitting = fitting;
	}

	public String getTmi() {
		return tmi;
	}

	public void setTmi(String tmi) {
		this.tmi = tmi;
	}

}
