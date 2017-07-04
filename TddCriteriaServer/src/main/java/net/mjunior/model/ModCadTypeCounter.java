package net.mjunior.model;

/**
 *
 * @author mjunior
 */
public enum ModCadTypeCounter {
    
    INSTRUCTION(0), LINE(1), COMPLEXITY(2), METHOD(3), CLASS(4), BRANCH(5);
    
    //@Id
    private final int idTypeCounter;
    
    private ModCadTypeCounter(int idTypeCounter) {
        this.idTypeCounter = idTypeCounter;
    }

    public int getIdTypeCounter() {
        return idTypeCounter;
    }
}