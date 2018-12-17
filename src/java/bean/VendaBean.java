/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import controle.Cliente;
import controle.Itemvenda;
import controle.Produto;
import controle.Venda;
import dao.ClienteDAO;
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
public class VendaBean implements Serializable{
    private Venda venda = new Venda();
    private Itemvenda itemVenda = new Itemvenda();
    
    private VendaDAO vendaDao =  new VendaDAO();
    private ItemVendaDAO itemVendaDao = new ItemVendaDAO();
    private ClienteDAO clienteDao = new ClienteDAO();
    private ProdutoDAO produtoDao = new ProdutoDAO();
    
    private List<Venda> listaVenda;
    private List<Cliente> listaCliente;
    private List<Itemvenda> listaItemVenda;
    private List<Produto> listaProduto;
    
    Boolean vendaConfirmada = false;
    Venda x = null;

    public VendaBean() {
        BuscarID();
        this.venda.setId(x.getId()+1);
    }
    
    public void BuscarID(){
        for(int i = 0; i<=this.getLista().size()-1; i++){
            this.x = getLista().get(i);
        }
    }
    
    public void AtualizaID(){
        itemVenda.setVendaId(x);
    }
    
    public Venda getVenda(){
        return venda;
    }
    
    public Itemvenda getItemVenda(){
        return itemVenda;
    }
    
    public List<Venda> getLista(){
        if(this.listaVenda == null)
            this.listaVenda = vendaDao.ListarVenda();
        return this.listaVenda;
    }
    
    public List<Itemvenda> getListaItemVenda(){
        if(this.listaItemVenda == null)
            this.listaItemVenda = itemVendaDao.ListarItemVenda();
        return this.listaItemVenda;
    }
    
    public List<Cliente> getClientes(){
        if(this.listaCliente == null)
            this.listaCliente = clienteDao.ListarCliente();
        return this.listaCliente;
    }
    
    public List<Produto> getProdutos(){
        if(this.listaProduto == null)
            this.listaProduto = produtoDao.ListarProduto();
        return this.listaProduto;
    }
    
    public String confirmaVenda() {
        if (this.vendaConfirmada == false) {
            this.vendaDao.SalvarVenda(venda);
            this.venda = new Venda();
            this.vendaConfirmada = true;
            FacesContext ctx = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Venda Confirmada", "Salve a operação!");
            ctx.addMessage(null, msg);
            BuscarID();
            AtualizaID();
            return "venda.xhtml";
        } else {
            FacesContext ctx = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operação inválido", "Compra já confirmada!");
            ctx.addMessage(null, msg);
            return null;
        }
    }
    
    public void cadastro(){
        if (vendaConfirmada) {
            BuscarID();
            AtualizaID();
            this.itemVendaDao.SalvarItemvenda(itemVenda);
            this.itemVenda = new Itemvenda();
            this.vendaConfirmada = false;
            FacesContext ctx = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrado", "Venda Realizada com Sucesso!");
            ctx.addMessage(null, msg);
        } else {
            FacesContext ctx = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operação inválido", "Confirme a venda!");
            ctx.addMessage(null, msg);
        }
    }
    
    public void atualizar(){
        this.vendaDao.AtualizarVenda(venda);
        this.itemVendaDao.AtualizarItemvenda(itemVenda);
        this.venda = new Venda();
        this.itemVenda = new Itemvenda();
    }
    
    public void excluir(Venda venda, Itemvenda iv){
        this.venda = venda;
        this.itemVenda = iv;
        this.vendaDao.ExcluirVenda(venda);
        this.itemVendaDao.ExcluirItemvenda(iv);
    }
    
    public String editar(Venda venda,Itemvenda iv){
        this.venda = venda;
        this.itemVenda = iv;
        return "venda.xhtml";
    }
}
