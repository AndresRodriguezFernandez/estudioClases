package Kotlin.Estudio.Trimestre1.GestorNotas

fun main(){
    var notas = mutableMapOf<String, Double>(
        "Ana" to 8.5,
        "Luis" to 4.2,
        "Marta" to 9.0
    )

    var op: Int
    do {
        mostrarMenu()
        op = readln().trim().toIntOrNull()?:-1
        if (op != -1){
            when(op){
                1->anadirAlumno(notas)
                2->mostrarBoletinNotas(notas)
                3->obtenerEstadisticas(notas)
                4-> println("Hasta pronto! :))")
            }
        }else {
            println("La opción introducida es incorrecta.")
        }
    }while (op != 4)

}

fun obtenerCalificacion(nota:Double){
    when(nota){
        in 0.0..5.0-> println("Suspenso")
        in 5.0..6.9 -> println("Aprobado")
        in 7.0..8.9-> println("Notable")
        in 9.0..10.0-> println("Sobresaliente")
        else -> println("Nota no válida.")
    }
}

fun mostrarMenu(){
    println("1. Añadir/modificar alumno")
    println("2. Mostar boletin de notas")
    println("3. Ver estadisticas rápidas")
    println("4. Salir")
    println("Introduzca una opción: ")
}

fun anadirAlumno(notas: MutableMap<String, Double>){
    print("Introduce el nombre del alumno: ")
    var nombre = readln().trim()
    if (notas.containsKey(nombre)){
        println("Introduce la nota para modificarla: ")
        var nota = readln().trim().toDoubleOrNull()?:-1.0
        if (nota != -1.0 && nota > 0.0){
            notas[nombre] = nota
        }else{
            println("La nota no está en un rango aceptable.")
        }
    }else{
        println("Introduce la nota para añadir al alumno: ")
        var nota = readln().trim().toDoubleOrNull()?:-1.0
        if (nota != -1.0 && nota > 0.0){
            notas[nombre] = nota
        }else{
            println("La nota no está en un rango aceptable.")
        }
    }
}

fun mostrarBoletinNotas(notas: MutableMap<String, Double>){
    for ((nombre, nota) in notas){
        println("${nombre} está ${obtenerCalificacion(nota)}")
    }
}

fun obtenerEstadisticas(notas: MutableMap<String, Double>){
    println("Tamaño de la lista: ${notas.size}")
    var notaMedia = 0.0
    for (nota in notas.values){
        notaMedia+=nota
    }
    println("Nota media de la clase: "+notaMedia/notas.size)
    println(notas.entries.sortedByDescending { it.value })
}