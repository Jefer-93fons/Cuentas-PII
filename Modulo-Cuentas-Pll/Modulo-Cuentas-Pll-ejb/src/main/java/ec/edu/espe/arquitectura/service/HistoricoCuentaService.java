/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.HistoricoFacade;
import ec.edu.espe.arquitectura.model.Historico;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class HistoricoCuentaService {
    
    @EJB
    private HistoricoFacade historicoFacade;
    
    public List<Historico> obtenerTodos(){
        return this.historicoFacade.findAll();
    }
    public void crear(Historico historico){
        this.historicoFacade.create(historico);
    }
    
    public List<Historico> porNumCuenta(Integer idCuenta){
        return this.historicoFacade.findByAccount(idCuenta);
    }
    
    public void modificar(Historico historico){
        this.historicoFacade.edit(historico);
    }
    
}
