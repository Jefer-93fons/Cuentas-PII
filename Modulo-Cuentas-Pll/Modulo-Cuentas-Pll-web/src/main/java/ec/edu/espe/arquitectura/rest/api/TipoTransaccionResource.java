/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.rest.api;
import ec.edu.espe.arquitectura.cuentas.rest.msg.TipoTransaccionRQ;
import ec.edu.espe.arquitectura.model.TipoTransaccion;
import ec.edu.espe.arquitectura.service.TipoTransaccionService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
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
        lstTipoTransacciones=tipotransaccionService.obtenerTodos();
        if(lstTipoTransacciones.size()>0){
            TipoTransaccion auxTipoTransaccion=lstTipoTransacciones.get(0);
            System.out.println("El tipo de transaccion es " + auxTipoTransaccion.getNombreTipoTransaccion()); 
            
            return auxTipoTransaccion;
            
        }else{
            System.out.println("No hay Tipos de Transacciones registradas.");
        }
        return null;
    }

    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) 
    @Produces (MediaType.TEXT_PLAIN)
    public Response postJson(TipoTransaccionRQ content){
        System.out.println("Datos Recibidos son: "+ content.toString());
        TipoTransaccion newTipoTransaccion=new TipoTransaccion();
        
        newTipoTransaccion.setIdTipoTransaccion(0);
        newTipoTransaccion.setNombreTipoTransaccion(content.getNombreTipoTransaccion());
        newTipoTransaccion.setCargo(content.getCargo());
        tipotransaccionService.crear(newTipoTransaccion);
        return Response.status(200).entity("").build();
   
}
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson(TipoTransaccionRQ content){
        System.out.println("Datos Recibidos son: " + content.toString());
        TipoTransaccion tipoTransaccion=new TipoTransaccion();
        tipoTransaccion.setIdTipoTransaccion(content.getIdTipoTransaccion());
        tipoTransaccion.setNombreTipoTransaccion(content.getNombreTipoTransaccion());
        tipoTransaccion.setCargo(content.getCargo());
        tipotransaccionService.modificar(tipoTransaccion);
        return Response.status(200).entity("").build();
    }
    
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{id}")
    public Response delJson(@PathParam("id") Integer tipoTransaccionID){
        String msg="El tipo de transaccion no existe ";
         System.out.println("El tipo de transaccion a borrar es: " + tipoTransaccionID);
         TipoTransaccion auxTipoTransaccion=new TipoTransaccion();
         auxTipoTransaccion.setIdTipoTransaccion(tipoTransaccionID);
         TipoTransaccion tipoTransaccion=tipotransaccionService.buscar(auxTipoTransaccion);
         if (tipoTransaccion != null) {
            tipotransaccionService.eliminar(tipoTransaccion);
            tipoTransaccion= tipotransaccionService.buscar(auxTipoTransaccion);
            if (tipoTransaccion!= null) {
                msg = "El tipo de transacción no ha sido borrado";
            } else {
                msg = "El tipo de transacción  ha sido Borrado";
            }
        }
        return Response.status(200).entity(msg).build();

    }
    
}


    /**
     * PUT method for updating or creating an instance of TipoTransaccionResource
     * @param content representation for the resource
     */
   // @PUT
  //  @Consumes(MediaType.APPLICATION_XML)
    
   
    

