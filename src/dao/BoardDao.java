package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Board;

public class BoardDao {
	public void insert(Board board) {
		System.out.println("~~~~~~~~~~~~~ " + board.getBtitle());
	}
	
	 public int insert2(Board board, Connection conn) throws Exception {
	      String sql = "insert into boards2(bno, btitle, bcontent, bwriter, bdate, bhitcount, bfilename, bsavedname, bfiletype) ";
	      sql += "values(seq_boards2_bno.nextval, ?, ?, ?, sysdate, 0, ?, ?, ?)";
	      
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, board.getBtitle());
	      pstmt.setString(2, board.getBcontent());
	      pstmt.setString(3, board.getBwriter());
	      pstmt.setString(4, board.getBfileName());
	      pstmt.setString(5, board.getBsavedName());
	      pstmt.setString(6, board.getBfileType());
	      int rows = pstmt.executeUpdate();
	      pstmt.close();
	      return rows;
	   }

	public int countRows(Connection conn) throws Exception {		
		String sql = "select count(*) from boards2";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		
		int result = rs.getInt(1);
		rs.close();
		pstmt.close();
		
		return result;
		
	}
}
