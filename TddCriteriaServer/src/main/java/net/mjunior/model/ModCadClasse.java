package net.mjunior.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author mjunior
 */
@Entity
@Table(name = "Classe")
public class ModCadClasse implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClasse;
    @Column(name = "descricao")
    private String dsClasse;
    @ManyToOne(optional = true)
    private ModCadProjeto projeto;
    @ManyToOne(optional = true)
    private ModCadTipoClasse tipoClasse;

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public String getDsClasse() {
        return dsClasse;
    }

    public void setDsClasse(String dsClasse) {
        this.dsClasse = dsClasse;
    }

    public ModCadProjeto getProjeto() {
        return projeto;
    }

    public void setProjeto(ModCadProjeto projeto) {
        this.projeto = projeto;
    }

    public ModCadTipoClasse getTipoClasse() {
        return tipoClasse;
    }

    public void setTipoClasse(ModCadTipoClasse tipoClasse) {
        this.tipoClasse = tipoClasse;
    }
}