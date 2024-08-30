
package org.example

class Paciente(
    dni: String,
    nombre: String,
    apellido: String,
    fechaNacimiento: String,
    direccion: String,
    ciudadProcedencia: String,
    var historiaClinica: String,
    var sexo: String,
    var grupoSanguineo: String,
    var alergias: MutableList<String>
) : Persona(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia) {

    fun agregarAlergia(alergia: String) {
        alergias.add(alergia)
    }

    fun eliminarAlergia(alergia: String) {
        alergias.remove(alergia)
    }
}