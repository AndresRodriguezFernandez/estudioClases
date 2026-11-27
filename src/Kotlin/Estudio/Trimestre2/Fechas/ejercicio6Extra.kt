package Kotlin.Estudio.Trimestre2.Fechas

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

fun main(){
    var listaFechas = mutableListOf<LocalDate>()
    print("Cuántas fechas quieres introducir?: ")
    var numFechas = readln().toIntOrNull()?:-1
    if (numFechas > 0){
        for (i in 1..numFechas){
            listaFechas.add(leerFecha(i.toString()))
        }
    }
}

fun leerFecha(mensaje: String): LocalDate{
    println(mensaje)
    var valida = false
    var fecha = LocalDate.now()
    do {
        try{
            fecha = LocalDate.parse(readln(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            valida=true
        }catch (e: DateTimeParseException){
            println("Error")
        }
    }while (!valida)
    return fecha
}