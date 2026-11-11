package Kotlin.Estudio.Trimestre1.ValidadorCredenciales

fun main(){
    var password: String

    //creacion del  nombre de usuario
    println("====CREAR CUENTA====")
    println("Introduce un nombre de usuario: ")
    var nombreusuario = readln().trim()

    //creacion de la password
    var passwordValida = false
    do {
        println("Introduce una contraseña: ")
        println("(Debe tener más de 7 caracteres, tener al menos 2 vocales y no contener espacios)")
        password = readln()
        passwordValida = validarPassword(password)
        if (!passwordValida){
            println("La contraseña no cumple con los requisitos, vuelva a introducir una contraseña.")
        }
    }while(!passwordValida)
    println("----CUENTA CREADA------")

    //==========INICIO DE SESION=================
    var intentos = 3
    var sesionIniciada = false

    while (intentos > 0){
        var usuarioCorrecto = false
        var passwordCorrecta = false
        println()
        println()
        println("=====INICIO DE SESIÓN=====")
        println("Introduce tu nombre de usuario: ")
        var usuario = readln().trim()
        if (usuario.equals(nombreusuario)){
            usuarioCorrecto=true
        }
        println("Introduce tu contraseña: ")
        var passwordIntroducida = readln()
        if (passwordIntroducida.equals(password)){
            passwordCorrecta=true
        }
        if (usuarioCorrecto && passwordCorrecta){
            sesionIniciada = true
            println("Acceso concedido.")
            break
        }else{
            println("Credenciales inválidas, te quedan ${intentos-1} intentos.")
            intentos--
        }
    }

    if (!sesionIniciada){
        println("Cuenta bloqueada.")
    }

}

fun validarPassword(pass: String): Boolean{
    if (pass.length >= 8 && (!pass.trim().contains(" ")) && ((pass.lowercase().count { it in "aeiou" }) >= 2)){
        return true
    }else{
        return false
    }
}