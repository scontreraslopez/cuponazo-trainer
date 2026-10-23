package net.iessochoa.sergiocontreras.cuponazotrainer.model

data class Terminacion(
    val numero: Int,
    val nombre: String
) {
    init {
        require(numero in 0..99) { "La terminación debe estar comprendida entre 00 y 99" }
    }

    // Derivada: no entra en equals/hashCode/copy
    val codigo: String
        get() = numero.toString().padStart(2, '0')


    companion object {
        // Para cuando la entrada viene del usuario como texto ("0", "00", "7", "07"...)
        fun parse(texto: String, nombre: String): Terminacion {
            val limpio = texto.trim()
            require(limpio.length in 1..2 && limpio.all { it in '0'..'9' }) {
                "Terminación inválida: '$texto'"
            }
            return Terminacion(limpio.toInt(), nombre)
        }
    }

}