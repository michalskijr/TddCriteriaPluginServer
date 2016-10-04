package net.mjunior.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mjunior
 */
@Entity
@Table(name = "Execucao")
public class ModCadExecucao implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExecucao;
    @Column(name = "dataHora", nullable = true)
    private Date dataHora;
    @ManyToOne(optional = true)
    private ModCadEstagioTdd estagioTdd;
    @OneToMany(mappedBy = "execucao")
    private List<ModCadExecProjeto> projetosExecutados;

    public List<ModCadExecProjeto> getProjetosExecutados() {
        return projetosExecutados;
    }

    public void setProjetosExecutados(List<ModCadExecProjeto> projetosExecutados) {
        this.projetosExecutados = projetosExecutados;
    }
    
    public int getIdExecucao() {
        return idExecucao;
    }

    public void setIdExecucao(int idExecucao) {
        this.idExecucao = idExecucao;
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