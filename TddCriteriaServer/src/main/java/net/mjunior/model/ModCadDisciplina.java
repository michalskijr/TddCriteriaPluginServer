package net.mjunior.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

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
    
    @Column(name = "nomeDisciplina", nullable = true)
    private String nomeDisciplina;
    
    @Column(name = "ano", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ano;
    
//    @Column(name = "situacao", nullable = true)
//    private String situacao;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "situacao")
    private ModCadSituacao situacao;
    
    @ManyToOne
    @JoinColumn(name = "idSemestre")
    private ModCadSemestre semestre;

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

//    public String getSituacao() {
//        return situacao;
//    }
//
//    public void setSituacao(String situacao) {
//        this.situacao = situacao;
//    }

    public ModCadSituacao getSituacao() {
        return situacao;
    }
    
    public ModCadSemestre getSemestre() {
        return semestre;
    }

    public void setSemestre(ModCadSemestre semestre) {
        this.semestre = semestre;
    }
}