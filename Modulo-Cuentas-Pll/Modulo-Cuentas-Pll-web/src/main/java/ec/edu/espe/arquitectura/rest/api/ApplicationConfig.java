/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.rest.api;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Jefferson
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ec.edu.espe.arquitectura.rest.api.ComisionProductoResource.class);
        resources.add(ec.edu.espe.arquitectura.rest.api.ComisionResource.class);
        resources.add(ec.edu.espe.arquitectura.rest.api.CuentaResource.class);
        resources.add(ec.edu.espe.arquitectura.rest.api.HistoricoProductoResource.class);
        resources.add(ec.edu.espe.arquitectura.rest.api.InteresProductoResource.class);
        resources.add(ec.edu.espe.arquitectura.rest.api.InteresResource.class);
        resources.add(ec.edu.espe.arquitectura.rest.api.ProductoResource.class);

    }
    
}
