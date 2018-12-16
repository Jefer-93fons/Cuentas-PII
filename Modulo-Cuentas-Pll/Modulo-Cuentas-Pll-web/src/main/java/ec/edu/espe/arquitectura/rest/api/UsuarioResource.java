/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.rest.api;

import ec.edu.espe.arquitectura.model.Usuario;
import ec.edu.espe.arquitectura.service.UsuarioService;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Jefferson
 */
@Path("usuario")
@RequestScoped
public class UsuarioResource {

    @Context
    private UriInfo context;
    @Inject
    private UsuarioService usuarioService;
    private List<Usuario> lstUsuarios;
    

    /**
     * Creates a new instance of UsuarioResource
     */
    public UsuarioResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.arquitectura.rest.api.UsuarioResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getJson() {
        lstUsuarios = usuarioService.obtenerTodos();
        if(lstUsuarios.size() > 0){
            Usuario auxUsuario = lstUsuarios.get(0);
            System.out.println("Su numero de usuario es " + auxUsuario.getClaveUsuario());
            
            return auxUsuario;
        }else{
            System.out.println("No existen Usuarios");
        }
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        return null;
    }

    /**
     * PUT method for updating or creating an instance of UsuarioResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
