package Kotlin.Clase.GestionBiblioteca

import Libro

fun main(){
    val librosLista = mutableListOf<Libro>()
    librosLista.add(Libro("Cervantes", "El quijote"))
    librosLista.add(Libro("George Orwell", "1984"))
    librosLista.add(Libro("Tokien", "El Hobbit"))

    var op = 0
    do {
        mostrarMenu()
        op = readln().toIntOrNull()?:0
        if (op > 4 || op < 1){
            println("La opción no está disponbile, por favor, vuelva a introducir una opción correcta.")
        }else{
            when(op){
                1->mostarLibros(librosLista)
                2->prestarLibro(librosLista)
                3->devolerLibro(librosLista)
                4-> println("Hasta pronto :)")
            }
        }
    }while (op != 4)
}

fun mostrarMenu(){
    println("===MENU===")
    println("1. Mostrar datos")
    println("2. Prestar libro")
    println("3. Devolver libro")
    println("4. Salir")
    print("Introduce una opción por el teclado: ")
}

fun mostarLibros(listaLibros: MutableList<Libro>){
    for (libro in listaLibros){
        println(libro.mostrarInformacion())
    }
}

fun prestarLibro(listaLibros: MutableList<Libro>){
    println("Introduce el titulo del libro que deseas mostrar: ")
    var nombre = readln()
    var encontrado = false;
    for (libros in listaLibros){
        if (libros.titulo.uppercase().trim().equals(nombre.trim().uppercase())){
            encontrado=true
            libros.prestar()
        }
    }
    if (!encontrado){
        println("No se ha encontrado el libro <<${nombre}>>")
    }
}

fun devolerLibro(listaLibros: MutableList<Libro>){
    println("Introduce el titulo del libro que deseas devolver: ")
    var titulo = readln().trim().uppercase()
    var encontrado = false
    for (libro in listaLibros){
        if (libro.titulo.uppercase().trim().equals(titulo)){
            encontrado = true
            libro.devolver()
        }
    }
    if (!encontrado){
        println("No se ha encontrado ese libro.")
    }
}