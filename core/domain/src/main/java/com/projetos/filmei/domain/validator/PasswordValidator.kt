package com.projetos.filmei.domain.validator

/**
 * Validação de senha comum aos apps. Retorna as regras violadas em vez de um
 * simples Boolean, para que cada app decida como exibir o feedback (checklist,
 * mensagem única, etc.) — essa decisão de apresentação NÃO pertence ao domain.
 */
object PasswordValidator {

    enum class Rule {
        MIN_LENGTH,
        HAS_DIGIT,
        HAS_UPPERCASE,
        HAS_LOWERCASE
    }

    fun validate(
        password: String,
        minLength: Int = 8
    ): Set<Rule> {
        val violated = mutableSetOf<Rule>()

        if (password.length < minLength) violated += Rule.MIN_LENGTH
        if (password.none { it.isDigit() }) violated += Rule.HAS_DIGIT
        if (password.none { it.isUpperCase() }) violated += Rule.HAS_UPPERCASE
        if (password.none { it.isLowerCase() }) violated += Rule.HAS_LOWERCASE

        return violated
    }

    fun isValid(password: String, minLength: Int = 8): Boolean =
        validate(password, minLength).isEmpty()
}
