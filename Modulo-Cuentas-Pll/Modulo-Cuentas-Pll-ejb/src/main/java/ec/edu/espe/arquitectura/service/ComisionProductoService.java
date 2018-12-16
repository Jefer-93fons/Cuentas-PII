/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.ComisionProductoFacade;
import ec.edu.espe.arquitectura.model.ComisionProducto;
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
public class ComisionProductoService {
    
    @EJB
    private ComisionProductoFacade comisionProductoFacade;
    
    public List<ComisionProducto> obtenerTodos(){
        return this.comisionProductoFacade.findAll();
    }
    public ComisionProducto obtenerPorCodigo(Integer codigo) {
        return this.comisionProductoFacade.find(codigo);
    }
    public void crear(ComisionProducto interes){
        this.comisionProductoFacade.create(interes);
    }
    
    public void modificar(ComisionProducto interes){
        this.comisionProductoFacade.edit(interes);
    }
    
    public void eliminar(Integer codigo){
        ComisionProducto interes = this.comisionProductoFacade.find(codigo);
        this.comisionProductoFacade.remove(interes);
    }
    
}
