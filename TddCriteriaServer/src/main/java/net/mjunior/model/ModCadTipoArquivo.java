package net.mjunior.model;

/**
 *
 * @author mjunior
 */
public enum ModCadTipoArquivo {
    
    COVERAGE(0), JUNIT(1), SOURCE(2);
    
    private final int idTipoArquivo;

    private ModCadTipoArquivo(int idTipoArquivo) {
        this.idTipoArquivo = idTipoArquivo;
    }
    
    //Getters and Setters
    public int getIdTipoArquivo() {
        return idTipoArquivo;
    }
}