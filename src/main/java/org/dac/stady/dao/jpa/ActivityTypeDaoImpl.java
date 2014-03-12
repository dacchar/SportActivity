package org.dac.stady.dao.jpa;  
  
import java.util.List;  
import org.dac.stady.dao.ActivityTypeDao;
import org.dac.stady.domain.ActivityType;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Repository;  
import org.springframework.transaction.annotation.Transactional;
  
  
@Repository("activityTypeDao")  
public class ActivityTypeDaoImpl implements ActivityTypeDao {  
  
    @Autowired  
    private SessionFactory sessionfactory;  

  
    @Override  
    @Transactional  
    public void save(ActivityType activityType) {  
        sessionfactory.getCurrentSession().saveOrUpdate(activityType);  
    }  
  
    @Override  
    @Transactional  
    public List<ActivityType> getActivityTypeList() {  
  
        @SuppressWarnings("unchecked")  
        Session session = sessionfactory.getCurrentSession();
        Criteria  criteria = session.createCriteria(ActivityType.class);
        List<ActivityType> userlist = criteria.list();

        return userlist;  
      }  
  
    @Override  
    @Transactional  
    public ActivityType getById(Integer id){
    	ActivityType activity = (ActivityType) sessionfactory.getCurrentSession().get(ActivityType.class, id);
    	
    	return activity;
    }
    
    @Override  
    @Transactional  
    public void remove(Integer id){
    	ActivityType activityType = (ActivityType) sessionfactory.getCurrentSession().load( ActivityType.class, id );
        if (null != activityType) {
            sessionfactory.getCurrentSession().delete(activityType);
        }
    }
    
}  