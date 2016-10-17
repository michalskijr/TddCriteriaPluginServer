package net.mjunior.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author mjunior
 */

@Entity
@Table(name = "ExecucaoEstatistica")
public class ModCadExecEstatistica implements Serializable {
    
    @Id
    private int idArquivo;
    
    @Id
    private int idTipoEstatistica;
    
    @Column(name = "missed")
    private int missed;
    
    @Column(name = "covered")
    private int covered;
    
    @Column(name = "failed")
    private Boolean failed;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "idArquivo", referencedColumnName = "idArquivo")
    private ModCadArquivo arquivo;
    
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "idTipoEstatistica", referencedColumnName = "idTipoEstatistica")
    private ModCadTipoEstatistica tipoEstatistica;

    public int getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(int idArquivo) {
        this.idArquivo = idArquivo;
    }

    public int getIdTipoEstatistica() {
        return idTipoEstatistica;
    }

    public void setIdTipoEstatistica(int idTipoEstatistica) {
        this.idTipoEstatistica = idTipoEstatistica;
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
}