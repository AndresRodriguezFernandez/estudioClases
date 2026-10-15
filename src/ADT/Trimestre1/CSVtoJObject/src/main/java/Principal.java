import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[]args){
        List<PersonaCSV> lista = new ArrayList<>();
        lista.add(new PersonaCSV("Ana", 23));
        lista.add(new PersonaCSV("Pepe", 45));

        try{
            Writer escritor = Files.newBufferedWriter(Paths.get("personas.csv"));
            StatefulBeanToCsv<PersonaCSV> escritorCSV = new StatefulBeanToCsvBuilder<PersonaCSV>(escritor).withApplyQuotesToAll(false).build();
            escritorCSV.write(lista);
            escritor.close();
        } catch (CsvRequiredFieldEmptyException e) {
            throw new RuntimeException(e);
        } catch (CsvDataTypeMismatchException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
