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
    
    public TipoTransaccion obtenerPorCodigo(Integer codigo){
        return this.tipoTransaccionFacade.find(codigo);
    }
    public void crear(TipoTransaccion tipoTransaccion){
        this.tipoTransaccionFacade.create(tipoTransaccion);
    }
    
    public void modificar (TipoTransaccion tipoTransaccion){
        this.tipoTransaccionFacade.edit(tipoTransaccion);
    }
    
    public void eliminar(TipoTransaccion auxTipoTransaccion){
        this.tipoTransaccionFacade.remove(auxTipoTransaccion);
    }
    
    public TipoTransaccion buscar(TipoTransaccion auxTipoTransaccion){
        TipoTransaccion tipoTransaccion=null;
        for(TipoTransaccion tipoTransaccionAux: this.tipoTransaccionFacade.findAll()){
            if(tipoTransaccionAux.getIdTipoTransaccion()==auxTipoTransaccion.getIdTipoTransaccion()){
                tipoTransaccion=tipoTransaccionAux;
            }
        }
        return tipoTransaccion;
    }
}
    




