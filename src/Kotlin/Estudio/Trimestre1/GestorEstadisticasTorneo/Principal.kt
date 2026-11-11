package Kotlin.Estudio.Trimestre1.GestorEstadisticasTorneo

fun main(){
    //1
    var resultados = arrayOf(
        intArrayOf(0, 1, 2),
        intArrayOf(5, 6, 3),
        intArrayOf(3, 6, 1),
        intArrayOf(3, 5, 3),
        intArrayOf(3, 1, 3)
    )

    var totalesJugadores = intArrayOf(0, 0, 0)

    for (i in resultados.indices){
        for (j in resultados[i].indices){
            print(" " + resultados[i][j])
            totalesJugadores[j] += resultados[i][j]
        }
        println()
    }

    println("Puntuaciones totales: ")
    for (total in totalesJugadores){
        print(" "+total)
    }

    //2 no aplicable al examen
    println()
    println()
    println("Puntuaciones ordenados descendientes")
    var listaDescendiente = totalesJugadores.sortedDescending()
    for (total in listaDescendiente){
        println(" "+total)
    }

}