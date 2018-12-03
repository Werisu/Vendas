/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import controle.Cidade;
import controle.Estado;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import dao.CidadeDAO;
import dao.EstadoDAO;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Wellysson
 */
@ManagedBean
@SessionScoped
public class CidadeBean implements Serializable{
    private Cidade cidades = new Cidade();
    private CidadeDAO cidadeDao = new CidadeDAO();
    private EstadoDAO estadoDao = new EstadoDAO();
    
    private List<Cidade> listaCidade;
    private List<Estado> listaEstados;
    
    public Cidade getCidade(){
        return cidades;
    }
    
    public List<Cidade> getLista(){
        if(this.listaCidade == null)
            this.listaCidade = cidadeDao.ListarCidade();
        return this.listaCidade;
    }
    
    public List<Estado> getEstados(){
        if(this.listaEstados == null)
            this.listaEstados = estadoDao.ListarEstado();
        return this.listaEstados;
    }
    
    public void cadastro(){
        this.cidadeDao.SalvarCidade(cidades);
        this.cidades = new Cidade();
    }
    
    public void atualizar(){
        this.cidadeDao.AtualizarCidade(cidades);
        this.cidades = new Cidade();
    }
    
    public void excluir(Cidade cidade){
        this.cidades = cidade;
        this.cidadeDao.EcluirCidade(cidade);
    }
    
    public String editar(Cidade cidade){
        this.cidades = cidade;
        return "cidade.xhtml";
    }
}
