package org.dac.stady.service;

import java.util.List;
import org.dac.stady.domain.User;

public interface UserService {
    public void add(User user);  
    public List<User> getList();
    public User getById(Integer id);
    public void remove(Integer id);
}
