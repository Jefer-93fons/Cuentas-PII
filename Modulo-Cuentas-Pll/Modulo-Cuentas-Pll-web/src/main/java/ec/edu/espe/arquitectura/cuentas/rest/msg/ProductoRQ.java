/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.cuentas.rest.msg;

/**
 *
 * @author DAVID
 */
public class ProductoRQ {
    private Integer idProducto;
    private Integer idTipoProducto;
    private String nombreProducto;
    private String restriccionProducto;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(Integer idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getRestriccionProducto() {
        return restriccionProducto;
    }

    public void setRestriccionProducto(String restriccionProducto) {
        this.restriccionProducto = restriccionProducto;
    }

    @Override
    public String toString() {
        return "ProductoRQ{" + "idTipoProducto=" + idTipoProducto + ", nombreProducto=" + nombreProducto + ", restriccionProducto=" + restriccionProducto + '}';
    }
    
}
