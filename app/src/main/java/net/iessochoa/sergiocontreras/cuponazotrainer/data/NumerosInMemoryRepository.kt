package net.iessochoa.sergiocontreras.cuponazotrainer.data

import net.iessochoa.sergiocontreras.cuponazotrainer.model.Terminacion

object NumerosInMemoryRepository {

    private val NOMBRES = listOf(
        "la muerte", "el galán", "el sol", "el niño", "la cama", "el pincho", "el corazón", "la luna", "la dama", "el arpa",
        "la rosa", "el clavel", "la talega", "el billete", "las cerezas", "las uvas", "la guitarra", "el navío", "el ramillete", "san José",
        "España", "Francia", "la manzana", "el melón", "la galera", "el cañón", "el pollo", "la pajarita", "Alicante", "Aragón",
        "el león", "el caballo", "la bomba", "la torre", "el pato", "el infierno", "la ensalada", "la espada y la daga", "el perro", "el toro",
        "la campana", "el negro", "la estrella", "la corona", "el clarín", "el tambor", "el sombrero", "el mundo", "la negra", "la breva",
        "el cucurucho", "la cabra", "el tomate", "el pimiento", "el cólera", "los gallegos", "la lechuga", "la zanahoria", "el limón", "el canario",
        "la abuela", "la pipa", "el piojoso", "el arroz", "la casa", "la discusión", "las monjas", "el fraile", "el rosario", "la mudanza",
        "el albaricoque", "el maestro", "el higo", "el conejo", "la escalera", "el gato", "el agua", "las banderas", "el escarabajo", "el cerdo",
        "la lavandera", "los casados", "el orinal", "la dama y el niño", "la boda", "la palmera", "la mierda", "el pescado", "las tetas", "la gamba",
        "el abuelo", "el borracho", "el palomo", "la revolución", "la rata", "el pavo", "paseo de la Explanada", "la gallina", "el borrego", "la agonía",
    )

    val TERMINACIONES: List<Terminacion> =
        NOMBRES.mapIndexed { i, nombre -> Terminacion(i, nombre) }

    fun getRandomTerminacion(): Terminacion =
        TERMINACIONES.random()

}