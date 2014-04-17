package org.dac.stady.dao.jpa;  
  
import org.dac.stady.dao.UserDao;
import org.dac.stady.domain.User;
import org.springframework.stereotype.Repository;  
  
@Repository("userDao")  
//public class PersonDaoImpl implements PersonDao   
public class  UserDaoImpl extends DefaultDaoImpl<User> implements UserDao 
{}

