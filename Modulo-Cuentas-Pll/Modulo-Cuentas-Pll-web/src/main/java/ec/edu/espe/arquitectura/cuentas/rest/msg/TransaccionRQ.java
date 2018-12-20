/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.cuentas.rest.msg;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class TransaccionRQ {
    private Integer idTransaccion;
    private Integer idTipoTransaccion;
    private Integer idCuenta;
    private Float valorTransaccion;
    private Date fechaTransaccion;
    public Integer getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Integer getIdTipoTransaccion() {
        return idTipoTransaccion;
    }

    public void setIdTipoTransaccion(Integer idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Float getValorTransaccion() {
        return valorTransaccion;
    }

    public void setValorTransaccion(Float valorTransaccion) {
        this.valorTransaccion = valorTransaccion;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    @Override
    public String toString() {
        return "TransacionRQ{" + "idTransaccion=" + idTransaccion + ", idTipoTransaccion=" + idTipoTransaccion + ", idCuenta=" + idCuenta + ", valorTransaccion=" + valorTransaccion + ", fechaTransaccion=" + fechaTransaccion + '}';
    }
    
    
}
