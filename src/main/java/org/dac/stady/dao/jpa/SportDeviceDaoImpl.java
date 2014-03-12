package org.dac.stady.dao.jpa;  
  
import org.dac.stady.dao.SportDeviceDao;
import org.dac.stady.domain.SportDevice;
import org.springframework.stereotype.Repository;  
  
@Repository("sportDevicenDao")  
public class  SportDeviceDaoImpl extends DefaultDaoImpl<SportDevice> implements SportDeviceDao 
{
}  