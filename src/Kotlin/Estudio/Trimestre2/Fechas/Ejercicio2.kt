package Kotlin.Estudio.Trimestre2.Fechas

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.IsoFields

fun main(){
    print("Introduce una fecha por teclado (dd/MM/yyyy): ")
    //usamos val en vez de var ya que fecha no se areasigna o cambia el valor
    val fecha = LocalDate.parse(readln(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))

    println("Dia del año: ${fecha.dayOfYear}")
    println("Semana del año: ${fecha.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR)}")
}