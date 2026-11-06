class Libro(var autor:String, var titulo:String){
    private var prestado = false;

    fun prestar(){
        if (prestado){
            println("Este libro ya está prestado")
        }else{
            prestado=true
            println("Libro prestado")
        }
    }

    fun devolver(){
        if (this.prestado){
            prestado=false;
            println("El libro se ha devuelto correctamente")
        }else{
            println("El libro ya estaba disponible, no hace falta devolverlo.")
        }
    }

    fun getPrestado(): Boolean{
        return this.prestado
    }

    fun mostrarInformacion(){
        println("Título: ${this.titulo} | Autor: ${this.autor} | Prestado: ${getPrestado()}")
    }
}