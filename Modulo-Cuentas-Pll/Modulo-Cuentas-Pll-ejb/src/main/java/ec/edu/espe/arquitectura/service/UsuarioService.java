/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.UsuarioFacade;
import ec.edu.espe.arquitectura.model.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Jefferson
 */
@Stateless
@LocalBean
public class UsuarioService {
    @EJB
    private UsuarioFacade usuarioFacade;
    
    public List<Usuario> obtenerTodos(){
        return this.usuarioFacade.findAll();
    }
    public Usuario obtenerPorCodigo(Integer codigo) {
        return this.usuarioFacade.find(codigo);
    }
    
    public void crear(Usuario usuario){
        this.usuarioFacade.create(usuario);
    }
    
    public void modificar(Usuario usuario){
        this.usuarioFacade.edit(usuario);
    }
    
    public void eliminar(Integer codigo){
        Usuario usuario = this.usuarioFacade.find(codigo);
        this.usuarioFacade.remove(usuario);
    }
}
