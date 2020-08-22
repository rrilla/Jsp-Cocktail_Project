package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.CockList;

public class CockDao {
		private static CockDao instance = new CockDao();
		
		private CockDao() {}
		
		public static CockDao getInstance() {
			return instance;
		}
		
		public List<CockList> selectAll(){
			List<CockList> list = new ArrayList<CockList>();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select * from cocklist order by no";
			try {
				conn = DBconn.getConnection();
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					CockList cock = new CockList();
					cock.setNo(rs.getInt("no"));
					cock.setName(rs.getString("name"));
					cock.setAlike(rs.getString("alike"));
					cock.setBase(rs.getString("base"));
					cock.setTechnique(rs.getString("technique"));
					cock.setTaste(rs.getString("taste"));
					cock.setImg_name(rs.getString("img_name"));
					cock.setFitting(rs.getString("fitting"));
					cock.setTmi(rs.getString("tmi"));
					list.add(cock);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				DBconn.close(conn, ps, rs);
			}
			return list;
		}
		
		public CockList selectOne(){
			CockList cock = new CockList();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select * from cocklist order by no desc";
			try {
				conn = DBconn.getConnection();
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					cock.setNo(rs.getInt("no"));
					cock.setName(rs.getString("name"));
					cock.setAlike(rs.getString("alike"));
					cock.setBase(rs.getString("base"));
					cock.setTechnique(rs.getString("technique"));
					cock.setTaste(rs.getString("taste"));
					cock.setImg_name(rs.getString("image_name"));
					cock.setFitting(rs.getString("fitting"));
					cock.setTmi(rs.getString("tmi"));
				}
				
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				DBconn.close(conn, ps, rs);
			}
			
			return cock;
		}	
}

