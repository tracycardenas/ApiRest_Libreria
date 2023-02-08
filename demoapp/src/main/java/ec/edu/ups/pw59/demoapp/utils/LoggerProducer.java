package ec.edu.ups.pw59.demoapp.utils;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class LoggerProducer {
	
	@Produces
	public Logger producesLogger(InjectionPoint in) {
		return Logger.getLogger(in.getMember().getDeclaringClass().getName());
	}

}
