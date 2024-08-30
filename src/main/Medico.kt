// Medico.kt
package org.example

class Medico(
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
    salarioMensual: Double,
    porcentajeAdicionalHoraExtra: Double,
    var especialidad: String,
    var servicio: String,
    var consultorio: String
) : EmpleadoPorPlanilla(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia, codigoEmpleado, horasExtras, fechaIngreso, area, cargo, salarioMensual, porcentajeAdicionalHoraExtra)