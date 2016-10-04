package net.mjunior.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mjunior
 */

@Entity
@Table(name = "ExecucaoEstatistica")
public class ModCadExecEstatistica implements Serializable {
    
    @Id
    private int idArquivo;
    @Id
    private int idTipoEstatistica;
    @Column(name = "missed")
    private int missed;
    @Column(name = "covered")
    private int covered;
    @Column(name = "failed")
    private Boolean failed;
    
}
