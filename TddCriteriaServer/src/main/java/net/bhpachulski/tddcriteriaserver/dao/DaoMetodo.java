package net.bhpachulski.tddcriteriaserver.dao;

import java.sql.SQLException;
import net.bhpachulski.tddcriteriaserver.util.HibernateUtil;
import net.mjunior.model.ModCadMetodo;

/**
 *
 * @author mjunior
 */
public class DaoMetodo extends HibernateUtil {
    
    ModCadMetodo metodo;
    DaoGeneric<ModCadMetodo> dao;
    
    public void salvarMetodo(ModCadMetodo modMetodo) throws SQLException {
        metodo = new ModCadMetodo();
        dao = new DaoGeneric<>();
        
        dao.salvar(modMetodo);
    }
    
    public void update(ModCadMetodo modMetodo) throws SQLException {
        dao = new DaoGeneric<>();
        
        dao.update(modMetodo);
    }
}