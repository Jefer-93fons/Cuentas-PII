/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.rest.api;

import ec.edu.espe.arquitectura.cuentas.rest.msg.ProductoRQ;
import ec.edu.espe.arquitectura.model.Producto;
import ec.edu.espe.arquitectura.model.TipoProducto;
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
@Path("productos")
@RequestScoped
public class ProductoResource {

    @Context
    private UriInfo context;
    @Inject
    private ProductoService productoService;
    private List<Producto> lstProductos;

    @Inject
    private TipoProductoService tipoProductoService;
    private List<TipoProducto> lstTipoProductos;

    public ProductoResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Producto getJson() {
        lstProductos = productoService.obtenerTodos();
        if (lstProductos.size() > 0) {
            Producto auxProducto = lstProductos.get(0);
            System.out.println("El Producto es " + auxProducto.getNombreProducto()
                    + " es un producto de tipo " + auxProducto.getIdTipoProducto().getNombreTipoProducto() + " y tiene una restriccion de $" + auxProducto.getRestriccionProducto());

            return auxProducto;
        } else {
            System.out.println("No existen Productos");
        }
        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response postJson(ProductoRQ content) {
        System.out.println("Datos Recibidos son: " + content.toString());
        Producto newProducto = new Producto();
        TipoProducto tipoProducto = new TipoProducto();

        tipoProducto.setIdTipoProducto(content.getIdTipoProducto());
        newProducto.setIdProducto(0);
        newProducto.setIdTipoProducto(tipoProducto);
        newProducto.setNombreProducto(content.getNombreProducto());
        newProducto.setRestriccionProducto(content.getRestriccionProducto());

        productoService.crear(newProducto);

        return Response.status(200).entity("").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson(ProductoRQ content) {
        System.out.println("Datos Recibidos son: " + content.toString());
        Producto producto = new Producto();
        TipoProducto tipoProducto = new TipoProducto();
        producto.setIdProducto(content.getIdProducto());
        producto.setNombreProducto(content.getNombreProducto());
        producto.setRestriccionProducto(content.getRestriccionProducto());
        producto.setIdTipoProducto(tipoProducto);
        productoService.modificar(producto);
        return Response.status(200).entity("").build();
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{id}")
    public Response delJson(@PathParam("id") Integer productoID) {
        String msg = "El producto no existe";
        System.out.println("El producto a borrar es: " + productoID);
        Producto auxProducto = new Producto();
        auxProducto.setIdProducto(productoID);
        Producto producto = productoService.buscar(auxProducto);
        if (producto != null) {
            productoService.eliminar(producto);
            producto = productoService.buscar(auxProducto);
            if (producto != null) {
                msg = "El producto no a sido borrado";
            } else {
                msg = "El producto a sido Borrado";
            }
        }
        return Response.status(200).entity(msg).build();
    }
}
