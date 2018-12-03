/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import controle.Cidade;
import controle.Fornecedor;
import dao.CidadeDAO;
import dao.FornecedorDAO;
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
public class FornecedorBean implements Serializable {
    private Fornecedor fornecedores = new Fornecedor();
    private FornecedorDAO fornecedorDao = new FornecedorDAO();
    private CidadeDAO cidadeDao = new CidadeDAO();
    
    private List<Fornecedor> listaFornecedor;
    private List<Cidade> listaCidade;
    
    public Fornecedor getFornecedor(){
        return fornecedores;
    }
    
    public List<Fornecedor> getLista(){
        if(this.listaFornecedor == null)
            this.listaFornecedor = fornecedorDao.ListarFornecedor();
        return this.listaFornecedor;
    }
    
    public List<Cidade> getCidades(){
        if(this.listaCidade == null)
            this.listaCidade = cidadeDao.ListarCidade();
        return this.listaCidade;
    }
    
    public void cadastro(){
        this.fornecedorDao.SalvarCliente(fornecedores);
        this.fornecedores = new Fornecedor();
    }
    
    public void atualizar(){
        this.fornecedorDao.AtualizarCliente(fornecedores);
        this.fornecedores = new Fornecedor();
    }
    
    public void excluir(Fornecedor f){
        this.fornecedores = f;
        this.fornecedorDao.EcluirCliente(f);
    }
    
    public String editar(Fornecedor f){
        this.fornecedores = f;
        return "fornecedores.xhtml";
    }
    
    public String reset(){
        this.fornecedores = new Fornecedor();
        return "fornecedores.xhtml";
    }
}
