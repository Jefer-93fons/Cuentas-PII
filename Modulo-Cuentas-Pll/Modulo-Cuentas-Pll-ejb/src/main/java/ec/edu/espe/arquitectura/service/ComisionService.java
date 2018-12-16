/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.ComisionFacade;
import ec.edu.espe.arquitectura.model.Comision;
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
public class ComisionService {
    
    @EJB
    private ComisionFacade comisionFacade;
    
    public List<Comision> obtenerTodos(){
        return this.comisionFacade.findAll();
    }
    public Comision obtenerPorCodigo(Integer codigo) {
        return this.comisionFacade.find(codigo);
    }
    public void crear(Comision interes){
        this.comisionFacade.create(interes);
    }
    
    public void modificar(Comision interes){
        this.comisionFacade.edit(interes);
    }
  
    
    public void eliminar(Comision auxComision){
        this.comisionFacade.remove(auxComision);
    }
    
    
    public Comision buscar(Comision auxComision){
        Comision comision=null;
        for (Comision comisionAux: this.comisionFacade.findAll()) {
            if (comisionAux.getIdComision()==auxComision.getIdComision()) {
                comision=comisionAux;
            }
        }

        return comision;
    }
}
