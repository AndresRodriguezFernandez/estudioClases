package Kotlin.Estudio.Trimestre1.CalculadoraGymConversion

fun main(){
    var op = 0
    do {
        op = mostrarMenu()
        when(op){
            1-> {
                print("Introduce tu edad: ")
                var edad = readln().toIntOrNull()?:-1
                print("¿Deseas entrandor personal? (S/N): ")
                var entrenador = false
                var respuesta = readln().trim().uppercase()
                if (respuesta.equals("S")){
                    entrenador = true
                }else if (respuesta.equals("N")){
                    entrenador=false
                }else{
                    println("No se entendió la respuesta por lo que se presupone que no se quiere entrenador.")
                }
                println("Total de la cuota: ${calcularCuota(edad, entrenador)}€")
            }
            2->{
                print("Introduce un peso en kilogramos: ")
                var peso = readln().toDoubleOrNull()?:0.0
                if (peso <= 0.0){
                    println("Se ha introducido un peso no válido")
                }else{
                    fun kgALibras(kg: Double) = kg*2.20462
                    println("Ese peso en libras son: ${kgALibras(peso)}")
                    fun kgAGramos(kg: Double) = kg*1000
                    println("Ese peso en gramos son: ${kgAGramos(peso)}")
                }
            }
            3-> println("Hasta pronto! :))")
            else -> println("Esa opción no existe.")
        }
    }while (op != 3)
}

fun calcularCuota(edad:Int, conMonitor: Boolean = false): Double{
    var total = 0.00
    if (edad < 0){
        println("La edad es menor que 0 por lo que el cálculo enn la función calcularCuota saldrá 0.00")
    }else{
        when (edad){
            in 0..17 ->total+=20
            in 18..64 ->total+=35
            else-> total+=15
        }
    }
    if (conMonitor){
        total+=15;
    }
    return total
}

fun mostrarMenu():Int{
    println("1. Calculadora de cuota del gym.")
    println("2. Conversor de unidades.")
    println("3. Salir")
    print("Introduce una opción: ")
    var op = readln().trim().toIntOrNull()?:0
    return op
}