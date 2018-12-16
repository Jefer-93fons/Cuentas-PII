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
    
    
     public ComisionProducto buscar(ComisionProducto auxComisionProducto){
        ComisionProducto comisionProducto=null;
        for (ComisionProducto comisionProductoAux: this.comisionProductoFacade.findAll()) {
            if (comisionProductoAux.getIdComisionProducto()==auxComisionProducto.getIdComisionProducto()) {
                comisionProducto=comisionProductoAux;
            }
        }

        return comisionProducto;
    }
      public void eliminar(ComisionProducto auxComisionProducto){
        this.comisionProductoFacade.remove(auxComisionProducto);
    }
}
