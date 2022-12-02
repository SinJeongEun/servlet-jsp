package dao;

import java.sql.Connection;

import dto.Board;

public class BoardDao {
	public void insert(Board board) {
		System.out.println("~~~~~~~~~~~~~ " + board.getBtitle());
	}
}
