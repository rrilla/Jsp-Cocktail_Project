package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import vo.CockList;
import vo.Cocktail;
import vo.Member;

public class CockDao {
		private static CockDao instance = new CockDao();
		
		private CockDao() {}
		
		public static CockDao getInstance() {
			return instance;
		}
		
		//전체리스트에 가져올 데이터
		public List<Cocktail> selectAll(){
			List<Cocktail> list = new ArrayList<Cocktail>();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select no,name,ename,f_letter,img_name,base,isacid from cocktail";
			try {
				conn = DBconn.getConnection();
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					Cocktail cock = new Cocktail();
					cock.setNo(rs.getInt("no"));
					cock.setName(rs.getString("name"));
					cock.setEname(rs.getString("ename"));
					cock.setF_letter(rs.getString("f_letter"));
					cock.setImg_name(rs.getString("img_name"));
					cock.setBase(rs.getString("base"));
					cock.setIsAcid(rs.getInt("isacid"));
					list.add(cock);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				DBconn.close(conn, ps, rs);
			}
			return list;
		}
		
		//상세정보시 가져올 데이터
		public Cocktail SelectOne(int no){
			Cocktail cock = new Cocktail();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select no,name,ename,img_name,base,ingredient,technique,glass,garnish,recipe,tmi,taste,isacid from cocktail where no=?";
			try {
				conn = DBconn.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setInt(1, no);
				rs = ps.executeQuery();
				while(rs.next()) {
					cock.setNo(rs.getInt("no"));
					cock.setName(rs.getString("name"));
					cock.setEname(rs.getString("ename"));
					cock.setImg_name(rs.getString("img_name"));
					cock.setBase(rs.getString("base"));
					cock.setIngredient(rs.getString("ingredient"));
					cock.setTechnique(rs.getString("technique"));
					cock.setGlass(rs.getString("glass"));
					cock.setGarnish(rs.getString("garnish"));
					cock.setRecipe(rs.getString("recipe"));
					cock.setTmi(rs.getString("tmi"));
					cock.setTaste(rs.getInt("taste"));
					cock.setIsAcid(rs.getInt("isacid"));
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				DBconn.close(conn, ps, rs);
			}
			return cock;
		}
		
		//연관칵테일 가져올 데이터
		public List<Cocktail> relevantCock(String base,int no){
			List<Cocktail> list = new ArrayList<Cocktail>();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select no,name from cocktail where base=? and no!=?";
			try {
				conn = DBconn.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, base);
				ps.setInt(2, no);
				rs = ps.executeQuery();
				while(rs.next()) {
					Cocktail cock = new Cocktail();
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
		
		//이름 검색 가져올 데이터
		public List<Cocktail> searchName(String cName){
			List<Cocktail> list = new ArrayList<Cocktail>();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select no,name,ename,base,img_name,isacid from cocktail where name like ?";
			try {
				conn = DBconn.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+cName+"%");
				rs = ps.executeQuery();
//				int n = ps.executeUpdate();
//				if(n == 0) {
//					System.out.println("이름검색결과 없음");
//				}
				while(rs.next()) {
					Cocktail cock = new Cocktail();
					cock.setNo(rs.getInt("no"));
					cock.setName(rs.getString("name"));
					cock.setEname(rs.getString("ename"));
					cock.setBase(rs.getString("base"));
					cock.setImg_name(rs.getString("img_name"));
					cock.setIsAcid(rs.getInt("isacid"));
					list.add(cock);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				DBconn.close(conn, ps, rs);
			}
			return list;
		}
		
		//검색창에 랜덤으로 띄울 이름 가져오기
		public List<String> rName(){
			List<String> list = new ArrayList<String>();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select name from cocktail";
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
		
		
		public List<Cocktail> searchAbv(int abv){
			List<Cocktail> list = new ArrayList<Cocktail>();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select no,name,ename,img_name,base,isacid from cocktail where abv like ?";
			try {
				conn = DBconn.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+abv+"%");
				rs = ps.executeQuery();
				while(rs.next()) {
					Cocktail cock = new Cocktail();
					cock.setNo(rs.getInt("no"));
					cock.setName(rs.getString("name"));
					cock.setEname(rs.getString("ename"));
					cock.setBase(rs.getString("base"));
					cock.setImg_name(rs.getString("img_name"));
					cock.setIsAcid(rs.getInt("isacid"));
					list.add(cock);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				DBconn.close(conn, ps, rs);
			}
			return list;
		}
		
		public List<Cocktail> searchColor(int abv, int color){
			List<Cocktail> list = new ArrayList<Cocktail>();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select no,name,ename,img_name,base,isacid from cocktail where abv like ? and color like ?";
			try {
				conn = DBconn.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+abv+"%");
				ps.setString(2, "%"+color+"%");
				rs = ps.executeQuery();
				while(rs.next()) {
					Cocktail cock = new Cocktail();
					cock.setNo(rs.getInt("no"));
					cock.setName(rs.getString("name"));
					cock.setEname(rs.getString("ename"));
					cock.setBase(rs.getString("base"));
					cock.setImg_name(rs.getString("img_name"));
					cock.setIsAcid(rs.getInt("isacid"));
					list.add(cock);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				DBconn.close(conn, ps, rs);
			}
			return list;
		}
		
}

