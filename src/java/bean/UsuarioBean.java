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
public class UsuarioBean {
    private Funcionario usuario = new Funcionario();
    private FuncionarioDAO fDao = new FuncionarioDAO(); // usuariocionario dao
    private CidadeDAO cidadeDao = new CidadeDAO(); // cidade dao
    private EstadoDAO estadoDao = new EstadoDAO(); // estado dao
    
    private List<Funcionario> listaFuncionario;
    private List<Cidade> listaCidade;
    private List<Estado> listaEstado;
    
    public Funcionario getFuncionario(){
        return usuario;
    }
    
    public List<Funcionario> getLista(){
        if(this.listaFuncionario == null)
            this.listaFuncionario = fDao.ListarFuncionario();
        return this.listaFuncionario;
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
        this.fDao.SalvarFuncionario(usuario);
        this.usuario = new Funcionario();
    }
    
    public void atualizar(){
        this.fDao.AtualizarFuncionario(usuario);
        this.usuario = new Funcionario();
    }
    
    public void excluir(Funcionario f){
        this.usuario = f;
        this.fDao.ExcluirFuncionario(f);
    }
    
    public String editar(Funcionario f){
        this.usuario = f;
        return "usuariocionario.xhtml";
    }
    
    public String reset() {
        this.usuario = new Funcionario();
        return "usuariocionario.xhtml";
    }
    
    public String logar(Funcionario f){
        Funcionario usuarioc = this.fDao.buscarFuncionario(f.getCpf());
        if(usuarioc == null){
            FacesContext ctx = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operação inválido", "Confirme a compra!");
            ctx.addMessage(null, msg);
            return "";
        }
        if(usuarioc.getSenha().equals(f.getSenha())){
            this.usuario = usuarioc;
            return "/index.xhtml?faces-redirect=true";
        }else{
            return "";
        }
    }
    
    public boolean isLogado(){
        if(this.usuario != null){
            if(!(this.usuario.getCpf() == null || this.usuario.getCpf().equals("")))
                return true;
        }
        return false;
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/pages/login.xhtml?faces-redirect=true";
    }
    
}
