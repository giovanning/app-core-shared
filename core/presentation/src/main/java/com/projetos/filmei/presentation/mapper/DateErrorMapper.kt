package com.projetos.filmei.presentation.mapper

import com.projetos.filmei.domain.error.DataError
import com.projetos.filmei.presentation.R
import com.projetos.filmei.presentation.UiText


/**
 * Mapeia erros de domínio para mensagens exibíveis. Fica em core:presentation
 * (não em core:domain) porque é aqui que faz sentido depender de recursos
 * Android — domain nunca deve conhecer strings ou UI.
 */
fun DataError.asUiText(): UiText = when (this) {
    DataError.Network.REQUEST_TIMEOUT -> UiText.StringResource(R.string.error_request_timeout)
    DataError.Network.NO_INTERNET -> UiText.StringResource(R.string.error_no_internet)
    DataError.Network.SERVER_ERROR -> UiText.StringResource(R.string.error_server)
    DataError.Network.SERIALIZATION -> UiText.StringResource(R.string.error_serialization)
    DataError.Network.UNAUTHORIZED -> UiText.StringResource(R.string.error_unauthorized)
    DataError.Network.UNKNOWN -> UiText.StringResource(R.string.error_unknown)
    DataError.Local.DISK_FULL -> UiText.StringResource(R.string.error_disk_full)
    DataError.Local.UNKNOWN -> UiText.StringResource(R.string.error_unknown)
    else -> {
        UiText.DynamicString("")
    }
}
