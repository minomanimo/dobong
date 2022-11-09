package DAO;

import java.util.*;
import java.util.function.Function;

import Beans.*;

import java.sql.*;

public class detailDAO {
	private detailDAO() {}
	
	private static detailDAO instance=new detailDAO();
	public static detailDAO getInstance() {
		return instance;
	}
	
	//연결처리 메서드 getConn
		public static Connection getConn() throws Exception{
			Connection conn=null;
			String url="jdbc:mysql://127.0.0.1:3306/dobong";	//DB 변경
			String id="root";
			String pw="iotiot";
			String driver="com.mysql.cj.jdbc.Driver";
			Class.forName(driver);
			conn=DriverManager.getConnection(url, id, pw);
			return conn;
		}
		
		
		//커넥션 연결해제 처리 메서드
		public static void close(Connection conn, Statement stmt, ResultSet rs) {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				System.out.println("연결해제중 오류 발생"+e);
			}
		}
		//rs 없이 close(연결해제 처리 메서드)
		public static void close(Connection conn, Statement stmt) {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				System.out.println("연결해제중 오류 발생"+e);
			}
		}
		
		
		//디비 조회 기능 메서드(전체조회)
		public List<detailDTO> selectAllDetail() {
			List<detailDTO> list=new ArrayList<detailDTO>();	//TO 정보들이 있는곳의 객체를 생성
			String sql="select * from intropage;";
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			try {
				conn=getConn();
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while (rs.next()) {
					detailDTO d=new detailDTO();
					d.setNumber(rs.getInt("number"));
					d.setShortpage(rs.getString("shortpage"));
					d.setDetailpage(rs.getString("detailpage"));
					d.setImageurl(rs.getString("imageurl"));
					d.setTextminning1(rs.getString("textminning1"));
					d.setTextminning2(rs.getString("textminning2"));
					list.add(d);
				}
				System.out.println(list);
			} catch (Exception e) {
				System.out.println("전체조회 중 오류발생"+e);
			}finally {
				detailDAO.close(conn, pstmt, rs); 	
			}
			return list;
		}
		
		//대분류만 보여줄 수 있는 메서드
		public List<detailDTO> selectShortpage() {
			List<detailDTO> shortpage=new ArrayList<detailDTO>();
			
			String sql="select distinct shortpage from intropage;";		//intropage테이블에서 shortpage컬럼 distinct(중복의 제거,별개) 하여 select(보여달라)
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			try {
				conn=getConn();
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while (rs.next()) {
					detailDTO s=new detailDTO();
					s.setShortpage(rs.getString("shortpage"));
					shortpage.add(s);
				}
			} catch (Exception e) {
				System.out.println("selectShortpage() 대분류 접속오류 "+e);
			}finally {
				detailDAO.close(conn, pstmt, rs); 	
			}
			System.out.println(shortpage);
			return shortpage;
		} 
		
		//대분류로 소분류의 자세한 내용보기 //0919: 프로토 타입으로 %문화%만 넣음 
		//대분류에서 클릭된 링크를 ?=파라미터를 통해 넣어주고 아규먼트는 
		//pstmt에 setString으로 소분류만 불어와 줄 수 있게 세팅함 
		//여기에 detailPage 어레이리스트를 디테일jsp에서 보여줌(이건 서블릿에서 사용)
		
		public List<detailDTO> selectDetailPage(String shortpage){
			List<detailDTO> detailPage=new ArrayList<detailDTO>();
			
			String param="%"+shortpage+"%";//이렇게 안하고 바로 like "스트링" 해도 충분히 검색됨!!
			System.out.println(param);
			String sql="select number,shortpage, detailpage, imageurl, textminning1, textminning2, textminning3, textminning4, api_latitude, api_longitude "
					+ "from intropage where number=?";
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			try {
				conn=getConn();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, shortpage);
				rs=pstmt.executeQuery();
				while (rs.next()) {
					detailDTO d=new detailDTO();
					d.setNumber(rs.getInt("number"));	//넘버가 필요해서 추가함
					d.setShortpage(rs.getString("shortpage"));
					d.setDetailpage(rs.getString("detailpage"));
					d.setImageurl(rs.getString("imageurl"));
					d.setTextminning1(rs.getString("textminning1"));
					d.setTextminning2(rs.getString("textminning2"));
					d.setTextminning3(rs.getString("textminning3"));
					d.setTextminning4(rs.getString("textminning4"));
					d.setApi_latitude(rs.getString("api_latitude"));
					d.setApi_longitude(rs.getString("api_longitude"));
					detailPage.add(d);
				}
			} catch (Exception e) {
				System.out.println("selectDetailPage() 소분류 접속오류 "+e);
			}finally {
				detailDAO.close(conn, pstmt, rs); 	
			}
			System.out.println(detailPage);
			return detailPage ;
		} 
		
		//=============================		
		// 리뷰 비회원 업데이트(insert는 create!! 무조건 생성)  
		//==============================
		public int UpdateReview(detailDTO r) {
			int result=-1;
			String sql="update intropage set shortpage=? textminning1=? where number=?";
						
			Connection conn=null;
			PreparedStatement pstmt=null;
			
			try {
				conn=getConn();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, r.getShortpage());
				pstmt.setString(2, r.getTextminning1());
//				pstmt.setString(3, r.getTextminning2());
//				pstmt.setString(4, r.getTextminning3());
//				pstmt.setString(5, r.getTextminning4());
				pstmt.setInt(3, r.getNumber());
				result=pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("UpdateReview() 리뷰작성 sql중 오류: "+e);
			}finally {
				detailDAO.close(conn, pstmt);
			}
			return result;
		}
		
		
		
		
}//c
