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
@Table(name = "Disciplina")
public class ModCadDisciplina implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDisciplina;

    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "idSemestre")
    private ModCadSemestre semestre;

    @Id
    @Column(name = "ano")
    private String ano;

    @Enumerated(EnumType.STRING)
    @Column(name = "situacao")
    private ModCadSituacao situacao;
    
    @Column(name = "nomeDisciplina", nullable = false)
    private String nomeDisciplina;

    //Getter and Setter
    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public ModCadSemestre getSemestre() {
        return semestre;
    }

    public void setSemestre(ModCadSemestre semestre) {
        this.semestre = semestre;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public ModCadSituacao getSituacao() {
        return situacao;
    }

    public void setSituacao(ModCadSituacao situacao) {
        this.situacao = situacao;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
}