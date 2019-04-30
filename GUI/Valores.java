package GUI;

import org.codehaus.jackson.map.ObjectMapper;

class Valores {

    public String llavejson;
    public int valorjson;
    public float valorjson2;
    public double valorjson3;
    public long valorjson4;


    public float getValorjson2() {
        return valorjson2;
    }

    public void setValorjson2(float valorjson2) {
        this.valorjson2 = valorjson2;
    }

    public double getValorjson3() {
        return valorjson3;
    }

    public void setValorjson3(double valorjson3) {
        this.valorjson3 = valorjson3;
    }

    public long getValorjson4() {
        return valorjson4;
    }

    public void setValorjson4(long valorjson4) {
        this.valorjson4 = valorjson4;
    }

    public String getLlavejson() {
        return llavejson;
    }

    public void setLlavejson(String llavejson) {
        this.llavejson = llavejson;
    }

    public Integer getValorjson() {
        return valorjson;
    }

    public void setValorjson(Integer valorjson) {
        this.valorjson = valorjson;
    }

}


/*
 System.out.println(columnas);
                System.out.println(tiposva);

                //Toma de valores de la llave y el valor para la conversión en JSON
                llavejson = llavenombre.getText();
                valorjson = valornombre.getText();

                //Concatena los valores de llave y valor en formato JSON
                parajson = "{ \"llavejson\":\"" + llavejson + "\"}";


                System.out.println(llavejson + "  " + valorjson);


                //Función para la deserialziación de los datos recibidos
                ObjectMapper mapper = new ObjectMapper();
                try {
                    Valores  mp =  mapper.readValue(parajson, Valores.class);
                    System.out.println(mp.getLlavejson());
                }
                catch (Exception j){

                }
            }
 */