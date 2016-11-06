package net.mjunior.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    //private int idProjeto;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "idArquivo")
    private ModCadArquivo arquivo;
    //private int idArquivo;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataHora;
    
    @ManyToOne
    @JoinColumn(name = "idEstagioTdd")
    private ModCadEstagioTdd estagioTdd;
    
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