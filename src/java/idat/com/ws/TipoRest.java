
package idat.com.ws;

import idat.com.dao.TipoDao;

import idat.com.vo.TipoVo;

import java.util.Collection;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author JHAIRO MENDOZA
 */
@Path("tipo")
public class TipoRest {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TipoRest
     */
    public TipoRest() {
    }

   TipoDao usuariodao = new TipoDao();

    @Path("/listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TipoVo> listartipo() {
        return usuariodao.Listartipo();
    }
    
    
    
    
    
    @Path("/agregar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregar(TipoVo usuario) {
        usuariodao.Registrarusuario(usuario);
        return Response.ok().entity(usuario).build();
    }

    
    
    
    

    @Path("/{nc}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int Actualizarusuario(@PathParam("nc") int idTipoUsuario, TipoVo usuario) {
        usuario.setIdTipoUsuario(idTipoUsuario);
        return usuariodao.Actualizarusuario(usuario);
    }

    
    
    
    
    
    @Path("/{nc}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int Eliminarusuario(@PathParam("nc") int idTipoUsuario) {
        return usuariodao.Eliminarusuario(idTipoUsuario);
    }
    
}
