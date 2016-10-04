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
@Table(name = "Semestre")
public class ModCadSemestre implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSemestre;
    
    @Column(name = "descricao", nullable = true)
    private String descSemestre;

    public int getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(int idSemestre) {
        this.idSemestre = idSemestre;
    }

    public String getDescSemestre() {
        return descSemestre;
    }

    public void setDescSemestre(String descSemestre) {
        this.descSemestre = descSemestre;
    }
}