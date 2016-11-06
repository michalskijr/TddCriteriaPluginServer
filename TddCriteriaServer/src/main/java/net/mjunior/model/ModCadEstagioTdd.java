package net.mjunior.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mjunior
 */
@Entity
@Table(name = "EstagioTDD")
public class ModCadEstagioTdd implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstagioTdd;
    
    @Column(name = "descricao", nullable = true)
    private String dsEstagioTdd;

    public int getIdEstagioTdd() {
        return idEstagioTdd;
    }

    public void setIdEstagioTdd(int idEstagioTdd) {
        this.idEstagioTdd = idEstagioTdd;
    }

    public String getDsEstagioTdd() {
        return dsEstagioTdd;
    }

    public void setDsEstagioTdd(String dsEstagioTdd) {
        this.dsEstagioTdd = dsEstagioTdd;
    }
}