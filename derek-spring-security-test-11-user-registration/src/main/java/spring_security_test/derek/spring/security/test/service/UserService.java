package spring_security_test.derek.spring.security.test.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import spring_security_test.derek.spring.security.test.entity.User;
import spring_security_test.derek.spring.security.test.user.CrmUser;

public interface UserService extends UserDetailsService {

	User findByUserName(String userName);
	
	void save(CrmUser crmUser);
	
}
