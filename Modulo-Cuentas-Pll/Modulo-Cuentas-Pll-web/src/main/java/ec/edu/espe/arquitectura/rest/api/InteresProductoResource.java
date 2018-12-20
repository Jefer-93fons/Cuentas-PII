/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.rest.api;

import ec.edu.espe.arquitectura.cuentas.rest.msg.InteresProductoRQ;
import ec.edu.espe.arquitectura.model.Interes;
import ec.edu.espe.arquitectura.model.InteresProducto;
import ec.edu.espe.arquitectura.model.Producto;
import ec.edu.espe.arquitectura.service.InteresProductoService1;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Juan
 */
@Path("interesProductos")
@RequestScoped
public class InteresProductoResource {

    @Context
    private UriInfo context;
    @Inject
    private InteresProductoService1 interesProductoService;
    private List<InteresProducto> lstInteresProductos;

    /**
     * Creates a new instance of CuentaResource
     */
    public InteresProductoResource() {
        //lstCuentas=cuentaEJB.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public InteresProducto getJson() {
        lstInteresProductos = interesProductoService.obtenerTodos();
        if (lstInteresProductos.size() > 0) {
            InteresProducto auxInteresProducto = lstInteresProductos.get(0);
            System.out.println("El interes para producto es " + auxInteresProducto.getIdInteresProducto()
                    + "Para el producto " + auxInteresProducto.getIdProducto().getNombreProducto());

            return auxInteresProducto;
        } else {
            System.out.println("No existen Interes para productos");
        }
        return null;
    }

    /**
     * PUT method for updating or creating an instance of CuentaResource
     *
     * @param content representation for the resource
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson(InteresProductoRQ content) {
        System.out.println("Datos Recibidos son: " + content.toString());
        InteresProducto newInteresProducto = new InteresProducto();
        Interes interes = new Interes();
        Producto producto = new Producto();
        interes.setIdInteres(content.getIdInteres());
        producto.setIdProducto(content.getIdProducto());
        newInteresProducto.setIdInteresProducto(content.getIdInteresProducto());
        newInteresProducto.setIdInteres(interes);
        newInteresProducto.setIdProducto(producto);
        interesProductoService.modificar(newInteresProducto);
        return Response.status(200).entity("El interes es " + content.getIdInteresProducto()+ " a sido modificada").build();
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{id}")
    public Response delJson(@PathParam("id") Integer interesProductoID) {
        String msg = "El interes no existe";
        System.out.println("El interes a borrar es: " + interesProductoID);
        InteresProducto auxInteresProducto = new InteresProducto();
        auxInteresProducto.setIdInteresProducto(interesProductoID);
        InteresProducto interesProducto = interesProductoService.buscar(auxInteresProducto);
        if (interesProducto != null) {
            interesProductoService.eliminar(interesProducto);
            interesProducto = interesProductoService.buscar(auxInteresProducto);
            if (interesProducto != null) {
                msg = "El interes de producto no a sido borrada";
            } else {
                msg = "El interes de producto a sido Borrada";
            }
        }
        return Response.status(200).entity(msg).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response postJson(InteresProductoRQ content) {
        System.out.println("Datos Recibidos son: " + content.toString());
        InteresProducto newInteresProducto = new InteresProducto();
        Interes interes = new Interes();
        Producto producto = new Producto();
        interes.setIdInteres(content.getIdInteres());
        producto.setIdProducto(content.getIdProducto());
        newInteresProducto.setIdInteresProducto(0);
        newInteresProducto.setIdInteres(interes);
        newInteresProducto.setIdProducto(producto);
        interesProductoService.crear(newInteresProducto);
        return Response.status(200).entity("El interes del producto a sido creada").build();
    }

}
