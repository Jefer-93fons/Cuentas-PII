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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "HISTORICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historico.findAll", query = "SELECT h FROM Historico h")
    , @NamedQuery(name = "Historico.findByIdHistorico", query = "SELECT h FROM Historico h WHERE h.idHistorico = :idHistorico")
    , @NamedQuery(name = "Historico.findByFechaHistorico", query = "SELECT h FROM Historico h WHERE h.fechaHistorico = :fechaHistorico")})
public class Historico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_HISTORICO")
    private Integer idHistorico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_HISTORICO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHistorico;
    @JoinColumn(name = "ID_CUENTA", referencedColumnName = "ID_CUENTA")
    @ManyToOne
    private Cuenta idCuenta;
    @JoinColumn(name = "ID_ESTADO_CUENTA", referencedColumnName = "ID_ESTADO_CUENTA")
    @ManyToOne
    private EstadoCuenta idEstadoCuenta;

    public Historico() {
    }

    public Historico(Integer idHistorico) {
        this.idHistorico = idHistorico;
    }

    public Historico(Integer idHistorico, Date fechaHistorico) {
        this.idHistorico = idHistorico;
        this.fechaHistorico = fechaHistorico;
    }

    public Integer getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(Integer idHistorico) {
        this.idHistorico = idHistorico;
    }

    public Date getFechaHistorico() {
        return fechaHistorico;
    }

    public void setFechaHistorico(Date fechaHistorico) {
        this.fechaHistorico = fechaHistorico;
    }

    public Cuenta getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Cuenta idCuenta) {
        this.idCuenta = idCuenta;
    }

    public EstadoCuenta getIdEstadoCuenta() {
        return idEstadoCuenta;
    }

    public void setIdEstadoCuenta(EstadoCuenta idEstadoCuenta) {
        this.idEstadoCuenta = idEstadoCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistorico != null ? idHistorico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historico)) {
            return false;
        }
        Historico other = (Historico) object;
        if ((this.idHistorico == null && other.idHistorico != null) || (this.idHistorico != null && !this.idHistorico.equals(other.idHistorico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.model.Historico[ idHistorico=" + idHistorico + " ]";
    }
    
}
