package Kotlin.Estudio.Trimestre1.practicaExamen.AlquilerVehiculos

class Coche(matricula:String, diasAlquiler:Int, var tipoCombustible:String) : Vehiculo(matricula, diasAlquiler){

    override fun calcularPrecio():Double{
        if (this.tipoCombustible.equals("DIESEL")){
            return super.calcularPrecio()+(diasAlquiler*10.0)
        }else{
            return super.calcularPrecio()
        }
    }


}