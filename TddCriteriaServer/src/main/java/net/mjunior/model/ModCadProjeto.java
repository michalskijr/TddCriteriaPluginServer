package net.mjunior.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Column(name = "dataInicio", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicio;
    @Column(name = "nomeProjeto", nullable = true)
    private String nomeProjeto;
    @Column(name = "situacao", nullable = true)
    private String situacao;
    @ManyToOne(optional = true)
    private ModCadProfessor professor;
    @ManyToOne(optional = true)
    private ModCadAluno aluno;

    public int getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
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

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
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
}