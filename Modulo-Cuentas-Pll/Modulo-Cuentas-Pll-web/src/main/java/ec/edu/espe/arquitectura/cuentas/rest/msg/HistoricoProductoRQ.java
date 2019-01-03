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
public class HistoricoProductoRQ {

    
    private Integer idHistoricoProducto;
    private Integer idEstadoProducto;
    private Integer idProducto;
    //private Date fechaVigencia;
    private String fechaVigencia1;
    public Integer getIdHistoricoProducto() {
        return idHistoricoProducto;
    }

    public void setIdHistoricoProducto(Integer idHistoricoProducto) {
        this.idHistoricoProducto = idHistoricoProducto;
    }

    public Integer getIdEstadoProducto() {
        return idEstadoProducto;
    }

    public void setIdEstadoProducto(Integer idEstadoProducto) {
        this.idEstadoProducto = idEstadoProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getFechaVigencia1() {
        return fechaVigencia1;
    }

    public void setFechaVigencia1(String fechaVigencia1) {
        this.fechaVigencia1 = fechaVigencia1;
    }
    

//    public Date getFechaVigencia() {
//        return fechaVigencia;
//    }
//
//    public void setFechaVigencia(Date fechaVigencia) {
//        this.fechaVigencia = fechaVigencia;
//    }

    @Override
    public String toString() {
        return "HistoricoProductoRQ{" + "idHistoricoProducto=" + idHistoricoProducto + ", idEstadoProducto=" + idEstadoProducto + ", idProducto=" + idProducto + ", fechaVigencia1=" + fechaVigencia1 + '}';
    }


    

   
    




}
