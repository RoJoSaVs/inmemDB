package Logic;

public class ArbolAVL {
    private Nodo2 raíz;

    public void  AVL (){
        raíz = null;
    }
    public void insertar(int nuevoM){
        if(raíz==null){
            raíz =  new Nodo2(nuevoM);
        }
        else{
            insertar(raíz,nuevoM);
        }
    }
    private void insertar(Nodo2 rz, int nm){
        if (rz == null)
            rz = new Nodo2(nm);
        else if(nm < rz.numMat)
            insertar(rz.izqda,nm);
        else if(nm > rz.numMat)
            insertar(rz.drcha,nm);
        else
            System.out.println("Numero Duplicados");
    }
    public void visualizar(){
        if(raíz!=null)
            raíz.re_enorden();
    }
}