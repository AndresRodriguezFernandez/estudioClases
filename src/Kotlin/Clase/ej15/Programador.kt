package Kotlin.Clase.ej15

class Programador (nombre:String, sueldoBase:Double, var horasExtra:Int): Empleado(nombre, sueldoBase) {
    override fun calcularSueldo(): Double {
        return (super.calcularSueldo()+(20*horasExtra))
    }
}