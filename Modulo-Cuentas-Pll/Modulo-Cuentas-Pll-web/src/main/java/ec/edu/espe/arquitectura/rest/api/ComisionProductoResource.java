/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.rest.api;

import ec.edu.espe.arquitectura.cuentas.rest.msg.ComisionProductoRQ;
import ec.edu.espe.arquitectura.model.Comision;
import ec.edu.espe.arquitectura.model.ComisionProducto;
import ec.edu.espe.arquitectura.model.Producto;
import ec.edu.espe.arquitectura.service.ComisionProductoService;
import java.math.BigDecimal;
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
@Path("comisionProductos")
@RequestScoped
public class ComisionProductoResource {

    @Context
    private UriInfo context;
    @Inject
    private ComisionProductoService comisionProductoService;
    private List<ComisionProducto> lstComisionProductos;

    /**
     * Creates a new instance of CuentaResource
     */
    public ComisionProductoResource() {
        //lstCuentas=cuentaEJB.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ComisionProducto getJson() {
        lstComisionProductos = comisionProductoService.obtenerTodos();
        if (lstComisionProductos.size() > 0) {
            ComisionProducto auxComisionProducto = lstComisionProductos.get(0);
            System.out.println("La comision para producto es " + auxComisionProducto.getIdComisionProducto()
                    + "la razon de la comision es " + auxComisionProducto.getIdComision().getRazonComision()+ " y esta asociado al producto " + auxComisionProducto.getIdProducto().getNombreProducto());

            return auxComisionProducto;
        } else {
            System.out.println("No existen Comisiones para productos");
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
    public Response putJson(ComisionProductoRQ content) {
        System.out.println("Datos Recibidos son: " + content.toString());
        ComisionProducto newComisionProducto = new ComisionProducto();
        Comision comision = new Comision();
        Producto producto = new Producto();
        comision.setIdComision(content.getIdComision());
        producto.setIdProducto(content.getIdProducto());
        newComisionProducto.setIdComisionProducto(content.getIdComisionProducto());
        newComisionProducto.setIdComision(comision);
        newComisionProducto.setIdProducto(producto);
        newComisionProducto.setValorComisionProducto((BigDecimal.valueOf(content.getValor())));
        comisionProductoService.modificar(newComisionProducto);
        return Response.status(200).entity("La comision " + content.getIdComisionProducto()+ " a sido modificada").build();
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{id}")
    public Response delJson(@PathParam("id") Integer comisionProductoID) {
        String msg = "La comision no existe";
        System.out.println("La comision a borrar es: " + comisionProductoID);
        ComisionProducto auxComisionProducto = new ComisionProducto();
        auxComisionProducto.setIdComisionProducto(comisionProductoID);
        ComisionProducto comisionProducto = comisionProductoService.buscar(auxComisionProducto);
        if (comisionProducto != null) {
            comisionProductoService.eliminar(comisionProducto);
            comisionProducto = comisionProductoService.buscar(auxComisionProducto);
            if (comisionProducto != null) {
                msg = "La comision de producto no a sido borrada";
            } else {
                msg = "La comision de producto a sido Borrada";
            }
        }
        return Response.status(200).entity(msg).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response postJson(ComisionProductoRQ content) {
        System.out.println("Datos Recibidos son: " + content.toString());
        ComisionProducto newComisionProducto = new ComisionProducto();
        Comision comision = new Comision();
        Producto producto = new Producto();
        comision.setIdComision(content.getIdComision());
        producto.setIdProducto(content.getIdProducto());
        newComisionProducto.setIdComisionProducto(0);
        newComisionProducto.setIdComision(comision);
        newComisionProducto.setIdProducto(producto);
        newComisionProducto.setValorComisionProducto((BigDecimal.valueOf(content.getValor())));

        comisionProductoService.crear(newComisionProducto);

        return Response.status(200).entity("La comision del producto a sido creada").build();
    }

}
