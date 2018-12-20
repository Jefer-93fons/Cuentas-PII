/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.TransaccionFacade;
import ec.edu.espe.arquitectura.model.Cuenta;
import ec.edu.espe.arquitectura.model.Transaccion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author DAVID
 */
@Stateless
@LocalBean
public class TransaccionService {

    @EJB
    private TransaccionFacade transaccionFacade;

    public List<Transaccion> obtenerTodos() {
        return this.transaccionFacade.findAll();
    }

    public List<Transaccion> porCuenta(int accountCode) {
        List<Transaccion> transacciones = obtenerTodos();
        List<Transaccion> transaccionsDevuletas = new ArrayList<>();
        for (Transaccion auxTrans : transacciones) {
            if (auxTrans.getIdCuenta().getIdCuenta() == accountCode) {
                transaccionsDevuletas.add(auxTrans);
            }
        }
        return transaccionsDevuletas;
    }

    public void crear(Transaccion transaccion) {
        this.transaccionFacade.create(transaccion);
    }

    public void modificar(Transaccion transaccion) {
        this.transaccionFacade.edit(transaccion);
    }

    public List<Transaccion> findHistorialTransaccion(Date fechaI, Date fechaF, String cuenta) {
        List<Transaccion> trans = porCuenta(Integer.parseInt(cuenta));
        List<Transaccion> transaccionsDevuletas = new ArrayList<>();
        for (Transaccion auxTran : trans) {
            Date auxFecha = auxTran.getFechaTransaccion();
            if (auxFecha.before(fechaF) && auxFecha.after(fechaI)) {
                transaccionsDevuletas.add(auxTran);
            }
        }
        return transaccionsDevuletas;
    }

}
