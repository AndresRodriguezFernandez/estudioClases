package Kotlin.Estudio.Trimestre2.Fechas

import java.time.LocalDate

fun main(){
    val fecha = LocalDate.of(2007, 7, 13)
    //1
    println("Día: ${fecha.dayOfMonth}, Mes: ${fecha.monthValue}, Año: ${fecha.year}")
    //2
    println("Día de la semana como número: ${fecha.dayOfWeek.value}")
    //3
    println("Es bisiesto: "+fecha.isLeapYear)
}