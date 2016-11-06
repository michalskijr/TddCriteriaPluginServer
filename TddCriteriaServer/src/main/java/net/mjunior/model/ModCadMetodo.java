package net.mjunior.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    
    @Id
    @ManyToOne
    @JoinColumn(name = "idClasse", nullable = false)
    private ModCadClasse classe;
    
    @Column(name = "descricao", nullable = false)
    private String dsMetodo;
    
    //Getters and Setters
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