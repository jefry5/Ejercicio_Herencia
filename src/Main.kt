fun main() {
    // Creamos una variable para la cuenta de ahorros
    val ahorro = CuentaAhorros(saldoInicial = 12_000f, tasaAnual = 12f)
    println("Operaciones en cuenta de ahorros")
    ahorro.imprimir()

    // Insertamos dinero a la cuenta de ahorros
    ahorro.consignar(2_000f)
    ahorro.consignar(2_000f)

    // Probamos el excedente para comisión (>4 retiros)
    repeat(5) { ahorro.retirar(500f) }

    println("\nAntes del extracto mensual")
    ahorro.imprimir()

    // Realizamos el extracto mensual
    ahorro.extractoMensual()
    println("\nDespués del extracto mensual")
    ahorro.imprimir()

    // Inactivamos la cuenta
    ahorro.retirar(5_000f)
    ahorro.imprimir()

    // Intentamos consignar dinero
    ahorro.consignar(1_000f)
    ahorro.imprimir()
}