package Kotlin.Estudio.Trimestre1.practicaExamen.AlquilerVehiculos

fun main(){
    var vehciulos = mutableListOf<Vehiculo>(
        Coche("1234ABC", 3, "GASOLINA"),
        Coche("2345BCD", 4, "DIESEL"),
        CocheElectrico("9876CBD", 2, 12000)
    )

    for (vehiculo in vehciulos){
        println(vehiculo.mostrarFactura())
    }

    var op: Int
    do {
        menu()
        op = readln().trim().toIntOrNull()?:-1
        if (op < 0){
            when(op){
                1->anadirVehiculo(vehciulos)
                2->calcularTotal(vehciulos)
            }
        }else{
            println("La opción introducida no es correcta")
        }
    }while (op != 3)
}

fun menu(){
    println("1. Añadir coche")
    println("2. Total facturado: ")
    println("3. Salir")
}

fun anadirVehiculo(lista: MutableList<Vehiculo>){
    print("De que tipo quieres que sea el coche?(Normal/electrico): ")
    var tipo = readln().trim().uppercase()
    if (tipo.equals("ELECTRICO")){
        print("Introduce la matricula: ")
        var mat = readln().trim().uppercase()
        println("Introduce los dias que quieres alquilarlo: ")
        var dias = readln().trim().toIntOrNull()?:-1
        if (dias<0){
            println("Los días introducidos no son válidos")
        }else{
            print("Introduce la capacidad de la bateria: ")
            var capacidad = readln().trim().toIntOrNull()?:-1
            if (capacidad<0){
                println("La capacidad introducida no es correcta")
            }else{
                lista.add(CocheElectrico(mat, dias, capacidad))
            }
        }
    }else if (tipo.equals("NORMAL")){
        print("Introduce la matricula: ")
        var mat = readln().trim().uppercase()
        println("Introduce los dias que quieres alquilarlo: ")
        var dias = readln().trim().toIntOrNull()?:-1
        if (dias<0){
            println("Los días introducidos no son válidos")
        }else{
            print("Introduce el tipo de combustible: ")
            var combustible = readln().trim().uppercase()
            lista.add(Coche(mat, dias, combustible))
        }
    }
}

fun calcularTotal(lista: MutableList<Vehiculo>){
    var total = 0.0
    for (vehiculo in lista){
        total+=vehiculo.calcularPrecio()
    }
    println("Total: ${total}")
}