package vo;

public class Cocktail {
	private int no;
	private String name;
	private String ename;
	private String f_letter;
	private String img_name;
	private String base;
	private String ingredient;
	private String technique;
	private String glass;
	private int isAcid;
	private int temp;
	private String garnish;
	private String recipe;
	private String tmi;
	private int abv;
	private int taste;
	private int color;
	private String url;
	
	public Cocktail() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getF_letter() {
		return f_letter;
	}

	public void setF_letter(String f_letter) {
		this.f_letter = f_letter;
	}

	public String getImg_name() {
		return img_name;
	}

	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public String getTechnique() {
		return technique;
	}

	public void setTechnique(String technique) {
		this.technique = technique;
	}

	public String getGlass() {
		return glass;
	}

	public void setGlass(String glass) {
		this.glass = glass;
	}

	public int getIsAcid() {
		return isAcid;
	}

	public void setIsAcid(int isAcid) {
		this.isAcid = isAcid;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public String getGarnish() {
		return garnish;
	}

	public void setGarnish(String garnish) {
		this.garnish = garnish;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public String getTmi() {
		return tmi;
	}

	public void setTmi(String tmi) {
		this.tmi = tmi;
	}

	public int getAbv() {
		return abv;
	}

	public void setAbv(int abv) {
		this.abv = abv;
	}

	public int getTaste() {
		return taste;
	}

	public void setTaste(int taste) {
		this.taste = taste;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Cocktail [no=" + no + ", name=" + name + ", ename=" + ename + ", f_letter=" + f_letter + ", img_name="
				+ img_name + ", base=" + base + ", ingredient=" + ingredient + ", technique=" + technique + ", glass="
				+ glass + ", isAcid=" + isAcid + ", temp=" + temp + ", garnish=" + garnish + ", recipe=" + recipe
				+ ", tmi=" + tmi + ", abv=" + abv + ", taste=" + taste + ", color=" + color + ", url=" + url + "]";
	}

}
