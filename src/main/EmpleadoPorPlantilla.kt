package org.example

open class EmpleadoPorPlanilla(
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
    var salarioMensual: Double,
    var porcentajeAdicionalHoraExtra: Double
) : Empleado(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia, codigoEmpleado, horasExtras, fechaIngreso, area, cargo) {

    override fun calcularSalarioTotal(): Double {
        return salarioMensual + (horasExtras * (salarioMensual / 160) * (1 + porcentajeAdicionalHoraExtra / 100))
    }
}