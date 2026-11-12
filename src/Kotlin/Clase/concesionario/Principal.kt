package Kotlin.Clase.concesionario

fun main(){
    var listaCoches = mutableListOf<Coche>(
        Coche("1234ABC", "Mercedes", "G63", 200000.00),
        Coche("5678DFEG", "Nissan", "R34", 150000.0),
        Coche("4321CBA", "Toyota", "Supra", 60000.0)
    )
    var op: Int
    do {
        mostrarMenu()
        op = readln().trim().toIntOrNull()?:-1
        if (op < 1){
            println("Has introducido una opción no válida.")
        }else{
            when(op){
                1->anadirCoche(listaCoches)
                2->mostrarTodosCoches(listaCoches)
                3->buscarCochePorMatricula(listaCoches)
            }
        }
    }while (op != 7)
}

fun mostrarMenu(){
    println("1. Añadir coche")
    println("2. Mostrar todos los coches")
    println("3. Buscar un coche por matricula")
    println("4. Modificar el precio de un coche")
    println("5. Eliminar un coche")
    println("6. Buscar coches por precio máximo")
    println("7. Salir")
    println("Introduce una opción")
}

fun anadirCoche(listaCoche: MutableList<Coche>){
    print("Introduce la matrícula: ")
    var mat = readln().uppercase().trim()
    print("Introduce la marca: ")
    var marca = readln().trim()
    print("Inttroduce el modelo: ")
    var modelo = readln().trim()
    print("Introduce el precio: ")
    var precio = readln().trim().toDoubleOrNull()?:-1.0
    if (precio < 0.00){
        println("El precio no es válido")
    }else{
        listaCoche.addLast(Coche(mat, marca, modelo, precio))

    }
}

fun mostrarTodosCoches(listaCoche: MutableList<Coche>){
    for (coche in listaCoche){
        coche.mostrarDatos()
    }
}

fun buscarCochePorMatricula(listaCoche: MutableList<Coche>){
    print("Introduce la mátricula: ")
    var mat = readln().trim()
    //if (listaCoche.)
}