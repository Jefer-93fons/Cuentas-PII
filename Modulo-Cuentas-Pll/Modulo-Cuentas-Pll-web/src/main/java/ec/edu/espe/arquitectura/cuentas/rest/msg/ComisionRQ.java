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
public class ComisionRQ {
    private Integer idComision;
    private String razonComision;

    public Integer getIdComision() {
        return idComision;
    }

    public void setIdComision(Integer idComision) {
        this.idComision = idComision;
    }

    public String getRazonComision() {
        return razonComision;
    }

    public void setRazonComision(String razonComision) {
        this.razonComision = razonComision;
    }

    @Override
    public String toString() {
        return "ComisionRQ{" + "idComision=" + idComision + ", razonComision=" + razonComision + '}';
    }
    

   
    
}
