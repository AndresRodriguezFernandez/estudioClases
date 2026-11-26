package Kotlin.Estudio.Trimestre2.Fechas

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.temporal.IsoFields

fun main(){
    var fechaCorrecta = false
    do {
        try{
            print("Introduce una fecha por teclado (dd/MM/yyyy): ")
            //usamos val en vez de var ya que fecha no se areasigna o cambia el valor
            val fecha = LocalDate.parse(readln(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            fechaCorrecta=true
            println("Dia del año: ${fecha.dayOfYear}")
            println("Semana del año: ${fecha.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR)}")
        }catch(e: DateTimeParseException){
            println("Fecha incorrecta: Debes escribirla como dd/MM/yyyy")
        }
    }while(!fechaCorrecta)
}