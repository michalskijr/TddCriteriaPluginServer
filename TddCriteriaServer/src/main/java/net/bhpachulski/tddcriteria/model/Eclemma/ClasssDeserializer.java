package net.bhpachulski.tddcriteria.model.Eclemma;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author mjunior
 */
public class ClasssDeserializer extends JsonDeserializer<List<Classs>> {
    
    @Override
    public List<Classs> deserialize(JsonParser jsonParser, 
            DeserializationContext deserializationContext) throws IOException {
        
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(jsonParser);
        List<Classs> classs = mapper.convertValue(node.findValue("class"), new TypeReference<List<Classs>>(){});
        
        return classs;
    }
}
