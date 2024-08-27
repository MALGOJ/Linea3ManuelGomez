import org.example.Main
import org.example.Cabina
import org.example.Llamada
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito.*

class MainKtTest {

    @Test
    fun getTarifas() {
        val mockMain = mock(Main::class.java)
        `when`(mockMain.getTarifas()).thenReturn(listOf(1.0, 2.0, 3.0))
        assertEquals(listOf(1.0, 2.0, 3.0), mockMain.getTarifas())
    }

    @Test
    fun getCabinaList() {
        val mockMain = mock(Main::class.java)
        val mockCabina = mock(Cabina::class.java)
        `when`(mockMain.getCabinaList()).thenReturn(listOf(mockCabina))
        assertEquals(listOf(mockCabina), mockMain.getCabinaList())
    }

    @Test
    fun buscarCabina() {
        val mockMain = mock(Main::class.java)
        val mockCabina = mock(Cabina::class.java)
        `when`(mockMain.buscarCabina(1)).thenReturn(mockCabina)
        assertEquals(mockCabina, mockMain.buscarCabina(1))
    }

    @Test
    fun registrarLlamada() {
        val mockMain = mock(Main::class.java)
        val mockCabina = mock(Cabina::class.java)
        val mockLlamada = mock(Llamada::class.java)
        `when`(mockMain.registrarLlamada(mockCabina, mockLlamada)).thenReturn(true)
        assertTrue(mockMain.registrarLlamada(mockCabina, mockLlamada))
    }

    @Test
    fun informacionCabina() {
        val mockMain = mock(Main::class.java)
        `when`(mockMain.informacionCabina(1)).thenReturn("Información de la cabina")
        assertEquals("Información de la cabina", mockMain.informacionCabina(1))
    }

    @Test
    fun consolidadoTotal() {
        val mockMain = mock(Main::class.java)
        `when`(mockMain.consolidadoTotal()).thenReturn("Consolidado total")
        assertEquals("Consolidado total", mockMain.consolidadoTotal())
    }

    @Test
    fun reiniciarCabina() {
        val mockMain = mock(Main::class.java)
        `when`(mockMain.reiniciarCabina(1)).thenReturn(true)
        assertTrue(mockMain.reiniciarCabina(1))
    }
}