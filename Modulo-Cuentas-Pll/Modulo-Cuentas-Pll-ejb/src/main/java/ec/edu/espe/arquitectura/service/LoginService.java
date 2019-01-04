/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.LoginFacade;
import ec.edu.espe.arquitectura.model.UsuarioLogin;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Jefferson
 */
@Stateless
@LocalBean
public class LoginService {
    @EJB
    private LoginFacade loginFacade;
    
    public boolean verificarUsuario(UsuarioLogin usu) throws MalformedURLException, ProtocolException, IOException{
        return this.loginFacade.iniciarSesion(usu);
    }
    
}
