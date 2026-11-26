package Kotlin.Estudio.Trimestre2.Fechas

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

fun main(){
    var fechaInicioValida = false
    var fecha = LocalDate.now()
    do {
        try{
            print("Introduce una fecha de inicio del plzo (dd/MM/yyyy): ")
            fecha = LocalDate.parse(readln(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            fechaInicioValida=true
        }catch (e: DateTimeParseException){
            println("Debes introducir la fecha en el formato correcto.")
        }
    }while (!fechaInicioValida)

    println()
    var anios: Int
    do {
        print("Introduce los años del plazo: ")
        anios = readln().trim().toIntOrNull()?:-1
    }while (anios ==-1 || anios < 0)

    println()
    var meses: Int
    do {
        print("Introduce los meses del plazo: ")
        meses = readln().trim().toIntOrNull()?:-1
    }while (meses==-1 || meses < 0)

    println()
    var dias: Int
    do {
        print("Introduce los dias del plazo: ")
        dias = readln().trim().toIntOrNull()?:-1
    }while (dias ==-1 || dias < 0)

    var fechaVencimiento = fecha.plusYears(anios.toLong())
    fechaVencimiento = fechaVencimiento.plusMonths(meses.toLong())
    fechaVencimiento = fechaVencimiento.plusDays(dias.toLong())
    val fechaFormateada = fechaVencimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    println("Fecha de vencimiento del plazo: $fechaFormateada")

    if (fechaVencimiento.dayOfWeek.value == 6 || fechaVencimiento.dayOfWeek.value == 7){
        println("AVISO: La fecha de vencimiento del plazo cae en fin de semana.")
    }
}