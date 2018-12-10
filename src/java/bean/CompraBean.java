/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import controle.Compra;
import controle.Fornecedor;
import controle.Itemcompra;
import controle.Produto;
import dao.CompraDAO;
import dao.FornecedorDAO;
import dao.ItemCompraDAO;
import dao.ProdutoDAO;
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
public class CompraBean {
    private Compra compras = new Compra();
    private Itemcompra itemcompras = new Itemcompra();
    private CompraDAO compraDao = new CompraDAO();
    private ItemCompraDAO itemcompraDao = new ItemCompraDAO();
    private ProdutoDAO produtoDao = new ProdutoDAO();
    private FornecedorDAO fornecedorDao = new FornecedorDAO();
    
    private List<Compra> listaCompra;
    private List<Itemcompra> listaItens;
    private List<Fornecedor> listaFornecedor;
    private List<Produto> listaProduto;

    Boolean compraConfirmada = false;
    Compra x = null;
    
    public void BuscarID(){
        for(int i=0; i<=this.getLista().size()-1; i++){
            this.x = getLista().get(i);
        }
    }
    
    public void AtualizaID(){
        itemcompras.setCompraId(x);
    }
    
    public Compra getCompra(){
        return compras;
    }
    
    public Itemcompra getItem(){
        return itemcompras;
    }
    
    public List<Compra> getLista(){
        if(this.listaCompra == null)
            this.listaCompra = compraDao.ListarCompra();
        return this.listaCompra;
    }
    
    public List<Itemcompra> getItens(){
        if(this.listaItens == null)
            this.listaItens = itemcompraDao.ListarItemCompra();
        return this.listaItens;
    }
    
    public List<Produto> getProdutos(){
        if(this.listaProduto == null)
            this.listaProduto = this.produtoDao.ListarProduto();
        return this.listaProduto;
    }
    
    public List<Fornecedor> getFornecedores(){
        if(this.listaFornecedor == null)
            this.listaFornecedor = fornecedorDao.ListarFornecedor();
        return this.listaFornecedor;
    }
    
    public String confirmarCompra(){
        if(this.compraConfirmada == false){
            this.compraDao.SalvarCompra(compras);
            this.compras = new Compra();
            this.compraConfirmada = true;
            FacesContext ctx = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Compra Confirmada", "Salve a operação!");
            ctx.addMessage(null, msg);
            return "compra.xhtml";
        }else{
            FacesContext ctx = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operação inválido", "Compra já confirmada!");
            ctx.addMessage(null, msg);
            return null;
        }
    }
    
    public void cadastro(){
        if(this.compraConfirmada == true){
            BuscarID();
            AtualizaID();
            this.itemcompraDao.SalvarItemCompra(itemcompras);
            this.itemcompras = new Itemcompra();
            compraConfirmada = false;
            FacesContext ctx = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação inválido", "Compra Realizada com Sucesso!");
            ctx.addMessage(null, msg);
        }else{
            FacesContext ctx = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operação inválido", "Confirme a compra!");
            ctx.addMessage(null, msg);
        }
    }
    
    public void atualizar(){
        this.compraDao.AtualizarCompra(compras);
        this.compras = new Compra();
        this.itemcompraDao.AtualizarItemCompra(itemcompras);
        this.itemcompras = new Itemcompra();
    }
    
    public void excluir(Compra c, Itemcompra i){
        this.compras = c;
        this.compraDao.EcluirCompra(c);
        this.itemcompras = i;
        this.itemcompraDao.EcluirItemCompra(i);
    }
    
    public String editar(Compra c, Itemcompra i){
        this.compras = c;
        this.itemcompras = i;
        return "compra.xhtml";
    }
    
    public String reset(){
        this.compras = new Compra();
        this.itemcompras = new Itemcompra();
        return "compra.xhtml";
    }
}
