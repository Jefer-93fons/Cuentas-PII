/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.InteresProductoFacade;
import ec.edu.espe.arquitectura.model.InteresProducto;
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
public class InteresProductoService {
    
    @EJB
    private InteresProductoFacade fechaTrabajoFacade;
    
    public List<InteresProducto> obtenerTodos(){
        return this.fechaTrabajoFacade.findAll();
    }
    
    public void crear(InteresProducto interesProducto){
        this.fechaTrabajoFacade.create(interesProducto);
    }
    
    public void modificar(InteresProducto interesProducto){
        this.fechaTrabajoFacade.edit(interesProducto);
    }
    

}
