/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.rest.api;

import ec.edu.espe.arquitectura.cuentas.rest.msg.CuentaBancaRQ;
import ec.edu.espe.arquitectura.cuentas.rest.msg.CuentaRP;
import ec.edu.espe.arquitectura.model.Cuenta;
import ec.edu.espe.arquitectura.model.Historico;
import ec.edu.espe.arquitectura.cuentas.rest.msg.CuentaRQ;
import ec.edu.espe.arquitectura.model.EstadoCuenta;
import ec.edu.espe.arquitectura.model.Producto;
import ec.edu.espe.arquitectura.service.CuentaService;
import ec.edu.espe.arquitectura.service.EstadoCuentaService;
import ec.edu.espe.arquitectura.service.HistoricoService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Jefferson
 */
@Path("cuenta")
@RequestScoped
public class CuentaResource {

    @Context
    private UriInfo context;
    @Inject
    private CuentaService cuentaService;
    @Inject
    private HistoricoService historicoService;
    @Inject
    private EstadoCuentaService estadoCuentaService;
    private List<Cuenta> lstCuentas;

    /**
     * Creates a new instance of CuentaResource
     */
    public CuentaResource() {
    }

    /**
     * Retrieves representation of an instance of
     * ec.edu.espe.arquitectura.rest.api.CuentaResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(@PathParam("cedula") String cedula) {
        //TODO return proper representation object
        lstCuentas = cuentaService.obtenerPorCedulaCliente(cedula);
        List<CuentaBancaRQ> lstCuentasRQ = new ArrayList<>();
        for (Cuenta auxCuenta : lstCuentas) {
            CuentaBancaRQ auxCuentaBancaRQ = new CuentaBancaRQ();
            auxCuentaBancaRQ.setCuenta(auxCuenta.getIdCuenta().toString());
            //Falta consultar el estado de la cuenta
            auxCuentaBancaRQ.setEstado("Activa");
            auxCuentaBancaRQ.setSaldo(auxCuenta.getSaldoCuenta().doubleValue());
            auxCuentaBancaRQ.setTipo(auxCuenta.getIdProducto().getNombreProducto());
            lstCuentasRQ.add(auxCuentaBancaRQ);
        }
        GenericEntity generic = new GenericEntity<List<CuentaBancaRQ>>(lstCuentasRQ) {
        };

        return Response.ok(generic).build();
    }

    @GET
    @Path("cedula/{cuenta}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCedulaXCuenta(@PathParam("cuenta") String cuenta) {
        System.out.println("SERVICIO REST - DATOS CUENTA POR ID CUENTA - DATOS: " + cuenta);
        lstCuentas = cuentaService.obtenerTodos();
        List<Historico> lstH = new ArrayList<>();
        CuentaRP C = null;
        for (Cuenta auxCuenta : lstCuentas) {
            if (cuenta.equals(auxCuenta.getIdCuenta() + "")) {
                C = new CuentaRP();
                C.setCedula(auxCuenta.getCodCliente());
                C.setTipo(auxCuenta.getIdProducto().getNombreProducto());
                C.setSaldo(auxCuenta.getSaldoCuenta().doubleValue());
                lstH = auxCuenta.getHistoricoList();
            }
        }
        
        //Ordenar por fecha
        if (lstH.size() > 1) {
            System.out.println("hasta "+lstH.size());
            for (int i = 0; i < lstH.size() - 1; i++) {
                for (int j = 0; j < lstH.size() - 1; j++) {

                    Historico TA = lstH.get(j);
                    Historico TP = lstH.get(j + 1);
                    if (TA.getFechaHistorico().after(TP.getFechaHistorico())) {
                        Historico TEMP = lstH.get(j + 1);
                        lstH.set(j + 1, TA);
                        lstH.set(j, TEMP);
                    }

                }
            }
            Historico get = lstH.get(lstH.size() - 1);
            if (get.getIdEstadoCuenta().getIdEstadoCuenta() == 1) {
                C.setEstado(true);
            } else {
                C.setEstado(false);
            }
        }else{
            C.setEstado(true);
        }

        GenericEntity generic = new GenericEntity<CuentaRP>(C) {
        };

        return Response.ok(generic).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        //TODO return proper representation object
        System.out.println("Entro");
        List<CuentaRQ> cuentasRQ = new ArrayList<>();
        lstCuentas = cuentaService.obtenerTodos();
        System.out.println("2");
        for (Cuenta cuenta : lstCuentas) {
            CuentaRQ newcuenta = new CuentaRQ();
            newcuenta.setIdCuenta(cuenta.getIdCuenta());
            newcuenta.setCodCliente(cuenta.getCodCliente());
            newcuenta.setNombreProducto(cuenta.getIdProducto().getNombreProducto());
            newcuenta.setSaldoCuenta(cuenta.getSaldoCuenta());
            //newcuenta.setEstadoCuenta(Integer.parseInt(historicoService.obtenerPorCuenta(cuenta.getIdCuenta()).get(0).getIdEstadoCuenta().getNombreEstadoCuenta()); 
            newcuenta.setEstadoCuenta(historicoService.obtenerPorCuenta(cuenta.getIdCuenta()).get(0).getIdEstadoCuenta().getIdEstadoCuenta());
            cuentasRQ.add(newcuenta);

        }
        System.out.println("3");
        GenericEntity generic = new GenericEntity<List<CuentaRQ>>(cuentasRQ) {
        };
        return Response.ok(generic).build();
    }

    /**
     * PUT method for updating or creating an instance of CuentaResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson(CuentaRQ content) {
        System.out.println("Datos Recibidos: " + content.toString());
        Cuenta cuent = new Cuenta();
        Producto prod = new Producto();
        cuent.setIdCuenta(content.getIdCuenta());
        prod.setIdProducto(content.getIdProducto());
        cuent.setSaldoCuenta(content.getSaldoCuenta());
        cuent.setCodCliente(content.getCodCliente());
        cuent.setIdProducto(prod);

        cuentaService.modificar(cuent);
        return Response.status(200).entity("La cuenta " + content.getIdCuenta() + " ha sido modificada").build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postJson(CuentaRQ content) {
        System.out.println("Datos Recibidos: " + content.toString());
        Cuenta cuent = new Cuenta();
        Producto prod = new Producto();
        Historico hist = new Historico();
        EstadoCuenta estadoC = new EstadoCuenta();

        cuent.setIdCuenta(1);
        prod.setIdProducto(content.getIdProducto());
        cuent.setSaldoCuenta(content.getSaldoCuenta());
        cuent.setCodCliente(content.getCodCliente());
        cuent.setIdProducto(prod);
        cuentaService.crear(cuent);

        cuent.setIdCuenta(cuentaService.obtenerUltimaCuenta().get(0).getIdCuenta());
        estadoC = estadoCuentaService.obtenerPorCodigo(content.getEstadoCuenta());
        hist.setIdHistorico(1);
        hist.setIdCuenta(cuent);
        hist.setIdEstadoCuenta(estadoC);
        hist.setFechaHistorico(new Date());

        historicoService.crear(hist);

        return Response.status(200).entity("Cuenta Creada").build();

    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response delJson(@PathParam("id") Integer cuentaId) {
        System.out.println("La cuenta a borrar es: " + cuentaId);
        Cuenta auxCuenta = new Cuenta();
        auxCuenta.setIdCuenta(cuentaId);
        //return Response.ok().entity("Borrado").build();
        try {
            cuentaService.eliminar(cuentaId);
            return Response.ok("Cuenta Eliminada").build();
        } catch (RuntimeException ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(new Exception(ex.getMessage())).build();
        }
    }

}
