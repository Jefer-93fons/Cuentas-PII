/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "COMISION_PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComisionProducto.findAll", query = "SELECT c FROM ComisionProducto c")
    , @NamedQuery(name = "ComisionProducto.findByIdComisionProducto", query = "SELECT c FROM ComisionProducto c WHERE c.idComisionProducto = :idComisionProducto")
    , @NamedQuery(name = "ComisionProducto.findByValorComisionProducto", query = "SELECT c FROM ComisionProducto c WHERE c.valorComisionProducto = :valorComisionProducto")})
public class ComisionProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COMISION_PRODUCTO")
    private Integer idComisionProducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR_COMISION_PRODUCTO")
    private BigDecimal valorComisionProducto;
    @JoinColumn(name = "ID_COMISION", referencedColumnName = "ID_COMISION")
    @ManyToOne
    private Comision idComision;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne
    private Producto idProducto;

    public ComisionProducto() {
    }

    public ComisionProducto(Integer idComisionProducto) {
        this.idComisionProducto = idComisionProducto;
    }

    public Integer getIdComisionProducto() {
        return idComisionProducto;
    }

    public void setIdComisionProducto(Integer idComisionProducto) {
        this.idComisionProducto = idComisionProducto;
    }

    public BigDecimal getValorComisionProducto() {
        return valorComisionProducto;
    }

    public void setValorComisionProducto(BigDecimal valorComisionProducto) {
        this.valorComisionProducto = valorComisionProducto;
    }

    public Comision getIdComision() {
        return idComision;
    }

    public void setIdComision(Comision idComision) {
        this.idComision = idComision;
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
        hash += (idComisionProducto != null ? idComisionProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComisionProducto)) {
            return false;
        }
        ComisionProducto other = (ComisionProducto) object;
        if ((this.idComisionProducto == null && other.idComisionProducto != null) || (this.idComisionProducto != null && !this.idComisionProducto.equals(other.idComisionProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.model.ComisionProducto[ idComisionProducto=" + idComisionProducto + " ]";
    }
    
}
