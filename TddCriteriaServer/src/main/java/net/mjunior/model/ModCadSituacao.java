package net.mjunior.model;

/**
 *
 * @author mjunior
 */
public enum ModCadSituacao {
    
    ATIVO(0), INATIVO(1);
    
    private final int idSituacao;

    private ModCadSituacao(int idSituacao) {
        this.idSituacao = idSituacao;
    }

    //Getters and Setters
    public int getIdSituacao() {
        return idSituacao;
    }
}