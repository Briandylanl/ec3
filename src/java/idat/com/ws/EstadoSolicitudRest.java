/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idat.com.ws;

import idat.com.dao.EstadoSolicitudDao;
import idat.com.vo.EstadoSolicitudVo;
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

@Path("estadoSolicitud")
public class EstadoSolicitudRest {

    @Context
    private UriInfo context;
    
    private EstadoSolicitudDao estadoSolicitudDao = new EstadoSolicitudDao();

    public EstadoSolicitudRest() {
    }

    @GET
    @Path("listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<EstadoSolicitudVo> listar() {
        return estadoSolicitudDao.findAll();
    }
    
    @GET
    @Path("listarUno/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EstadoSolicitudVo listarUno(@PathParam("id") int id) {
        return estadoSolicitudDao.findById(id);
    }

    @Path("/agregar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregar(EstadoSolicitudVo estadoSolicitud) {
        estadoSolicitudDao.insert(estadoSolicitud);
        return Response.ok().entity(estadoSolicitud).build();
    }
    
    @Path("/modificar/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response modificar(EstadoSolicitudVo estadoSolicitud, @PathParam("id") int id) {
        estadoSolicitud.setIdEstadoSolicitud(id);
        estadoSolicitudDao.update(estadoSolicitud);
        return Response.ok().entity(estadoSolicitud).build();
    }
    
    @Path("/eliminar/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void eliminar(@PathParam("id") int id) {
        estadoSolicitudDao.delete(id);
    }
}
