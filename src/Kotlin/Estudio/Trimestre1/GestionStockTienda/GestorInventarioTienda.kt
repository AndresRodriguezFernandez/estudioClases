package Kotlin.Estudio.Trimestre1.GestionStockTienda

fun main(){
    var inventario = mutableMapOf<String, Int>(
        "TECLADO" to 15,
        "RATON" to 20,
        "DISCO DURO" to 19,
        "MONITOR" to 5
    )

    var op = 0
    do {
        mostrarMenu()
        op = readln().trim().toIntOrNull()?:0
        if (op < 1 || op > 6){
            println("Esa opción no existe.")
        }else{
            when(op){
                1->anadirActualizarProducto(inventario)
                2->venderProducto(inventario)
                3->mostrarInventarioStock(inventario)
                4->mostrarInventarioAlfabeticamente(inventario)
                5->alertaBajoStock(inventario)
                6-> println("Hasta pronto! :))")
            }
        }
    }while(op != 6)
}

fun mostrarMenu(){
    println("1. Añadir o actualizar producto.")
    println("2. Vender producto.")
    println("3. Mostrar inventario ordenador por stock (de mayor a menor)")
    println("4. Mostrar productos ordenados alfabeticamente.")
    println("5. Alerta de bajo stock.")
    println("6. Salir")
    println("Introduce una opción: ")
}

fun anadirActualizarProducto(inventario: MutableMap<String, Int>){
    print("Introduce el nombre del producto que desea añadir o actualizar: ")
    var nombreP = readln().trim().uppercase()
    if (inventario.containsKey(nombreP)){
        print("Introduce las unidades a añadir: ")
        var uds = readln().toIntOrNull()?:-1
        if (uds <1){
            println("Número de unidades no válido.")
        }else{
            inventario[nombreP] = inventario.getValue(nombreP) + uds
        }
        println("Cantidad añadida al inventario.")
    }else{
        println("Añadiendo nuevo producto...")
        print("Introduce la cantida del producto a añadir al inventario: ")
        var uds = readln().trim().toIntOrNull()?:-1
        if (uds <1){
            println("Número de unidades no válido.")
        }else{
            inventario[nombreP] = uds
        }
        println("Cantidad añadida al inventario y producto creado.")
    }
}

fun venderProducto(inventario: MutableMap<String, Int>){
    print("Introduce el nombre del producto a vender: ")
    var nombreP = readln().trim().uppercase()
    if (inventario.containsKey(nombreP)){
        print("Introduce las unidades a vender: ")
        var uds = readln().trim().toIntOrNull()?:-1
        if (uds > 0){
            inventario[nombreP] = inventario.getValue(nombreP) - uds
            println("Cantidad restada.")
            if (inventario.getValue(nombreP) == 0){
                inventario.remove(nombreP)
            }
        }else{
            println("Cantidad no válida.")
        }
    }else{
        println("No se encontró ese producto.")
    }
}

fun mostrarInventarioStock(inventario: MutableMap<String, Int>){
    var listaOrdenada = inventario.entries.sortedByDescending { it.value }
    for ((nombre, cantidad) in listaOrdenada){
        println("Hay ${cantidad} ${nombre.lowercase()}")
    }
}

fun mostrarInventarioAlfabeticamente(inventario: MutableMap<String, Int>){
    var listaOrdenada = inventario.entries.sortedBy { it.key }
    for ((nombre, cantidad) in listaOrdenada){
        println("Hay ${cantidad} ${nombre.lowercase()}")
    }
}

fun alertaBajoStock(inventario: MutableMap<String, Int>){
    println("Hay menos de 5 unidades de: ")
    for ((nombre, cantidad) in inventario){
        if (cantidad < 5){
            println("${nombre}: ${cantidad}")
        }
    }
}