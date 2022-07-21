/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idat.com.ws;

import idat.com.dao.ServiciosDao;
import idat.com.vo.ServiciosVo;
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
 * @author A20204357
 */
@Path("servicio")
public class ServicioRest {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServicioRest
     */
    public ServicioRest() {
    }

 
     ServiciosDao usuariodao = new ServiciosDao();

    @Path("/listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<ServiciosVo> listartipo() {
        return usuariodao.Listartipo();
    }
    
    
    
    
    
    @Path("/agregar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregar(ServiciosVo usuario) {
        usuariodao.Registrarusuario(usuario);
        return Response.ok().entity(usuario).build();
    }

    
    
    
    

    @Path("/{nc}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int Actualizarusuario(@PathParam("nc") int idServicios, ServiciosVo usuario) {
        usuario.setIdServicios(idServicios);
        return usuariodao.Actualizarusuario(usuario);
    }

    
    
    
    
    
    @Path("/{nc}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int Eliminarusuario(@PathParam("nc") int idServicios) {
        return usuariodao.Eliminarusuario(idServicios);
    }
    
}