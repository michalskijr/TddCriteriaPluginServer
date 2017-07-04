package net.bhpachulski.tddcriteriaserver.dao;

import java.sql.SQLException;
import net.bhpachulski.tddcriteriaserver.util.HibernateUtil;
import net.mjunior.model.ModCadClasse;

/**
 *
 * @author mjunior
 */
public class DaoClasse extends HibernateUtil {
    
    DaoGeneric<ModCadClasse> dao;
    
    public void salvarClasse(ModCadClasse modClasse) throws SQLException {
        dao = new DaoGeneric<>();
        
        dao.salvar(modClasse);
    }
}