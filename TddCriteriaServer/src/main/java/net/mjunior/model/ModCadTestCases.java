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
@Table(name = "TestCases")
public class ModCadTestCases implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTestCases;
    
    @Column(name = "failed")
    private boolean failed;

    public int getIdTestCases() {
        return idTestCases;
    }

    public void setIdTestCases(int idTestCases) {
        this.idTestCases = idTestCases;
    }

    public boolean isFailed() {
        return failed;
    }

    public void setFailed(boolean failed) {
        this.failed = failed;
    }
}