package com.projetos.filmei.domain.validator

/**
 * Validação de e-mail comum aos apps, sem android.util.Patterns,
 * que não é testável em unit tests JVM puro.
 */
object EmailValidator {

    private val EMAIL_REGEX = Regex(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    )

    fun isValid(email: String): Boolean {
        if (email.isBlank()) return false
        return EMAIL_REGEX.matches(email.trim())
    }
}
