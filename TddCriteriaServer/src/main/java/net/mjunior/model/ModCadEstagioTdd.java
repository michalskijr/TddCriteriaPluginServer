package net.mjunior.model;

/**
 *
 * @author mjunior
 */
public enum ModCadEstagioTdd {
    
    RED(0), GREEN(1), REFACTOR(2);
    
    private final int idEstagioTdd;

    private ModCadEstagioTdd(int idEstagioTdd) {
        this.idEstagioTdd = idEstagioTdd;
    }
    
    //Getters and Setters
    public int getIdEstagioTdd() {
        return idEstagioTdd;
    }
}