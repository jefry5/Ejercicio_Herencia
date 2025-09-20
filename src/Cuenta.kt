open class Cuenta(
    saldoInicial: Float,
    tasaAnual: Float
) {
    protected var saldo: Float = saldoInicial
    protected var numeroConsignaciones: Int = 0
    protected var numeroRetiros: Int = 0
    protected var tasaAnual: Float = tasaAnual
    protected var comisionMensual: Float = 0f

    // Realizamos la validaciones iniciales
    init {
        require(saldoInicial >= 0f) { "El saldo inicial no puede ser negativo." }
        require(tasaAnual >= 0f) { "La tasa anual debe ser no negativa." }
    }

    // Función para insertar dinero y acumular la cantidad de inserciones
    open fun consignar(monto: Float) {
        require(monto > 0f) { "El monto a consignar debe ser positivo." }
        saldo += monto
        numeroConsignaciones++
    }

    // Función para retirar dinero y acumular la cantidad de retiros
    open fun retirar(monto: Float) {
        require(monto > 0f) { "El monto a retirar debe ser positivo." }
        require(monto <= saldo) { "Fondos insuficientes." }
        saldo -= monto
        numeroRetiros++
    }

    // Función para realizar el cálculo del interés mensual
    protected fun calcularInteresMensual() {
        val interesMensual = saldo * (tasaAnual / 12f) / 100f
        saldo += interesMensual
    }

    // Función para realizar el extracto mensual
    open fun extractoMensual() {
        saldo -= comisionMensual
        if (saldo < 0f) saldo = 0f
        calcularInteresMensual()
    }

    // Función para imprimir los resultados de la cuenta
    open fun imprimir() {
        println(
            """
            --- Cuenta ---
            Saldo: $saldo
            Tasa anual (%): $tasaAnual
            Comisión mensual: $comisionMensual
            # Consignaciones: $numeroConsignaciones
            # Retiros: $numeroRetiros
            """.trimIndent()
        )
    }

    // Funciones útiles para obtener y setear datos globables
    fun getSaldoActual(): Float = saldo
    fun getNumeroTransaccionesActual(): Int = numeroConsignaciones + numeroRetiros
    fun getComisionMensualActual(): Float = comisionMensual
    fun setComisionMensualActual(valor: Float) {
        require(valor >= 0f) { "La comisión mensual no puede ser negativa." };
        comisionMensual = valor
    }

    // Funciones protegidas para obtener y setear datos en las subclases
    protected fun getNumeroRetirosProtected(): Int = numeroRetiros
    protected fun getNumeroConsignacionesProtected(): Int = numeroConsignaciones
    protected fun incrementarRetirosProtected() { numeroRetiros++ }
    protected fun incrementarConsignacionesProtected() { numeroConsignaciones++ }
}