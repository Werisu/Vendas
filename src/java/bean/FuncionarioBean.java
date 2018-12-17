/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import controle.Cidade;
import controle.Estado;
import controle.Funcionario;
import dao.CidadeDAO;
import dao.EstadoDAO;
import dao.FuncionarioDAO;
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
public class FuncionarioBean implements Serializable {
    private Funcionario fun = new Funcionario();
    private FuncionarioDAO funDao = new FuncionarioDAO(); // funcionario dao
    private CidadeDAO cidDao = new CidadeDAO(); // cidade dao
    private EstadoDAO estDao = new EstadoDAO(); // estado dao
    
    private List<Funcionario> listaFuncionario;
    private List<Cidade> listaCidade;
    private List<Estado> listaEstado;
    
    public Funcionario getFuncionario(){
        return fun;
    }
    
    public List<Funcionario> getLista(){
        if(this.listaFuncionario == null)
            this.listaFuncionario = funDao.ListarFuncionario();
        return this.listaFuncionario;
    }
    
    public List<Cidade> getCidades(){
        if(this.listaCidade == null)
            this.listaCidade = cidDao.ListarCidade();
        return this.listaCidade;
    }
    
    public List<Estado> getEstados(){
        if(this.listaEstado == null)
            this.listaEstado = estDao.ListarEstado();
        return this.listaEstado;
    }
    
    public void cadastro(){
        this.funDao.SalvarFuncionario(fun);
        this.fun = new Funcionario();
    }
    
    public void atualizar(){
        this.funDao.AtualizarFuncionario(fun);
        this.fun = new Funcionario();
    }
    
    public void excluir(Funcionario f){
        this.fun = f;
        this.funDao.ExcluirFuncionario(f);
    }
    
    public String editar(Funcionario f){
        this.fun = f;
        return "funcionario.xhtml";
    }
    
    public String reset() {
        this.fun = new Funcionario();
        return "funcionario.xhtml";
    }
    
    public String logar(Funcionario f){
        Funcionario func = this.funDao.buscarFuncionario(f.getCpf());
        if(func == null){
            FacesContext ctx = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operação inválido", "Confirme a compra!");
            ctx.addMessage(null, msg);
            return "";
        }
        if(func.getSenha().equals(f.getSenha())){
            this.fun = func;
            return "/index.xhtml?faces-redirect=true";
        }else{
            return "";
        }
    }
    
    public boolean isLogado(){
        if(this.fun != null){
            if(!(this.fun.getCpf() == null || this.fun.getCpf().equals("")))
                return true;
        }
        return false;
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/pages/login.xhtml?faces-redirect=true";
    }
}
