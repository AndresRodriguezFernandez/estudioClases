package Kotlin.Tragaperras

fun main(){
    println("===🎰MAQUINA TRAGAPERRAS🎰====")
    do {
        print("Introduce un número de jugadas: ")
        var num = readln().toIntOrNull()
        if (num != null && num > 0) {
            resultado(num)
        }else if (num == 0) {
            println("Gracias por juagr. Vuelve pronto! ;)")
        } else {
            println("Número de tiradas incorrecto.")
        }
    }while (num != 0)
}

fun resultado(num: Int) {
    var partidasGanadas = 0
    var resultados = arrayOf("🍋", "7️⃣", "🍒")
    for (i in 1..num) {
        println("Tirando...")
        Thread.sleep(4000)
        var numero1 = (0..2).random()
        var numero2 = (0..2).random()
        var numero3 = (0..2).random()
        print("Partida ${i} : ")
        print(resultados[numero1])
        print(resultados[numero2])
        print(resultados[numero3])
        println()
        if (numero1 == numero2 && numero2 == numero3) {
            println("=====😎HAS GANADOOOOOOOOO!!!!!😎======")
            print("😎+100000 AURA")
            partidasGanadas++
            println()
        }else{
            println("😔Inténtalo de nuevo")
        }
        println()

    }
    println("🏅Partidas ganadas: ${partidasGanadas}")
    println()
    if (partidasGanadas != 0) {
        var aura = (100..100000).random()
        println("🛡️Aura ganada: ${aura}")
        println()
    }
}