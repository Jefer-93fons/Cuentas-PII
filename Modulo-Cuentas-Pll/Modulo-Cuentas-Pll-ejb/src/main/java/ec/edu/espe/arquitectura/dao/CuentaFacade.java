/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.dao;

import ec.edu.espe.arquitectura.model.Cuenta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jefferson
 */
@Stateless
public class CuentaFacade extends AbstractFacade<Cuenta> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_Modulo-Cuentas-Pll-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentaFacade() {
        super(Cuenta.class);
    }
    
    public List<Cuenta> findByCedulaCliente(String cedula){
        Query qry=this.em.createQuery("SELECT c FROM Cuenta c WHERE c.codCliente = ?1");
        qry.setParameter(1, cedula);
        return qry.getResultList();
    } 
    
    
    public List<Cuenta> findLastAccount(){
        //Query qry=this.em.createQuery("SELECT MAX(c.idCuenta) FROM Cuenta c");
        //Query qry=this.em.createQuery("SELECT c FROM (SELECT t FROM Cuenta t ORDER BY t.idCuenta DESC)   \n" +
//"WHERE ROWNUM = 1");
        Query qry=this.em.createQuery("SELECT c FROM Cuenta c ORDER BY c.idCuenta DESC");
        return qry.getResultList();
        
    }
    
    
}
