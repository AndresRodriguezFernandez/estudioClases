package Kotlin.Clase.fechas.basico

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

fun main(){
    println("Introduce una fecha(dd/mm/yyyy): ")
    try {
        var fecha = LocalDate.parse(readln(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        println("La fecha es $fecha")
    }catch (e: DateTimeParseException){
        println("Fecha incorrecta.Debes introducila con un formato válido")
    }

}