/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.soap.ws.msg;

/**
 *
 * @author Juan
 */
public class TransaferenciaRQ {
    private double monto;
    private double cuentaOrigen;
    private double cuentaDestino;

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(double cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public double getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(double cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    @Override
    public String toString() {
        return "TransaferenciaRQ{" + "monto=" + monto + ", cuentaOrigen=" + cuentaOrigen + ", cuentaDestino=" + cuentaDestino + '}';
    }
    
}
