package Kotlin.Estudio.Trimestre2.Fechas

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.temporal.ChronoUnit

fun main(){
    var fechaInicioValida = false
    var fechaInicio = LocalDate.now()
    do {
        try{
            print("Introduce la fecha de inicio (dd/MM/yyyy): ")
            fechaInicio = LocalDate.parse(readln(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            fechaInicioValida=true
        }catch(e: DateTimeParseException){
            println("La fecha introducida no tiene el formato correcto, vuelva a introducirla.")
        }
    }while (!fechaInicioValida)

    var fechaFin = LocalDate.now()
    var fechaFinValida=false
    do {
        try{
            print("Introduce la fecha de fin (dd/MM/yyyy): ")
            fechaFin = LocalDate.parse(readln(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            fechaFinValida=true
        }catch(e: DateTimeParseException){
            println("La fecha introducida no tiene el formato correcto, vuelva a introducirla.")
        }
    }while (!fechaFinValida)

    if (fechaFin < fechaInicio){
        println("La fecha de inicio es posterior que la fecha final.")
    }else if(fechaInicio == fechaFin){
        println("La fecha de inicio es igual a la fecha de fin.")
    }else if(fechaInicio < fechaFin){
        println("La fecha de inicio es anterior que la fecha de fin.")
        val periodo = Period.between(fechaInicio, fechaFin)
        println("Periodo: ${periodo.years} años, ${periodo.months} meses y ${periodo.days} días. ")
        val dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin)
        println("Días de diferencia: $dias")
    }
}