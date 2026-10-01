package PSP.Trimestre1.LibroEstudio.Capitulo2.actividad2_5;

public class NumeroOculto {
    private int identificador;
    private int numeroOculto;
    private boolean adivinado = false;

    NumeroOculto(int ident, int num) {
        this.identificador = ident;
        this.numeroOculto=num;
    }

    NumeroOculto(){}

    public synchronized int propuestaNumero(int num, int identif) {
        if(identif == this.identificador) {
            if(num == this.numeroOculto && !adivinado) {
                adivinado = true;
                return 1;
            }else if  (adivinado) {
                return -1;
            }else{
                return 0;
            }
        }else{
            return getidentificador();
        }
    }

    public synchronized int getidentificador() {
        return this.identificador;
    }

    public void setidentificador(int ident){
        this.identificador=ident;
    }

    public void setnumeroOculto(int numOc){
        this.numeroOculto=numOc;
    }

    public boolean getadivinado(){
        return this.adivinado;
    }
}
