package net.mjunior.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mjunior
 */
@Entity
@Table(name = "TipoArquivo")
public class ModCadTipoArquivo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoArquivo;
    
    @Column(name = "dsTipoArquivo", nullable = true)
    private String dsTipoArquivo;

    public int getIdTipoArquivo() {
        return idTipoArquivo;
    }

    public void setIdTipoArquivo(int idTipoArquivo) {
        this.idTipoArquivo = idTipoArquivo;
    }

    public String getDsTipoArquivo() {
        return dsTipoArquivo;
    }

    public void setDsTipoArquivo(String dsTipoArquivo) {
        this.dsTipoArquivo = dsTipoArquivo;
    }
}