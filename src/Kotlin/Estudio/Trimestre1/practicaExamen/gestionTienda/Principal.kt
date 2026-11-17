package Kotlin.Estudio.Trimestre1.practicaExamen.gestionTienda

fun main(){
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
                1->mostrarTodo(lista)
                2->venderJuego(lista)
                3->reponerJuego(lista)
                4->buscarPorPlataforma(lista)
                5-> println("Hasta pronto! :))")
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

fun mostrarTodo(lista: MutableList<Videojuego>){
    for (videojuego in lista){
        println(videojuego.mostrarInfo())
    }
}

fun venderJuego(list: MutableList<Videojuego>){
    print("Introduce el titulo del videojuego a vender: ")
    var titulo = readln().trim().uppercase()
    var encontrado = false
    for (videojuego in list){
        if (videojuego.getTitulo().uppercase().equals(titulo)){
            encontrado=true
            videojuego.venderUnidad()
        }
    }
    if (!encontrado){
        println("No se ha encontrado el videojuego")
    }
}

fun reponerJuego(lista: MutableList<Videojuego>){
    print("Introduce el titulo del videojuego a reponer: ")
    var titulo = readln().trim().uppercase()
    var encontrado = false
    for (videojuego in lista){
        if (videojuego.getTitulo().uppercase().equals(titulo)){
            encontrado=true
            videojuego.reponerStock()
        }
    }
    if (!encontrado){
        println("No se ha encontrado el videojuego")
    }
}

fun buscarPorPlataforma(lista: MutableList<Videojuego>){
    print("Introduce la plataforma: ")
    var plataforma = readln().trim().uppercase()
    var encontrado = false
    for (videojuego in lista){
        if (videojuego.getPlataforma().uppercase().equals(plataforma.uppercase())){
            println(videojuego.mostrarInfo())
            encontrado=true
        }
    }
    if (!encontrado){
        println("No se ha encontrado ningún videojuego para ${plataforma}")
    }
}
