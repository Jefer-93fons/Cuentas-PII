/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.ClienteFacade;
import ec.edu.espe.arquitectura.model.Cliente;
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
public class ClienteService {
    @EJB
    private ClienteFacade clienteFacade;
    
    public List<Cliente> obtenerTodos(){
        return this.clienteFacade.findAll();
    }
    public Cliente obtenerPorCodigo(Integer codigo) {
        return this.clienteFacade.find(codigo);
    }
    
    public Cliente obtenerCliente (Integer codigo) {
        return this.clienteFacade.find(codigo);
    }
    public void crear(Cliente cuenta){
        this.clienteFacade.create(cuenta);
    }
    
    public void modificar(Cliente cuenta){
        this.clienteFacade.edit(cuenta);
    }
    
    public void eliminar(Integer codigo){
        Cliente cuenta = this.clienteFacade.find(codigo);
        this.clienteFacade.remove(cuenta);
    }
}
