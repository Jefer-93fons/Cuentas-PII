
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.rest.api;

import ec.edu.espe.arquitectura.cuentas.rest.msg.TransaccionBancaHistoricoRQ;
import ec.edu.espe.arquitectura.model.Transaccion;
import ec.edu.espe.arquitectura.service.TransaccionService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Juan
 */
@Path("transaccion")
@RequestScoped
public class TransaccionResource {

    @Context
    private UriInfo context;
    @Inject
    private TransaccionService transaccionService;

    /**
     * Creates a new instance of TransaccionResource
     */
    public TransaccionResource() {
    }

    /**
     * Retrieves representation of an instance of
     * ec.edu.espe.arquitectura.rest.api.TransaccionResource
     *
     * @param fechaI
     * @param fechaF
     * @param cuenta
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{fechaI}&{fechaF}&{cuenta}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(@PathParam("fechaI") String fechaI, @PathParam("fechaF") String fechaF, @PathParam("cuenta") String cuenta) {
        fechaF=fechaF.replaceAll("-","/" );
        fechaI=fechaI.replaceAll("-","/" );
        System.out.println("Llego: " + fechaF + " " + fechaI + " " + cuenta);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateI = new Date();
        Date dateF = new Date();
        try {
            dateI = formatter.parse(fechaI);
            dateF = formatter.parse(fechaF);
        } catch (ParseException ex) {
            Logger.getLogger(TransaccionResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        //
        List<TransaccionBancaHistoricoRQ> lstTrasnRQ = new ArrayList<>();
        List<Transaccion> lstTransaccions = transaccionService.findHistorialTransaccion(dateI, dateF, cuenta);
        for (Transaccion auxTrans: lstTransaccions) {
            TransaccionBancaHistoricoRQ T=new TransaccionBancaHistoricoRQ();
            T.setDocumento(auxTrans.getIdTransaccion()+"");
            T.setFecha(auxTrans.getFechaTransaccion());
            T.setSaldo(auxTrans.getSaldo().doubleValue());
            T.setTipo(auxTrans.getIdTipoTransaccion().getNombreTipoTransaccion());
            T.setValor(auxTrans.getValorTransaccion().doubleValue());
            lstTrasnRQ.add(T);
        }
        //TODO return proper representation object
        GenericEntity generic = new GenericEntity<List<TransaccionBancaHistoricoRQ>>(lstTrasnRQ) {
        };
        return Response.ok(generic).build();
    }

    /**
     * PUT method for updating or creating an instance of TransaccionResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
