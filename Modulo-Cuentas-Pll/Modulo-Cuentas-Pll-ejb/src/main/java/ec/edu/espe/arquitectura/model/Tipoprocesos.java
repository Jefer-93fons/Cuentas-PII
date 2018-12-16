/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jefferson
 */
@Entity
@Table(name = "TIPOPROCESOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoprocesos.findAll", query = "SELECT t FROM Tipoprocesos t")
    , @NamedQuery(name = "Tipoprocesos.findByIdtipoproceso", query = "SELECT t FROM Tipoprocesos t WHERE t.idtipoproceso = :idtipoproceso")
    , @NamedQuery(name = "Tipoprocesos.findByProceso", query = "SELECT t FROM Tipoprocesos t WHERE t.proceso = :proceso")})
public class Tipoprocesos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTIPOPROCESO")
    private Integer idtipoproceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PROCESO")
    private String proceso;
    @OneToMany(mappedBy = "idtipoproceso")
    private List<Procesos> procesosList;

    public Tipoprocesos() {
    }

    public Tipoprocesos(Integer idtipoproceso) {
        this.idtipoproceso = idtipoproceso;
    }

    public Tipoprocesos(Integer idtipoproceso, String proceso) {
        this.idtipoproceso = idtipoproceso;
        this.proceso = proceso;
    }

    public Integer getIdtipoproceso() {
        return idtipoproceso;
    }

    public void setIdtipoproceso(Integer idtipoproceso) {
        this.idtipoproceso = idtipoproceso;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    @XmlTransient
    public List<Procesos> getProcesosList() {
        return procesosList;
    }

    public void setProcesosList(List<Procesos> procesosList) {
        this.procesosList = procesosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoproceso != null ? idtipoproceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoprocesos)) {
            return false;
        }
        Tipoprocesos other = (Tipoprocesos) object;
        if ((this.idtipoproceso == null && other.idtipoproceso != null) || (this.idtipoproceso != null && !this.idtipoproceso.equals(other.idtipoproceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.model.Tipoprocesos[ idtipoproceso=" + idtipoproceso + " ]";
    }
    
}
