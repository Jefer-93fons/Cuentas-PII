/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.cuentas.rest.msg;

import java.util.Date;

/**
 *
 * @author Juan
 */
public class TransaccionRQ {
    private Date fechaInicio;
    private Date fechaFin;
    private String cuenta;

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "TransaccionRQ{" + "fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", cuenta=" + cuenta + '}';
    }
    
    
}
