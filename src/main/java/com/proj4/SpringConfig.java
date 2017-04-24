package com.proj4;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
 
@Configuration
@ComponentScan(basePackages="com.proj4")
@PropertySource("classpath:com/proj4/bus.properties")
public class SpringConfig {

}
