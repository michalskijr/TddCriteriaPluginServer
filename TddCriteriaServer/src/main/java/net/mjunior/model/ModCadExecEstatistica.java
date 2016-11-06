package net.mjunior.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author mjunior
 */

@Entity
@Table(name = "ExecucaoEstatistica")
public class ModCadExecEstatistica implements Serializable {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "idArqivo")
    private ModCadArquivo arquivo;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "idTipoEstatistica")
    private ModCadTipoEstatistica tipoEstatistica;
    
    @Column(name = "missed", nullable = true)
    private int missed;
    
    @Column(name = "covered", nullable = true)
    private int covered;
    
    @Column(name = "failed", nullable = true)
    private Boolean failed;

    //Getters and Setters
    public ModCadArquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(ModCadArquivo arquivo) {
        this.arquivo = arquivo;
    }

    public ModCadTipoEstatistica getTipoEstatistica() {
        return tipoEstatistica;
    }

    public void setTipoEstatistica(ModCadTipoEstatistica tipoEstatistica) {
        this.tipoEstatistica = tipoEstatistica;
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

    public Boolean getFailed() {
        return failed;
    }

    public void setFailed(Boolean failed) {
        this.failed = failed;
    }
}