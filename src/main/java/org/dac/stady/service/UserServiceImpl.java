package org.dac.stady.service;

import java.util.List;
import org.dac.stady.dao.UserDao;
import org.dac.stady.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service  
//@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)  
public class UserServiceImpl implements UserService {

    @Autowired  
    private UserDao userDao;  
	
	@Override
	@Transactional
	public void add(User user) {
		userDao.save(user);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> getList() {
		return userDao.getList(); 
	}

	@Override
	@Transactional(readOnly = true)
	public User getById(Integer id) {
		return userDao.getById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public User getByName(String name) {
		return userDao.getByName(name);
	}
	
	@Override
	@Transactional
	public void remove(Integer id) {
		userDao.remove(id);
	}
}
