package DAO;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import org.apache.taglibs.standard.tag.compat.sql.TransactionTag;

import Beans.NoticeDTO;

public class NoticeDAO {
	private NoticeDAO() {}
	
	private static NoticeDAO instance=new NoticeDAO();
	public static NoticeDAO getInstance() {
		return instance;
	}

	//연결처리 메서드 getConn
	public static Connection getConn() throws Exception{
		Connection conn=null;
		String url="jdbc:mysql://127.0.0.1:3306/dobong";
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
	
	//============================
	//  전체 공지사항 내용보기 
	//============================
	public List<NoticeDTO>  selectAllReview(){
		List<NoticeDTO> list=new ArrayList<NoticeDTO>();
		String sql="select * from notice order by number desc;";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=getConn();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				NoticeDTO n=new NoticeDTO();
				n.setNumber(rs.getString("number"));
				n.setNickname(rs.getString("nickname"));
				n.setTitle(rs.getString("title"));
				n.setContent(rs.getString("content"));
				n.setWritingtime(rs.getString("writingtime"));	//연도 빼는 작업필요
				//n.setChangetime(rs.getString("changetime"));		//연도 빼는 작업필요
				list.add(n);
			}
			
		} catch (Exception e) {
			System.out.println("selectAllReview() 실행오류: "+e);
		}finally {
			NoticeDAO.close(conn, pstmt, rs);
		}
		return list;
	}
	
	//============================
	//  title로 내용보기 
	//============================
	//(number으로 아규먼트로 사용함) 
	public NoticeDTO selectContent(String number) {
		NoticeDTO DTO=null;
		//List<NoticeDTO> NoticeDetailList=new ArrayList<NoticeDTO>();	//왜 주석처리 했지????
		
		String sql="select * from notice where number=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=getConn();
			pstmt=conn.prepareStatement(sql);	//순서 pstmt에 ?의 값을 넣어주어야 한다!!
			pstmt.setString(1, number);
			rs=pstmt.executeQuery();
			//없을 수도 있어서 if 사용
			if(rs.next()) {
				DTO=new NoticeDTO();
				DTO.setNumber(rs.getString("number"));
				DTO.setNickname(rs.getString("nickname"));
				DTO.setTitle(rs.getString("title"));
				DTO.setContent(rs.getString("content"));
				DTO.setWritingtime(rs.getString("writingtime"));
				//DTO.setChangetime(rs.getString("changetime"));
				//NoticeDetailList.add(nc);
			}
		} catch (Exception e) {
			System.out.println("selectContent()접속오류 "+e);
		}finally {
		NoticeDAO.close(conn, pstmt, rs);
		}
		return DTO;
	}
	
	//============================
	//  공지사항 글쓰기(글등록)
	//============================
	public int insertNoice(NoticeDTO n) {
		//추가항목 5개
		int result=-1;	//이걸 꼭 해줘야하네 왜지???? 
		String sql="insert into notice (nickname, title, content, writingtime)"
				+ "values(?, ?, ?, ?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=getConn();
			pstmt=conn.prepareStatement(sql);
			
			//pstmt.setString(1, n.getNumber());
			pstmt.setString(1, n.getNickname());
			pstmt.setString(2, n.getTitle());
			pstmt.setString(3, n.getContent());
//			pstmt.setString(5, n.getWritingtime());		//Date타입으로 넣기위해 캐스팅 확인!
			pstmt.setString(4, NoticeDAO.getDate());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("insertNoice() sql오류: "+e);
		}finally {
			NoticeDAO.close(conn, pstmt);
		}
		return result;
	}
	
	//============================
	//  글쓰기 시간 메서드 
	//============================
	//sql SELECT NOW()/sql에서 적힌값으로 바로 date 넣어줌
	public static String getDate() {
		String sql="SELECT NOW();";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=getConn();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			System.out.println("getDate() 시간기록 중 오류: "+e);
		}finally {
			NoticeDAO.close(conn, pstmt, rs);
		}
		
		return "";	//오류가 나면 빈문자열로 반환세팅
	}
	
	//============================
	//  공지사항 수정(update)
	//============================
	public void updateNoice(NoticeDTO DTO) {
		String sql="update notice set title=?, content=? where number=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, DTO.getTitle());
			pstmt.setString(2, DTO.getContent());
			pstmt.setString(3, DTO.getNumber());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("updateNoice() sql 접속오류: "+e);
		}finally {
			NoticeDAO.close(conn, pstmt);
		}
	}

	//============================
	//  공지사항 삭제(delete)
	//============================
	public void deleteNotice(String number) {
		String sql="delete from notice where number=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, number);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("deleteNotice() sql 오류: "+e);
		}finally {
			NoticeDAO.close(conn, pstmt);
		}
	}
	
	//==========================================
	// 페이지처리(int 현재페이지, int 목록페이지) 목록개수설정
	//==========================================
	public ArrayList<NoticeDTO> findList(int currentPage, int recordsPerPage){
		//1019페이지번호 리턴값을 받기 위해 수정=======
		ArrayList<NoticeDTO> list=new ArrayList<NoticeDTO>();
		
		int start; 			//페이지 처음 시작 변수 1,11,21~n1
		start=currentPage*recordsPerPage-recordsPerPage;	//1와 5개씩 보기라면 실제 디비에서 가져와야할 항목은 0~4의 글가져오기(x*y-y)
		
		//select limit ?, ? = n번째 부터 n2까지의 값 select
		//페이지처리도 number desc 처리 
		String sql="select * from notice order by number desc limit ?, ?";			
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, recordsPerPage);
			rs=pstmt.executeQuery();
			
			while (rs.next()) {
				NoticeDTO n=new NoticeDTO();
				n.setNumber(rs.getString("number"));
				n.setTitle(rs.getString("title"));
				n.setContent(rs.getString("content"));
				n.setWritingtime(rs.getString("writingtime"));
				list.add(n);
			}
		}catch (Exception e) {
			System.out.println("findList() 오류: "+e);
		}finally {
			NoticeDAO.close(conn, pstmt, rs);
		}
		
		return list;
	}



	//=================================
	// 전체자료의 개수 구하기(count 사용)
	//=================================
	public int getNumOfRows() {
		int numOfRows=0;	//데이터가 있는지 저장할 공간
		
		String sql="select count(number) from notice";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=getConn();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			numOfRows=Integer.parseInt(rs.getString(1));	//1을 바로 세팅해 주나보다
			
		} catch (Exception e) {
			System.out.println("getNumOfRows() 오류: "+e);
		}finally {
			NoticeDAO.close(conn, pstmt, rs);
		}
		return numOfRows;
	}
	
	//============================
	//  공지사항 검색하기 (검색타입, 검색어) 
	//============================
	public ArrayList<NoticeDTO> getSearch(String type, String text){
		ArrayList<NoticeDTO> sList=new ArrayList<NoticeDTO>();
		
		String sql="select * from notice where "+type.trim();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			if(text!=null && !text.equals("")) {
				sql=" like '%"+text.trim()+"%' order by notice desc limit 10";
				//검색페이지 수는 10개로 세팅 
			}
			conn=getConn();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				NoticeDTO s =new NoticeDTO();
				s.setNumber(rs.getString("number"));
				s.setTitle(rs.getString("title"));
				s.setContent(rs.getNString("content"));
				s.setWritingtime(rs.getString("writingtime"));
				sList.add(s);
			}
			
		} catch (Exception e) {
			System.out.println("NoticeDAO getSearch() sql 접속오류: "+e);
		}finally {
			NoticeDAO.close(conn, pstmt, rs);
		}
		return sList;
	}
	
}//c
