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
public class InteresProductoService1 {
    
    @EJB
    private InteresProductoFacade interesProductoFacade;
    
    public List<InteresProducto> obtenerTodos(){
        return this.interesProductoFacade.findAll();
    }
    public InteresProducto obtenerPorCodigo(Integer codigo) {
        return this.interesProductoFacade.find(codigo);
    }
    public void crear(InteresProducto interes){
        this.interesProductoFacade.create(interes);
    }
    
    public void modificar(InteresProducto interes){
        this.interesProductoFacade.edit(interes);
    }
    
    public void eliminar(Integer codigo){
        InteresProducto interes = this.interesProductoFacade.find(codigo);
        this.interesProductoFacade.remove(interes);
    }
    
}
