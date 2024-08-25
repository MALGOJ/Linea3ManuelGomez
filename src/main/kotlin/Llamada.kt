package org.example

class Llamada(

    val idCabina: Int,
    val tipoLlamada: TipoLlamada,
    val duracionMinutos: Double,
    val costo: Double

)
// definimos las contantes que representan los tipos de llamadas posibles y se lo asignamos al tipoLlamada
enum class TipoLlamada {
    LOCAL, LARGA_DISTANCIA, CELULAR
}