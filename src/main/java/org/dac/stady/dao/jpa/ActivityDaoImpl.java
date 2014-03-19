package org.dac.stady.dao.jpa;  
  
import java.util.List;  

import org.dac.stady.dao.ActivityDao;
import org.dac.stady.domain.Activity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;  
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Repository;  
import org.springframework.transaction.annotation.Transactional;
  
  
@Repository("activityDao")  
public class ActivityDaoImpl implements ActivityDao {  
  
    @Autowired  
    private SessionFactory sessionfactory;  

  
    @Override  
    @Transactional  
    public void save(Activity activity) {  
        sessionfactory.getCurrentSession().saveOrUpdate(activity);  
    }  
  
    @Override  
    @Transactional  
    public List<Activity> getActivityList() {  
  
        @SuppressWarnings("unchecked")  
        Session session = sessionfactory.getCurrentSession();
        Criteria  criteria = session.createCriteria(Activity.class);
        criteria.addOrder( Order.desc("activityDate") );
        criteria.addOrder( Order.desc("activityId") );
        List<Activity> list = criteria.list();
        
        return list;  
      }  
  
    @Override  
    @Transactional  
    public Activity getById(Integer id){
    	Activity activity = (Activity) sessionfactory.getCurrentSession().get(Activity.class, id);
    	
    	return activity;
    }
    
    @Override  
    @Transactional  
    public void remove(Integer id){
    	Activity activity = (Activity) sessionfactory.getCurrentSession().load( Activity.class, id );
        if (null != activity) {
            sessionfactory.getCurrentSession().delete(activity);
        }
    }
    
}  