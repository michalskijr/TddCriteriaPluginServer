package net.mjunior.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mjunior
 */
@Entity
@Table(name = "Aluno")
public class ModCadAluno implements Serializable {
    
    @Id
    private int idAluno;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "situacao", nullable = false)
    private ModCadSituacao situacao;

    @Column(name = "nomeAluno", nullable = true)
    private String nomeAluno;
    
    @Column(name = "macAddress", nullable = true)
    private String macAddress;
    
    //Getter and Setter
    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public ModCadSituacao getSituacao() {
        return situacao;
    }

    public void setSituacao(ModCadSituacao situacao) {
        this.situacao = situacao;
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
}