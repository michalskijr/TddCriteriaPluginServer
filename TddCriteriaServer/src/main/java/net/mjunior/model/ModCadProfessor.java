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
@Table(name = "Professor")
public class ModCadProfessor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProfessor;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "situacao", nullable = false)
    private ModCadSituacao situacao;
    
    @Column(name = "nomeProfessor", nullable = true)
    private String nomeProfessor;
    
    @Column(name = "login", nullable = true)
    private String login;
    
    @Column(name = "senha", nullable = true)
    private String senha;
    
    @Column(name = "email", nullable = true)
    private String email;

    //Getters and Setters
    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public ModCadSituacao getSituacao() {
        return situacao;
    }

    public void setSituacao(ModCadSituacao situacao) {
        this.situacao = situacao;
    }
    
    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}