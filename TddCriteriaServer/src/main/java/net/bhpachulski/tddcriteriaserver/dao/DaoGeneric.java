package net.bhpachulski.tddcriteriaserver.dao;

import java.sql.SQLException;
import java.util.List;
import net.bhpachulski.tddcriteriaserver.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class DaoGeneric<Object> extends HibernateUtil {
    
    private final SessionFactory sf = HibernateUtil.getSessionFactory();
    Session sessao = sf.openSession();

    public DaoGeneric() throws SQLException {

    }
    
    public void init() throws SQLException {
        
    }
    
    public Boolean salvar(Object object) {
        sessao.beginTransaction();
        
        try {
            sessao.save(object);
            sessao.getTransaction().commit();
            sessao.close();
                    
            return true;
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            
            return false;
        }
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
    
    public List consultaGeral(Object object) {
        try {
            return getSession().createCriteria(object.getClass()).list();
        } finally {
            close();
        }
    }
    
    public Object consultaPorId(Object object, int id) {
        try {
            return (Object) getSession().createCriteria(object.getClass())
                    .add(Restrictions.idEq(id)).uniqueResult();
        } finally {
            close();
        }
    }
}