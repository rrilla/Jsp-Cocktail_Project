package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Member;
import vo.Member_MyCock;

public class MyCockDao {
	private static MyCockDao instance = new MyCockDao();

	private MyCockDao() {};

	public static MyCockDao getInstance() {
		return instance;
	}
	
	public List<Member_MyCock> selectAll(String id) {
		List<Member_MyCock> list = new ArrayList<Member_MyCock>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select m.id, c.no, c.img_name, c.name, c.base from member_mycock m,cocktail c where id=? and m.cocktail_no = c.no";
		try {
			conn = DBconn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				Member_MyCock myCock = new Member_MyCock(
						rs.getString("id"),
						rs.getInt("no"),
						rs.getString("img_name"),
						rs.getString("name"),
						rs.getString("base")
						);
				list.add(myCock);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBconn.close(conn, ps, rs);
		}
		return list;
	}
	
	public boolean checkAdd(String id, int no) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from member_mycock where id=? and cocktail_no=?";
		try {
			conn = DBconn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, no);
			rs = ps.executeQuery();
			if(rs.next()) {
				flag = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBconn.close(conn, ps, rs);
		}
		return flag;
	}
	
	public boolean addMyCock(String id, int no) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into member_mycock(id, cocktail_no) values(?, ?)";
		try {
			conn = DBconn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, no);
			int n = ps.executeUpdate();
			if(n == 1) {
				flag = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBconn.close(conn, ps);
		}
		return flag;
	}
	
	public boolean delMyCock(String id, int no) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from member_mycock where id=? and cocktail_no=?";
		try {
			conn = DBconn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, no);
			int n = ps.executeUpdate();
			if(n == 1) {
				flag = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBconn.close(conn, ps);
		}
		return flag;
	}
}
