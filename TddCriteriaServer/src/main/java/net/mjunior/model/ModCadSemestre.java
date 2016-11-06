package net.mjunior.model;

/**
 *
 * @author mjunior
 */
public enum ModCadSemestre {
    
    SEMESTRE1(1, "1º SEMESTRE"), SEMESTRE2(2, "2º SEMESTRE");
    
    private final int idSemestre;
    private final String dsSemestre;

    private ModCadSemestre(int idSemestre, String dsSemestre) {
        this.idSemestre = idSemestre;
        this.dsSemestre = dsSemestre;
    }

    public int getIdSemestre() {
        return idSemestre;
    }

    public String getDsSemestre() {
        return dsSemestre;
    }
}