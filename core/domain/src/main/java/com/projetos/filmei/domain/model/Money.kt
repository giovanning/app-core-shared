package com.projetos.filmei.domain.model

/**
 * Value object monetário. Armazena o valor em centavos (Long) para evitar os
 * erros clássicos de arredondamento de Double/Float em cálculos financeiros.
 *
 * A formatação para exibição (R$ 12,34, $12.34, etc.) NÃO é responsabilidade
 * deste value object — isso é apresentação e vive em core:presentation
 * (ver CurrencyFormatters.kt).
 */
data class Money(
    val amountInCents: Long,
    val currencyCode: String = "BRL"
) {

    init {
        require(currencyCode.length == 3) { "currencyCode deve seguir ISO 4217 (ex: BRL, USD)" }
    }

    val amount: Double
        get() = amountInCents / 100.0

    operator fun plus(other: Money): Money {
        require(currencyCode == other.currencyCode) { "Não é possível somar moedas diferentes" }
        return copy(amountInCents = amountInCents + other.amountInCents)
    }

    operator fun minus(other: Money): Money {
        require(currencyCode == other.currencyCode) { "Não é possível subtrair moedas diferentes" }
        return copy(amountInCents = amountInCents - other.amountInCents)
    }

    companion object {
        fun fromAmount(amount: Double, currencyCode: String = "BRL"): Money =
            Money(amountInCents = Math.round(amount * 100), currencyCode = currencyCode)
    }
}
