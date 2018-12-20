/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.rest.api;

import ec.edu.espe.arquitectura.model.HistoricoProducto;
import ec.edu.espe.arquitectura.service.HistoricoProductoService;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Juan
 */
@Path("comisionProductos")
@RequestScoped
public class HistoricoProductoResource {

    @Context
    private UriInfo context;
    @Inject
    private HistoricoProductoService historicoProductoService;
    private List<HistoricoProducto> lstHistoricoProductos;

    /**
     * Creates a new instance of CuentaResource
     */
    public HistoricoProductoResource() {
        //lstCuentas=cuentaEJB.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public HistoricoProducto getJson() {
        lstHistoricoProductos = historicoProductoService.obtenerTodos();
        if (lstHistoricoProductos.size() > 0) {
            HistoricoProducto auxHistoricoProducto = lstHistoricoProductos.get(0);
            System.out.println("El historico de producto es " + auxHistoricoProducto.getIdHistoricoProducto()
                    + "del Producto " + auxHistoricoProducto.getIdProducto().getNombreProducto()+ "Con una fecha de vigencia" + auxHistoricoProducto.getFechaVigencia1());

            return auxHistoricoProducto;
        } else {
            System.out.println("No existen Historicos para productos");
        }
        return null;
    }

    /**
     * PUT method for updating or creating an instance of CuentaResource
     *
     * @param content representation for the resource
     * @return
     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response putJson(HistoricoProductoRQ content) {
//        System.out.println("Datos Recibidos son: " + content.toString());
//        HistoricoProducto newHistoricoProducto = new HistoricoProducto();
//        EstadoProducto estado = new EstadoProducto();
//        Producto producto = new Producto();
//        estado.setIdEstadoProducto(content.getIdEstadoProducto());
//        producto.setIdProducto(content.getIdProducto());
//        newHistoricoProducto.setIdHistoricoProducto(content.getIdHistoricoProducto());
//        newHistoricoProducto.setIdEstadoProducto(estado);
//        newHistoricoProducto.setIdProducto(producto);
//        newHistoricoProducto.setFechaVigencia(((content.getFechaVigencia())));
//        historicoProductoService.modificar(newHistoricoProducto);
//        return Response.status(200).entity("El historico " + content.getIdComisionProducto()+ " a sido modificada").build();
//    }

//    @DELETE
//    @Produces(MediaType.TEXT_PLAIN)
//    @Path("/{id}")
//    public Response delJson(@PathParam("id") Integer comisionProductoID) {
//        String msg = "La comision no existe";
//        System.out.println("La comision a borrar es: " + comisionProductoID);
//        ComisionProducto auxComisionProducto = new ComisionProducto();
//        auxComisionProducto.setIdComisionProducto(comisionProductoID);
//        ComisionProducto comisionProducto = comisionProductoService.buscar(auxComisionProducto);
//        if (comisionProducto != null) {
//            comisionProductoService.eliminar(comisionProducto);
//            comisionProducto = comisionProductoService.buscar(auxComisionProducto);
//            if (comisionProducto != null) {
//                msg = "La comision de producto no a sido borrada";
//            } else {
//                msg = "La comision de producto a sido Borrada";
//            }
//        }
//        return Response.status(200).entity(msg).build();
//    }

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.TEXT_PLAIN)
//    public Response postJson(ComisionProductoRQ content) {
//        System.out.println("Datos Recibidos son: " + content.toString());
//        ComisionProducto newComisionProducto = new ComisionProducto();
//        Comision comision = new Comision();
//        Producto producto = new Producto();
//        comision.setIdComision(content.getIdComision());
//        producto.setIdProducto(content.getIdProducto());
//        newComisionProducto.setIdComisionProducto(0);
//        newComisionProducto.setIdComision(comision);
//        newComisionProducto.setIdProducto(producto);
//        newComisionProducto.setValorComisionProducto((BigDecimal.valueOf(content.getValor())));
//
//        comisionProductoService.crear(newComisionProducto);
//
//        return Response.status(200).entity("La comision del producto a sido creada").build();
//    }

}
