package spring_security_test.derek.spring.security.test.dao;

import spring_security_test.derek.spring.security.test.entity.User;

public interface UserDao {

	
	User findByUserName(String userName);
	
	void save(User user);
	
}
