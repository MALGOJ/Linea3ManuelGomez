package org.example

class EmpleadoEventual(
    dni: String,
    nombre: String,
    apellido: String,
    fechaNacimiento: String,
    direccion: String,
    ciudadProcedencia: String,
    codigoEmpleado: String,
    horasExtras: Int,
    fechaIngreso: String,
    area: String,
    cargo: String,
    var honorariosPorHora: Double,
    var horasTotalesTrabajadas: Int,
    var fechaTerminoContrato: String
) : Empleado(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia, codigoEmpleado, horasExtras, fechaIngreso, area, cargo) {

    override fun calcularSalarioTotal(): Double {
        return honorariosPorHora * horasTotalesTrabajadas
    }
}