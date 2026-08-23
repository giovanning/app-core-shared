package com.projetos.filmei.design_system.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.projetos.filmei.design_system.icons.AppIcons

/**
 * Campo de texto padrão com suporte a label, erro, ícones,
 * contador de caracteres e modo senha com toggle de visibilidade.
 *
 * Uso básico:
 *   AppTextField(
 *       value = state.email,
 *       onValueChange = { onAction(OnEmailChange(it)) },
 *       label = "E-mail",
 *   )
 *
 * Com erro:
 *   AppTextField(
 *       value = state.email,
 *       onValueChange = { onAction(OnEmailChange(it)) },
 *       label = "E-mail",
 *       error = state.emailError?.asString(),
 *   )
 *
 * Senha:
 *   AppTextField(
 *       value = state.password,
 *       onValueChange = { onAction(OnPasswordChange(it)) },
 *       label = "Senha",
 *       isPassword = true,
 *   )
 */
@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String? = null,
    supportingText: String? = null,
    error: String? = null,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    onTrailingIconClick: (() -> Unit)? = null,
    isPassword: Boolean = false,
    maxLength: Int? = null,
    showCharCounter: Boolean = false,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    singleLine: Boolean = true,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    var passwordVisible by remember { mutableStateOf(false) }

    val visualTransformation = when {
        isPassword && !passwordVisible -> PasswordVisualTransformation()
        else -> VisualTransformation.None
    }

    val resolvedTrailingIcon: (@Composable () -> Unit)? = when {
        isPassword -> {
            {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible)
                            AppIcons.Visibility else AppIcons.VisibilityOff,
                        contentDescription = if (passwordVisible) "Ocultar senha" else "Mostrar senha",
                    )
                }
            }
        }

        trailingIcon != null -> {
            {
                if (onTrailingIconClick != null) {
                    IconButton(onClick = onTrailingIconClick) {
                        Icon(imageVector = trailingIcon, contentDescription = null)
                    }
                } else {
                    Icon(imageVector = trailingIcon, contentDescription = null)
                }
            }
        }

        else -> null
    }

    Column(modifier = modifier) {
        OutlinedTextField(
            value = value,
            onValueChange = { newValue ->
                if (maxLength == null || newValue.length <= maxLength) {
                    onValueChange(newValue)
                }
            },
            modifier = Modifier.fillMaxWidth(),
            label = label?.let { { Text(it) } },
            placeholder = placeholder?.let { { Text(it) } },
            leadingIcon = leadingIcon?.let {
                {
                    Icon(
                        imageVector = it,
                        contentDescription = null
                    )
                }
            },
            trailingIcon = resolvedTrailingIcon,
            supportingText = when {
                error != null -> {
                    { Text(error, color = MaterialTheme.colorScheme.error) }
                }

                supportingText != null -> {
                    { Text(supportingText) }
                }

                showCharCounter && maxLength != null -> {
                    {
                        Text(
                            "${value.length} / $maxLength",
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                }

                else -> null
            },
            isError = error != null,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            maxLines = maxLines,
            enabled = enabled,
            readOnly = readOnly,
            shape = MaterialTheme.shapes.medium,
        )
    }
}

// ─── Preview ──────────────────────────────────────────────────────────────────

@Preview(showBackground = true)
@Composable
private fun AppTextFieldPreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        AppTextField(value = "", onValueChange = {}, label = "E-mail")
        AppTextField(value = "texto preenchido", onValueChange = {}, label = "Nome")
        AppTextField(
            value = "",
            onValueChange = {},
            label = "E-mail",
            error = "E-mail inválido"
        )
        AppTextField(value = "••••••", onValueChange = {}, label = "Senha", isPassword = true)
        AppTextField(
            value = "Olá",
            onValueChange = {},
            label = "Bio",
            maxLength = 150,
            showCharCounter = true,
            singleLine = false,
            maxLines = 4,
        )

    }
}