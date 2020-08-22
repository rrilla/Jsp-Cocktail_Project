package dao;

public class MyCockDao {
	private static MyCockDao instance = new MyCockDao();

	private MyCockDao() {};

	public static MyCockDao getInstance() {
		return instance;
	}
}
