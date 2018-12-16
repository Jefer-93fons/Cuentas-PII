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

/**
 *
 * @author Jeffer
 */
@Stateless
@LocalBean
public class HistoricoService {
    
    @EJB
    private HistoricoFacade historicoFacade;
    
    public List<Historico> obtenerTodos(){
        return this.historicoFacade.findAll();
    }
    public Historico obtenerPorCodigo(Integer codigo) {
        return this.historicoFacade.find(codigo);
    }
    public void crear(Historico historico){
        this.historicoFacade.create(historico);
    }
    
    public void modificar(Historico historico){
        this.historicoFacade.edit(historico);
    }
    
    public void eliminar(Integer codigo){
        Historico historico = this.historicoFacade.find(codigo);
        this.historicoFacade.remove(historico);
    }
    
    public List<Historico> obtenerPorCuenta(int numcuenta){
        return this.historicoFacade.findByCuenta(numcuenta);
    }
}
