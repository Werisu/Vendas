/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import controle.Itemvenda;
import controle.Produto;
import controle.Venda;
import dao.ItemVendaDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Wellysson
 */
@ManagedBean
@SessionScoped
public class ItemVendaBean implements Serializable{
    private Itemvenda itemVenda = new Itemvenda();
    
    private ItemVendaDAO itemVendaDao = new ItemVendaDAO();
    private VendaDAO vendaDao = new VendaDAO();
    private ProdutoDAO produtoDao = new ProdutoDAO();
    
    private List<Itemvenda> listaItemVenda;
    private List<Venda> listaVenda;
    private List<Produto> listaProduto;
    
    public Itemvenda getItemVenda(){
        return itemVenda;
    }
    
    public List<Itemvenda> getLista(){
        if(this.listaItemVenda == null)
            this.listaItemVenda = itemVendaDao.ListarItemVenda();
        return this.listaItemVenda;
    }
    
    public List<Venda> getVendas(){
        if(this.listaVenda == null)
            this.listaVenda = this.vendaDao.ListarVenda();
        return this.listaVenda;
    }
    
    public List<Produto> getProdutos(){
        if(this.listaProduto == null)
            this.listaProduto = produtoDao.ListarProduto();
        return this.listaProduto;
    }
    
    public void cadastro(){
        this.itemVendaDao.SalvarItemvenda(itemVenda);
        this.itemVenda = new Itemvenda();
    }
    
    public void atualizar(){
        this.itemVendaDao.AtualizarItemvenda(itemVenda);
        this.itemVenda = new Itemvenda();
    }
    
    public void excluir(Itemvenda iv){
        this.itemVenda = iv;
        this.itemVendaDao.ExcluirItemvenda(iv);
    }
    
    public String editar(Itemvenda iv){
        this.itemVenda = iv;
        return "venda.xhtml";
    }
    
    public String buscarProduto(Produto p) {
        this.itemVenda.setValorItem(p.getValorVenda());

        FacesContext ctx = FacesContext.getCurrentInstance();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação inválido", p.getDescricao() + " selecionado");
        ctx.addMessage(null, msg);
        return "venda.xhtml";
    }
}
