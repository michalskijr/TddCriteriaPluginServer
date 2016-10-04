package net.mjunior.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mjunior
 */

@Entity
@Table(name = "ExecucaoProjeto")
public class ModCadExecProjeto implements Serializable {
    
    @Id
    private int idClasse;
    @Id
    private int idMetodo;
    @Id
    private int idExecucao;
    
}
