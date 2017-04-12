package net.mjunior.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author mjunior
 */
@Entity
@Table(name = "SaveFile")
public class SaveFile implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFile;
    
    @Column(name = "idAluno", nullable = false)
    private int idAlunoFile;
    
    @Column(name = "idTipoArquivo", nullable = false)
    private int idTipoArquivoFile;
    
    @Column(name = "nomeProjeto", nullable = false)
    private String nomeProjetoFile;
    
    @Column(name = "nomeArquivo", nullable = false)
    private String nomeArquivoFile;
    
    @Column(name = "arquivo", nullable = false)
    @Lob
    private byte[] arquivoXmlFile;
    
    @Column(name = "estagioTdd", nullable = false)
    private String estagioTddFile;
    
    @Column(name = "realizadoLeitura", nullable = false)
    private Boolean realizadoLeitura;

    public int getIdFile() {
        return idFile;
    }

    public void setIdFile(int idFile) {
        this.idFile = idFile;
    }

    public int getIdAlunoFile() {
        return idAlunoFile;
    }

    public void setIdAlunoFile(int idAlunoFile) {
        this.idAlunoFile = idAlunoFile;
    }

    public int getIdTipoArquivoFile() {
        return idTipoArquivoFile;
    }

    public void setIdTipoArquivoFile(int idTipoArquivoFile) {
        this.idTipoArquivoFile = idTipoArquivoFile;
    }

    public String getNomeProjetoFile() {
        return nomeProjetoFile;
    }

    public void setNomeProjetoFile(String nomeProjetoFile) {
        this.nomeProjetoFile = nomeProjetoFile;
    }

    public String getNomeArquivoFile() {
        return nomeArquivoFile;
    }

    public void setNomeArquivoFile(String nomeArquivoFile) {
        this.nomeArquivoFile = nomeArquivoFile;
    }

    public byte[] getArquivoXmlFile() {
        return arquivoXmlFile;
    }

    public void setArquivoXmlFile(byte[] arquivoXmlFile) {
        this.arquivoXmlFile = arquivoXmlFile;
    }

    public String getEstagioTddFile() {
        return estagioTddFile;
    }

    public void setEstagioTddFile(String estagioTddFile) {
        this.estagioTddFile = estagioTddFile;
    }
    
    public void setArquivoFile(File file) {
        try {
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            int offset = 0;
            int numRead = 0;
            
            while(offset < bytes.length
                    && (numRead = inputStream.read(bytes, offset, 
                            bytes.length - offset)) >= 0) {
                offset += numRead;
            }
            
            this.arquivoXmlFile = bytes;
        } catch (Exception e) {
            this.arquivoXmlFile = null;
        }
    }

    public Boolean getRealizadoLeitura() {
        return realizadoLeitura;
    }

    public void setRealizadoLeitura(Boolean realizadoLeitura) {
        this.realizadoLeitura = realizadoLeitura;
    }
}