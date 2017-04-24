package com.proj4.dispatcher;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import com.proj4.bus.Bus;
import com.proj4.busCount.BusCountGenerator;
import com.proj4.drivers.Driveable;
import com.proj4.drivers.Driver;

/** @SEE
 *  Every injected object need to create a bean and also to add Qualifier("name")  
 */



@Configuration
@PropertySource("classpath:com/proj4/dispatcher/bus.properties")
@Named
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BusDispatcher {

	@Inject
	private ApplicationContext ctx;
	
	/** @SEE
	 * I have change the @Injected with @Resources  
	 * @DPCUMENTATION 
	 * http://stackoverflow.com/questions/8070964/spring-3-1-configuration-environment-not-injected
	 */
	@Resource
	private Environment env;	

	@Inject
	@Qualifier("driver1")
	private Driver driver1;
	
	@Bean
	public Driver driver1(){	
		String driverName1 = env.getProperty("driver1.name", String.class);
		String driverId1 = env.getProperty("driver1.id", String.class);
		return new Driver(driverId1, driverName1);
	}

	@Inject
	@Qualifier("driver2")
	private Driver driver2;
	
	@Bean
	public Driver driver2(){
		String driverName2 = env.getProperty("driver2.name", String.class);
		String driverId2 = env.getProperty("driver2.id", String.class);
		return new Driver(driverId2, driverName2);
	}
	

	@Inject
	@Qualifier("driver3")
	private Driver driver3;
	
	@Bean
	public Driver driver3(){
		String driverName3 = env.getProperty("driver3.name", String.class);
		String driverId3 = env.getProperty("driver3.id", String.class);
		return new Driver(driverId3, driverName3);
	}
	

	@Inject
	@Qualifier("bus1")
	private Bus bus1;
	
	@Bean
	public Bus bus1(){
		int number1 = env.getProperty("bus1.number", Integer.class);
		String destination1 = env.getProperty("bus1.destination", String.class);
		int passenger1 = env.getProperty("bus1.passengers", Integer.class);
		return new Bus(number1,  destination1,  passenger1, this.driver1());
	}

	@Inject
	@Qualifier("bus2")
	private Bus bus2;
	
	@Bean
	public Bus bus2(){
		int number2 = env.getProperty("bus2.number", Integer.class);
		String destination2 = env.getProperty("bus2.destination", String.class);
		int passenger2 = env.getProperty("bus2.passengers", Integer.class);
		return new Bus(number2,  destination2,  passenger2, this.driver2());
	}

	@Inject
	@Qualifier("bus3")
	private Bus bus3;

	@Bean
	public Bus bus3(){
		int number3 = env.getProperty("bus3.number", Integer.class);
		String destination3 = env.getProperty("bus3.destination", String.class);
		int passenger3 = env.getProperty("bus3.passengers", Integer.class);
		return new Bus(number3,  destination3,  passenger3, this.driver3());
	}
	
	@Resource
	private int busCount;
	
	@Bean
	public int busCount(){
		return new BusCountGenerator().getBusCount();
	}
	
	@Resource
	private ArrayList<Driveable> buses;

	@Bean
	public ArrayList<Driveable> buses() {
		ArrayList <Driveable> bus = new ArrayList<Driveable>();
		int busCount=busCount();

		if (busCount == 1) {
			bus.add(bus1());
		}

		if (busCount == 2) {
			bus.add(bus1());
			bus.add(bus2());
		}

		if (busCount == 3) {
			bus.add(bus1());
			bus.add(bus2());
			bus.add(bus3());
		}

		return bus;
	}

}
