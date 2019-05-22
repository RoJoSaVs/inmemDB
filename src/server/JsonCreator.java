package server;

import GUI.Contenedor_de_esquemas;
import GUI.Esquema;
import com.sun.xml.internal.ws.developer.SerializationFeature;
import com.sun.xml.internal.ws.spi.db.PropertyAccessor;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

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
        mapper.disable(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS);
        mapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.writeValue(new File("Data.json"), item);
        String json = mapper.writeValueAsString(item);
        return json;
    }

    public ArrayList<JsonToSend> separadorDeEsquemas(ArrayList<Esquema> esquemas){
        ArrayList<JsonToSend> esquemasSeparados = new ArrayList<>();
        for (Esquema i: esquemas){
            JsonToSend jsonToSend = new JsonToSend();
            jsonToSend.setG_conteo(i.g_conteo);
            jsonToSend.setG_paracolumnas(i.g_paracolumnas);
            jsonToSend.setG_parafilas(i.ftotal);
            jsonToSend.setG_titulo(i.g_titulo);
            jsonToSend.setTipos(i.tipos);
            esquemasSeparados.add(jsonToSend);

        }
        return esquemasSeparados;
    }

    /**
     * Convert a json string into a ArrayList object
     * @param json
     * @return
     * @throws IOException
     */
    public JsonToSend unSerializer(String json) throws IOException {
        JsonToSend data = mapper.readValue(json, JsonToSend.class);
        System.out.println("deserialice bien y la prueba es" + data.getG_parafilas());
        return data;
    }

}