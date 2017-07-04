package net.bhpachulski.tddcriteriaserver.dao;

import java.sql.SQLException;
import net.bhpachulski.tddcriteriaserver.util.HibernateUtil;
import net.mjunior.model.ModCadTestCases;

/**
 *
 * @author mjunior
 */
public class DaoTestCases extends HibernateUtil {
    
    DaoGeneric<ModCadTestCases> dao;
    
    public void salvar(ModCadTestCases modTest) throws SQLException {
        dao = new DaoGeneric<>();
        
        dao.salvar(modTest);
    }
}