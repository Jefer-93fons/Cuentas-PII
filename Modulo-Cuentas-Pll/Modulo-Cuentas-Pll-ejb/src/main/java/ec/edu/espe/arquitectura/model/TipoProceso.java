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
@Table(name = "TIPO_PROCESO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProceso.findAll", query = "SELECT t FROM TipoProceso t")
    , @NamedQuery(name = "TipoProceso.findByIdTipoProceso", query = "SELECT t FROM TipoProceso t WHERE t.idTipoProceso = :idTipoProceso")
    , @NamedQuery(name = "TipoProceso.findByNombreTipoProceso", query = "SELECT t FROM TipoProceso t WHERE t.nombreTipoProceso = :nombreTipoProceso")})
public class TipoProceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_PROCESO")
    private Integer idTipoProceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_TIPO_PROCESO")
    private String nombreTipoProceso;
    @OneToMany(mappedBy = "idTipoProceso")
    private List<Proceso> procesoList;

    public TipoProceso() {
    }

    public TipoProceso(Integer idTipoProceso) {
        this.idTipoProceso = idTipoProceso;
    }

    public TipoProceso(Integer idTipoProceso, String nombreTipoProceso) {
        this.idTipoProceso = idTipoProceso;
        this.nombreTipoProceso = nombreTipoProceso;
    }

    public Integer getIdTipoProceso() {
        return idTipoProceso;
    }

    public void setIdTipoProceso(Integer idTipoProceso) {
        this.idTipoProceso = idTipoProceso;
    }

    public String getNombreTipoProceso() {
        return nombreTipoProceso;
    }

    public void setNombreTipoProceso(String nombreTipoProceso) {
        this.nombreTipoProceso = nombreTipoProceso;
    }

    @XmlTransient
    public List<Proceso> getProcesoList() {
        return procesoList;
    }

    public void setProcesoList(List<Proceso> procesoList) {
        this.procesoList = procesoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoProceso != null ? idTipoProceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProceso)) {
            return false;
        }
        TipoProceso other = (TipoProceso) object;
        if ((this.idTipoProceso == null && other.idTipoProceso != null) || (this.idTipoProceso != null && !this.idTipoProceso.equals(other.idTipoProceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.model.TipoProceso[ idTipoProceso=" + idTipoProceso + " ]";
    }
    
}
