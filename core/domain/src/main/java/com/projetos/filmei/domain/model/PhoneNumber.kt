package com.projetos.filmei.domain.model

/**
 * Value object de telefone. Guarda apenas os dígitos (E.164-like, sem máscara),
 * e expõe formatação para exibição já que é um formato bem definido e universal
 * o suficiente (diferente de datas/moedas, que variam por locale).
 */
data class PhoneNumber private constructor(
    val ddi: String,
    val digits: String
) {

    val e164: String
        get() = "+$ddi$digits"

    /** Formatação para exibição no padrão brasileiro: (11) 91234-5678 */
    fun formatted(): String {
        if (digits.length !in 10..11) return e164
        val ddd = digits.substring(0, 2)
        val rest = digits.substring(2)
        return if (rest.length == 9) {
            "($ddd) ${rest.substring(0, 5)}-${rest.substring(5)}"
        } else {
            "($ddd) ${rest.substring(0, 4)}-${rest.substring(4)}"
        }
    }

    companion object {
        /** Retorna null se os dígitos não formarem um número válido. */
        fun from(raw: String, ddi: String = "55"): PhoneNumber? {
            val digits = raw.filter { it.isDigit() }
            if (digits.length !in 10..11) return null
            return PhoneNumber(ddi = ddi, digits = digits)
        }
    }
}
