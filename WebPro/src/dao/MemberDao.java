package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Member;

public class MemberDao {
	private static MemberDao instance = new MemberDao();

	private MemberDao() {
	};

	public static MemberDao getInstance() {
		return instance;
	}

	/*
	 * public List<Member> SelectAll(){ List<Member> list = new ArrayList<Member>();
	 * Connection conn = null; PreparedStatement ps = null; ResultSet rs = null;
	 * String sql = "select * from member"; try { conn = DBconn.getConnection(); ps
	 * = conn.prepareStatement(sql); rs = ps.executeQuery(); while(rs.next()) {
	 * Member member = new Member(); member.setNo(rs.getInt("no"));
	 * member.setId(rs.getString("id")); member.setPw(rs.getString("pw"));
	 * member.setName(rs.getString("name"));
	 * member.setAddress(rs.getString("address"));
	 * member.setOne_s(rs.getString("one_s")); list.add(member); } } catch
	 * (Exception ex) { ex.printStackTrace(); } finally { DBconn.close(conn, ps,
	 * rs); } return list; }
	 */

	public Member SelectOne(String id) {
		Member member = new Member();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select nickname,img_name from member where id=?";
		try {
			conn = DBconn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				member.setNickname(rs.getString("nickname"));
				member.setImg_name(rs.getString("img_name"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBconn.close(conn, ps, rs);
		}
		return member;
	}

	public boolean insert(Member member) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
//		String sql = "insert into member(no,id,name,nickname,password,address,one_s,img_name) values(member_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		String sql = "insert into member(no,id,name,nickname,password,address,one_s,img_name) values(nextval('member_seq'), ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = DBconn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getId());
			ps.setString(2, member.getName());
			ps.setString(3, member.getNickname());
			ps.setString(4, member.getPw());
			ps.setString(5, member.getAddress());
			ps.setString(6, member.getOne_s());
			ps.setString(7, member.getImg_name());
			int n = ps.executeUpdate();
			if (n == 1) {
				flag = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBconn.close(conn, ps, rs);
		}
		return flag;
	}
	
	public int overappedId(String id) {
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from member where id=?";
		try {
			conn = DBconn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				n = 1;
			} else {
				n = 0;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBconn.close(conn, ps, rs);
		}
		return n;
	}
	
	public int overappedNname(String nickname) {
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from member where nickname=?";
		try {
			conn = DBconn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, nickname);
			rs = ps.executeQuery();
			if (rs.next()) {
				n = 1;
			} else {
				n = 0;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBconn.close(conn, ps, rs);
		}
		return n;
	}

	public int login(String id, String pw) {
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select password from member where id=?";
		try {
			conn = DBconn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getString(1).trim());
				System.out.println(pw);
				if (pw.equals(rs.getString(1).trim()) || pw == rs.getString(1).trim()) {
					n = 1;
				} else {
					n = 0;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBconn.close(conn, ps, rs);
		}
		return n;
	}

	public boolean update(Member member) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		// ResultSet rs = null;
		String sql = "update member set pw=?, name=? where id=?";
		try {
			conn = DBconn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getPw());
			ps.setString(2, member.getName());
			ps.setString(2, member.getId());
			int n = ps.executeUpdate();
			if (n == 1) {
				flag = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBconn.close(conn, ps);
		}
		return flag;
	}

	public boolean delete(String id) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "delete from member where id=?";
		try {
			conn = DBconn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int n = ps.executeUpdate();
			if (n == 1) {
				flag = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBconn.close(conn, ps, rs);
		}
		return flag;
	}


}
