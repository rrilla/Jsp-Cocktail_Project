package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.CockList;
import vo.CockListComm;

public class ListCommDao {
	private static ListCommDao instance = new ListCommDao();

	private ListCommDao() {};

	public static ListCommDao getInstance() {
		return instance;
	}
	
	public List<CockListComm> selectAll(int no){
		List<CockListComm> list = new ArrayList<CockListComm>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from cocklist_comm where cocklist_no=?";
		try {
			conn = DBconn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			while(rs.next()) {
				CockListComm listComm = new CockListComm();
				listComm.setNo(rs.getInt("no"));
				listComm.setCocklist_no(rs.getInt("cocklist_no"));
				listComm.setId(rs.getString("id"));
				listComm.setContent(rs.getString("content"));
				listComm.setWrite_date(rs.getDate("write_date"));
				list.add(listComm);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBconn.close(conn, ps, rs);
		}
		return list;
	}
	
	public boolean insertComm(CockListComm cockListComm){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql="insert into cocklist_comm(no, cocklist_no, id, content) "
				+ "values(cocklist_comm_seq.nextval,?,?,?)";
		try{
			conn = DBconn.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, cockListComm.getCocklist_no());
			ps.setString(2,cockListComm.getId());
			ps.setString(3, cockListComm.getContent());
			int n=ps.executeUpdate();
			if(n==1) {
				flag=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBconn.close(conn,ps);
		}
		return flag;
	}
	
}
