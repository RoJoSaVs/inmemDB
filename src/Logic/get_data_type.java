package Logic;

public class get_data_type {
    public static void main(String[] args){
        String data="dfs";
        get_type(data);
    }

    public static String get_type(String data){
        String tipo="";
        if(data.equals("")){
            tipo="vacio";
        }
        try{
            if(tipo.equals("")){
                Integer.parseInt(data);
                tipo="int";
            }
        }
        catch (Exception e){ }

        try{
            if(tipo.equals("")){
                Float.parseFloat(data);
                tipo="float";
            }
        }
        catch (Exception e){}
        try{
            if(tipo.equals("")){
                Double.parseDouble(data);
                tipo="double";
            }
        }
        catch (Exception e){}
        try{
            if(tipo.equals("")){
                Long.parseLong(data);
                tipo="long";
            }
        }
        catch (Exception e){}
        try{
            if(tipo.equals("")){
                Float.parseFloat(data);
                tipo="float";
            }
        }
        catch (Exception e){}

        if(tipo.equals("")){
            tipo="string";
        }
        System.out.println(tipo);
        return tipo;

    }
}
