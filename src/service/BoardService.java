package service;

import javax.servlet.ServletContext;

import dao.BoardDao;
import dto.Board;

public class BoardService {
	private ServletContext application;
	private BoardDao boardDao;

	public BoardService(ServletContext application) {
		this.application = application;
		if(application.getAttribute("boardDao") == null) System.out.println("dfljfdlf```````````````");
		this.boardDao = (BoardDao) this.application.getAttribute("boardDao");

	}

	public void write(Board board) {
//		BoardDao boardDao = (BoardDao) application.getAttribute("boardDao");
		System.out.println(board.getBtitle());
		boardDao.insert(board);
	}
}
