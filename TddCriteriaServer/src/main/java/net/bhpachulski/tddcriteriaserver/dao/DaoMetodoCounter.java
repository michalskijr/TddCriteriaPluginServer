package net.bhpachulski.tddcriteriaserver.dao;

import java.sql.SQLException;
import net.bhpachulski.tddcriteriaserver.util.HibernateUtil;
import net.mjunior.model.ModCadMetodoCounter;

/**
 *
 * @author mjunior
 */
public class DaoMetodoCounter extends HibernateUtil {
    
    ModCadMetodoCounter metodoCounter;
    DaoGeneric<ModCadMetodoCounter> dao;
    
    public void salvar(ModCadMetodoCounter modMetodoCounter) throws SQLException {
        metodoCounter = new ModCadMetodoCounter();
        dao = new DaoGeneric<>();
        
        dao.salvar(modMetodoCounter);
    }
}