class CuentaAhorros(
    saldoInicial: Float,
    tasaAnual: Float
) : Cuenta(saldoInicial, tasaAnual) {
    // La cuenta se activa si tiene más de $10000
    private var activa: Boolean = saldoInicial >= 10_000f

    // Función para actualizar el estado de la cuenta de ahorros
    private fun actualizarEstado() {
        activa = getSaldoActual() >= 10_000f
    }

    // Función sobreescrita para insertar dinero
    override fun consignar(monto: Float) {
        if (!activa) {
            println("Operación denegada: la cuenta de ahorros está inactiva.")
            return
        }
        super.consignar(monto)
        actualizarEstado()
    }

    // Función sobreescrita para retirar dinero
    override fun retirar(monto: Float) {
        if (!activa) {
            println("Operación denegada: la cuenta de ahorros está inactiva (no se permite retirar).")
            return
        }
        super.retirar(monto)
        actualizarEstado()
    }

    // Función sobreescrita para el extracto mensual
    override fun extractoMensual() {
        // Cada retiro adicional despues del cuarto, indica un comisión de $1000
        val retiros = getNumeroRetirosProtected()
        if (retiros > 4) {
            val adicionales = retiros - 4
            setComisionMensualActual(getComisionMensualActual() + adicionales * 1_000f)
        }
        super.extractoMensual()
        actualizarEstado()
    }

    // Función sobreescrita para imprimir la cuenta de ahorros
    override fun imprimir() {
        println(
            """
            --- Cuenta de Ahorros ---
            Activa: $activa
            Saldo: ${getSaldoActual()}
            Comisión mensual: ${getComisionMensualActual()}
            Transacciones: ${getNumeroTransaccionesActual()}
            """.trimIndent()
        )
    }
}