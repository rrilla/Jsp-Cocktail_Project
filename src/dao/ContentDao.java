package dao;

public class ContentDao {
	private static ContentDao instance = new ContentDao();

	private ContentDao() {};

	public static ContentDao getInstance() {
		return instance;
	}
}
