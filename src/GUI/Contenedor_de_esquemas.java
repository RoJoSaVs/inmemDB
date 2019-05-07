package GUI;

import java.util.ArrayList;

public class Contenedor_de_esquemas {
    public static ArrayList<Esquema> lista_de_esquemas = new ArrayList<Esquema>();

    public static ArrayList<Esquema> getLista_de_esquemas() {
        return lista_de_esquemas;
    }

    public static void setLista_de_esquemas(ArrayList<Esquema> lista_de_esquemas) {
        Contenedor_de_esquemas.lista_de_esquemas = lista_de_esquemas;
    }

    public String[] toArray(){
        String[] contenedor_version_array = lista_de_esquemas.toArray(new String[lista_de_esquemas.size()]);
        return contenedor_version_array;
    }
}
