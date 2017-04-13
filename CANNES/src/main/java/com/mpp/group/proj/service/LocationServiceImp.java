package com.mpp.group.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mpp.group.proj.dao.LocationDao;
import com.mpp.group.proj.model.Location;

@Service
public class LocationServiceImp implements LocationService {
	
    LocationDao LocationDao;
	
	@Autowired
	public void setLocationDao(LocationDao LocationDao){
		this.LocationDao = LocationDao;
	}

	@Override
	public List<Location> listAllLocation() {
		return LocationDao.listAllLocation();
	}

	@Override
	public void addLocation(Location Location) {
		LocationDao.addLocation(Location);
	}

	@Override
	public void updateLocation(Location Location) {
		LocationDao.updateLocation(Location);
	}

	@Override
	public void deleteLocation(int id) {
		LocationDao.deleteLocation(id);
	}

	@Override
	public Location findLocationById(int id) {
		return LocationDao.findLocationById(id);
	}


}
