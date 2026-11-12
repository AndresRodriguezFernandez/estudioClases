package Kotlin.Clase.ej15

fun main(){
    var empleados = listOf<Empleado>(
        Programador("Ana", 1800.0, 10),
        Comercial("Luis", 1500.0, 20000.0)
    )

    for (empleado in empleados){
        empleado.mostrardatos()
    }
}