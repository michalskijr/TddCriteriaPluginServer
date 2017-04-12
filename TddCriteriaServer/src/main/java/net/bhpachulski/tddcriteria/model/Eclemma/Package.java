package net.bhpachulski.tddcriteria.model.Eclemma;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bhpachulski
 */

@JsonRootName("package")
public class Package {
    
    @JsonProperty(value = "name")
    private String name;
    
    @JsonProperty(value = "class")
    private List<Classs> classs; 
    
    @JsonProperty("sourcefile")
    private SourceFile sourcefile;
    
    @JsonProperty("counter")
    private List<Counter> counter = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Classs> getClasss() {
        return classs;
    }

    public void setClasss(List<Classs> classs) {
        this.classs = classs;
    }

    public SourceFile getSourcefile() {
        return sourcefile;
    }

    public void setSourcefile(SourceFile sourcefile) {
        this.sourcefile = sourcefile;
    }

    public List<Counter> getCounter() {
        return counter;
    }

    public void setCounter(List<Counter> counter) {
        this.counter = counter;
    }

}
