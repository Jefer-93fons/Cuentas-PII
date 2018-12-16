/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jefferson
 */
@Entity
@Table(name = "INTERES_PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InteresProducto.findAll", query = "SELECT i FROM InteresProducto i")
    , @NamedQuery(name = "InteresProducto.findByIdInteresProducto", query = "SELECT i FROM InteresProducto i WHERE i.idInteresProducto = :idInteresProducto")})
public class InteresProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INTERES_PRODUCTO")
    private Integer idInteresProducto;
    @JoinColumn(name = "ID_INTERES", referencedColumnName = "ID_INTERES")
    @ManyToOne
    private Interes idInteres;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne
    private Producto idProducto;

    public InteresProducto() {
    }

    public InteresProducto(Integer idInteresProducto) {
        this.idInteresProducto = idInteresProducto;
    }

    public Integer getIdInteresProducto() {
        return idInteresProducto;
    }

    public void setIdInteresProducto(Integer idInteresProducto) {
        this.idInteresProducto = idInteresProducto;
    }

    public Interes getIdInteres() {
        return idInteres;
    }

    public void setIdInteres(Interes idInteres) {
        this.idInteres = idInteres;
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
        hash += (idInteresProducto != null ? idInteresProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InteresProducto)) {
            return false;
        }
        InteresProducto other = (InteresProducto) object;
        if ((this.idInteresProducto == null && other.idInteresProducto != null) || (this.idInteresProducto != null && !this.idInteresProducto.equals(other.idInteresProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.model.InteresProducto[ idInteresProducto=" + idInteresProducto + " ]";
    }
    
}
