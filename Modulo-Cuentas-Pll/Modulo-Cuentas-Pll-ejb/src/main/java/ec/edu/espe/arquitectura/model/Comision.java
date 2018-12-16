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
@Table(name = "COMISION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comision.findAll", query = "SELECT c FROM Comision c")
    , @NamedQuery(name = "Comision.findByIdComision", query = "SELECT c FROM Comision c WHERE c.idComision = :idComision")
    , @NamedQuery(name = "Comision.findByRazonComision", query = "SELECT c FROM Comision c WHERE c.razonComision = :razonComision")})
public class Comision implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COMISION")
    private Integer idComision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "RAZON_COMISION")
    private String razonComision;
    @OneToMany(mappedBy = "idComision")
    private List<ComisionProducto> comisionProductoList;

    public Comision() {
    }

    public Comision(Integer idComision) {
        this.idComision = idComision;
    }

    public Comision(Integer idComision, String razonComision) {
        this.idComision = idComision;
        this.razonComision = razonComision;
    }

    public Integer getIdComision() {
        return idComision;
    }

    public void setIdComision(Integer idComision) {
        this.idComision = idComision;
    }

    public String getRazonComision() {
        return razonComision;
    }

    public void setRazonComision(String razonComision) {
        this.razonComision = razonComision;
    }

    @XmlTransient
    public List<ComisionProducto> getComisionProductoList() {
        return comisionProductoList;
    }

    public void setComisionProductoList(List<ComisionProducto> comisionProductoList) {
        this.comisionProductoList = comisionProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComision != null ? idComision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comision)) {
            return false;
        }
        Comision other = (Comision) object;
        if ((this.idComision == null && other.idComision != null) || (this.idComision != null && !this.idComision.equals(other.idComision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.model.Comision[ idComision=" + idComision + " ]";
    }
    
}
