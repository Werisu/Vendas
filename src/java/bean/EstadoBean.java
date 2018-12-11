/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import controle.Estado;
import dao.EstadoDAO;
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
public class EstadoBean implements Serializable {
    private Estado estados = new Estado();
    private EstadoDAO estadoDao = new EstadoDAO();
    private List<Estado> listaEstado;
    
    public Estado getEstado(){
        return estados;
    }
    
    public List<Estado> getLista(){
        if(this.listaEstado == null)
            this.listaEstado = estadoDao.ListarEstado();
        return this.listaEstado;
    }
    
    public void cadastro(){
        try {
            this.estadoDao.SalvarEstado(estados);
            this.estados = new Estado();
        } catch (NullPointerException e) {
            System.out.println("erro cadastro: " +e.getMessage());
        }
        
    }
    
    public void atualizar(){
        this.estadoDao.AtualizarEstado(estados);
        this.estados = new Estado();
    }
    
    public void excluir(Estado t){
        this.estados = t;
        this.estadoDao.ExcluirEstado(t);
    }
    
    public String editar(Estado t){
        this.estados = t;
        return "estado.xhtml";
    }
}
