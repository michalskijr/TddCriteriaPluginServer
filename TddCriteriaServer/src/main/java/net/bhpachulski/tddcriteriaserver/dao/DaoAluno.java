package net.bhpachulski.tddcriteriaserver.dao;

import java.sql.SQLException;
import net.bhpachulski.tddcriteriaserver.util.HibernateUtil;
import net.mjunior.model.ModCadAluno;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author mjunior
 */
public class DaoAluno {
    
    private SessionFactory sf = HibernateUtil.getSessionFactory();
    Session sessao = sf.openSession();
    ModCadAluno aluno;
    DaoGeneric<ModCadAluno> daoAluno;
    
    public ModCadAluno consultaPorId(int idAluno) {
        sessao.beginTransaction();
        
        Query consulta = sessao.createQuery("FROM aluno WHERE idAluno = " + idAluno);
        aluno = (ModCadAluno) consulta;
        
        sessao.getTransaction().commit();
        sessao.close();
        
        return aluno;
    }
    
    public void inserirAluno(ModCadAluno modAluno) throws SQLException {
        aluno = this.consultaPorId(modAluno.getIdAluno());
        
        if(aluno.getIdAluno() == 0)
            daoAluno.salvar(modAluno);
    }
}