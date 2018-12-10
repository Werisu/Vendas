/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controle.Produto;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Wellysson
 */
public class ProdutoDAO {
    private Session session;
    private Transaction transaction;
    
    public void SalvarProduto(Produto p){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(p);
            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("Erro na operação salvar: " +e.getMessage());
        }
        finally{
            session.close();
        }
    }
    
    public void ExcluirProduto(Produto t){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(t);
            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("Erro na operação Excluir: " +e.getMessage());
        }finally{
            session.close();
        }
    }
    
    public void AtualizarProduto(Produto t){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(t);
            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("Erro na operação Atualizar: " +e.getMessage());
        }finally{
            session.close();
        }
    }
    
    public List<Produto> ListarProduto(){
         List<Produto> resultado = null;
         try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query selects = session.createQuery("From Produto");
            resultado = selects.list();
            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("Erro na operação listar: " +e.getMessage());
        }finally{
             session.close();
         }
         return resultado;
    }
}
