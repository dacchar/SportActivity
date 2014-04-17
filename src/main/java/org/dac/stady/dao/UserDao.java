package org.dac.stady.dao;  
  
import java.util.List;  
import org.dac.stady.domain.User;
  
public interface UserDao {  
	public void save(User user);  
	public List<User> getList();  
	public User getById(Integer id);
	public void remove(Integer id);
}  