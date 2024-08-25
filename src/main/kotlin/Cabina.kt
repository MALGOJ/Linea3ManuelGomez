package org.example

class Cabina(val idCabina: Int) {
    var numLlamadas: Int = 0
    var duracionTotalMinutos: Double = 0.0
    var costoTotal: Double = 0.0

    fun registrarLlamada(llamada: Llamada) { //se toma un parametro de tipo de clase Llamada
        // Incrementa el contador de llamadas en 1
        numLlamadas++
        // Suma la duración de la nueva llamada a la duración total de todas las llamadas
        duracionTotalMinutos += llamada.duracionMinutos
        // Suma el costo de la nueva llamada al costo total de todas las llamadas
        costoTotal += llamada.costo
    }

    fun reiniciar() {
        // Establece el contador de llamadas a 0
        numLlamadas = 0
        // Establece la duración total de las llamadas a 0.0 minutos
        duracionTotalMinutos = 0.0
        // Establece el costo total de las llamadas a 0.0 pesos
        costoTotal = 0.0
    }

    fun Informacion(): String {
        // Devuelve una cadena de texto que incluye el ID de la cabina, el número de llamadas realizadas,
        // la duración total de las llamadas en minutos y el costo total de las llamadas en pesos.
        return "Cabina $idCabina: Llamadas: $numLlamadas, Duración Total: $duracionTotalMinutos minutos, Costo Total: $costoTotal pesos"
    }
}