package net.bhpachulski.tddcriteriaserver.dao;

import java.sql.SQLException;
import net.bhpachulski.tddcriteriaserver.util.HibernateUtil;
import net.mjunior.model.ModCadAluno;

/**
 *
 * @author mjunior
 */
public class DaoAluno extends HibernateUtil {
    
    ModCadAluno aluno;
    DaoGeneric<ModCadAluno> dao;
    
    public void inserirAluno(ModCadAluno modAluno) throws SQLException {
        aluno = new ModCadAluno();
        dao = new DaoGeneric<>();
        aluno = dao.consultaUmParametro(
                modAluno, "idAluno", modAluno.getIdAluno());

        if(aluno == null)
            dao.salvar(modAluno);
    }
}