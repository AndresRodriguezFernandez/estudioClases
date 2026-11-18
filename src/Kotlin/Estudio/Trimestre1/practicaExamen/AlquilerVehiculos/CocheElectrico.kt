package Kotlin.Estudio.Trimestre1.practicaExamen.AlquilerVehiculos

class CocheElectrico(matricula:String, diasAlquiler:Int, var capacidadBateria:Int): Vehiculo(matricula, diasAlquiler) {

    override fun calcularPrecio(): Double {
        return super.calcularPrecio()-(15*super.calcularPrecio()/100)
    }


}