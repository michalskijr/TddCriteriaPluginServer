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
@Table(name = "Arquivo")
public class ModCadArquivo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArquivo;
    
    @Column(name = "nomeArquivo", nullable = true)
    private String nomeArquivo;
    
    @ManyToOne//(optional = true)
    private ModCadExecucao execucao;
    
    @ManyToOne//(optional = true)
    private ModCadTipoArquivo tipoArquivo;
    
    @OneToMany(mappedBy = "arquivo")
    private List<ModCadExecEstatistica> execucoes;
    
    public List<ModCadExecEstatistica> getExecucoes() {
        return execucoes;
    }

    public void setExecucoes(List<ModCadExecEstatistica> execucoes) {
        this.execucoes = execucoes;
    }
    
    public int getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(int idArquivo) {
        this.idArquivo = idArquivo;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public ModCadExecucao getExecucao() {
        return execucao;
    }

    public void setExecucao(ModCadExecucao execucao) {
        this.execucao = execucao;
    }

    public ModCadTipoArquivo getTipoArquivo() {
        return tipoArquivo;
    }

    public void setTipoArquivo(ModCadTipoArquivo tipoArquivo) {
        this.tipoArquivo = tipoArquivo;
    }
}