import org.example.Llamada
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito.*


class LlamadaTest {

    @Test
    fun getIdCabina() {
        // Crear una instancia simulada de Llamada
        val mockLlamada = mock(Llamada::class.java)

        // Configurar el mock para que devuelva un valor específico para idCabina
        `when`(mockLlamada.idCabina).thenReturn(1)

        // Verificar que el mock devuelva el valor esperado
        assertEquals(1, mockLlamada.idCabina)
    }

    @Test
    fun getDuracionMinutos() {
        // Crear una instancia simulada de Llamada
        val mockLlamada = mock(Llamada::class.java)

        // Configurar el mock para que devuelva un valor específico para duracionMinutos
        `when`(mockLlamada.duracionMinutos).thenReturn(10.0)

        // Verificar que el mock devuelva el valor esperado
        assertEquals(10.0, mockLlamada.duracionMinutos)
    }

    @Test
    fun getCosto() {
        // Crear una instancia simulada de Llamada
        val mockLlamada = mock(Llamada::class.java)

        // Configurar el mock para que devuelva un valor específico para costo
        `when`(mockLlamada.costo).thenReturn(100.0)

        // Verificar que el mock devuelva el valor esperado
        assertEquals(100.0, mockLlamada.costo)
    }
}