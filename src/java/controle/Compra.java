/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wellysson
 */
@Entity
@Table(name = "compra")
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRegistro;
    private BigDecimal valorTotalCompra;
    @JoinColumn(name = "fornecedor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Fornecedor fornecedorId;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compraId")
//    private Collection<Itemcompra> itemcompraCollection;

    public Compra() {
        
    }

    public Compra(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorTotalCompra() {
        return valorTotalCompra;
    }

    public void setValorTotalCompra(BigDecimal valorTotalCompra) {
        this.valorTotalCompra = valorTotalCompra;
    }

    public Fornecedor getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(Fornecedor fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
//    @XmlTransient
//    public Collection<Itemcompra> getItemcompraCollection() {
//        return itemcompraCollection;
//    }
//
//    public void setItemcompraCollection(Collection<Itemcompra> itemcompraCollection) {
//        this.itemcompraCollection = itemcompraCollection;
//    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Compra)) {
//            return false;
//        }
//        Compra other = (Compra) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "controle.Compra[ id=" + id + " ]";
//    }
    
}
