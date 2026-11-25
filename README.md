Ejercicio 1: Configuración Inicial de la Aplicación

Contexto del problema: Una aplicación modular necesita cargar propiedades de configuración desde un archivo maestro al inicio de su ejecución. Si diferentes componentes crearan sus propias instancias del lector de configuración, se desperdiciarían recursos de E/S y se podrían generar valores inconsistentes en memoria.

Objetivo de aprendizaje: Comprender cómo restringir la instanciación de una clase a una única copia global accesible para toda la aplicación.

Requisitos funcionales:

Permitir cargar parámetros de configuración clave-valor una sola vez al arrancar el sistema.

Proveer un mecanismo de consulta global para que cualquier parte de la aplicación pueda leer un parámetro a partir de su clave.

Restricciones técnicas:

La clase debe poseer un constructor privado para impedir la creación de objetos mediante el operador de instanciación estándar.

Debe incluir un método estático de acceso público que devuelva siempre la misma referencia única al objeto de configuración.

# Ejercicio 1: Reglas Generales del Banco (Patrón Singleton)

## Temática

Banca Digital y Tradicional — Reglas centrales compartidas del sistema bancario.

## Consigna

Un banco tiene reglas que todos sus canales (App móvil, Home Banking, sistemas de préstamos y administración) deben respetar al mismo tiempo, como el monto máximo diario para transferir y el interés anual de un plazo fijo. Si cada módulo creara su propia copia de estas reglas en memoria, un cambio hecho por Gerencia no se reflejaría en el resto del sistema.

El objetivo es centralizar estas reglas en un único punto para que, cuando se actualice un valor, todos los sectores del banco lean y apliquen siempre los mismos datos vigentes.

## Explicación lógica

1. Atributos: En la clase ReglasGeneralesBanco se declaran las variables nombreBanco (String), montoMaximoTransferencia (double) e interesPlazoFijo (double) para guardar las reglas centrales del banco. A esto se suma instancia (private static ReglasGeneralesBanco), que va a conservar la única referencia en memoria para que todos los sectores del sistema trabajen sobre los mismos datos sin duplicarlos.


2. Instancia única: El constructor se define como private para impedir que otras clases creen copias independientes con new, y además inicializa los valores base del banco cuando se crea por primera vez. El método getInstancia() controla el acceso: revisa si instancia es null (es decir, si todavía no se creó), la instancia una sola vez y en las siguientes llamadas devuelve siempre ese mismo objeto ya existente.


3. Asignación y Acceso: En Main, primero se obtiene la instancia desde el lado de la app (reglasApp) y se muestran las reglas iniciales. Luego se pide la referencia desde gerencia (reglasGerencia) y se actualizan los valores usando los métodos cambiarInteresPlazoFijo y cambiarMontoMaximoTransferencia. Al volver a consultar desde la app se ve que los cambios ya están aplicados, y la comparación reglasApp == reglasGerencia confirma que ambas variables apuntan exactamente al mismo objeto en memoria.



## Estructura del ejercicio

* ReglasGeneralesBanco.java: Implementa el Singleton con las reglas centrales del banco y sus métodos de consulta y modificación
* Main.java: Prueba el acceso desde distintos sectores, la actualización de valores y la igualdad de instancia



