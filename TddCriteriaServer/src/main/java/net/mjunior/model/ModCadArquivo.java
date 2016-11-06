package net.mjunior.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    
    @Column(name = "nomeArquivo", nullable = true)
    private String nomeArquivo;
    
    @Column
    @Lob
    private byte[] arquivoXML;
    
    @ManyToOne//(optional = true)
    @JoinColumn(name = "idTipoArquivo")
    private ModCadTipoArquivo tipoArquivo;
    
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
}