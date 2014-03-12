package org.dac.stady.service;

import java.util.List;

import org.dac.stady.dao.SportDeviceDao;
import org.dac.stady.domain.SportDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service  
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)  
public class SportDeviceServiceImpl implements SportDeviceService {

    @Autowired  
    SportDeviceDao sportDeviceDao;  
	
	@Override
	public void add(SportDevice sportDevice) {
		sportDeviceDao.save(sportDevice);
	}

	@Override
	public List<SportDevice> getList() {
		return sportDeviceDao.getList(); 
	}

	@Override
	public SportDevice getById(Integer id) {
		return sportDeviceDao.getById(id);
	}

	@Override
	public void remove(Integer id) {
		sportDeviceDao.remove(id);
	}
}
