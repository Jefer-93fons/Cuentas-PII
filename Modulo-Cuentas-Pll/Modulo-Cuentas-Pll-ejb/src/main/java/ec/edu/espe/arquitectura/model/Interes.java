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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jefferson
 */
@Entity
@Table(name = "INTERES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Interes.findAll", query = "SELECT i FROM Interes i")
    , @NamedQuery(name = "Interes.findByIdInteres", query = "SELECT i FROM Interes i WHERE i.idInteres = :idInteres")
    , @NamedQuery(name = "Interes.findByPorcentajeInteres", query = "SELECT i FROM Interes i WHERE i.porcentajeInteres = :porcentajeInteres")
    , @NamedQuery(name = "Interes.findByValorMin", query = "SELECT i FROM Interes i WHERE i.valorMin = :valorMin")
    , @NamedQuery(name = "Interes.findByValorMax", query = "SELECT i FROM Interes i WHERE i.valorMax = :valorMax")})
public class Interes implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INTERES")
    private Integer idInteres;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PORCENTAJE_INTERES")
    private BigDecimal porcentajeInteres;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_MIN")
    private BigDecimal valorMin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_MAX")
    private BigDecimal valorMax;
    @JoinColumn(name = "ID_PERIODO", referencedColumnName = "ID_PERIODO")
    @ManyToOne
    private Periodo idPeriodo;
    @OneToMany(mappedBy = "idInteres")
    private List<InteresProducto> interesProductoList;

    public Interes() {
    }

    public Interes(Integer idInteres) {
        this.idInteres = idInteres;
    }

    public Interes(Integer idInteres, BigDecimal porcentajeInteres, BigDecimal valorMin, BigDecimal valorMax) {
        this.idInteres = idInteres;
        this.porcentajeInteres = porcentajeInteres;
        this.valorMin = valorMin;
        this.valorMax = valorMax;
    }

    public Integer getIdInteres() {
        return idInteres;
    }

    public void setIdInteres(Integer idInteres) {
        this.idInteres = idInteres;
    }

    public BigDecimal getPorcentajeInteres() {
        return porcentajeInteres;
    }

    public void setPorcentajeInteres(BigDecimal porcentajeInteres) {
        this.porcentajeInteres = porcentajeInteres;
    }

    public BigDecimal getValorMin() {
        return valorMin;
    }

    public void setValorMin(BigDecimal valorMin) {
        this.valorMin = valorMin;
    }

    public BigDecimal getValorMax() {
        return valorMax;
    }

    public void setValorMax(BigDecimal valorMax) {
        this.valorMax = valorMax;
    }

    public Periodo getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Periodo idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    @XmlTransient
    public List<InteresProducto> getInteresProductoList() {
        return interesProductoList;
    }

    public void setInteresProductoList(List<InteresProducto> interesProductoList) {
        this.interesProductoList = interesProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInteres != null ? idInteres.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interes)) {
            return false;
        }
        Interes other = (Interes) object;
        if ((this.idInteres == null && other.idInteres != null) || (this.idInteres != null && !this.idInteres.equals(other.idInteres))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.model.Interes[ idInteres=" + idInteres + " ]";
    }
    
}
