package net.mjunior.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    @Enumerated(EnumType.STRING)
    @Column(name = "idTipoArquivo", nullable = false)
    private ModCadTipoArquivo tipoArquivo;
    
    @Column(name = "dsTipoEstatistica", nullable = false)
    private String dsTipoEstatistica;

    //Getters and Setters
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