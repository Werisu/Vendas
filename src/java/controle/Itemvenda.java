/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wellysson
 */
@Entity
@Table(name = "itemvenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemvenda.findAll", query = "SELECT i FROM Itemvenda i")
    , @NamedQuery(name = "Itemvenda.findById", query = "SELECT i FROM Itemvenda i WHERE i.id = :id")
    , @NamedQuery(name = "Itemvenda.findByQtdItem", query = "SELECT i FROM Itemvenda i WHERE i.qtdItem = :qtdItem")
    , @NamedQuery(name = "Itemvenda.findByValorItem", query = "SELECT i FROM Itemvenda i WHERE i.valorItem = :valorItem")})
public class Itemvenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer qtdItem;
    private BigDecimal valorItem;
    @JoinColumn(name = "produto_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Produto produtoId;
    @JoinColumn(name = "venda_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Venda vendaId;

    public Itemvenda() {
    }

    public Itemvenda(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQtdItem() {
        return qtdItem;
    }

    public void setQtdItem(Integer qtdItem) {
        this.qtdItem = qtdItem;
    }

    public BigDecimal getValorItem() {
        return valorItem;
    }

    public void setValorItem(BigDecimal valorItem) {
        this.valorItem = valorItem;
    }

    public Produto getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produto produtoId) {
        this.produtoId = produtoId;
    }

    public Venda getVendaId() {
        return vendaId;
    }

    public void setVendaId(Venda vendaId) {
        this.vendaId = vendaId;
    }
}
