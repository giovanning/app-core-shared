package com.projetos.filmei.presentation.format

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

/**
 * Formatters de data para exibição. Lógica de negócio de datas (cálculo de prazos,
 * regras de expiração, etc.) fica em domain — aqui só formatação para UI.
 */
object DateFormatters {

    private val locale = Locale("pt", "BR")

    /** Ex: "15 de mar. de 2026" */
    fun mediumDate(date: LocalDate): String =
        date.format(DateTimeFormatter.ofPattern("dd 'de' MMM. 'de' yyyy", locale))

    /** Ex: "15/03/2026" */
    fun shortDate(date: LocalDate): String =
        date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy", locale))

    /** Ex: "15/03/2026 às 14:30" */
    fun dateTime(dateTime: LocalDateTime): String =
        dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm", locale))

    /** Converte um Instant (UTC) para exibição no fuso do dispositivo. */
    fun relativeInstant(instant: Instant, zoneId: ZoneId = ZoneId.systemDefault()): String =
        dateTime(LocalDateTime.ofInstant(instant, zoneId))

    /**
     * Ex: "há 5 minutos", "há 2 horas", "há 3 dias".
     * Para textos completos e localizados, prefira DateUtils.getRelativeTimeSpanString
     * do Android quando disponível no contexto de UI.
     */
    fun timeAgo(instant: Instant, now: Instant = Instant.now()): String {
        val seconds = now.epochSecond - instant.epochSecond
        return when {
            seconds < 60 -> "agora mesmo"
            seconds < 3600 -> "há ${seconds / 60} min"
            seconds < 86400 -> "há ${seconds / 3600} h"
            else -> "há ${seconds / 86400} d"
        }
    }
}
