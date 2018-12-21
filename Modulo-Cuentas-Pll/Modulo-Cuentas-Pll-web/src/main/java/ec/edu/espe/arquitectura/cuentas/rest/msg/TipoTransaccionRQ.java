/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.cuentas.rest.msg;

import java.math.BigDecimal;

/**
 *
 * @author Admin
 */
public class TipoTransaccionRQ {
    private Integer idTipoTransaccion;
    private String nombreTipoTransaccion;
    private BigDecimal cargo;

    public Integer getIdTipoTransaccion() {
        return idTipoTransaccion;
    }

    public void setIdTipoTransaccion(Integer idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public String getNombreTipoTransaccion() {
        return nombreTipoTransaccion;
    }

    public void setNombreTipoTransaccion(String nombreTipoTransaccion) {
        this.nombreTipoTransaccion = nombreTipoTransaccion;
    }

    public BigDecimal getCargo() {
        return cargo;
    }

    public void setCargo(BigDecimal cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "TipoTransaccionRQ{" + "idTipoTransaccion=" + idTipoTransaccion + ", nombreTipoTransaccion=" + nombreTipoTransaccion + ", cargo=" + cargo + '}';
    }

    
    
}
