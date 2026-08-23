package giovanni.projetos.com.designsystem.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import giovanni.projetos.com.designsystem.theme.AppTheme

/**
 * Tooltip simples sobre um ícone de informação (ou qualquer conteúdo).
 *
 * Uso:
 *   AppTooltip(tooltip = "Essa senha é usada apenas localmente.") {
 *       Icon(Icons.Outlined.Info, contentDescription = "Ajuda")
 *   }
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTooltip(
    tooltip: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    TooltipBox(
        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
        tooltip = {
            PlainTooltip { Text(tooltip) }
        },
        state   = rememberTooltipState(),
        modifier = modifier,
        content = content,
    )
}

/**
 * Tooltip rico com título e link de ação.
 *
 * Uso:
 *   AppRichTooltip(
 *       title = "Senha segura",
 *       tooltip = "Use ao menos 8 caracteres, letras e números.",
 *       actionLabel = "Saiba mais",
 *       onAction = { openUrl("https://...") },
 *   ) {
 *       Icon(Icons.Outlined.Info, contentDescription = "Ajuda")
 *   }
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppRichTooltip(
    title: String,
    tooltip: String,
    modifier: Modifier = Modifier,
    actionLabel: String? = null,
    onAction: (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    val tooltipState = rememberTooltipState(isPersistent = true)
    TooltipBox(
        positionProvider = TooltipDefaults.rememberRichTooltipPositionProvider(),
        tooltip = {
            RichTooltip(
                title  = { Text(title) },
                action = if (actionLabel != null && onAction != null) {
                    {
                        TextButton(onClick = onAction) { Text(actionLabel) }
                    }
                } else null,
            ) {
                Text(tooltip)
            }
        },
        state    = tooltipState,
        modifier = modifier,
        content  = content,
    )
}

// ─── Preview ──────────────────────────────────────────────────────────────────

@Preview(showBackground = true)
@Composable
private fun AppTooltipPreview() {
    AppTheme {
        AppTooltip(tooltip = "Informação adicional sobre este campo") {
            Icon(Icons.Outlined.Info, contentDescription = "Ajuda")
        }
    }
}