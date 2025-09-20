## 👨‍🎓 Alumnos
- Cristian Ricardo Morales Damasco (22200029)  
- Jefferson Marquez Rosasco (22200118)  

# Cuentas bancarias
Modelado de cuentas bancarias en Kotlin aplicando Herencia y Encapsulamiento.

# Requisitos
* Kotlin 1.9+

# Entorno
* Intellij IDEA

# Reglas del problema
* **Cuenta Base**
    * Saldo, numeroConsignaciones, numerosRetiros, tasaAnual, comisionMensual.
    * Funciones: consignar(monto), retirar(monto), extractoMensual() e imprimir().
* **Cuenta de Ahorros**
    * Operaciones solo si se activa (saldo >= 10000).
    * Si retiros > 4 en el periodo, comisión adicional $1000 por cada retiro extra.
    * Recalcula si sigue activa tras el extracto.
* **Cuenta Corriente**
    * Permite retirar sobre el saldo, genera sobregiro.
    * Consigna reduce el sobregiro, luego aumenta el saldo (si sobra).
