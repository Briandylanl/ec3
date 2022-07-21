
package idat.com.ws;

import idat.com.dao.UsuarioDao;
import idat.com.vo.UsuarioVo;
import java.util.Collection;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
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
@Path("usuario")
public class UsuarioRest {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsuarioRest
     */
    public UsuarioRest() {
    }

   UsuarioDao usuariodao = new UsuarioDao();

    @Path("/listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<UsuarioVo> listarusuario() {
        return usuariodao.ListarUsuario();
    }
    
    
    
    
    
    @Path("/agregar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregar(UsuarioVo usuarios) {
        usuariodao.RegistrarUsuario(usuarios);
        return Response.ok().entity(usuarios).build();
    }

    
    
    
    

    @Path("/{nc}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int Actualizarusuario(@PathParam("nc") int idUsuario, UsuarioVo usuario) {
        usuario.setIdUsuario(idUsuario);
        return usuariodao.Actualizarusuario(usuario);
    }

    
    
    
    
    
    @Path("/{nc}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int Eliminarusuario(@PathParam("nc") int idUsuario) {
        return usuariodao.Eliminarusuario(idUsuario);
    }
    

}
