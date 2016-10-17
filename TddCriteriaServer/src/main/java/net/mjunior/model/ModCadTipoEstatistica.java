package net.mjunior.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mjunior
 */
@Entity
@Table(name = "TipoEstatistica")
public class ModCadTipoEstatistica implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoEstatistica;
    
    @Column(name = "dsTipoEstatistica", nullable = true)
    private String dsTipoEstatistica;
    
    @ManyToOne//(optional = true)
    private ModCadTipoArquivo tipoArquivo;
    
    //relacionamento n para n com Arquivo
    @OneToMany(mappedBy = "tipoEstatistica")
    private List<ModCadExecEstatistica> execucoes;

    public List<ModCadExecEstatistica> getExecucoes() {
        return execucoes;
    }

    public void setExecucoes(List<ModCadExecEstatistica> execucoes) {
        this.execucoes = execucoes;
    }
    
    public int getIdTipoEstatistica() {
        return idTipoEstatistica;
    }

    public void setIdTipoEstatistica(int idTipoEstatistica) {
        this.idTipoEstatistica = idTipoEstatistica;
    }

    public String getDsTipoEstatistica() {
        return dsTipoEstatistica;
    }

    public void setDsTipoEstatistica(String dsTipoEstatistica) {
        this.dsTipoEstatistica = dsTipoEstatistica;
    }

    public ModCadTipoArquivo getTipoArquivo() {
        return tipoArquivo;
    }

    public void setTipoArquivo(ModCadTipoArquivo tipoArquivo) {
        this.tipoArquivo = tipoArquivo;
    }
}