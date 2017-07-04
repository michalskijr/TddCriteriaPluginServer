package net.bhpachulski.tddcriteriaserver.dao;

import java.sql.SQLException;
import net.bhpachulski.tddcriteriaserver.util.HibernateUtil;
import net.mjunior.model.ModCadClasseCounter;

/**
 *
 * @author mjunior
 */
public class DaoClasseCounter extends HibernateUtil {
    
    ModCadClasseCounter classeCounter;
    DaoGeneric<ModCadClasseCounter> dao;
    
    public void salvar(ModCadClasseCounter modClasseCounter) throws SQLException {
        classeCounter = new ModCadClasseCounter();
        dao = new DaoGeneric<>();
        
        dao.salvar(modClasseCounter);
    }
}