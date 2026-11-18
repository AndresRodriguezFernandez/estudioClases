package Kotlin.Estudio.Trimestre1.practicaExamen.AlquilerVehiculos

open class Vehiculo(var matricula:String, var diasAlquiler:Int) {

    open fun calcularPrecio(): Double{
        return diasAlquiler*30.0
    }

    fun mostrarFactura(){
        println("Matrícula: ${matricula}")
        println("Precio final: ${calcularPrecio()}")
    }


}