package com.proj4.bus;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import javax.inject.Named;

import com.proj4.drivers.Driveable;
import com.proj4.drivers.Driver;

@Named
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component
public class Bus implements Driveable {
   
	private int busNumber;
    private String destination;
    private int numPassengers;
    private Driver driver;
    
    

	public Bus(int busNumber, String destination, int numPassengers, Driver driver) {
		super();
		this.busNumber = busNumber;
		this.destination = destination;
		this.numPassengers = numPassengers;
		this.driver = driver;
	}
	public int getBusNumber() {
		return busNumber;
	}
    public void setBusNumber(int busNumber) {
		this.busNumber = busNumber;
	}
    public String getDestination() {
		return destination;
	}
    public void setDestination(String destination) {
		this.destination = destination;
	}
    public int getNumPassengers() {
		return numPassengers;
	}
    public void setNumPassengers(int numPassengers) {
		this.numPassengers = numPassengers;
	}
    
    @Override
    public Driver getDriver() {
		return driver;
	}
    public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	@Override
	public String toString() {
		return "Bus [busNumber=" + busNumber + ", destination=" + destination + ", numPassengers=" + numPassengers
				+ ", driver=" + driver + "]";
	}
	
	
}
