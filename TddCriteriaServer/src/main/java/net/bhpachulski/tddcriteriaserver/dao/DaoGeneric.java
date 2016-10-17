package net.bhpachulski.tddcriteriaserver.dao;

import java.util.List;
import net.bhpachulski.tddcriteriaserver.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DaoGeneric<Object> {
    
    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session sessao = sf.openSession();

    public DaoGeneric() {
        
    }
    
    public List consultaGeral(Object object) {
        sessao.beginTransaction();
        
        Query consulta = sessao.createQuery("FROM " + object.getClass().getName());
        List<Object> objects = consulta.list();
        
        sessao.getTransaction().commit();
        //sessao.close();
        
        return objects;
    }
    
    public Boolean update(Object object) {
        sessao.beginTransaction();
        
        try {
            sessao.update(object);
            sessao.getTransaction().commit();
            sessao.close();
                    
            return true;
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            
            return false;
        }
    }
    
    public Boolean excluir(Object object) {
        sessao.beginTransaction();
        
        try {
            sessao.delete(object);
            sessao.getTransaction().commit();
            sessao.close();
            
            return true;
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            
            return false;
        }
    }
    
    public Boolean salvar(Object object) {
        sessao.beginTransaction();
        
        try {
            sessao.save(object);
            sessao.getTransaction().commit();
            //sessao.close();
                    
            return true;
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            
            return false;
        }
    }
}