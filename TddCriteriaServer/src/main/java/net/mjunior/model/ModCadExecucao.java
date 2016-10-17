package net.mjunior.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

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
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataHora;
    
    @ManyToOne//(optional = true)
    private ModCadEstagioTdd estagioTdd;
    
    //relacionamento n para n com Metodo
//    @ManyToMany(mappedBy = "execucaoProjeto")
//    private List<ModCadMetodo> projetosExecutados;
//
//    public List<ModCadMetodo> getProjetosExecutados() {
//        return projetosExecutados;
//    }
//
//    public void setProjetosExecutados(List<ModCadMetodo> projetosExecutados) {
//        this.projetosExecutados = projetosExecutados;
//    }
    
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