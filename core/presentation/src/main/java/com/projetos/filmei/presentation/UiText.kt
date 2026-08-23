package com.projetos.filmei.presentation

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.projetos.filmei.domain.error.DataError

sealed interface UiText {
    data class DynamicString(val value: String) : UiText
    data class StringResource(@StringRes val id: Int, val args: Array<Any> = emptyArray()) : UiText

    @Composable
    fun asString(): String = when (this) {
        is DynamicString    -> value
        is StringResource   -> stringResource(id, *args)
    }
}

fun DataError.toUiText(): UiText = when (this) {
    DataError.Local.DISK_FULL  -> UiText.DynamicString("Armazenamento cheio")
    DataError.Local.NOT_FOUND  -> UiText.DynamicString("Item não encontrado")
    DataError.Local.UNKNOWN    -> UiText.DynamicString("Erro desconhecido")
    DataError.Network.NO_INTERNET -> UiText.DynamicString("Sem conexão com a internet")
    DataError.Network.SERVER_ERROR -> UiText.DynamicString("Erro no servidor")
    DataError.Network.REQUEST_TIMEOUT -> UiText.DynamicString("Tempo de conexão esgotado")
    DataError.Network.TOO_MANY_REQUESTS -> UiText.DynamicString("Muitas requisições")
    DataError.Network.SERIALIZATION -> UiText.DynamicString("Erro ao processar dados")
    DataError.Network.UNAUTHORIZED -> UiText.DynamicString("Acesso não autorizado ao Google Sheets")
    DataError.Network.UNKNOWN -> UiText.DynamicString("Erro de rede desconhecido")
}