package DAO;

import java.util.*;
import java.sql.*;
import Beans.MemberDTO;

public class MemberDAO {
	
	private MemberDAO() {}
	private static MemberDAO instance=new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	
	//연결처리 메서드 getConn
		public Connection getConn() throws Exception{
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
		
		//=================		
		//	  회원가입 메서드
		//=================
		public int insertMember(MemberDTO m) {
			int result=-1;//이거 어디에 쓰지?? 기억이 안난다!! //insert 사용 rs가 없다!
							//인설트 되었는지 안됬는지 체크할려고 있나보다! 
			
			String sql= "insert into register(id,nickname,name,password, phone, email, address, tos1, tos2, category, meter)"
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			Connection conn=null;
			PreparedStatement pstmt=null;
			
			try {
				conn=getConn();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, m.getId());
				pstmt.setString(2, m.getNickname());
				pstmt.setString(3, m.getName());
				pstmt.setString(4, m.getPassword());
				pstmt.setString(5, m.getPhone());
				pstmt.setString(6, m.getEmail());
				pstmt.setString(7, m.getAddress());
				pstmt.setString(8, m.getTos1());
				pstmt.setString(9, m.getTos2());
				pstmt.setInt(10, m.getAdmin());
				pstmt.setString(11, m.getMeter());
				result=pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("insertMember() sql 오류: "+e);
			}finally {
				MemberDAO.close(conn, pstmt);
			}
			return result;
		}
		
		//=====================		
		//	  사용자 인증처리(로그인)
		//=====================
		public int userCheck(String id, String pwd) {
			//	1; 아이디가 존재하고 비번일치(성공)
			//	0; 비번없거나 일치하지 않는 경우(비번 안내)
			//	-1; 디폴트(실패)
			int result=-1;
			
			String sql="select password from register where id=?";
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			try {
				conn=getConn();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();
				
//				1.해당 아이가 존재한다면
				if(rs.next()) {
					if(rs.getString("password").equals(pwd)&&
						rs.getString("password")!=null) {	//패스워드의 값이 같고 null아니라면
						result=1;	//ID有 pwOK
					}else //pw불일치
						result=0;
				}else
					result=-1;
			} catch (Exception e) {
				System.out.println("userCheck() 접속중 오류: "+e);
			}finally {
				MemberDAO.close(conn, pstmt, rs);
			}
			return result;
		}
		
		//=====================		
		// 사용자 정보조회(로그인 정보)
		//=====================
		public MemberDTO getMember(String userid) {
			MemberDTO m=new MemberDTO();
			String sql="select * from register where id=?";
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			try {
				conn=getConn();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, userid);
				rs=pstmt.executeQuery();
				
				if(rs.next()) {	  
					m.setNumber(rs.getInt("number"));
					m.setId(rs.getString("id"));
					m.setNickname(rs.getString("nickname"));
					m.setName(rs.getString("name"));
					m.setPassword(rs.getString("password"));
					m.setPhone(rs.getString("phone"));
					m.setEmail(rs.getString("email"));
					m.setAddress(rs.getString("address"));
					m.setTos1(rs.getString("tos1"));
					m.setTos2(rs.getString("tos2"));
					m.setMeter(rs.getString("meter"));
					m.setAdmin(rs.getInt("admin"));
				}
				
			} catch (Exception e) {
				System.out.println("getMember() 접송중 오류: "+e);
			}finally {
				MemberDAO.close(conn, pstmt, rs);
			}
			//여기는 어레이 리스트 말고 객체 통채로 리턴함 꼭 확인할거! 
			return m;	
		}
		//=====================		
		//  관리자용 회원정보 조회
		//=====================
		public ArrayList<MemberDTO> getAllMember(int currentPage) {
			ArrayList<MemberDTO> mList=new ArrayList<>();
			MemberDTO m=null;
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			int start=(currentPage-1)*20;
			String sql="select * from register limit ?,20";
			try {
				conn=getConn();
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, start);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					m=new MemberDTO();
					m.setNumber(rs.getInt("number"));
					m.setId(rs.getString("id"));
					m.setNickname(rs.getString("nickname"));
					m.setName(rs.getString("name"));
					m.setPassword(rs.getString("password"));
					m.setPhone(rs.getString("phone"));
					m.setEmail(rs.getString("email"));
					m.setAddress(rs.getString("address"));
					m.setTos1(rs.getString("tos1"));
					m.setTos2(rs.getString("tos2"));
					m.setMeter(rs.getString("meter"));
					m.setAdmin(rs.getInt("admin"));
					mList.add(m);
				}
			}catch(Exception e) {
				System.out.println("getAllMember() 실행중 오류발생 : "+e);
			}finally {
				MemberDAO.close(conn, pstmt, rs);
			}
			return mList;
		}
		//=====================		
		//  관리자 신규 등록
		//=====================
		public int changeAdmin(String id,int admin) {
			int result=0;
			Connection conn=null;
			PreparedStatement pstmt=null;
			String sql="update register set admin=? where id=?";

			try {
				conn=getConn();
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, admin);
				pstmt.setString(2, id);
				pstmt.executeUpdate();
			}catch(Exception e) {
				System.out.println("changeAdmin() 실행중 오류발생 : "+e);
			}finally {
				MemberDAO.close(conn, pstmt);
			}
			return result;
		}
		//=====================		
		//  전체 회원 수 
		//=====================
		public int memberCount() {
			int count=0;
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String sql="select count(*) from register";
			try {
				conn=getConn();
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				rs.next();
				count=rs.getInt(1);
			}catch(Exception e) {
				System.out.println("memberCount() 실행중 오류발생 : "+e);
			}finally {
				MemberDAO.close(conn, pstmt, rs);
			}
			return count;
		}
}//c
