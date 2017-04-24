package com.proj4.drivers;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import javax.inject.Named;

@Named
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)

public class Driver {
	
	private String driverId;
	private String driverName;
	
	
	
	public Driver(String driverId, String driverName) {
		super();
		this.driverId = driverId;
		this.driverName = driverName;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", driverName=" + driverName + "]";
	}
	
	

}
