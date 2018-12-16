/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.ProductoFacade;
import ec.edu.espe.arquitectura.model.Producto;
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
public class ProductoService {
    
    @EJB
    private ProductoFacade productoFacade;
    
   
    public List<Producto> obtenerTodos(){
        return this.productoFacade.findAll();
    }
    public Producto obtenerPorCodigo(Integer codigo) {
        return this.productoFacade.find(codigo);
    }
    public void crear(Producto producto){
        this.productoFacade.create(producto);
    }
    
    public void modificar(Producto producto){
        this.productoFacade.edit(producto);
    }
    
//    public void eliminar(Integer codigo){
//        Producto producto = this.productoFacade.find(codigo);
//        this.productoFacade.remove(producto);
//    }
    public void eliminar(Producto auxProducto){
        this.productoFacade.remove(auxProducto);
    }
    
    public List<Producto> buscarPorTipo(Integer tipoBusqueda) {
        return this.productoFacade.findByTipo(tipoBusqueda);
    }
    
    public Producto buscar(Producto auxProducto){
        Producto producto=null;
        for (Producto productoAux: this.productoFacade.findAll()) {
            if (productoAux.getIdProducto()==auxProducto.getIdProducto()) {
                producto=productoAux;
            }
        }

        return producto;
    }
}
