package PSP.Trimestre1.Clase.iniciadorProcesos;

public class Principal {
    public static void main(String[] args) {
        String ruta = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        iniciadorProcesos lp = new iniciadorProcesos();
        lp.ejecutar(ruta);
        System.out.println("Finalizado");
    }
}
