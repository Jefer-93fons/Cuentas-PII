/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.soap.ws;

import ec.edu.espe.arquitectura.model.Cuenta;
import ec.edu.espe.arquitectura.model.TipoTransaccion;
import ec.edu.espe.arquitectura.model.Transaccion;
import ec.edu.espe.arquitectura.service.CuentaService;
import ec.edu.espe.arquitectura.service.TransaccionService;
import ec.edu.espe.arquitectura.soap.ws.msg.TranfBancaHistoricoRQ;
import ec.edu.espe.arquitectura.soap.ws.msg.TransaferenciaRQ;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Juan
 */
@WebService(serviceName = "TransferenciaWs")
public class TransferenciaWs {

    @Inject
    private TransaccionService transaccionService;
    @Inject
    private CuentaService cuentaService;

    @WebMethod(operationName = "Transferencia")
    public String hacerTransferenciaInterna(@WebParam(name = "origen") String origen, @WebParam(name = "destino") String destino, @WebParam(name = "monto") double monto) {

        try {
            Transaccion t = new Transaccion();
            t.setIdTransaccion(100);
            t.setConcepto(destino);
            t.setFechaTransaccion(new Date());
            Cuenta C = new Cuenta();
            C.setIdCuenta(Integer.parseInt(origen));
            t.setIdCuenta(C);
            TipoTransaccion TP = new TipoTransaccion();
            TP.setIdTipoTransaccion(9);
            t.setIdTipoTransaccion(TP);
            //Cuenta de origen
            Cuenta cOrigen = null;
            //Cuenta de destino
            Cuenta cDestino = null;
            for (Cuenta auxCuenta : cuentaService.obtenerTodos()) {
                if (auxCuenta.getIdCuenta() == Integer.parseInt(origen)) {
                    cOrigen = auxCuenta;
                }
                if (auxCuenta.getIdCuenta() == Integer.parseInt(destino)) {
                    cDestino = auxCuenta;
                }
            }
            double valor = cOrigen.getSaldoCuenta().doubleValue();
            double valor2 = cDestino.getSaldoCuenta().doubleValue();
            valor -= monto;
            valor2 += monto;
            t.setSaldo(BigDecimal.valueOf(valor));
            t.setValorTransaccion(BigDecimal.valueOf(monto));
            transaccionService.crear(t);
            cOrigen.setSaldoCuenta(BigDecimal.valueOf(valor));
            cuentaService.modificar(cOrigen);

        } catch (Exception e) {
            return "Fallo";
        }
        return "ok";
    }

    @WebMethod(operationName = "Historico")
    public List<TranfBancaHistoricoRQ> historicoTransferencia(@WebParam(name = "cuenta") String cuenta) {
        List<Transaccion> porCuenta = transaccionService.porCuenta(Integer.parseInt(cuenta));
        List<TranfBancaHistoricoRQ> lst = new ArrayList<>();
        for (Transaccion A : porCuenta) {
            if (A.getIdTipoTransaccion().getIdTipoTransaccion() == 9 || A.getIdTipoTransaccion().getIdTipoTransaccion() == 10) {
                TranfBancaHistoricoRQ T = new TranfBancaHistoricoRQ();
                T.setConcepto("Transferencia Bancaria");
                T.setCuentaDestino(A.getConcepto());
                T.setDocumento(A.getIdTransaccion() + "");
                T.setFecha(A.getFechaTransaccion());
                T.setSaldo(A.getSaldo().doubleValue());
                T.setTipo(A.getIdTipoTransaccion().getNombreTipoTransaccion());
                T.setValor(A.getValorTransaccion().doubleValue());
                lst.add(T);
            }
        }
        return lst;
    }

    @WebMethod(operationName = "TransferenciaI")
    public String hacerTransferenciaExterna(@WebParam(name = "origen") String origen, @WebParam(name = "destino") String destino, @WebParam(name = "monto") double monto) {

        try {
            Transaccion t = new Transaccion();
            t.setIdTransaccion(100);
            t.setConcepto(destino);
            t.setFechaTransaccion(new Date());
            Cuenta C = new Cuenta();
            C.setIdCuenta(Integer.parseInt(origen));
            t.setIdCuenta(C);
            TipoTransaccion TP = new TipoTransaccion();
            TP.setIdTipoTransaccion(9);
            t.setIdTipoTransaccion(TP);
            //Cuenta de origen
            Cuenta cOrigen = null;
            //Cuenta de destino
            Cuenta cDestino = null;
            for (Cuenta auxCuenta : cuentaService.obtenerTodos()) {
                if (auxCuenta.getIdCuenta() == Integer.parseInt(origen)) {
                    cOrigen = auxCuenta;
                }
                if (auxCuenta.getIdCuenta() == Integer.parseInt(destino)) {
                    cDestino = auxCuenta;
                }
            }
            double valor = cOrigen.getSaldoCuenta().doubleValue();
            double valor2 = cDestino.getSaldoCuenta().doubleValue();
            valor -= monto;
            valor2 += monto;
            t.setSaldo(BigDecimal.valueOf(valor));
            t.setValorTransaccion(BigDecimal.valueOf(monto));
            transaccionService.crear(t);
            cOrigen.setSaldoCuenta(BigDecimal.valueOf(valor));
            cuentaService.modificar(cOrigen);
            cDestino.setSaldoCuenta(BigDecimal.valueOf(valor2));
            cuentaService.modificar(cDestino);
            TP.setIdTipoTransaccion(10);
            t.setIdTipoTransaccion(TP);
            t.setIdCuenta(cDestino);
            t.setConcepto("Acreditacion de transferencia");
            t.setSaldo(BigDecimal.valueOf(valor2));
            transaccionService.crear(t);
        } catch (Exception e) {
            return "Fallo";
        }
        return "ok";
    }
}
