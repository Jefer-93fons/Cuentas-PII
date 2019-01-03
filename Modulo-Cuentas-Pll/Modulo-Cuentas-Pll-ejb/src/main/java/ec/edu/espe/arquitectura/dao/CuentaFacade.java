/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.dao;

import ec.edu.espe.arquitectura.model.Cuenta;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jefferson
 */
@Stateless
public class CuentaFacade extends AbstractFacade<Cuenta> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_Modulo-Cuentas-Pll-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentaFacade() {
        super(Cuenta.class);
    }
    
    public List<Cuenta> findByCedulaCliente(String cedula){
        Query qry=this.em.createQuery("SELECT c FROM Cuenta c WHERE c.codCliente = ?1");
        qry.setParameter(1, cedula);
        return qry.getResultList();
    } 
    
    
    public List<Cuenta> findLastAccount(){
        //Query qry=this.em.createQuery("SELECT MAX(c.idCuenta) FROM Cuenta c");
        //Query qry=this.em.createQuery("SELECT c FROM (SELECT t FROM Cuenta t ORDER BY t.idCuenta DESC)   \n" +
//"WHERE ROWNUM = 1");
        Query qry=this.em.createQuery("SELECT c FROM Cuenta c ORDER BY c.idCuenta DESC");
        return qry.getResultList();
        
    }
    
    public boolean obtenerUsuario(String cedula) throws MalformedURLException, ProtocolException, IOException{
        StringBuilder usuario=new StringBuilder();
        StringBuilder contrasenia=new StringBuilder();
        String nombre="";
        String apellido="";
        String usser="";
        //String uri = "http://kyc.strangled.net:8080/KYC-mongo-rest-web/api/cliente/cedula/1234567891";
        String uri = "http://kyc.strangled.net:8080/KYC-mongo-rest-web/api/cliente/cedula/";
        uri = uri + cedula;
        URL url = new URL(uri);
        String[] res;
        String[] fnl;
        boolean estado = false;
        StringBuilder usuarios = null;
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json"); 
        connection.setUseCaches(false);
        connection.setAllowUserInteraction(false);
        connection.connect();
        int status = connection.getResponseCode();
        switch (status) {
            case 200:
                estado = true;
        }
        return estado;
    }
    
    
}
