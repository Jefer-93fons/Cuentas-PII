/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.model.Producto;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Juan
 */
@Stateless
@LocalBean
public class CierreService {


    public void calcularInteres() {
        ProductoService productoService = new ProductoService();
        List<Producto> productos = productoService.obtenerTodos();

        for (Producto prod : productos) {
            System.out.println("Producto: " + prod.getNombreProducto());
        }
    }
    

}
