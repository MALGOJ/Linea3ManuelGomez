# Aplicacion de gastos telefónicos de una empresa

## Descripción

La aplicación permite llevar un control de los gastos telefónicos de una empresa. 
La empresa cuenta con N canbinas telefónicas a través de las cuales pueden realizar llamadas locales de larga distancia y a celulares.


La empresa cuenta con planes telefonicos que establecen las siguientes tarifas:

- Llamadas locales por minuto: 50 pesos
- Llamadas de larga distancia por minuto: 350 pesos
- Llamadas a celulares por minuto: 150 pesos


## Aspectos Relevantes para el Correcto Funcionamiento del Software

1. **Inicialización de Datos**:
    - Asegúrese de inicializar correctamente las listas de cabinas y tarifas antes de registrar llamadas o consultar información.
    - Verifique que las tarifas estén configuradas adecuadamente para cada tipo de llamada.

2. **Validación de Datos**:
    - Valide que los `cabinaId` proporcionados existan en la lista de cabinas antes de realizar operaciones.
    - Asegúrese de que la duración de las llamadas sea un valor positivo.

3. **Manejo de Excepciones**:
    - Maneje adecuadamente las excepciones, como `IllegalArgumentException`, para evitar que el programa se detenga inesperadamente.
    - Considere agregar más validaciones y manejo de errores para mejorar la robustez del software.

4. **Consistencia de Datos**:
    - Asegúrese de que las operaciones de registro de llamadas y reinicio de cabinas mantengan la consistencia de los datos.
    - Verifique que los cálculos de costos y duraciones sean precisos y coherentes.

## Posibles Mejoras del Código

1. **Refactorización de Código**:
    - Centralizar la lógica de búsqueda de cabinas en una función auxiliar para evitar duplicación de código.
    - Utilizar estructuras de datos más eficientes si el número de cabinas es grande.

2. **Optimización de Cálculos**:
    - Optimizar los cálculos de consolidado total para mejorar el rendimiento, especialmente si se manejan grandes volúmenes de datos.

3. **Manejo de Concurrencia**:
    - Implementar mecanismos de sincronización si el software se ejecuta en un entorno multihilo para evitar problemas de concurrencia.


## Nuevas Funcionalidades a considerar

1. **Historial de Llamadas**:
    - Implementar una funcionalidad para almacenar y consultar el historial de llamadas realizadas en cada cabina.

2. **Reportes Detallados**:
    - Generar reportes detallados de llamadas, incluyendo estadísticas por tipo de llamada y por cabina.

3. **Interfaz de Usuario**:
    - Desarrollar una interfaz gráfica o web para facilitar la interacción con el sistema y la visualización de datos.

4. **Notificaciones y Alertas**:
    - Implementar notificaciones y alertas para eventos importantes, como el reinicio de cabinas o llamadas de larga duración.

5. **Integración con Sistemas Externos**:
    - Integrar el software con otros sistemas de la empresa para automatizar la gestión de gastos y la facturación.