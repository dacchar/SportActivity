package org.dac.stady.service;

import java.util.List;
import org.dac.stady.domain.SportDevice;

public interface SportDeviceService {
    public void add(SportDevice sportDevice);  
    public List<SportDevice> getList();
    public SportDevice getById(Integer id);
    public void remove(Integer id);
}
