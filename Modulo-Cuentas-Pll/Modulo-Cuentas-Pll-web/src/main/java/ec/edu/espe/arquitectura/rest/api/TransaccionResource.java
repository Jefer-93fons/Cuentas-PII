
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.rest.api;

import ec.edu.espe.arquitectura.cuentas.rest.msg.TransaccionBancaHistoricoRQ;
import ec.edu.espe.arquitectura.cuentas.rest.msg.TransactionRQ;
import ec.edu.espe.arquitectura.model.Cuenta;
import ec.edu.espe.arquitectura.model.TipoTransaccion;
import ec.edu.espe.arquitectura.model.Transaccion;
import ec.edu.espe.arquitectura.service.CuentaService;
import ec.edu.espe.arquitectura.service.TransaccionService;
import ec.edu.espe.arquitectura.soap.ws.msg.TranfBancaHistoricoRQ;
import java.math.BigDecimal;
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
    @Inject
    private CuentaService cuentaService;

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
        try {
            fechaF = fechaF.replaceAll("-", "/");
            fechaI = fechaI.replaceAll("-", "/");
            System.out.println("SERVICIO REST - HISTORIAL DE MOVIMIENTOS DATOS: " + fechaF + " " + fechaI + " " + cuenta);

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dateI = new Date();
            Date dateF = new Date();
            if (fechaF.equals("") || fechaI.equals("") || cuenta.equals("")) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
            try {
                dateI = formatter.parse(fechaI);
                dateF = formatter.parse(fechaF);
            } catch (ParseException ex) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
            //
            List<TransaccionBancaHistoricoRQ> lstTrasnRQ = new ArrayList<>();
            List<Transaccion> lstTransaccions = transaccionService.findHistorialTransaccion(dateI, dateF, cuenta);
            if (lstTransaccions.size() == 0) {
                return Response.status(Response.Status.NO_CONTENT).build();
            }
            for (Transaccion auxTrans : lstTransaccions) {
                TransaccionBancaHistoricoRQ T = new TransaccionBancaHistoricoRQ();
                T.setDocumento(auxTrans.getIdTransaccion() + "");
                T.setFecha(auxTrans.getFechaTransaccion());
                T.setSaldo(auxTrans.getSaldo().doubleValue());
                T.setTipo(auxTrans.getIdTipoTransaccion().getNombreTipoTransaccion());
                T.setValor(auxTrans.getValorTransaccion().doubleValue());
                lstTrasnRQ.add(T);
            }
            //Ordenar por fecha
            for (int i = 0; i < lstTrasnRQ.size() - 1; i++) {
                for (int j = 0; j < lstTrasnRQ.size() - 1; j++) {
                    TransaccionBancaHistoricoRQ TA = lstTrasnRQ.get(j);
                    TransaccionBancaHistoricoRQ TP = lstTrasnRQ.get(j + 1);
                    if (TA.getFecha().after(TP.getFecha())) {
                        TransaccionBancaHistoricoRQ TEMP = lstTrasnRQ.get(j + 1);
                        lstTrasnRQ.set(j + 1, TA);
                        lstTrasnRQ.set(j, TEMP);
                    }

                }
            }
            //TODO return proper representation object
            GenericEntity generic = new GenericEntity<List<TransaccionBancaHistoricoRQ>>(lstTrasnRQ) {
            };
            return Response.ok(generic).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GET
    @Path("HisTransfer/{fechaI}&{fechaF}&{cuenta}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHistorico(@PathParam("fechaI") String fechaI, @PathParam("fechaF") String fechaF, @PathParam("cuenta") String cuenta) {
        try {
            fechaF = fechaF.replaceAll("-", "/");
            fechaI = fechaI.replaceAll("-", "/");
            System.out.println("SERVICIO REST - HISTORIAL TRANSFERENCIAS-DATOS: " + fechaF + " " + fechaI + " " + cuenta);

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dateI = new Date();
            Date dateF = new Date();
            if (fechaF.equals("") || fechaI.equals("") || cuenta.equals("")) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
            try {
                dateI = formatter.parse(fechaI);
                dateF = formatter.parse(fechaF);
            } catch (ParseException ex) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
            //
            List<TranfBancaHistoricoRQ> lstTrasnRQ = new ArrayList<>();
            List<Transaccion> lstTransaccions = transaccionService.findHistorialTransaccion(dateI, dateF, cuenta);
            if (lstTransaccions.size() == 0) {
                return Response.status(Response.Status.NO_CONTENT).build();
            }
            for (Transaccion auxTrans : lstTransaccions) {
                int i = auxTrans.getIdTipoTransaccion().getIdTipoTransaccion();
                if (i == 4 || i == 10 || i == 5) {
                    TranfBancaHistoricoRQ T = new TranfBancaHistoricoRQ();
                    T.setConcepto("Transferencia Bancaria");
                    T.setCuentaDestino(auxTrans.getConcepto());
                    T.setDocumento(auxTrans.getIdTransaccion() + "");
                    T.setFecha(auxTrans.getFechaTransaccion());
                    T.setSaldo(auxTrans.getSaldo().doubleValue());
                    T.setTipo(auxTrans.getIdTipoTransaccion().getNombreTipoTransaccion());
                    T.setValor(auxTrans.getValorTransaccion().doubleValue());
                    lstTrasnRQ.add(T);
                }
            }
            //Ordenar por fecha
            for (int i = 0; i < lstTrasnRQ.size() - 1; i++) {
                for (int j = 0; j < lstTrasnRQ.size() - 1; j++) {
                    TranfBancaHistoricoRQ TA = lstTrasnRQ.get(j);
                    TranfBancaHistoricoRQ TP = lstTrasnRQ.get(j + 1);
                    if (TA.getFecha().after(TP.getFecha())) {
                        TranfBancaHistoricoRQ TEMP = lstTrasnRQ.get(j + 1);
                        lstTrasnRQ.set(j + 1, TA);
                        lstTrasnRQ.set(j, TEMP);
                    }

                }
            }
            //TODO return proper representation object
            GenericEntity generic = new GenericEntity<List<TranfBancaHistoricoRQ>>(lstTrasnRQ) {
            };
            return Response.ok(generic).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }

    /**
     * PUT method for updating or creating an instance of TransaccionResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putJson(TransactionRQ T) {
        try {
            //TODO return proper representation object
            System.err.println("SERVICIO REST TRANSACCIÓN - MÉTODO PUT DATOS: " + T.toString());
            //Crear el formato de la transaccion
            Transaccion t = crearTransacción(T);
            if (t == null) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
            int i = T.getTipo();
            if (!(i == 1 || i == 2 || i == 3 || i == 31 || i == 41|| i == 32)) {
                return Response.status(Response.Status.CONFLICT).build();
            }
            //Cuenta a la que corresponde la transaccion
            Cuenta cOrigen = null;
            for (Cuenta auxCuenta : cuentaService.obtenerTodos()) {
                if (auxCuenta.getIdCuenta() == Integer.parseInt(T.getCuenta())) {
                    cOrigen = auxCuenta;
                }
            }
            double valor = cOrigen.getSaldoCuenta().doubleValue();
            if (T.getTipo() == 1 || T.getTipo() == 31|| T.getTipo() == 32) {
                valor += T.getMonto();
            } else {
                valor -= T.getMonto();
                if (valor < 0) {
                    return Response.status(Response.Status.NOT_ACCEPTABLE).build();
                }
            }
            cOrigen.setSaldoCuenta(BigDecimal.valueOf(valor));
            cuentaService.modificar(cOrigen);
            t.setSaldo(BigDecimal.valueOf(valor));
            t.setValorTransaccion(BigDecimal.valueOf(T.getMonto()));
            transaccionService.crear(t);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    private Transaccion crearTransacción(TransactionRQ T) {
        Transaccion t = new Transaccion();
        t.setIdTransaccion(T.getTipo());
        switch (T.getTipo()) {
            case 1:
                t.setConcepto("Depósito");
                break;
            case 2:
                t.setConcepto("Retiro");
                break;
            case 3:
                t.setConcepto("Cobro de Cheques");
                break;
            case 31:
                t.setConcepto("Acreditación de Prestamo");
                break;
            case 32:
                t.setConcepto("Sobregiro");
                break;
            case 41:
                t.setConcepto("Pago de Prestamo");
                break;
            default:
                t.setConcepto("Otras Transacciones");
                break;
        }

        t.setFechaTransaccion(new Date());
        Cuenta C = new Cuenta();
        C.setIdCuenta(Integer.parseInt(T.getCuenta()));
        t.setIdCuenta(C);
        TipoTransaccion TP = new TipoTransaccion();
        TP.setIdTipoTransaccion(T.getTipo());
        t.setIdTipoTransaccion(TP);
        int i = T.getTipo();
        String s = T.getCuenta();
        double d = T.getMonto();
        if (!(s == "" || d <= 0)) {
            return t;
        }
        return null;
    }
}
