package Kotlin.Clase.ej15

class Comercial(nombre:String, sueldoBase:Double, var ventas: Double): Empleado(nombre, sueldoBase) {
    override fun calcularSueldo(): Double {
        return (super.calcularSueldo()+(5*ventas/100))
    }
}