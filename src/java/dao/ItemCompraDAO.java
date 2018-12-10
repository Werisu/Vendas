/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controle.Itemcompra;
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
public class ItemCompraDAO {
    private Session session;
    private Transaction transaction;
    
    public void SalvarItemCompra(Itemcompra c){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(c);
            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("Erro na operação salvar: " +e.getMessage());
        }
        finally{
            session.close();
        }
    }
    
    public void EcluirItemCompra(Itemcompra c){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(c);
            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("Erro na operação deletar: " +e.getMessage());
        }
        finally{
            session.close();
        }
    }
    
    public void AtualizarItemCompra(Itemcompra c){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(c);
            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("Erro na operação Atualizar: " +e.getMessage());
        }
        finally{
            session.close();
        }
    }
    
    public List<Itemcompra> ListarItemCompra(){
         List<Itemcompra> resultado = null;
         try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query selects = session.createQuery("From Itemcompra");
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
