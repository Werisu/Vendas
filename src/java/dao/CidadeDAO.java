/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import controle.Cidade;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import util.HibernateUtil;

/**
 *
 * @author Wellysson
 */
public class CidadeDAO {
    private Session session;
    private Transaction transaction;
    
    /**
     * Método SalvarCidade, vai cadastrar a cidade no banco de dados
     * @param cidade pega a cidade do bean
     */
    public void SalvarCidade(Cidade cidade){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(cidade);
            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("Erro na operação Salvar: "+e.getMessage());
        }finally{
            session.close();
        }
    }
    
    /**
     * Método Excluir, esse método deleta um cidade do banco de dados
     * @param cidade é a cidade que será excluída
     */
    public void EcluirCidade(Cidade cidade){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(cidade);
            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("Erro na operação Deletar: "+e.getMessage());
        }finally{
            session.close();
        }
    }
    
    /**
     * Método para atualizar dados no banco de dados
     * @param cidade que será atualizada
     */
    public void AtualizarCidade(Cidade cidade){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(cidade);
            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("Erro na operação Atualizar: "+e.getMessage());
        }finally{
            session.close();
        }
    }
    
    /**
     * Este método é para listar todas cidades do banco de dados
     * @return o resultado do query selects, irá retornar cada linha.
     */
    public List<Cidade> ListarCidade(){
        List<Cidade> resultado = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query selects = session.createQuery("From Cidade");
            resultado = selects.list();
            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("Erro na operação Listar: "+e.getMessage());
        }finally{
            session.close();
        }
        return resultado;
    }
}
