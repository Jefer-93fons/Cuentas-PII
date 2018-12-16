/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.dao;

import ec.edu.espe.arquitectura.model.HistoricoProducto;
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
public class HistoricoProductoFacade extends AbstractFacade<HistoricoProducto> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_Modulo-Cuentas-Pll-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoricoProductoFacade() {
        super(HistoricoProducto.class);
    }
    
    public List<HistoricoProducto> findByCodigo(Integer codigo) {
        Query qry = this.em.createQuery("SELECT obj FROM HistoricoProducto obj WHERE obj.idHistoricoProducto=?1");
        qry.setParameter(1, codigo);
        return qry.getResultList();
    }
    
    public List<HistoricoProducto> findByTipo(Integer estado){
        Query qry=this.em.createQuery("SELECT obj FROM HistoricoProducto obj WHERE obj.idEstadoProducto.idEstadoProducto=?1");
        qry.setParameter(1, estado);
        return qry.getResultList();
    } 
}
