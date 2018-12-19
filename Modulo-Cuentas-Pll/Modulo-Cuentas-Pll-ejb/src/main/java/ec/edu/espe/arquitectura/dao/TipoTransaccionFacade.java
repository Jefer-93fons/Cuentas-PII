/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.dao;

import ec.edu.espe.arquitectura.model.TipoTransaccion;
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
public class TipoTransaccionFacade extends AbstractFacade<TipoTransaccion> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_Modulo-Cuentas-Pll-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoTransaccionFacade() {
        super(TipoTransaccion.class);
    }
    
    public List<TipoTransaccion> findByCodigo(Integer codigo){
        Query qry=this.em.createQuery("SELECT obj FROM TipoTransaccion obj WHERE obj.idTipoTransaccion=?1");
        qry.setParameter(1,codigo);
        return qry.getResultList();
    }
    
    public List<TipoTransaccion> findByTipo(Integer tipo){
        Query qry=this.em.createQuery("SELECT obj FROM TipoTransaccion obj WHERE obj.idTipoTransaccion.idTipoTransaccion=?1");
        qry.setParameter(1,tipo);
        return qry.getResultList();
    }
    
}
