package Kotlin.Estudio.Trimestre2.Fechas

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.temporal.ChronoUnit

fun main(){
    var listaFechas = mutableListOf<LocalDate>()
    print("Cuántas fechas quieres introducir?: ")
    var numFechas = readln().toIntOrNull()?:-1
    if (numFechas > 0){
        for (i in 1..numFechas){
            listaFechas.add(leerFecha(i.toString()))
        }
        var fechasPasadas = 0
        var fechasPorLlegar = 0
        var fechaHoy = 0
        for(fecha in listaFechas){
            if (fecha == LocalDate.now()){
                fechaHoy++
            }else if (fecha > LocalDate.now()){
                fechasPorLlegar++
            }else{
                fechasPasadas++
            }
        }
        println("Fechas pasadas: $fechasPasadas")
        println("Fechas por llegar: $fechasPorLlegar")
        println("Fecha de hoy: $fechaHoy")
        for (fecha in listaFechas){
            println(fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
            println("Días transcurridos entre la fecha actual y la introducida: " +
                    "${ChronoUnit.DAYS.between(LocalDate.now(), fecha)}")
        }
    }else{
        println("Número de fechas no válido")
    }
}

fun leerFecha(mensaje: String): LocalDate{
    print("Fecha $mensaje : ")
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