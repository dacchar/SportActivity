package org.dac.stady.dao.jpa;  
  
import java.util.List;  
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.transaction.annotation.Transactional;
import java.lang.reflect.ParameterizedType;
  
 
public class DefaultDaoImpl<T> {
	
    @Autowired  
    private SessionFactory sessionfactory;  

    T classInstance = createNewInstance(); 
    		
    private T createNewInstance(){
    	T classInstance = null;
    	
		try {
			classInstance = (T)((Class)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			return classInstance;
		}
    }
    
    
//    @Override  
    @Transactional  
    public void save(T object) {  
        sessionfactory.getCurrentSession().saveOrUpdate(object);  
    }  
  
//    @Override  
    @Transactional  
    public List<T> getList() {  
  
        @SuppressWarnings("unchecked")  
        Session session = sessionfactory.getCurrentSession();
        
		Criteria  criteria = session.createCriteria( classInstance.getClass() );
		List<T> objectList = criteria.list();

		return objectList;
      }  
  
//    @Override  
    @Transactional  
    public T getById(Integer id){
    	
        @SuppressWarnings("unchecked")  
        Session session = sessionfactory.getCurrentSession();
        
		T object = (T) session.get( classInstance.getClass(), id);
			
		return object;
    }
    
//    @Override  
    @Transactional  
    public void remove(Integer id){
    	T object = (T) sessionfactory.getCurrentSession().load( classInstance.getClass(), id );
        if (null != object) {
            sessionfactory.getCurrentSession().delete(object);
        }
    }
}  