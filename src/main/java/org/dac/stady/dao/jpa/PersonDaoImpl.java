package org.dac.stady.dao.jpa;  
  
import org.dac.stady.dao.PersonDao;
import org.dac.stady.domain.Person;
import org.springframework.stereotype.Repository;  
  
  
@Repository("personDao")  
public class  PersonDaoImpl extends DefaultDaoImpl<Person> implements PersonDao 
{
}  