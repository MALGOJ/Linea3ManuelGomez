// Empleado.kt
package org.example

open class Empleado(
    dni: String,
    nombre: String,
    apellido: String,
    fechaNacimiento: String,
    direccion: String,
    ciudadProcedencia: String,
    var codigoEmpleado: String,
    var horasExtras: Int,
    var fechaIngreso: String,
    var area: String,
    var cargo: String
) : Persona(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia) {

    open fun calcularSalarioTotal(): Double {
        return 0.0
    }
}