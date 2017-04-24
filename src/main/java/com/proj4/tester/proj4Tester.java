
package com.proj4.tester;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.proj4.dispatcher.*;
import com.proj4.drivers.*;
import com.proj4.busCount.BusCountGenerator;

public class proj4Tester {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		 ApplicationContext ctx = new AnnotationConfigApplicationContext(BusDispatcher.class);
		BusDispatcher dispatcher = ctx.getBean(BusDispatcher.class);
		ArrayList <Driveable> busContainer = new ArrayList <Driveable>();  //creating array list of buses.
		busContainer = dispatcher.buses();
			
		for(int idx= 0; idx < busContainer.size(); idx++)
		{
			System.out.println(busContainer.get(idx));   //printing out array list of buses
		}
		
		
	}

}


