package menagerienetwork.webservices;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * @author Luke Stoward
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(menagerienetwork.webservices.AnimalService.class);
        resources.add(menagerienetwork.webservices.ZooService.class);
    }
    
}
