/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.rest.api;

import ec.edu.espe.arquitectura.cuentas.rest.msg.ComisionProductoRQ;
import ec.edu.espe.arquitectura.cuentas.rest.msg.InteresRQ;
import ec.edu.espe.arquitectura.model.Comision;
import ec.edu.espe.arquitectura.model.ComisionProducto;
import ec.edu.espe.arquitectura.model.Interes;
import ec.edu.espe.arquitectura.model.Periodo;
import ec.edu.espe.arquitectura.model.Producto;
import ec.edu.espe.arquitectura.service.ComisionProductoService;
import ec.edu.espe.arquitectura.service.InteresService;
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
@Path("intereses")
@RequestScoped
public class InteresResource {

    @Context
    private UriInfo context;
    @Inject
    private InteresService interesService;
    private List<Interes> lstIntereses;

    /**
     * Creates a new instance of CuentaResource
     */
    public InteresResource() {
        //lstCuentas=cuentaEJB.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Interes getJson() {
        lstIntereses = interesService.obtenerTodos();
        if (lstIntereses.size() > 0) {
            Interes auxInteres = lstIntereses.get(0);
            System.out.println("El interes de porcentaje " + auxInteres.getPorcentajeInteres());

            return auxInteres;
        } else {
            System.out.println("No existen Intereses");
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
    public Response putJson(InteresRQ content) {
        System.out.println("Datos Recibidos son: " + content.toString());
        Interes newInteres = new Interes();
        Periodo periodo = new Periodo();
        periodo.setIdPeriodo(content.getIdPeriodo());
        newInteres.setIdInteres(content.getIdInteres());
        newInteres.setIdPeriodo(periodo);
        newInteres.setPorcentajeInteres((BigDecimal.valueOf(content.getPorcentaje())));
        newInteres.setValorMin((BigDecimal.valueOf(content.getValorMinimo())));
        newInteres.setValorMax((BigDecimal.valueOf(content.getValorMaximo())));
        interesService.modificar(newInteres);
        return Response.status(200).entity("El interes con porcentaje" + content.getPorcentaje()+ " a sido modificado").build();
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{id}")
    public Response delJson(@PathParam("id") Integer interesID) {
        String msg = "El interes no existe";
        System.out.println("La comision a borrar es: " + interesID);
        Interes auxInteres = new Interes();
        auxInteres.setIdInteres(interesID);
        Interes interes = interesService.buscar(auxInteres);
        if (interes != null) {
            interesService.eliminar(interes);
            interes = interesService.buscar(auxInteres);
            if (interes != null) {
                msg = "El interes no a sido borrado";
            } else {
                msg = "El interes a sido Borrada";
            }
        }
        return Response.status(200).entity(msg).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response postJson(InteresRQ content) {
        System.out.println("Datos Recibidos son: " + content.toString());
        Interes newInteres = new Interes();
        Periodo periodo = new Periodo();
        periodo.setIdPeriodo(content.getIdPeriodo());
        newInteres.setIdInteres(0);
        newInteres.setIdPeriodo(periodo);
        newInteres.setPorcentajeInteres((BigDecimal.valueOf(content.getPorcentaje())));
        newInteres.setValorMin((BigDecimal.valueOf(content.getValorMinimo())));
        newInteres.setValorMax((BigDecimal.valueOf(content.getValorMaximo())));
        interesService.crear(newInteres);

        return Response.status(200).entity("El interes a sido creado").build();
    }

}
