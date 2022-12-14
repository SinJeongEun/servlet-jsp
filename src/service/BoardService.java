package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.BoardDao;
import dto.Board;

public class BoardService {
	private ServletContext application;
	private BoardDao boardDao;
	private DataSource ds;

	public BoardService(ServletContext application) {
		this.application = application;
		this.boardDao = (BoardDao) this.application.getAttribute("boardDao");
		
		try {
//		      InitialContext ic = new InitialContext();
//		      ds = (DataSource) ic.lookup("java:comp/env/jdbc/java");
			
			ds = (DataSource) application.getAttribute("dataSource");
			
		      Connection conn = ds.getConnection();
		      conn.close();
		      }catch(Exception e) {
		         e.printStackTrace();
		      }

	}

	public void write(Board board) {
//		BoardDao boardDao = (BoardDao) application.getAttribute("boardDao");
		System.out.println(board.getBtitle());
		boardDao.insert(board);
	}
	
	public void write2(Board board) {
//		BoardDao boardDao = (BoardDao) application.getAttribute("boardDao");
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			boardDao.insert2(board, conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {conn.close();} catch (SQLException e) {}
			}
	}

	public int getTotalBoardNum() {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			result = boardDao.countRows(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { conn.close();} catch (SQLException e) {}
		}
		
		return result;
	}
}
