/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.TransaccionFacade;
import ec.edu.espe.arquitectura.model.Cuenta;
import ec.edu.espe.arquitectura.model.Transaccion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class TransaccionService {

    @EJB
    private TransaccionFacade transaccionFacade;

    public List<Transaccion> obtenerTodos() {
        return this.transaccionFacade.findAll();
    }
    
  
    public Transaccion obtenerPorCodigo(Integer codigo){
        return this.transaccionFacade.find(codigo);
    }
    public void crear(Transaccion transaccion) {
        this.transaccionFacade.create(transaccion);
    }

    public void modificar(Transaccion transaccion) {
        this.transaccionFacade.edit(transaccion);
    }
    
    public void eliminar(Transaccion auxTransaccion){
        this.transaccionFacade.remove(auxTransaccion);
    }
    
    //public List<Transaccion> buscarPorTipo(Integer tipoBusqueda){
     //   return this.transaccionFacade.findByTipo(tipoBusqueda);
    //}
    
    public Transaccion buscar (Transaccion auxTransaccion){
       Transaccion transaccion=null;
       for(Transaccion transaccionAux: this.transaccionFacade.findAll()){
           if(transaccionAux.getIdTransaccion()==auxTransaccion.getIdTransaccion()){
               transaccion=transaccionAux;
            }
        }
    return transaccion;
    }
    
    
}    
