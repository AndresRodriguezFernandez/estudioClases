package Kotlin.Estudio.Trimestre1.practicaExamen.gestionTienda

class Videojuego (var titulo:String, var plataforma:String, var precio:Double){
    private var disponible = true

    fun venderUnidad(){
        if (disponible){
            disponible=false
            println("Venta realizada")
        }else{
            println("El producto no se puede vender porque no está disponible")
        }
    }

    fun reponerStock(){
        disponible=true
        println("El videojuego vuelve a estar disponible")
    }

    fun mostrarInfo(){
        println("Titulo: ${titulo} | Plataforma: ${plataforma} | Precio: ${precio} |")
        if (disponible){
            print(" Estado: Disponible")
        }else{
            print(" Estado: Vendido")
        }
    }
}