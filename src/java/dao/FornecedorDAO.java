/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controle.Fornecedor;
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
public class FornecedorDAO {
    private Session session;
    private Transaction transaction;
    
    public void SalvarCliente(Fornecedor f){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(f);
            transaction.commit();
        } catch (HibernateException ex) {
            System.err.println("Erro na operação Salvar: " +ex.getMessage());
        }finally{
            session.close();
        }
    }
    
    public void EcluirCliente(Fornecedor f){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(f);
            transaction.commit();
        } catch (HibernateException ex) {
            System.err.println("Erro na operação Excluir: " +ex.getMessage());
        }finally{
            session.close();
        }
    }
    
    public void AtualizarCliente(Fornecedor f){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(f);
            transaction.commit();
        } catch (HibernateException ex) {
            System.err.println("Erro na operação Atualizar: " +ex.getMessage());
        }finally{
            session.close();
        }
    }
    
    public List<Fornecedor> ListarFornecedor(){
        List<Fornecedor> resultado = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query selects = session.createQuery("From Fornecedor");
            resultado = selects.list();
            transaction.commit();
        } catch (HibernateException e) {
        }finally{
            session.close();
        }
        return resultado;
    }
}
