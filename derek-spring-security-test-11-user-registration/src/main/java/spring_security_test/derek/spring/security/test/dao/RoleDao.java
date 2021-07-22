package spring_security_test.derek.spring.security.test.dao;

import spring_security_test.derek.spring.security.test.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
