package dao;

import java.sql.Connection;

import dto.User;

public class UserDao {
	
	public void insert(User user, Connection conn) {
		System.out.println(" DB에 user 정보 저장했음~");
	}
}
