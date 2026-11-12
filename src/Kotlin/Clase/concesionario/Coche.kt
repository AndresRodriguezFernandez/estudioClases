package Kotlin.Clase.concesionario

class Coche (var matricula:String, var marca:String, var modelo:String, var precio:Double){
    fun mostrarDatos(){
        println("Mátricula: ${matricula}, Marca: ${marca}, Modelo: ${modelo}, Precio: ${precio}")
    }
}