package org.dac.stady.dao;  
  
import java.util.List;  
import org.dac.stady.domain.Person;
  
public interface PersonDao {  
	public void save(Person person);  
	public List<Person> getList();  
	public Person getById(Integer id);
	public void remove(Integer id);
}  