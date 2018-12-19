/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.rest.api;
import ec.edu.espe.arquitectura.model.Transaccion;
import ec.edu.espe.arquitectura.model.TipoTransaccion;
import ec.edu.espe.arquitectura.service.TransaccionService;
import ec.edu.espe.arquitectura.service.TipoTransaccionService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Admin
 */
@Path("tipotransaccion")
@RequestScoped
public class TipoTransaccionResource {

    @Context
    private UriInfo context;
    @Inject
    private TipoTransaccionService tipotransaccionService;
    private List<TipoTransaccion> lstTipoTransacciones;
    
    @Inject
    private TransaccionService transaccionservice;
    private List<Transaccion>lstTransacciones;

    /**
     * Creates a new instance of TipoTransaccionResource
     */
    public TipoTransaccionResource() {
    }
    
   
    /**
     * Retrieves representation of an instance of ec.edu.espe.arquitectura.rest.api.TipoTransaccionResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public TipoTransaccion getJson(){
      //  lstTipoTransacciones=TipoTransaccionService.obtenerTodos();
        if(lstTipoTransacciones.size()>0){
        }
   // }


    /**
     * PUT method for updating or creating an instance of TipoTransaccionResource
     * @param content representation for the resource
     */
   // @PUT
  //  @Consumes(MediaType.APPLICATION_XML)
    
   
    

