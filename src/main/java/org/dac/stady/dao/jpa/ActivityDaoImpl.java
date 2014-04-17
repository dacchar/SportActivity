package org.dac.stady.dao.jpa;  
  
import java.util.List;  

import org.dac.stady.dao.ActivityDao;
import org.dac.stady.domain.Activity;
import org.dac.stady.domain.ActivityFilter;
import org.dac.stady.domain.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;  
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
  
        Session session = sessionfactory.getCurrentSession();
        Criteria  criteria = session.createCriteria(Activity.class);
        criteria.addOrder( Order.desc("activityDate") );
        criteria.addOrder( Order.desc("activityTime") );
        criteria.addOrder( Order.desc("activityId") );
        
        @SuppressWarnings("unchecked")
		List<Activity> list = criteria.list();
        
        return list;  
      }  

    @Override  
    @Transactional  
    public List<Activity> getActivityList(ActivityFilter activityFilter) {  
  
        Session session = sessionfactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Activity.class);
        criteria.add( Restrictions.between("activityDate", activityFilter.getDateStart(), activityFilter.getDateEnd()) );
        if( activityFilter.isSportDeviceFiltered() ){
        	criteria.add( Restrictions.eq("sportDevice", activityFilter.getSportDevice()) );
        }
        
        User filteredUser = activityFilter.getUser();
        if( activityFilter.isUserFiltered() ){
        	criteria.add( Restrictions.eq("user", filteredUser) );
        }
        
        criteria.addOrder( Order.desc("activityDate") );
        criteria.addOrder( Order.desc("activityTime") );
        criteria.addOrder( Order.desc("activityId") );
        
        @SuppressWarnings("unchecked")
		List<Activity> list = criteria.list();
        
        return list;  
      }  
    
    @Override  
    @Transactional  
    public Long getCount(ActivityFilter activityFilter){
    	Session session = sessionfactory.getCurrentSession();
    	Criteria criteria = session.createCriteria(Activity.class);
    	criteria.add( Restrictions.between("activityDate", activityFilter.getDateStart(), activityFilter.getDateEnd()) );
        if( activityFilter.isSportDeviceFiltered() ){
        	criteria.add( Restrictions.eq("sportDevice", activityFilter.getSportDevice()) );
        }
        if( activityFilter.isUserFiltered() ){
        	criteria.add( Restrictions.eq("user", activityFilter.getUser()) );
        }
        Long result = (Long) criteria.setProjection(Projections.sum("amount") ).uniqueResult();
        
    	return result;
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