package idat.com.ws;

import idat.com.dao.SolicitudDao;
import idat.com.vo.EstadoSolicitudVo;
import idat.com.vo.SolicitudVo;
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

@Path("solicitud")
public class SolicitudRest {

    @Context
    private UriInfo context;
    
    SolicitudDao solicitudDao = new SolicitudDao();

    public SolicitudRest() {
    }

    @GET
    @Path("listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<SolicitudVo> listar() {
        return solicitudDao.findAll();
    }
    
    @GET
    @Path("listarUno/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public SolicitudVo listarUno(@PathParam("id") int id) {
        return solicitudDao.findById(id);
    }

    @Path("/agregar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregar(SolicitudVo solicitud) {
        solicitudDao.insert(solicitud);
        return Response.ok().entity(solicitud).build();
    }
    
    @Path("/modificar/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response modificar(SolicitudVo solicitud, @PathParam("id") int id) {
        solicitud.setIdSolicitud(id);
        solicitudDao.update(solicitud);
        return Response.ok().entity(solicitud).build();
    }
    
    @Path("/eliminar/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void eliminar(@PathParam("id") int id) {
        solicitudDao.delete(id);
    }
}
