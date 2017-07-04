package net.bhpachulski.tddcriteriaserver.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import net.bhpachulski.tddcriteriaserver.util.HibernateUtil;
import static net.bhpachulski.tddcriteriaserver.util.HibernateUtil.getSession;
import net.mjunior.model.ModCadExecProjeto;
import net.mjunior.model.ModCadProjeto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author mjunior
 */
public class DaoExecProjeto extends HibernateUtil {
    
    ModCadExecProjeto execProjeto;
    DaoGeneric<ModCadExecProjeto> dao;
    
    private final SessionFactory sf = HibernateUtil.getSessionFactory();
    Session sessao = sf.openSession();
    
    public void init() throws SQLException {
        
    }
    
    public void salvarExecProjeto(ModCadExecProjeto modExecProjeto) throws SQLException {
        dao = new DaoGeneric<>();
        
        dao.salvar(modExecProjeto);
    }
    
    //Pesquisa execução realizada na data e hora exata
    public ModCadExecProjeto verificarExecDataHoraExata(ModCadProjeto projeto, Date data) {
        execProjeto = new ModCadExecProjeto();
        try {
            execProjeto = (ModCadExecProjeto) getSession()
                    .createCriteria(ModCadExecProjeto.class)
                    .add(Restrictions.eq("projeto", projeto))
                    .add(Restrictions.eq("dataHora", data))
                    .uniqueResult();
            
            return execProjeto;
        } catch (Exception e) {
            System.out.println("Falha na pesquisa por data e hora exata! " + e);
            
            return null;
        } finally {
            close();
        }
    }
    
    //Pesquisa execução realizada na data e hora proxima
    
    //verificar
    //2015_10_23_21_34_49:GREEN 
    //2015_10_23_21_34_50:REFACTOR
    
    
    public ModCadExecProjeto verificarExecDataHoraProximo(Date data, ModCadProjeto projeto) {
        Date data1 = new Date(data.getTime() + TimeUnit.SECONDS.toMillis(-2));
        Date data2 = new Date(data.getTime() + TimeUnit.SECONDS.toMillis(2));
        
        try {
            return (ModCadExecProjeto) getSession().createCriteria(
                    ModCadExecProjeto.class)
                    .add(Restrictions.eq("projeto", projeto))
                    .add(Restrictions.between("dataHora", data1, data2))
                    .uniqueResult();
        } catch (Exception e) {
            System.out.println("Falha na pesquisa por data e hora próxima! " + e);
            
            return null;
        }finally {
            close();
        }
    }
}