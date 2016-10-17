package net.mjunior.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mjunior
 */
@Entity
@Table(name = "Metodo")
public class ModCadMetodo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMetodo;
    
    @Column(name = "descricao", nullable = true)
    private String dsMetodo;
    
    @ManyToOne//(optional = true)
    private ModCadClasse classe;
    
    //relacionamento n para n com Execucao
//    @ManyToMany
//    @JoinTable(
//            name = "ExecucaoProjeto",
//            joinColumns = @JoinColumn (name = "idMetodoExecucao",
//                                       referencedColumnName = "idMetodo"),
//            inverseJoinColumns = @JoinColumn (name = "idExecucaoProjeto",
//                                              referencedColumnName = "idExecucao"))
//    private List<ModCadExecucao> metodosDaExecucao;
//
//    public List<ModCadExecucao> getMetodosDaExecucao() {
//        return metodosDaExecucao;
//    }
//
//    public void setMetodosDaExecucao(List<ModCadExecucao> metodosDaExecucao) {
//        this.metodosDaExecucao = metodosDaExecucao;
//    }
    
    public int getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(int idMetodo) {
        this.idMetodo = idMetodo;
    }

    public String getDsMetodo() {
        return dsMetodo;
    }

    public void setDsMetodo(String dsMetodo) {
        this.dsMetodo = dsMetodo;
    }

    public ModCadClasse getClasse() {
        return classe;
    }

    public void setClasse(ModCadClasse classe) {
        this.classe = classe;
    }
}