/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.cuentas.rest.msg;

/**
 *
 * @author Juan
 */
public class InteresProductoRQ {

    
    private Integer idInteresProducto;
    private Integer idInteres;
    private Integer idProducto;

   
    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdInteresProducto() {
        return idInteresProducto;
    }

    public void setIdInteresProducto(Integer idInteresProducto) {
        this.idInteresProducto = idInteresProducto;
    }

    public Integer getIdInteres() {
        return idInteres;
    }

    public void setIdInteres(Integer idInteres) {
        this.idInteres = idInteres;
    }

    @Override
    public String toString() {
        return "InteresProductoRQ{" + "idInteresProducto=" + idInteresProducto + ", idInteres=" + idInteres + ", idProducto=" + idProducto + '}';
    }

   




}
