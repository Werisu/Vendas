/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import controle.Funcionario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import util.HibernateUtil;

/**
 *
 * @author Wellysson
 */
public class FuncionarioDAO {
    private Session session;
    private Transaction transaction;
    //private EntityManagerFactory factory = Persistence.createEntityManagerFactory("funcionario");
    //private EntityManager em = factory.createEntityManager();
    
    public void SalvarFuncionario(Funcionario f){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(f);
            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("Erro na operacao Salvar: " +e.getMessage());
        }finally{
            session.close();
        }
    }
    
    public void ExcluirFuncionario(Funcionario f){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(f);
            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("Erro na operacao Deletar: " +e.getMessage());
        }finally{
            session.close();
        }
    }
    
    public void AtualizarFuncionario(Funcionario f){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(f);
            transaction.commit();
        } catch (HibernateException e) {
            System.err.println("Erro na operacao Atualizar: " +e.getMessage());
        }finally{
            session.close();
        }
    }
    
    public List<Funcionario> ListarFuncionario(){
        List<Funcionario> resultado = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query selects = session.createQuery("From Funcionario");
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
