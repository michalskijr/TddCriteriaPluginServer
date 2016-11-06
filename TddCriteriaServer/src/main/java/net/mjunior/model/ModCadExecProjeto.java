package net.mjunior.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "ExecucaoProjeto")
public class ModCadExecProjeto implements Serializable {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "idProjeto")
    private ModCadProjeto projeto;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "idArquivo")
    private ModCadArquivo arquivo;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "idEstagioTdd", nullable = false)
    private ModCadEstagioTdd estagioTdd;
    
    @Column(name = "dataHora", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataHora;
    
    //Getters and Setters
    public ModCadProjeto getProjeto() {
        return projeto;
    }
    
    public void setProjeto(ModCadProjeto projeto) {
        this.projeto = projeto;
    }
    
    public ModCadArquivo getArquivo() {
        return arquivo;
    }
    
    public void setArquivo(ModCadArquivo arquivo) {
        this.arquivo = arquivo;
    }
    
    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public ModCadEstagioTdd getEstagioTdd() {
        return estagioTdd;
    }

    public void setEstagioTdd(ModCadEstagioTdd estagioTdd) {
        this.estagioTdd = estagioTdd;
    }
}