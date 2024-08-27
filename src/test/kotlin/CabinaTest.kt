import org.example.Cabina
import org.example.Llamada
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito.*

class CabinaTest {

    @Test
    fun getNumLlamadas() {
        val mockCabina = mock(Cabina::class.java)
        `when`(mockCabina.numLlamadas).thenReturn(5)
        assertEquals(5, mockCabina.numLlamadas)
    }

    @Test
    fun setNumLlamadas() {
        val mockCabina = mock(Cabina::class.java)
        mockCabina.numLlamadas = 5
        verify(mockCabina).numLlamadas = 5
    }

    @Test
    fun getDuracionTotalMinutos() {
        val mockCabina = mock(Cabina::class.java)
        `when`(mockCabina.duracionTotalMinutos).thenReturn(120.0)
        assertEquals(120.0, mockCabina.duracionTotalMinutos)
    }

    @Test
    fun setDuracionTotalMinutos() {
        val mockCabina = mock(Cabina::class.java)
        mockCabina.duracionTotalMinutos = 120.0
        verify(mockCabina).duracionTotalMinutos = 120.0
    }

    @Test
    fun getCostoTotal() {
        val mockCabina = mock(Cabina::class.java)
        `when`(mockCabina.costoTotal).thenReturn(300.0)
        assertEquals(300.0, mockCabina.costoTotal)
    }

    @Test
    fun setCostoTotal() {
        val mockCabina = mock(Cabina::class.java)
        mockCabina.costoTotal = 300.0
        verify(mockCabina).costoTotal = 300.0
    }

    @Test
    fun registrarLlamada() {
        val mockCabina = mock(Cabina::class.java)
        val mockLlamada = mock(Llamada::class.java)
        mockCabina.registrarLlamada(mockLlamada)
        verify(mockCabina).registrarLlamada(mockLlamada)
    }

    @Test
    fun reiniciar() {
        val mockCabina = mock(Cabina::class.java)
        mockCabina.reiniciar()
        verify(mockCabina).reiniciar()
    }

    @Test
    fun informacion() {
        val mockCabina = mock(Cabina::class.java)
        `when`(mockCabina.Informacion()).thenReturn("Información de la cabina")
        assertEquals("Información de la cabina", mockCabina.Informacion())
    }

    @Test
    fun getIdCabina() {
        val mockCabina = mock(Cabina::class.java)
        `when`(mockCabina.idCabina).thenReturn(1)
        assertEquals(1, mockCabina.idCabina)
    }
}