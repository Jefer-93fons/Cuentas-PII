/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jefferson
 */
@Entity
@Table(name = "FECHA_TRABAJO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FechaTrabajo.findAll", query = "SELECT f FROM FechaTrabajo f")
    , @NamedQuery(name = "FechaTrabajo.findByIdFecha", query = "SELECT f FROM FechaTrabajo f WHERE f.idFecha = :idFecha")
    , @NamedQuery(name = "FechaTrabajo.findByFechaProceso", query = "SELECT f FROM FechaTrabajo f WHERE f.fechaProceso = :fechaProceso")})
public class FechaTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FECHA")
    private Integer idFecha;
    @Column(name = "FECHA_PROCESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaProceso;

    public FechaTrabajo() {
    }

    public FechaTrabajo(Integer idFecha) {
        this.idFecha = idFecha;
    }

    public Integer getIdFecha() {
        return idFecha;
    }

    public void setIdFecha(Integer idFecha) {
        this.idFecha = idFecha;
    }

    public Date getFechaProceso() {
        return fechaProceso;
    }

    public void setFechaProceso(Date fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFecha != null ? idFecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FechaTrabajo)) {
            return false;
        }
        FechaTrabajo other = (FechaTrabajo) object;
        if ((this.idFecha == null && other.idFecha != null) || (this.idFecha != null && !this.idFecha.equals(other.idFecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.model.FechaTrabajo[ idFecha=" + idFecha + " ]";
    }
    
}
