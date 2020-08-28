	package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.CocktailComm;

public class CockCommDao {
	private static CockCommDao instance = new CockCommDao();

	private CockCommDao() {};

	public static CockCommDao getInstance() {
		return instance;
	}
	
	public List<CocktailComm> selectAll(int no){
		List<CocktailComm> list = new ArrayList<CocktailComm>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select m.nickname, m.img_name, c.id, c.content, c.cocktail_no from member m, cocktail_comm c where c.cocktail_no = ?";
		try {
			conn = DBconn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			while(rs.next()) {
				CocktailComm listComm = new CocktailComm();
				listComm.setNickname(rs.getString("nickname"));
				listComm.setImg_name(rs.getString("img_name"));
				listComm.setId(rs.getString("id"));
				listComm.setContent(rs.getString("content"));
				listComm.setCocktail_no(rs.getInt("cocktail_no"));
				list.add(listComm);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBconn.close(conn, ps, rs);
		}
		return list;
	}
	
	public boolean insertComm(CocktailComm cocktailComm){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql="insert into cocktail_comm(no, cocktail_no, id, content) "
				+ "values(cocklist_comm_seq.nextval,?,?,?)";
		try{
			conn = DBconn.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, cocktailComm.getCocktail_no());
			ps.setString(2, cocktailComm.getId());
			ps.setString(3, cocktailComm.getContent());
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
