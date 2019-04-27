package Logic;

public class Nodo2 {
    int numMat;
    Nodo2 izqda, drcha;
    public Nodo2(int mat){
        numMat = mat;
        izqda = drcha = null;
    }
    public void re_enorden(){
        if(izqda != null)
            izqda.re_enorden();
        System.out.println("Matricula:   " +numMat);
        if(drcha != null)
            drcha.re_enorden();
    }
}