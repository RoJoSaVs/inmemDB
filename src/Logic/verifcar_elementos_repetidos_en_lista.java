package Logic;

import java.util.ArrayList;

public class verifcar_elementos_repetidos_en_lista {
    public static boolean prueba(ArrayList<String> lista_a_validar) {
        boolean se_repite = false;
        for (String i : lista_a_validar) {
            int cont = 0;
            for (String j : lista_a_validar) {
                if (j.equals(i)) {
                    cont += 1;
                }
                if (cont > 1) {
                    se_repite = true;
                    break;
                }
            }
        }
        System.out.println(se_repite);
        return (se_repite);
    }
}
