/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controle.Venda;
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
public class VendaDAO {
    private Session session;
    private Transaction transaction;
    
    /**
     * Metodo para salvar venda no banco de dados
     * @param v pega a venda
     */
    public void SalvarVenda(Venda v){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(v);
            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("Erro na operação salvar: " +e.getMessage());
        }
        finally{
            session.close();
        }
    }
    
    public void ExcluirVenda(Venda v){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(v);
            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("Erro na operação Excluir: " +e.getMessage());
        }
        finally{
            session.close();
        }
    }
    
    public void AtualizarVenda(Venda v){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(v);
            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("Erro na operação atualizar: " +e.getMessage());
        }
        finally{
            session.close();
        }
    }
    
    public List<Venda> ListarVenda(){
         List<Venda> resultado = null;
         try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query selects = session.createQuery("From Venda");
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
