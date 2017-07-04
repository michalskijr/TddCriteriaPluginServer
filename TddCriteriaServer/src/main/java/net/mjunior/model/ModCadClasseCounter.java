package net.mjunior.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author mjunior
 */
@Entity
@Table(name = "ClasseCounter")
public class ModCadClasseCounter implements Serializable {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "idClasse")
    private ModCadClasse classe;
    
    @Id
    @Enumerated(EnumType.STRING)
    //@ManyToOne
    @Column(name = "typeCounter")
    private ModCadTypeCounter typeCounter;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "idExecucaoProjeto")
    private ModCadExecProjeto execucaoProjeto;
    
    @Column(name = "missed", nullable = true)
    private int missed;
    
    @Column(name = "covered", nullable = true)
    private int covered;

    //Getters and Setters
    public ModCadClasse getClasse() {
        return classe;
    }

    public void setClasse(ModCadClasse classe) {
        this.classe = classe;
    }

    public ModCadTypeCounter getTypeCounter() {
        return typeCounter;
    }

    public void setTypeCounter(ModCadTypeCounter typeCounter) {
        this.typeCounter = typeCounter;
    }

    public ModCadExecProjeto getExecucaoProjeto() {
        return execucaoProjeto;
    }

    public void setExecucaoProjeto(ModCadExecProjeto execucaoProjeto) {
        this.execucaoProjeto = execucaoProjeto;
    }
    
    public int getMissed() {
        return missed;
    }

    public void setMissed(int missed) {
        this.missed = missed;
    }

    public int getCovered() {
        return covered;
    }

    public void setCovered(int covered) {
        this.covered = covered;
    }
}