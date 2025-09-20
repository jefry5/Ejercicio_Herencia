fun main() {
    // Creamos una variable para la cuenta de ahorros
    val ahorro = CuentaAhorros(saldoInicial = 12_000f, tasaAnual = 12f)
    val corriente = CuentaCorriente(saldoInicial = 5_000f, tasaAnual = 12f)
    println("Operaciones en cuenta de ahorros")
    ahorro.imprimir()
    println("Operaciones en cuenta corriente")
    corriente.imprimir()

    // Cuenta Ahorro funcionalidades
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

    // Cuenta Corriente funcionalidades
    // Retiramos más del saldo para generar sobregiro
    println("\nRetirando 8,000 (mayor que el saldo actual)")
    corriente.retirar(8_000f)
    corriente.imprimir()

    // Consignamos dinero menor al sobregiro
    println("\nConsignando 2,000 (no cubre todo el sobregiro)")
    corriente.consignar(2_000f)
    corriente.imprimir()

    // Consignamos dinero mayor al sobregiro
    println("\nConsignando 10,000 (cubre sobregiro y queda saldo positivo)")
    corriente.consignar(10_000f)
    corriente.imprimir()

    // Probamos el extracto mensual
    println("\nAplicando extracto mensual")
    corriente.extractoMensual()
    corriente.imprimir()


}