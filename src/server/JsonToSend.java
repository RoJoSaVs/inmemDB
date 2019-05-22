package server;

import java.util.ArrayList;

public class JsonToSend <T> {
    public Object [] g_paracolumnas;
    public String[] parafilas;
    public String g_titulo;
    public ArrayList<String> tipos;
    public int g_conteo;

    public Object[] getG_paracolumnas() {
        return g_paracolumnas;
    }

    public void setG_paracolumnas(Object[] g_paracolumnas) {
        this.g_paracolumnas = g_paracolumnas;
    }

    public String[] getG_parafilas() {
        return parafilas;
    }

    public void setG_parafilas(String[] parafilas) {
        this.parafilas = parafilas;
    }

    public String getG_titulo() {
        return g_titulo;
    }

    public void setG_titulo(String g_titulo) {
        this.g_titulo = g_titulo;
    }

    public ArrayList<String> getTipos() {
        return tipos;
    }

    public void setTipos(ArrayList<String> tipos) {
        this.tipos = tipos;
    }

    public int getG_conteo() {
        return g_conteo;
    }

    public void setG_conteo(int g_conteo) {
        this.g_conteo = g_conteo;
    }
}