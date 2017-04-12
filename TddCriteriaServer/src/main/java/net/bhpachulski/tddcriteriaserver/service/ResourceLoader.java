package net.bhpachulski.tddcriteriaserver.service;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
import net.bhpachulski.tddcriteriaserver.service.impl.TDDCriteriaService;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

/**
 *
 * @author bhpachulski
 */
public class ResourceLoader extends Application{
 
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        
        classes.add(TDDCriteriaService.class);
        classes.add(MultiPartFeature.class);
        
        try {
            classes.add(Class.forName("org.glassfish.jersey.jackson.JacksonFeature"));
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: ResourceLoader " + ex);
        }
        
        return classes;
    }
}