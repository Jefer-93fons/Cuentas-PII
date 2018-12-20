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
public class TransaccionBancaHistoricoRQ {
    private Date fecha;
    private String documento;
    private String tipo;
    private double valor;
    private double saldo;
    private String cuentaDestino;
    private String concepto;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    @Override
    public String toString() {
        return "TransaccionBancaHistoricoRQ{" + "fecha=" + fecha + ", documento=" + documento + ", tipo=" + tipo + ", valor=" + valor + ", saldo=" + saldo + ", cuentaDestino=" + cuentaDestino + ", concepto=" + concepto + '}';
    }
    
    
    
}
