// Main.kt
package org.example

fun main() {
    val empleados = mutableListOf<Empleado>()
    val pacientes = mutableListOf<Paciente>()
    val medicos = mutableListOf<Medico>()
    val citasMedicas = mutableListOf<CitaMedica>()

    fun registrarEmpleado() {
        println("Ingrese los datos del empleado:")
        print("DNI: ")
        val dni = readLine()!!
        print("Nombre: ")
        val nombre = readLine()!!
        print("Apellido: ")
        val apellido = readLine()!!
        print("Fecha de Nacimiento: ")
        val fechaNacimiento = readLine()!!
        print("Dirección: ")
        val direccion = readLine()!!
        print("Ciudad de Procedencia: ")
        val ciudadProcedencia = readLine()!!
        print("Código de Empleado: ")
        val codigoEmpleado = readLine()!!
        print("Horas Extras: ")
        val horasExtras = readLine()!!.toInt()
        print("Fecha de Ingreso: ")
        val fechaIngreso = readLine()!!
        print("Área: ")
        val area = readLine()!!
        print("Cargo: ")
        val cargo = readLine()!!

        val empleado = Empleado(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia, codigoEmpleado, horasExtras, fechaIngreso, area, cargo)
        empleados.add(empleado)
        println("Empleado registrado exitosamente.")
    }

    fun registrarPaciente() {
        println("Ingrese los datos del paciente:")
        print("DNI: ")
        val dni = readLine()!!
        print("Nombre: ")
        val nombre = readLine()!!
        print("Apellido: ")
        val apellido = readLine()!!
        print("Fecha de Nacimiento: ")
        val fechaNacimiento = readLine()!!
        print("Dirección: ")
        val direccion = readLine()!!
        print("Ciudad de Procedencia: ")
        val ciudadProcedencia = readLine()!!
        print("Historia Clínica: ")
        val historiaClinica = readLine()!!
        print("Sexo: ")
        val sexo = readLine()!!
        print("Grupo Sanguíneo: ")
        val grupoSanguineo = readLine()!!
        print("Alergias (separadas por comas): ")
        val alergias = readLine()!!.split(",").map { it.trim() }.toMutableList()

        val paciente = Paciente(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia, historiaClinica, sexo, grupoSanguineo, alergias)
        pacientes.add(paciente)
        println("Paciente registrado exitosamente.")
    }

    fun registrarMedico() {
        println("Ingrese los datos del médico:")
        print("DNI: ")
        val dni = readLine()!!
        print("Nombre: ")
        val nombre = readLine()!!
        print("Apellido: ")
        val apellido = readLine()!!
        print("Fecha de Nacimiento: ")
        val fechaNacimiento = readLine()!!
        print("Dirección: ")
        val direccion = readLine()!!
        print("Ciudad de Procedencia: ")
        val ciudadProcedencia = readLine()!!
        print("Código de Empleado: ")
        val codigoEmpleado = readLine()!!
        print("Horas Extras: ")
        val horasExtras = readLine()!!.toInt()
        print("Fecha de Ingreso: ")
        val fechaIngreso = readLine()!!
        print("Área: ")
        val area = readLine()!!
        print("Cargo: ")
        val cargo = readLine()!!
        print("Salario Mensual: ")
        val salarioMensual = readLine()!!.toDouble()
        print("Porcentaje Adicional por Hora Extra: ")
        val porcentajeAdicionalHoraExtra = readLine()!!.toDouble()
        print("Especialidad: ")
        val especialidad = readLine()!!
        print("Servicio: ")
        val servicio = readLine()!!
        print("Consultorio: ")
        val consultorio = readLine()!!

        val medico = Medico(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia, codigoEmpleado, horasExtras, fechaIngreso, area, cargo, salarioMensual, porcentajeAdicionalHoraExtra, especialidad, servicio, consultorio)
        medicos.add(medico)
        println("Médico registrado exitosamente.")
    }

    fun registrarCitaMedica() {
        println("Ingrese los datos de la cita médica:")
        print("DNI del Paciente: ")
        val dniPaciente = readLine()!!
        val paciente = pacientes.find { it.dni == dniPaciente }
        if (paciente == null) {
            println("Paciente no encontrado.")
            return
        }

        print("Código del Médico: ")
        val codigoMedico = readLine()!!
        val medico = medicos.find { it.codigoEmpleado == codigoMedico }
        if (medico == null) {
            println("Médico no encontrado.")
            return
        }

        print("Fecha: ")
        val fecha = readLine()!!
        print("Hora: ")
        val hora = readLine()!!
        print("Servicio: ")
        val servicio = readLine()!!

        val citaMedica = CitaMedica(paciente, medico, fecha, hora, servicio)
        citasMedicas.add(citaMedica)
        println("Cita médica registrada exitosamente.")
    }

    fun listarMedicosPorEspecialidad() {
        print("Ingrese la especialidad: ")
        val especialidad = readLine()!!
        val medicosEspecialidad = medicos.filter { it.especialidad == especialidad }
        println("Médicos de la especialidad $especialidad:")
        medicosEspecialidad.forEach { println("${it.nombre} ${it.apellido}") }
    }

    fun listarPacientesPorMedico() {
        print("Ingrese el código del médico: ")
        val codigoMedico = readLine()!!
        val pacientesAtendidos = citasMedicas.filter { it.medico.codigoEmpleado == codigoMedico }.map { it.paciente }
        println("Pacientes atendidos por el médico con código $codigoMedico:")
        pacientesAtendidos.forEach { println("${it.nombre} ${it.apellido}") }
    }

    while (true) {
        println("Seleccione una opción:")
        println("1. Registrar Empleado")
        println("2. Registrar Paciente")
        println("3. Registrar Médico")
        println("4. Registrar Cita Médica")
        println("5. Listar Médicos por Especialidad")
        println("6. Listar Pacientes por Médico")
        println("7. Salir")
        when (readLine()!!.toInt()) {
            1 -> registrarEmpleado()
            2 -> registrarPaciente()
            3 -> registrarMedico()
            4 -> registrarCitaMedica()
            5 -> listarMedicosPorEspecialidad()
            6 -> listarPacientesPorMedico()
            7 -> break
            else -> println("Opción no válida")
        }
    }
}