package net.mjunior.model;

/**
 *
 * @author mjunior
 */
public enum ModCadTipoClasse {
    
    IMPLEMENTACAO(0), TESTE(1);
    
    private final int idTipoClasse;

    private ModCadTipoClasse(int idTipoClasse) {
        this.idTipoClasse = idTipoClasse;
    }
    
    //Getters and Setters

    public int getIdTipoClasse() {
        return idTipoClasse;
    }
}