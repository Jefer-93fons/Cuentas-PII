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
@Table(name = "HISTORICO_PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoricoProducto.findAll", query = "SELECT h FROM HistoricoProducto h")
    , @NamedQuery(name = "HistoricoProducto.findByIdHistoricoProducto", query = "SELECT h FROM HistoricoProducto h WHERE h.idHistoricoProducto = :idHistoricoProducto")
    , @NamedQuery(name = "HistoricoProducto.findByFechaVigencia", query = "SELECT h FROM HistoricoProducto h WHERE h.fechaVigencia = :fechaVigencia")})
public class HistoricoProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_HISTORICO_PRODUCTO")
    private Integer idHistoricoProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_VIGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVigencia;
    @JoinColumn(name = "ID_ESTADO_PRODUCTO", referencedColumnName = "ID_ESTADO_PRODUCTO")
    @ManyToOne
    private EstadoProducto idEstadoProducto;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne
    private Producto idProducto;

    public HistoricoProducto() {
    }

    public HistoricoProducto(Integer idHistoricoProducto) {
        this.idHistoricoProducto = idHistoricoProducto;
    }

    public HistoricoProducto(Integer idHistoricoProducto, Date fechaVigencia) {
        this.idHistoricoProducto = idHistoricoProducto;
        this.fechaVigencia = fechaVigencia;
    }

    public Integer getIdHistoricoProducto() {
        return idHistoricoProducto;
    }

    public void setIdHistoricoProducto(Integer idHistoricoProducto) {
        this.idHistoricoProducto = idHistoricoProducto;
    }

    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(Date fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public EstadoProducto getIdEstadoProducto() {
        return idEstadoProducto;
    }

    public void setIdEstadoProducto(EstadoProducto idEstadoProducto) {
        this.idEstadoProducto = idEstadoProducto;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistoricoProducto != null ? idHistoricoProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoProducto)) {
            return false;
        }
        HistoricoProducto other = (HistoricoProducto) object;
        if ((this.idHistoricoProducto == null && other.idHistoricoProducto != null) || (this.idHistoricoProducto != null && !this.idHistoricoProducto.equals(other.idHistoricoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.model.HistoricoProducto[ idHistoricoProducto=" + idHistoricoProducto + " ]";
    }
    
}
