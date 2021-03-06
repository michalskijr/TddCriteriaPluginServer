package net.bhpachulski.tddcriteriaserver.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author bhpachulski
 */
public enum FileType {

    JUNIT(1, "junitTrack"), ECLEMMA(2, "coverageTrack"), SRC(3, "srcTrack");

    private final Integer id;
    private final String folder;
    
    private static Map<Integer, FileType> fileType;
    
    static {
        fileType = new HashMap<Integer, FileType>();
        
        for (FileType ift : values()) {
            fileType.put(ift.getId(), ift);
        }
    }

    private FileType(int id, String folder) {
        this.id = id;
        this.folder = folder;
    }

    public Integer getId () {
        return this.id;
    }
    
    public String getFolder() {
        return folder;
    }

    public static FileType getFileType(int id) {
        return fileType.get(id);
    }
    
    

}
