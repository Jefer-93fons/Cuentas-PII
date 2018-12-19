/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

/**
 *
 * @author Admin
 */
import ec.edu.espe.arquitectura.dao.TipoTransaccionFacade;
import ec.edu.espe.arquitectura.model.TipoTransaccion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

@Stateless
@LocalBean
public class TipoTransaccionService {
    
    @EJB 
    private TipoTransaccionFacade tipoTransaccionFacade;
    
    public List<TipoTransaccion> obtenerTodos(){
        return this.tipoTransaccionFacade.findAll();
    }
    
    public void crear(TipoTransaccion tipoTransaccion){
        this.tipoTransaccionFacade.create(tipoTransaccion);
    }
    



}
