/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.rest.api;

import ec.edu.espe.arquitectura.cuentas.rest.msg.ComisionRQ;
import ec.edu.espe.arquitectura.cuentas.rest.msg.ProductoRQ;
import ec.edu.espe.arquitectura.model.Comision;
import ec.edu.espe.arquitectura.model.Producto;
import ec.edu.espe.arquitectura.model.TipoProducto;
import ec.edu.espe.arquitectura.service.ComisionService;
import ec.edu.espe.arquitectura.service.ProductoService;
import ec.edu.espe.arquitectura.service.TipoProductoService;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author DAVID
 */
@Path("comisiones")
@RequestScoped
public class ComisionResource {

    @Context
    private UriInfo context;
    @Inject
    private ComisionService comisionService;
    private List<Comision> lstComisiones;


    public ComisionResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Comision getJson() {
        lstComisiones = comisionService.obtenerTodos();
        if (lstComisiones.size() > 0) {
            Comision auxComision = lstComisiones.get(0);
            System.out.println("La comision es " + auxComision.getRazonComision());

            return auxComision;
        } else {
            System.out.println("No existen Comisiones");
        }
        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response postJson(ComisionRQ content) {
        System.out.println("Datos Recibidos son: " + content.toString());
        Comision newComision = new Comision();
        newComision.setIdComision(0);
        newComision.setRazonComision(content.getRazonComision());
        comisionService.crear(newComision);
        return Response.status(200).entity("").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson(ComisionRQ content) {
        System.out.println("Datos Recibidos son: " + content.toString());
        Comision newComision = new Comision();
        newComision.setIdComision(content.getIdComision());
        newComision.setRazonComision(content.getRazonComision());
        comisionService.modificar(newComision);
        return Response.status(200).entity("").build();
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{id}")
    public Response delJson(@PathParam("id") Integer comisionID) {
        String msg = "El producto no existe";
        System.out.println("La comision a borrar es: " + comisionID);
        Comision auxComision = new Comision();
        auxComision.setIdComision(comisionID);
        Comision comision = comisionService.buscar(auxComision);
        if (comision != null) {
            comisionService.eliminar(comision);
            comision = comisionService.buscar(auxComision);
            if (comision != null) {
                msg = "La comision no a sido borrada";
            } else {
                msg = "La comision a sido Borrada";
            }
        }
        return Response.status(200).entity(msg).build();
    }
}
