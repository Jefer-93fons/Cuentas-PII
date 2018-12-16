/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.HistoricoProductoFacade;
import ec.edu.espe.arquitectura.model.HistoricoProducto;
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
public class HistoricoProductoService {
    
    @EJB
    private HistoricoProductoFacade historicoProductoFacade;
    
    public List<HistoricoProducto> obtenerTodos(){
        return this.historicoProductoFacade.findAll();
    }
    public HistoricoProducto obtenerPorCodigo(Integer codigo) {
        return this.historicoProductoFacade.find(codigo);
    }
    public void crear(HistoricoProducto producto){
        this.historicoProductoFacade.create(producto);
    }
    
    public void modificar(HistoricoProducto producto){
        this.historicoProductoFacade.edit(producto);
    }
    
    public void eliminar(Integer codigo){
        HistoricoProducto producto = this.historicoProductoFacade.find(codigo);
        this.historicoProductoFacade.remove(producto);
    }
    
    public List<HistoricoProducto> buscarPorTipo(Integer tipoBusqueda) {
        return this.historicoProductoFacade.findByTipo(tipoBusqueda);
    }
    
}
