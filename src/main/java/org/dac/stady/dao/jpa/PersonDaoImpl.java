package org.dac.stady.dao.jpa;  
  
import org.dac.stady.dao.PersonDao;
import org.dac.stady.domain.Person;
import org.springframework.stereotype.Repository;  
  
  
@Repository("personDao")  
//public class PersonDaoImpl implements PersonDao   
public class  PersonDaoImpl extends DefaultDaoImpl<Person> implements PersonDao 
{
  
//    @Autowired  
//    private SessionFactory sessionfactory;  
//
//  
//    @Override  
//    @Transactional  
//    public void save(Person personType) {  
//        sessionfactory.getCurrentSession().saveOrUpdate(personType);  
//    }  
//  
//    @Override  
//    @Transactional  
//    public List<Person> getList() {  
//  
//        @SuppressWarnings("unchecked")  
//        Session session = sessionfactory.getCurrentSession();
//        Criteria  criteria = session.createCriteria(Person.class);
//        List<Person> userlist = criteria.list();
//
//        return userlist;  
//      }  
//  
//    @Override  
//    @Transactional  
//    public Person getById(Integer id){
//    	Person person = (Person) sessionfactory.getCurrentSession().get(Person.class, id);
//    	
//    	return person;
//    }
//    
//    @Override  
//    @Transactional  
//    public void remove(Integer id){
//    	Person person = (Person) sessionfactory.getCurrentSession().load( Person.class, id );
//        if (null != person) {
//            sessionfactory.getCurrentSession().delete(person);
//        }
//    }
//    
}  