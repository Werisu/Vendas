/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import controle.Cliente;
import controle.Venda;
import dao.ClienteDAO;
import dao.VendaDAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Wellysson
 */
@ManagedBean
@SessionScoped
public class VendaBean implements Serializable{
    private Venda venda = new Venda();
    private VendaDAO vendaDao =  new VendaDAO();
    private ClienteDAO clienteDao = new ClienteDAO();
    
    private List<Venda> listaVenda;
    private List<Cliente> listaCliente;
    
    public Venda getVenda(){
        return venda;
    }
    
    public List<Venda> getLista(){
        if(this.listaVenda == null)
            this.listaVenda = vendaDao.ListarVenda();
        return this.listaVenda;
    }
    
    public List<Cliente> getClientes(){
        if(this.listaCliente == null)
            this.listaCliente = clienteDao.ListarCliente();
        return this.listaCliente;
    }
    
    public void confirmaVenda(){
        this.vendaDao.SalvarVenda(venda);
        this.venda = new Venda();
    }
    
    public void atualizar(){
        this.vendaDao.AtualizarVenda(venda);
        this.venda = new Venda();
    }
    
    public void excluir(Venda venda){
        this.venda = venda;
        this.vendaDao.ExcluirVenda(venda);
    }
    
    public String editar(Venda venda){
        this.venda = venda;
        return "venda.xhtml";
    }
}
