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
@Table(name = "TipoClasse")
public class ModCadTipoClasse implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoClasse;
    @Column(name = "tipoClasse", nullable = true)
    private String dsTipoClasse;

    public int getIdTipoClasse() {
        return idTipoClasse;
    }

    public void setIdTipoClasse(int idTipoClasse) {
        this.idTipoClasse = idTipoClasse;
    }

    public String getDsTipoClasse() {
        return dsTipoClasse;
    }

    public void setDsTipoClasse(String dsTipoClasse) {
        this.dsTipoClasse = dsTipoClasse;
    }
}