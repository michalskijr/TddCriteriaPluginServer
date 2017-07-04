package net.bhpachulski.tddcriteriaserver.dao;

import java.sql.SQLException;
import net.bhpachulski.tddcriteriaserver.util.HibernateUtil;
import net.mjunior.model.ModCadArquivo;

/**
 *
 * @author mjunior
 */
public class DaoArquivo extends HibernateUtil {
    
    private DaoGeneric<ModCadArquivo> dao;

    public void salvarArquivo(ModCadArquivo modArquivo) throws SQLException {
        dao = new DaoGeneric<>();
        
        dao.salvar(modArquivo);
    }
}