package org.example

import kotlin.random.Random

val tarifas = Tarifas() // se crea una instancia de la clase Tarifas que a|macena las tarifas de las llamadas
val cabinaList = mutableListOf<Cabina>() // se crea una lista mutable de tipo Cabina que almacena las cabinas

// Función auxiliar que busca una cabina por su id
fun buscarCabina(cabinaId: Int): Cabina? {
    for (c in cabinaList) {
        if (c.idCabina == cabinaId) {
            return c
        }
    }
    return null
}

// Función que registra una llamada en una cabina específica
fun registrarLlamada(cabinaId: Int, tipoLlamada: TipoLlamada, duracionMinutos: Double) {
    // Busca la cabina en la lista de cabinas por su id. Si no se encuentra, retorna un mensaje de error.
    val cabina =
        buscarCabina(cabinaId) ?: throw IllegalArgumentException("Cabina no encontrada")  //verifica si la cabina existe

    // Calcula el costo de la llamada según el tipo de llamada y la duración en minutos
    val costo = when (tipoLlamada) {
        TipoLlamada.LOCAL -> tarifas.local * duracionMinutos
        TipoLlamada.LARGA_DISTANCIA -> tarifas.largaDistancia * duracionMinutos
        TipoLlamada.CELULAR -> tarifas.celular * duracionMinutos
    }
    // Crea una nueva llamada con los datos proporcionados y la registra en la cabina
    val llamada = Llamada(cabinaId, tipoLlamada, duracionMinutos, costo)
    cabina.registrarLlamada(llamada)
}

// Función que devuelve la información de una cabina específica
fun informacionCabina(cabinaId: Int): String {
    // Busca la cabina en la lista de cabinas por su id. Si no se encuentra, retorna un mensaje de error.
    val cabina =
        buscarCabina(cabinaId) ?: throw IllegalArgumentException("Cabina no encontrada") //verifica si la cabina existe
    return cabina.Informacion()
}

// Función que devuelve un resumen consolidado de todas las cabinas
fun consolidadoTotal(): String {

    // Suma el número total de llamadas de todas las cabinas.
    var totalLlamadas = 0
    for (cabina in cabinaList) {
        totalLlamadas += cabina.numLlamadas
    }

    // Suma la duración total de todas las llamadas en todas las cabinas.
    var totalDuracion = 0.0
    for (cabina in cabinaList) {
        totalDuracion += cabina.duracionTotalMinutos
    }

    // Suma el costo total de todas las llamadas en todas las cabinas.
    var totalCosto = 0.0
    for (cabina in cabinaList) {
        totalCosto += cabina.costoTotal
    }
    // Calcula el costo promedio por minuto, asegurándose de que la duración total sea mayor que 0 para evitar la división por cero.
    val costoPromedioPorMinuto = if (totalDuracion > 0) totalCosto / totalDuracion else 0.0
    // Devuelve una cadena de texto con el resumen consolidado de todas las llamadas.
    return "Consolidado Total: Llamadas: $totalLlamadas, Duración Total: $totalDuracion minutos, Costo Total: $totalCosto pesos, Costo Promedio por Minuto: $costoPromedioPorMinuto pesos"
}

// Función que reinicia una cabina específica
fun reiniciarCabina(cabinaId: Int) {
    // Busca la cabina en la lista de cabinas por su id.
    val cabina = buscarCabina(cabinaId) ?: return  //verifica si la cabina existe
    cabina.reiniciar()
}

fun main() {
    // Example usage
    cabinaList.add(Cabina(1))
    cabinaList.add(Cabina(2))

    // Generate de manera aleatoria la duracion de las llamadas
    val duracion1 = Random.nextDouble(1.0, 20.0)
    val duracion2 = Random.nextDouble(1.0, 20.0)
    val duracion3 = Random.nextDouble(1.0, 20.0)

    registrarLlamada(1, TipoLlamada.LOCAL, duracion1)
    registrarLlamada(1, TipoLlamada.CELULAR, duracion2)
    registrarLlamada(2, TipoLlamada.LARGA_DISTANCIA, duracion3)

    println(informacionCabina(1))
    println(informacionCabina(2))
    println(consolidadoTotal())

    reiniciarCabina(1)
    println(informacionCabina(1))
}