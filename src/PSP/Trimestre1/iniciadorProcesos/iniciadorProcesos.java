package PSP.Trimestre1.iniciadorProcesos;

public class iniciadorProcesos {
    public void ejecutar(String ruta) {
        ProcessBuilder pb;
        try {
            pb = new ProcessBuilder(ruta);
            pb.inheritIO();
            Process p =pb.start();
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
