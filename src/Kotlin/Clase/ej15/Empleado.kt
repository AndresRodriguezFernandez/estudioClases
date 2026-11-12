package Kotlin.Clase.ej15

open class Empleado (var nombre:String, var sueldoBase:Double){
    open fun calcularSueldo(): Double {
        return this.sueldoBase;
    }

    fun mostrardatos(){
        println("${nombre} tiene un sueldo de ${calcularSueldo()}€")
    }
}