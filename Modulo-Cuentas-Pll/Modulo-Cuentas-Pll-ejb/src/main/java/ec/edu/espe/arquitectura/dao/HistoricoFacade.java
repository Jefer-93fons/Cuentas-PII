/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.dao;

import ec.edu.espe.arquitectura.model.Historico;
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
public class HistoricoFacade extends AbstractFacade<Historico> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_Modulo-Cuentas-Pll-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoricoFacade() {
        super(Historico.class);
    }
    
    public List<Historico> findByCuenta(Integer idCuenta) {
        Query qry = this.em.createQuery("SELECT h from Historico h WHERE h.idCuenta.idCuenta = ?1 ORDER BY h.fechaHistorico DESC");
        qry.setParameter(1, idCuenta);
        return qry.getResultList();
    }
    
}
