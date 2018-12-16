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
public class ComisionProductoRQ {

    
    private Integer idComisionProducto;
    private Integer idComision;
    private Integer idProducto;
    private double valor;

    public Integer getIdComisionProducto() {
        return idComisionProducto;
    }

    public void setIdComisionProducto(Integer idComisionProducto) {
        this.idComisionProducto = idComisionProducto;
    }

    public Integer getIdComision() {
        return idComision;
    }

    public void setIdComision(Integer idComision) {
        this.idComision = idComision;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "ComisionProductoRQ{" + "idComisionProducto=" + idComisionProducto + ", idComision=" + idComision + ", idProducto=" + idProducto + ", valor=" + valor + '}';
    }

   
    




}
