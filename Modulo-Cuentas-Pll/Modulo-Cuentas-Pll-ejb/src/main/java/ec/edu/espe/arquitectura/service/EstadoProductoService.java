/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.EstadoProductoFacade;
import ec.edu.espe.arquitectura.model.EstadoProducto;
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
public class EstadoProductoService {
    
    @EJB
    private EstadoProductoFacade estadoProductoFacade;
    
    public List<EstadoProducto> obtenerTodos(){
        return this.estadoProductoFacade.findAll();
    }
    public EstadoProducto obtenerPorCodigo(Integer codigo) {
        return this.estadoProductoFacade.find(codigo);
    }
    public void crear(EstadoProducto producto){
        this.estadoProductoFacade.create(producto);
    }
    
    public void modificar(EstadoProducto producto){
        this.estadoProductoFacade.edit(producto);
    }
    
    public void eliminar(Integer codigo){
        EstadoProducto producto = this.estadoProductoFacade.find(codigo);
        this.estadoProductoFacade.remove(producto);
    }
    
}
