package dao;

public class CommDao {
	private static CommDao instance = new CommDao();

	private CommDao() {};

	public static CommDao getInstance() {
		return instance;
	}
}
