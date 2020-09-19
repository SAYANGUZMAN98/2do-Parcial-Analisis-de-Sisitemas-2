package Genericos;


public class Mierror extends Throwable{

    public Mierror(String MsMError, Throwable e) {
    super(MsMError, e);
    }
   
    public Mierror(String MsMError, Throwable e,Integer n) {
    super(MsMError, e);
        switch (n){
            case 1:
                 //programar la accion a seguir
                break;
            case 2:
                //programar la accion a seguir
                break;
            case 3:
                //programar la accion a seguir
                break;
        }
    }

}
