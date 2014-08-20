package org.dac.stady.service;

import java.util.List;

import org.dac.stady.dao.SportDeviceDao;
import org.dac.stady.domain.SportDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service  
//@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)  
public class SportDeviceServiceImpl implements SportDeviceService {

    @Autowired  
    private SportDeviceDao sportDeviceDao;  
	
	@Override
	@Transactional
	public void add(SportDevice sportDevice) {
		sportDeviceDao.save(sportDevice);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SportDevice> getList() {
		return sportDeviceDao.getList(); 
	}

	@Override
	@Transactional(readOnly = true)
	public SportDevice getById(Integer id) {
		return sportDeviceDao.getById(id);
	}

	@Override
	@Transactional
	public void remove(Integer id) {
		sportDeviceDao.remove(id);
	}
}
