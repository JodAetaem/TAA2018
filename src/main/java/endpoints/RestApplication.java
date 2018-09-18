package endpoints;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;
import io.swagger.jaxrs.config.BeanConfig;


public class RestApplication extends Application {
	

	public RestApplication() {
		BeanConfig bean = new BeanConfig();
		bean.setVersion("1.0.0");
		bean.setSchemes(new String[]{"http"});
		bean.setHost("localhost:3030");
		bean.setBasePath("/");
		bean.setResourcePackage("endpoints");
		bean.setScan(true);
		bean.setPrettyPrint(true);
	}

	@Override
	public Set<Class<?>> getClasses() {

		final Set<Class<?>> clazzes = new HashSet<Class<?>>();

		// clazzes.add(Sport.class);
		clazzes.add(io.swagger.jaxrs.listing.ApiListingResource.class);
		clazzes.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
		clazzes.add(SwaggerRessource.class);

		return clazzes;
	}

}
