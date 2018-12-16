/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.EstadoCuentaFacade;
import ec.edu.espe.arquitectura.model.EstadoCuenta;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Jeffer
 */
@Stateless
@LocalBean
public class EstadoCuentaService {
    
    @EJB
    private EstadoCuentaFacade estadoCuentaFacade;
    
    public List<EstadoCuenta> obtenerTodos(){
        return this.estadoCuentaFacade.findAll();
    }
    public EstadoCuenta obtenerPorCodigo(Integer codigo) {
        return this.estadoCuentaFacade.find(codigo);
    }
    public void crear(EstadoCuenta estadoCuenta){
        this.estadoCuentaFacade.create(estadoCuenta);
    }
    
    public void modificar(EstadoCuenta estadoCuenta){
        this.estadoCuentaFacade.edit(estadoCuenta);
    }
    
    public void eliminar(Integer codigo){
        EstadoCuenta estadoCuenta = this.estadoCuentaFacade.find(codigo);
        this.estadoCuentaFacade.remove(estadoCuenta);
    }
}
