package Kotlin.Clase.gestionGastosEstudiante

fun main(){
    var banco = Banco()
    println("=================" +
            "GESTOR DE DINERO" +
            "=================")

    var op: Int
    do {
        mostrarMenu()
        op = readln().trim().toIntOrNull()?:-1
        if (op < 1){
            println("La opción introducida no es correcta")
        }else{
            when(op){
                1-> banco.anadirIngreso()
                2->banco.anadirGasto()
                3->banco.verMovimientos()
                4-> println("El saldo es de ${banco.verSaldo()}€")
                5->banco.buscarGasto()
                6-> println("Hasta pronto! :))")
            }
        }
    }while (op != 6)
}

fun mostrarMenu(){
    println("1. Añadir ingreso")
    println("2. Añadir gasto")
    println("3. Ver movimientos")
    println("4. Ver saldo")
    println("5. Buscar gasto")
    println("6. Salir")
    println("Introduce una opción: ")
}


