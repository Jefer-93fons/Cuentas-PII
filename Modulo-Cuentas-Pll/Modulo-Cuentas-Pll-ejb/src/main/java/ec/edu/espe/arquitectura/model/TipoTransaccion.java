/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "TIPO_TRANSACCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTransaccion.findAll", query = "SELECT t FROM TipoTransaccion t")
    , @NamedQuery(name = "TipoTransaccion.findByIdTipoTransaccion", query = "SELECT t FROM TipoTransaccion t WHERE t.idTipoTransaccion = :idTipoTransaccion")
    , @NamedQuery(name = "TipoTransaccion.findByNombreTipoTransaccion", query = "SELECT t FROM TipoTransaccion t WHERE t.nombreTipoTransaccion = :nombreTipoTransaccion")
    , @NamedQuery(name = "TipoTransaccion.findByCargo", query = "SELECT t FROM TipoTransaccion t WHERE t.cargo = :cargo")})
public class TipoTransaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_TRANSACCION")
    private Integer idTipoTransaccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_TIPO_TRANSACCION")
    private String nombreTipoTransaccion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CARGO")
    private BigDecimal cargo;
    @OneToMany(mappedBy = "idTipoTransaccion")
    private List<Transaccion> transaccionList;

    public TipoTransaccion() {
    }

    public TipoTransaccion(Integer idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public TipoTransaccion(Integer idTipoTransaccion, String nombreTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
        this.nombreTipoTransaccion = nombreTipoTransaccion;
    }

    public Integer getIdTipoTransaccion() {
        return idTipoTransaccion;
    }

    public void setIdTipoTransaccion(Integer idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public String getNombreTipoTransaccion() {
        return nombreTipoTransaccion;
    }

    public void setNombreTipoTransaccion(String nombreTipoTransaccion) {
        this.nombreTipoTransaccion = nombreTipoTransaccion;
    }

    public BigDecimal getCargo() {
        return cargo;
    }

    public void setCargo(BigDecimal cargo) {
        this.cargo = cargo;
    }

    @XmlTransient
    public List<Transaccion> getTransaccionList() {
        return transaccionList;
    }

    public void setTransaccionList(List<Transaccion> transaccionList) {
        this.transaccionList = transaccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoTransaccion != null ? idTipoTransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTransaccion)) {
            return false;
        }
        TipoTransaccion other = (TipoTransaccion) object;
        if ((this.idTipoTransaccion == null && other.idTipoTransaccion != null) || (this.idTipoTransaccion != null && !this.idTipoTransaccion.equals(other.idTipoTransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.model.TipoTransaccion[ idTipoTransaccion=" + idTipoTransaccion + " ]";
    }
    
}
