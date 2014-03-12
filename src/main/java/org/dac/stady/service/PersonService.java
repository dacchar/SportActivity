package org.dac.stady.service;

import java.util.List;
import org.dac.stady.domain.Person;

public interface PersonService {
    public void add(Person person);  
    public List<Person> getList();
    public Person getById(Integer id);
    public void remove(Integer id);
}
