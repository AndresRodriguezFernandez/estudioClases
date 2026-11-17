package Kotlin.Estudio.Trimestre1.practicaExamen.gestionTienda

fun main(){
    var videojuego = Videojuego()
    var lista = mutableListOf<Videojuego>(
        Videojuego("Euro Truck Simulator 2", "PC", 19.99),
        Videojuego("GTAVI", "PS5", 69.99),
        Videojuego("CS2", "PC", 0.0)
    )
    var op: Int
    do {
        menu()
        op = readln().trim().toIntOrNull()?:-1
        if (op > 0){
            when(op){
                1->
            }
        }
    }while (op != 5)

}

fun menu(){
    println("1. Mostar catalogo")
    println("2. Vender juego")
    println("3. Reponer juego")
    println("4. Buscar por plataforma")
    println("5. Salir")
    print("Introduce una opcion: ")
}

fun mostr
