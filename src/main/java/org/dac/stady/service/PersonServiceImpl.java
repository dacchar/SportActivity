package org.dac.stady.service;

import java.util.List;

import org.dac.stady.dao.PersonDao;
import org.dac.stady.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service  
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)  
public class PersonServiceImpl implements PersonService {

    @Autowired  
    PersonDao personDao;  
	
	@Override
	public void add(Person person) {
		personDao.save(person);
	}

	@Override
	public List<Person> getList() {
		return personDao.getList(); 
	}

	@Override
	public Person getById(Integer id) {
		return personDao.getById(id);
	}

	@Override
	public void remove(Integer id) {
		personDao.remove(id);
	}
}
