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
public class InteresRQ {

    
    private Integer idInteres;
    private Integer idPeriodo;
    private double porcentaje;
    private double valorMinimo;
    private double valorMaximo;

    public Integer getIdInteres() {
        return idInteres;
    }

    public void setIdInteres(Integer idInteres) {
        this.idInteres = idInteres;
    }

    public Integer getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(double valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public double getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(double valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    @Override
    public String toString() {
        return "InteresRQ{" + "idInteres=" + idInteres + ", idPeriodo=" + idPeriodo + ", porcentaje=" + porcentaje + ", valorMinimo=" + valorMinimo + ", valorMaximo=" + valorMaximo + '}';
    }

}
