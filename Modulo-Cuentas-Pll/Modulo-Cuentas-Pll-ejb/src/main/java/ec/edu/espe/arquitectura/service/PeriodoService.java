/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.PeriodoFacade;
import ec.edu.espe.arquitectura.model.Periodo;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author DAVID
 */
@Stateless
@LocalBean
public class PeriodoService {
    
    @EJB
    private PeriodoFacade periodoFacade;
    
    public List<Periodo> obtenerTodos(){
        return this.periodoFacade.findAll();
    }
    public Periodo obtenerPorCodigo(Integer codigo) {
        return this.periodoFacade.find(codigo);
    }
    public void crear(Periodo periodo){
        this.periodoFacade.create(periodo);
    }
    
    public void modificar(Periodo periodo){
        this.periodoFacade.edit(periodo);
    }
    
    public void eliminar(Integer codigo){
        Periodo periodo = this.periodoFacade.find(codigo);
        this.periodoFacade.remove(periodo);
    }
    
}
