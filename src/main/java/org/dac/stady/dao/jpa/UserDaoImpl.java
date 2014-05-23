package org.dac.stady.dao.jpa;  
  
import java.util.List;
import org.dac.stady.dao.UserDao;
import org.dac.stady.domain.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;  
import org.springframework.transaction.annotation.Transactional;
  
@Repository("userDao")  
public class  UserDaoImpl extends DefaultDaoImpl<User> implements UserDao 
{
    @Override  
    @Transactional  
    public User getByName(String name){
        Session session = getSessionfactory().getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add( Restrictions.eq("username", name) );

        @SuppressWarnings("unchecked")
		List<User> list = criteria.list();
        
        if( !list.isEmpty()){
        	return list.get(0);
        } else {
        	return null;
        }
    }
	
}

