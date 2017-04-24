package com.proj4.busCount;

import javax.inject.Named;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;


@Named			
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BusCountGenerator {
	
    public int getBusCount(){
    	return (int) (Math.random() * (4-1) + 1);
    }

}
