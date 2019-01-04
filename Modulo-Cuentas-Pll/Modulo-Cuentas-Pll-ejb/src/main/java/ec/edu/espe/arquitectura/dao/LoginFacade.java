/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.dao;

import ec.edu.espe.arquitectura.model.Cliente;
import ec.edu.espe.arquitectura.model.UsuarioLogin;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jefferson
 */
@Stateless
public class LoginFacade extends AbstractFacade<UsuarioLogin> {
    
    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_Modulo-Cuentas-Pll-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public LoginFacade() {
        super(UsuarioLogin.class);
    }

    public boolean iniciarSesion(UsuarioLogin usu) throws MalformedURLException, ProtocolException, IOException{
        
        StringBuilder usuario=new StringBuilder();
        StringBuilder contrasenia=new StringBuilder();
        StringBuffer body = new StringBuffer();
        String nombre="";
        String apellido="";
        String usser="";
        String uri = "http://137.135.107.221:8080/SegNotP2v1-web/api/validarLogin";
        URL url = new URL(uri);
        String[] res;
        String[] fnl;
        boolean estado = false;
        StringBuilder usuarios = null;
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Accept", "application/json"); 
        body.append("usuario").append(usu.getUsuario()).append("clave").append(usu.getClave()).append("rol").append(usu.getRol());
        connection.setDoOutput(true);
        
        connection.setUseCaches(false);
        connection.setAllowUserInteraction(false);
        
        
        JsonObject value = Json.createObjectBuilder()
        .add("usuario", usu.getUsuario())
        .add("clave", usu.getClave())
        .add("rol", usu.getRol())
        .build();
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
        out.write(value.toString());
        out.close();
  
        connection.connect();
        int status = connection.getResponseCode();
        switch (status) {
            case 202:
                estado = true;
        }
        return estado;
        
//        try{
//            us = usuarioFacade.iniciarSesion(usuario);
//
//            if (us!=null){
//                //Almacenar Sesión
//                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
//                redireccion = "protected/principal.xhtml?faces-redirect=true";
//                
//            }else{
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Usuario no Registrado",null));
//            }
//            
//        }catch(Exception e){
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario no Registrado",null));
//        }
//        
//        return redireccion;
    } 
    
    public void cerrarSesion(){
//        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
    }
    
    public void verificarSesion(){
//        try {
//            FacesContext context = FacesContext.getCurrentInstance();
//            Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
//       
//            if (us==null){
//                context.getExternalContext().redirect("/Modulo_Cuentas-web/");
//            }
//        } catch (Exception e) {
//        }
    }
    
}
