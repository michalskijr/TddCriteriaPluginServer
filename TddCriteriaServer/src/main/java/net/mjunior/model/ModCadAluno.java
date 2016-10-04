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
@Table(name = "Aluno")
public class ModCadAluno implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAluno;
    @Column(name = "nomeAluno", nullable = true)
    private String nomeAluno;
    @Column(name = "macAddress", nullable = true)
    private String macAddress;
    @Column(name = "situacao", nullable = true)
    private String situacao;
    @ManyToOne(optional = true)
    private ModCadDisciplina disciplina;

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public ModCadDisciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(ModCadDisciplina disciplina) {
        this.disciplina = disciplina;
    }
}