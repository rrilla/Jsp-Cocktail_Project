package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import vo.CockList;
import vo.Member;

public class CockDao2 {
		private static CockDao2 instance = new CockDao2();
		
		private CockDao2() {}
		
		public static CockDao2 getInstance() {
			return instance;
		}
		
		public List<CockList> selectAll(){
			List<CockList> list = new ArrayList<CockList>();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select no,name,alike,base,technique,taste,img_name,fitting,tmi from cocklist";
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
		
		public CockList SelectOne(int no){
			CockList cock = new CockList();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select no,name,alike,base,technique,taste,img_name,fitting,tmi from cocklist where no=?";
			try {
				conn = DBconn.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setInt(1, no);
				rs = ps.executeQuery();
				while(rs.next()) {
					cock.setNo(rs.getInt("no"));
					cock.setName(rs.getString("name"));
					cock.setAlike(rs.getString("alike"));
					cock.setBase(rs.getString("base"));
					cock.setTechnique(rs.getString("technique"));
					cock.setTaste(rs.getString("taste"));
					cock.setImg_name(rs.getString("img_name"));
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
		
		public List<CockList> relevantCock(String base,int no){
			List<CockList> list = new ArrayList<CockList>();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select no,name from cocklist where base=? and no!=?";
			try {
				conn = DBconn.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, base);
				ps.setInt(2, no);
				rs = ps.executeQuery();
				while(rs.next()) {
					CockList cock = new CockList();
					cock.setNo(rs.getInt("no"));
					cock.setName(rs.getString("name"));
					list.add(cock);
				}
				
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				DBconn.close(conn, ps, rs);
			}
			return list;
		}
		
		public List<CockList> searchName(String cName){
			List<CockList> list = new ArrayList<CockList>();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select no,name,alike,base,technique,taste,img_name,fitting,tmi from cocklist where name like ?";
			try {
				conn = DBconn.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+cName+"%");
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
		
		public List<String> rName(){
			List<String> list = new ArrayList<String>();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select name from cocklist";
			try {
				conn = DBconn.getConnection();
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					list.add(rs.getString("name"));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				DBconn.close(conn, ps, rs);
			}
			return list;
		}
		
}

