package com.supphoto.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.supphoto.db.MySqlSessionManager;

public class UserDAO {
	private SqlSessionFactory factory = MySqlSessionManager.getFactory();
	
	public UserVO login(UserVO uvo) {
		SqlSession sqlSession = factory.openSession(true);
		return uvo;
	}
}
