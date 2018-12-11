/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controle.Cliente;
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
public class ClienteDAO {
    private Session session;
    private Transaction transaction;
    
    public void SalvarCliente(Cliente c){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(c);
            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("Erro na operação Salvar: "+e.getMessage());
        }finally{
            session.close();
        }
    }
    
    public void EcluirCliente(Cliente c){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(c);
            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("Erro na operação Deleter: "+e.getMessage());
        }finally{
            session.close();
        }
    }
    
    public void AtualizarCliente(Cliente c){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(c);
            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("Erro na operação Atualizar: "+e.getMessage());
        }finally{
            session.close();
        }
    }
    
    public List<Cliente> ListarCliente(){
        List<Cliente> resultado = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query selects = session.createQuery("From Cliente");
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
