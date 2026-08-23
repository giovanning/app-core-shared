package com.projetos.filmei.design_system.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// ─── Variantes ────────────────────────────────────────────────────────────────

enum class AppButtonVariant { Primary, Secondary, Outlined, Text, Destructive }

// ─── Componente principal ─────────────────────────────────────────────────────

/**
 * Botão padrão do design system com suporte a ícone, loading e variantes.
 *
 * Uso:
 *   AppButton(text = "Salvar", onClick = { onAction(Save) })
 *   AppButton(text = "Deletar", variant = AppButtonVariant.Destructive, onClick = { })
 *   AppButton(text = "Adicionar", leadingIcon = Icons.Outlined.Add, onClick = { })
 *   AppButton(text = "Carregando", isLoading = true, onClick = { })
 */
@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: AppButtonVariant = AppButtonVariant.Primary,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    isLoading: Boolean = false,
    enabled: Boolean = true,
) {
    val isEnabled = enabled && !isLoading

    val content: @Composable RowScope.() -> Unit = {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(18.dp),
                strokeWidth = 2.dp,
                color = LocalContentColor.current,
            )
        } else {
            leadingIcon?.let {
                Icon(imageVector = it, contentDescription = null, modifier = Modifier.size(18.dp))
                Spacer(Modifier.width(8.dp))
            }
            Text(text = text)
            trailingIcon?.let {
                Spacer(Modifier.width(8.dp))
                Icon(imageVector = it, contentDescription = null, modifier = Modifier.size(18.dp))
            }
        }
    }

    when (variant) {
        AppButtonVariant.Primary -> Button(
            onClick = onClick,
            modifier = modifier.height(48.dp),
            enabled = isEnabled,
            content = content,
        )

        AppButtonVariant.Secondary -> FilledTonalButton(
            onClick = onClick,
            modifier = modifier.height(48.dp),
            enabled = isEnabled,
            content = content,
        )

        AppButtonVariant.Outlined -> OutlinedButton(
            onClick = onClick,
            modifier = modifier.height(48.dp),
            enabled = isEnabled,
            content = content,
        )

        AppButtonVariant.Text -> TextButton(
            onClick = onClick,
            modifier = modifier.height(48.dp),
            enabled = isEnabled,
            content = content,
        )

        AppButtonVariant.Destructive -> Button(
            onClick = onClick,
            modifier = modifier.height(48.dp),
            enabled = isEnabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.error,
                contentColor = MaterialTheme.colorScheme.onError,
            ),
            content = content,
        )
    }
}

// ─── Preview ──────────────────────────────────────────────────────────────────

@Preview(showBackground = true)
@Composable
private fun AppButtonPreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        AppButton("Primary", onClick = {})
        AppButton("Secondary", onClick = {}, variant = AppButtonVariant.Secondary)
        AppButton("Outlined", onClick = {}, variant = AppButtonVariant.Outlined)
        AppButton("Text", onClick = {}, variant = AppButtonVariant.Text)
        AppButton("Destructive", onClick = {}, variant = AppButtonVariant.Destructive)
        AppButton("Loading", onClick = {}, isLoading = true)
        AppButton("Com ícone", onClick = {}, leadingIcon = Icons.Outlined.Add)
    }

}