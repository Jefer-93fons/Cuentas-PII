/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.rest.api;

import ec.edu.espe.arquitectura.model.UsuarioLogin;
import ec.edu.espe.arquitectura.service.LoginService;
import java.io.IOException;
import java.net.ProtocolException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Jefferson
 */
@Path("login")
@RequestScoped
public class LoginResource {

    @Context
    private UriInfo context;
    
    @Inject
    private LoginService loginService;

    /**
     * Creates a new instance of LoginResource
     */
    public LoginResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.arquitectura.rest.api.LoginResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of LoginResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postJson(UsuarioLogin content) throws ProtocolException, IOException {
        System.out.println("Datos Recibidos: " + content.toString());
           
        if(loginService.verificarUsuario(content)){
            
            return Response.status(202).entity("Login Satisfactorio").build();
        }else{
            return Response.status(500).entity("Usuario no valido1").build();
        }
        
    }
}
