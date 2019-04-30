package server;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;

public class JsonCreator <T>{
    private ObjectMapper mapper = new ObjectMapper();


    /**
     * Convert a generics into a JSON ready to send
     * @param item, generics
     * @throws IOException
     * @return String JSON
     */
    public String serializer(T item) throws IOException {

        mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
        mapper.writeValue(new File("Data.json"), item);
        mapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
        String json = mapper.writeValueAsString(item);
        return json;
    }

    /**
     * Convert a json string into a ArrayList object
     * @param json
     * @return
     * @throws IOException
     */
    public String[][] unSerializer(String json) throws IOException {
        String[][] data = mapper.readValue(new File("Data.json"), String[][].class);
        return data;
    }

}