package net.mjunior.model;

import java.io.Serializable;

/**
 *
 * @author mjunior
 */

//@Entity
//@Table(name = "ExecucaoProjeto")
public class ModCadExecProjeto implements Serializable {
    
//    @Id
    private int idClasseExecucao;
//    @Id
    private int idMetodoExecucao;
//    @Id
    private int idExecucaoProjeto;

    public int getIdClasseExecucao() {
        return idClasseExecucao;
    }

    public void setIdClasseExecucao(int idClasseExecucao) {
        this.idClasseExecucao = idClasseExecucao;
    }

    public int getIdMetodoExecucao() {
        return idMetodoExecucao;
    }

    public void setIdMetodoExecucao(int idMetodoExecucao) {
        this.idMetodoExecucao = idMetodoExecucao;
    }

    public int getIdExecucaoProjeto() {
        return idExecucaoProjeto;
    }

    public void setIdExecucaoProjeto(int idExecucaoProjeto) {
        this.idExecucaoProjeto = idExecucaoProjeto;
    }
}