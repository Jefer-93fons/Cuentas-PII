/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.InteresFacade;
import ec.edu.espe.arquitectura.model.Interes;
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
public class InteresService {
    
    @EJB
    private InteresFacade interesFacade;
    
    public List<Interes> obtenerTodos(){
        return this.interesFacade.findAll();
    }
    public Interes obtenerPorCodigo(Integer codigo) {
        return this.interesFacade.find(codigo);
    }
    public void crear(Interes interes){
        this.interesFacade.create(interes);
    }
    
    public void modificar(Interes interes){
        this.interesFacade.edit(interes);
    }
    
    public void eliminar(Integer codigo){
        Interes interes = this.interesFacade.find(codigo);
        this.interesFacade.remove(interes);
    }
    
}
