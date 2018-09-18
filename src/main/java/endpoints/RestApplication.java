package endpoints;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import entity.Sport;

public class RestApplication extends Application {
	
	  @Override
	    public Set<Class<?>> getClasses() {

	        final Set<Class<?>> clazzes = new HashSet<Class<?>>();

	       // clazzes.add(Sport.class);

	        return clazzes;
	    }


}
