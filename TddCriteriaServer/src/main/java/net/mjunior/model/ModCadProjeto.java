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
@Table(name = "Projeto")
public class ModCadProjeto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProjeto;

    @Enumerated(EnumType.STRING)
    @Column(name = "situacao", nullable = false)
    private ModCadSituacao situacao;
    
    @ManyToOne
    @JoinColumn(name = "idProfessor")
    private ModCadProfessor professor;
    
    @ManyToOne
    @JoinColumn(name = "idAluno", nullable = false)
    private ModCadAluno aluno;

    @Column(name = "dataInicio", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicio;
    
    @Column(name = "nomeProjeto", nullable = true)
    private String nomeProjeto;
    
    //Getters and Setters
    public int getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }

    public ModCadSituacao getSituacao() {
        return situacao;
    }

    public void setSituacao(ModCadSituacao situacao) {
        this.situacao = situacao;
    }

    public ModCadProfessor getProfessor() {
        return professor;
    }

    public void setProfessor(ModCadProfessor professor) {
        this.professor = professor;
    }

    public ModCadAluno getAluno() {
        return aluno;
    }

    public void setAluno(ModCadAluno aluno) {
        this.aluno = aluno;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }
}