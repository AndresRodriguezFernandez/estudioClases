package Kotlin

fun main(){
    //fase 1
    val notas = mutableMapOf(
        "Ana " to 8,
        "Pedro" to 4,
        "Lucía" to 7,
        "Carlos" to 3,
        "Marta" to 9
    )

    //fase 2
    for ((nombre, nota) in notas){
        println("${nombre}: ${nota}")
    }

    //fase3
    for ((nombre, nota) in notas){
        if (nota >= 5){
            println("${nombre}: ${nota}")
        }
    }

    //fase 4
    for ((nombre, nota) in notas){
        if (nota < 5){
            println("${nombre}: ${nota}")
        }
    }

    //fase 5
    var total = 0;
    for (nota in notas.values){
        total+=nota;
    }
    println("La nota media de la clase es ${total/notas.size}")

    //fase 6
    var nombreM = ""
    var notaM = 0
    for ((nombre, nota) in notas){
       if (nota > notaM){
           nombreM = nombre
           notaM = nota
       }
    }
    println("La nota mayor es ${notaM} y la sacó ${nombreM}")

    //fase 7
    var encontrado = false;
    print("Introduce el nombre de un alumno: ")
    var nombreBuscar = readln().lowercase()
    for ((nombre, nota) in notas){
        if (nombre.lowercase().equals(nombreBuscar)){
            encontrado=true;
            println("${nombre} tiene una nota de ${nota}")
        }
    }
    if (!encontrado){
        println("El alumno no existe")
    }


}