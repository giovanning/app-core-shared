package com.projetos.filmei.presentation.format

import com.projetos.filmei.domain.model.Money
import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

/**
 * Converte o value object Money (domain, sem formatação) em String pronta
 * para exibição — a formatação de moeda é sensível a locale, então fica em
 * presentation, nunca em domain.
 */
object CurrencyFormatters {

    /** Ex: Money(1234, "BRL") -> "R$ 12,34" */
    fun format(money: Money, locale: Locale = Locale("pt", "BR")): String {
        val format = NumberFormat.getCurrencyInstance(locale)
        format.currency = Currency.getInstance(money.currencyCode)
        return format.format(money.amount)
    }

    /** Versão sem símbolo de moeda. Ex: "12,34" */
    fun formatWithoutSymbol(money: Money, locale: Locale = Locale("pt", "BR")): String {
        val format = NumberFormat.getNumberInstance(locale)
        format.minimumFractionDigits = 2
        format.maximumFractionDigits = 2
        return format.format(money.amount)
    }
}
