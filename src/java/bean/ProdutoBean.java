/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import controle.Produto;
import dao.ProdutoDAO;
import java.util.List;

/**
 *
 * @author Wellysson
 */
@ManagedBean
@SessionScoped
public class ProdutoBean {
    private Produto produtos = new Produto();
    private ProdutoDAO produtoDao = new ProdutoDAO();
    private List<Produto> listaProduto;
    
    public Produto getProduto(){
        return produtos;
    }
    
    public List<Produto> getLista(){
        if(this.listaProduto == null)
            this.listaProduto = produtoDao.ListarProduto();
        return this.listaProduto;
    }
    
    public void cadastro(){
        try {
            this.produtoDao.SalvarProduto(produtos);
            this.produtos = new Produto();
        } catch (Exception e) {
            System.out.println("Erro cadastro: "+e.getMessage());
        }
    }
    
    public void atualizar(){
        this.produtoDao.AtualizarProduto(produtos);
        this.produtos = new Produto();
    }
    
    public void excluir(Produto p){
        this.produtos = p;
        this.produtoDao.ExcluirProduto(p);
    }
    
    public String editar(Produto p){
        this.produtos = p;
        return "produto.xhtml";
    }
    
    public String reset() {
        this.produtos = new Produto();
        return "produto.xhtml";
    }
}
