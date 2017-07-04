package net.mjunior.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
    
    //@Id
    @ManyToOne
    @JoinColumn(name = "idExecucaoProjeto")
    private ModCadExecProjeto execucaoProjeto;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "idTipoArquivo", nullable = false)
    private ModCadTipoArquivo tipoArquivo;
    
    @Column(name = "nomeArquivo", nullable = false)
    private String nomeArquivo;
    
    @Column(name = "arquivoXML", nullable = false)
    @Lob
    private byte[] arquivoXML;
    
    //Getters and Setters
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

    public byte[] getArquivoXML() {
        return arquivoXML;
    }

    public void setArquivoXML(byte[] arquivoXML) {
        this.arquivoXML = arquivoXML;
    }

    public ModCadTipoArquivo getTipoArquivo() {
        return tipoArquivo;
    }

    public void setTipoArquivo(ModCadTipoArquivo tipoArquivo) {
        this.tipoArquivo = tipoArquivo;
    }

    public ModCadExecProjeto getExecucaoProjeto() {
        return execucaoProjeto;
    }

    public void setExecucaoProjeto(ModCadExecProjeto execucaoProjeto) {
        this.execucaoProjeto = execucaoProjeto;
    }
}