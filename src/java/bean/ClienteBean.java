/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import controle.Cidade;
import controle.Cliente;
import controle.Estado;
import dao.CidadeDAO;
import dao.ClienteDAO;
import dao.EstadoDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Wellysson
 */
@ManagedBean
@SessionScoped
public class ClienteBean {
    private Cliente cliente =  new Cliente();
    
    private ClienteDAO clienteDao = new ClienteDAO();
    private CidadeDAO cidadeDao =  new CidadeDAO();
    private EstadoDAO estadoDao = new EstadoDAO();
    
    /*Listas*/
    private List<Cliente> listaCliente;
    private List<Cidade> listaCidade;
    private List<Estado> listaEstado;
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public List<Cliente> getLista(){
        if(this.listaCliente == null)
            this.listaCliente = clienteDao.ListarCliente();
        return this.listaCliente;
    }
    
    public List<Cidade> getCidades(){
        if(this.listaCidade == null)
            this.listaCidade = cidadeDao.ListarCidade();
        return this.listaCidade;
    }
    
    public List<Estado> getEstados(){
        if(this.listaEstado == null)
            this.listaEstado = estadoDao.ListarEstado();
        return this.listaEstado;
    }
    
    public void cadastro(){
        this.clienteDao.SalvarCliente(cliente);
        this.cliente =  new Cliente();
    }
    
    public void atualizar(){
        this.clienteDao.AtualizarCliente(cliente);
        this.cliente = new Cliente();
    }
    
    public void excluir(Cliente c){
        this.cliente = c;
        this.clienteDao.EcluirCliente(c);
    }
    
    public String editar(Cliente c){
        this.cliente = c;
        return "cliente.xhtml";
    }
    
    public String reset(){
        this.cliente = new Cliente();
        return "cliente.xhtml";
    }
}
