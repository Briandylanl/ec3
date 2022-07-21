
package idat.com.ws;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author JHAIRO MENDOZA
 */
@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

  
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(idat.com.ws.EstadoSolicitudRest.class);
        resources.add(idat.com.ws.ServicioRest.class);
        resources.add(idat.com.ws.SolicitudRest.class);
        resources.add(idat.com.ws.TipoRest.class);
        resources.add(idat.com.ws.UsuarioRest.class);
    }
    
}
