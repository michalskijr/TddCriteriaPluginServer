package net.bhpachulski.tddcriteriaserver.dao;

import java.sql.SQLException;
import java.util.Date;
import net.bhpachulski.tddcriteriaserver.util.HibernateUtil;
import net.mjunior.model.ModCadProjeto;

/**
 *
 * @author mjunior
 */
public class DaoProjeto extends HibernateUtil {
    
    ModCadProjeto projeto;
    DaoGeneric<ModCadProjeto> dao;
    
    public void salvarProjeto(ModCadProjeto modProjeto) throws SQLException {
        projeto = new ModCadProjeto();
        dao = new DaoGeneric<>();
        projeto = dao.consultaDoisParametros(
                modProjeto, "aluno.idAluno", modProjeto.getAluno().getIdAluno(),
                "nomeProjeto", modProjeto.getNomeProjeto());
        
        if(projeto == null) {
            modProjeto.setDataInicio(new Date());
            dao.salvar(modProjeto);
        } else {
            modProjeto.setIdProjeto(projeto.getIdProjeto());
            dao.update(modProjeto);
        }
    }
}