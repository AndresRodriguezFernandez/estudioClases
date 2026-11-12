package Kotlin.Clase.gestionGastosEstudiante

class Banco(){
    var saldo = 0.0
    var ingresos = mutableMapOf<String, Double>()
    var gastos = mutableMapOf<String, Double>()

    fun anadirIngreso(){
        println()
        print("¿Cuánto dinero quieres ingresar?: ")
        var cantidad = readln().trim().toDoubleOrNull()?:-1.0
        if (cantidad<=0){
            println("La cantidad introducida no es válida.")
        }else{
            print("¿De dònde viene ese ingreso?: ")
            var procendencia = readln().trim()
            saldo+=cantidad
            ingresos[procendencia] = cantidad
            println("Ingreso añadido")
        }
        println()
    }

    fun anadirGasto(){
        println()
        print("¿Cuánto dinero quieres descontar?: ")
        var cantidad = readln().trim().toDoubleOrNull()?:-1.0
        if (cantidad<=0){
            println("La cantidad introducida no es válida.")
        }else{
            print("¿De dònde viene ese gasto?(Categoría): ")
            var procendencia = readln().trim()
            saldo-=cantidad
            gastos[procendencia] = cantidad
            println("Ingreso añadido")
        }
        println()
    }

    fun verMovimientos(){
        println()
        println("----------")
        println("Ingresos: ")
        for ((procedencia, ingreso) in ingresos){
            println("${procedencia}: ${ingreso}")
        }
        println("----------")
        println("Gastos:")
        for ((procedencia, gasto) in gastos){
            println("${procedencia}: ${gastos}")
        }
        println("Eso es todo.")
        println()
    }

    fun verSaldo(): Double{
        return this.saldo
    }

    fun buscarGasto(){
        println()
        print("¿Qué quieres buscar?(Categoría): ")
        var categoria = readln().trim()
        var encontrado = false
        for ((nombre, valor) in gastos){
            if (nombre.uppercase().equals(categoria.uppercase())){
                println("GASTO|${valor}€|${categoria}")
                encontrado=true
            }
        }
        if (!encontrado){
            println("No se ha encontrado gastos que coincidan")
        }
        println()
    }
}