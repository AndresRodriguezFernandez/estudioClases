package Kotlin.Estudio.CompaDescuento

fun main(){
    var lista = listOf<Double>(12.50, 13.99, 8.99, 1.99, 97.90, 89.90)

    var totalPagar = calcularTotal(lista)
    println("Total SIN descuento: ${totalPagar}")
    if (totalPagar >= 100){
        println("Se aplicó el descuento.")
        println("Total CON descuento: ${totalPagar-(10*totalPagar/100)}")
    }else{
        println("No se aplicó el descuento.")
    }

}

fun calcularTotal(listaPrecios: List<Double>):Double{
    var total = 0.00
    for (i in listaPrecios){
        total+=i
    }
    return total
}