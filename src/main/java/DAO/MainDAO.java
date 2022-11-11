package DAO;

import java.sql.*;
import java.util.*;

import Beans.*;

public class MainDAO {
	private MainDAO() {}
	private static MainDAO instance=new MainDAO();
	public static MainDAO getInstance() {
		return instance;
	}
	public Connection getConnection() throws Exception{
		Connection conn=null;
		String url="jdbc:mysql://127.0.0.1:3306/dobong";
		String id="root";
		String pass="iotiot";
		String driver="com.mysql.cj.jdbc.Driver";
		Class.forName(driver);
		conn=DriverManager.getConnection(url,id,pass);
		return conn;
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
				System.out.println("close() 실행중 오류발생 : "+e);
			}
		
	}
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (Exception e) {
			System.out.println("close() 실행중 오류발생 : "+e);
		}
	
	}
	
	public List<ImageDTO> getLandmarkImg(){
		ImageDTO dto=null;
		List<ImageDTO> imglist=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from imageurl where page_num=0";
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				dto=new ImageDTO();
				String url=rs.getString("imageurl");
				int number=rs.getInt("number");
				int page_num=rs.getInt("page_num");
				dto.setImageurl(url);
				dto.setNumber(number);
				dto.setPage_num(page_num);
				imglist.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getLandmarkImg() 실행중 오류발생 : "+e);
		}finally {
			MainDAO.close(conn, pstmt, rs);
		}
		return imglist;
	}
	
	public void setLandmarkImg(List<ImageDTO> imglist) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="update imageurl set imageurl=? where number=?";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			for(ImageDTO dto : imglist) {
				pstmt.setString(1, dto.getImageurl());
				pstmt.setInt(2, dto.getNumber());
				pstmt.executeUpdate();
			}
		}catch(Exception e) {
			System.out.println("setLandmarkImg() 실행중 오류발생 : "+e);
		}finally {
			MainDAO.close(conn, pstmt);
		}
	}
}
