class CuentaCorriente(
    saldoInicial: Float,
    tasaAnual: Float
) : Cuenta(saldoInicial, tasaAnual) {

    private var sobregiro: Float = 0f

    // Funcion Sobreescribir el método de retiro
    override fun retirar(monto: Float) {
        require(monto > 0f) { "El monto a retirar debe ser positivo." }

        if (monto <= getSaldoActual()) {
            super.retirar(monto)
        } else {
            val faltante = monto - getSaldoActual()

            if (getSaldoActual() > 0) {
                super.retirar(getSaldoActual())
            }

            sobregiro += faltante
            incrementarRetirosProtected()
        }
    }

    // Sobrescribimos el método de consignación
    override fun consignar(monto: Float) {
        require(monto > 0f) { "El monto a consignar debe ser positivo." }

        if (sobregiro > 0f) {
            if (monto >= sobregiro) {
                val restante = monto - sobregiro
                sobregiro = 0f
                if (restante > 0) {
                    super.consignar(restante)
                }
            } else {
                sobregiro -= monto
            }
            incrementarConsignacionesProtected()
        } else {
            super.consignar(monto)
        }
    }

    // Función sobreescrita para el extracto mensual
    override fun extractoMensual() {
        super.extractoMensual()
    }

    // Funcion  imprimir con información adicional
    override fun imprimir() {
        println(
            """
            --- Cuenta Corriente ---
            Saldo: ${getSaldoActual()}
            Comisión mensual: ${getComisionMensualActual()}
            Transacciones: ${getNumeroTransaccionesActual()}
            Sobregiro: $sobregiro
            """.trimIndent()
        )
    }
}
