package net.bhpachulski.tddcriteriaserver.dao;

import java.util.List;
import net.bhpachulski.tddcriteriaserver.util.HibernateUtil;
import net.mjunior.model.SaveFile;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author mjunior
 */
public class DaoFile extends HibernateUtil {
    
    public List<SaveFile> findAllUnread() {
        try {
            return getSession().createCriteria(SaveFile.class)
                    .add(Restrictions.eq("realizadoLeitura", 
                            false)).list();
        } finally {
            close();
        }
    }
}