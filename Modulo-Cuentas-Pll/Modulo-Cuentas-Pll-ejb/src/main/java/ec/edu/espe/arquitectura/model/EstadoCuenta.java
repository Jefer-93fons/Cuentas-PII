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
@Table(name = "ESTADO_CUENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCuenta.findAll", query = "SELECT e FROM EstadoCuenta e")
    , @NamedQuery(name = "EstadoCuenta.findByIdEstadoCuenta", query = "SELECT e FROM EstadoCuenta e WHERE e.idEstadoCuenta = :idEstadoCuenta")
    , @NamedQuery(name = "EstadoCuenta.findByNombreEstadoCuenta", query = "SELECT e FROM EstadoCuenta e WHERE e.nombreEstadoCuenta = :nombreEstadoCuenta")})
public class EstadoCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTADO_CUENTA")
    private Integer idEstadoCuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_ESTADO_CUENTA")
    private String nombreEstadoCuenta;
    @OneToMany(mappedBy = "idEstadoCuenta")
    private List<Historico> historicoList;

    public EstadoCuenta() {
    }

    public EstadoCuenta(Integer idEstadoCuenta) {
        this.idEstadoCuenta = idEstadoCuenta;
    }

    public EstadoCuenta(Integer idEstadoCuenta, String nombreEstadoCuenta) {
        this.idEstadoCuenta = idEstadoCuenta;
        this.nombreEstadoCuenta = nombreEstadoCuenta;
    }

    public Integer getIdEstadoCuenta() {
        return idEstadoCuenta;
    }

    public void setIdEstadoCuenta(Integer idEstadoCuenta) {
        this.idEstadoCuenta = idEstadoCuenta;
    }

    public String getNombreEstadoCuenta() {
        return nombreEstadoCuenta;
    }

    public void setNombreEstadoCuenta(String nombreEstadoCuenta) {
        this.nombreEstadoCuenta = nombreEstadoCuenta;
    }

    @XmlTransient
    public List<Historico> getHistoricoList() {
        return historicoList;
    }

    public void setHistoricoList(List<Historico> historicoList) {
        this.historicoList = historicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoCuenta != null ? idEstadoCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCuenta)) {
            return false;
        }
        EstadoCuenta other = (EstadoCuenta) object;
        if ((this.idEstadoCuenta == null && other.idEstadoCuenta != null) || (this.idEstadoCuenta != null && !this.idEstadoCuenta.equals(other.idEstadoCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.model.EstadoCuenta[ idEstadoCuenta=" + idEstadoCuenta + " ]";
    }
    
}
