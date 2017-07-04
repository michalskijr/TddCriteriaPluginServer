package net.bhpachulski.tddcriteriaserver.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import net.bhpachulski.tddcriteriaserver.util.HibernateUtil;
import net.mjunior.model.ModCadProjeto;
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
    
    //o parametro precisa ser int
    public Object consultaUmParametro(
            Object object, String nomeAtributo, int id) {
        try {
            return (Object) getSession().createCriteria(
                    object.getClass())
                    .add(Restrictions.eq(nomeAtributo, id))
                    .uniqueResult();
        } finally {
            close();
        }
    }
    
    //os parametros precisam ser int e string
    public Object consultaDoisParametros(
            Object object, String nomeAtrInt, int num, 
            String nomeAtrString, String string) {
        try {
            return (Object) getSession().createCriteria(
                    object.getClass())
                    .add(Restrictions.eq(nomeAtrInt, num))
                    .add(Restrictions.like(nomeAtrString, string))
                    .uniqueResult();
        } finally {
            close();
        }
    }
    
    //os parametros precisam ser int e string
    public Object consultaTresParametros(
            Object object, String nomeAtrInt1, int num1,
            String nomeAtrInt2, int num2,
            String nomeAtrString, String string) {
        try {
            return (Object) getSession().createCriteria(
                    object.getClass())
                    .add(Restrictions.eq(nomeAtrInt1, num1))
                    .add(Restrictions.eq(nomeAtrInt2, num2))
                    .add(Restrictions.like(nomeAtrString, string))
                    .uniqueResult();
        } finally {
            close();
        }
    }
    
    //Pesquisar por data de determinado projeto execudado
    public Object consultaData(
            Object object, ModCadProjeto idProjeto, Date data) throws ParseException {
        
        Date data1 = new Date(data.getTime() + TimeUnit.SECONDS.toMillis(-2));
        System.out.println(data1);
        Date data2 = new Date(data.getTime() + TimeUnit.SECONDS.toMillis(2));
        System.out.println(data2);
        
        try {
            return (Object) getSession().createCriteria(
                    object.getClass())
                    .add(Restrictions.eq("projeto", idProjeto))
                    .add(Restrictions.between("dataHora", data1, data2))
                    .uniqueResult();
            
            
        } finally {
            close();
        }
    }
}