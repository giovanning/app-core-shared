package giovanni.projetos.com.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.projetos.filmei.design_system.icons.AppIcons
import com.projetos.filmei.design_system.icons.AppIcons.Inbox
import com.projetos.filmei.design_system.icons.AppIcons.SearchOff
import com.projetos.filmei.design_system.icons.AppIcons.WifiOff

/**
 * Estado vazio, erro ou ausência de conteúdo.
 *
 * Uso — lista vazia:
 *   EmptyStateView(
 *       icon = Icons.Outlined.Inbox,
 *       title = "Nenhuma nota ainda",
 *       description = "Toque em '+' para criar a sua primeira nota.",
 *   )
 *
 * Uso — erro com retry:
 *   EmptyStateView(
 *       icon = Icons.Outlined.WifiOff,
 *       title = "Sem conexão",
 *       description = "Verifique a sua internet e tente novamente.",
 *       primaryActionLabel = "Tentar novamente",
 *       onPrimaryAction = viewModel::retry,
 *   )
 */
@Composable
fun EmptyStateView(
    title: String,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    iconSize: Dp = 72.dp,
    description: String? = null,
    primaryActionLabel: String? = null,
    onPrimaryAction: (() -> Unit)? = null,
    secondaryActionLabel: String? = null,
    onSecondaryAction: (() -> Unit)? = null,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        icon?.let {
            Icon(
                imageVector = it,
                contentDescription = null,
                modifier = Modifier.size(iconSize),
                tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
            )
            Spacer(Modifier.height(16.dp))
        }
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
        )
        description?.let {
            Spacer(Modifier.height(8.dp))
            Text(
                text = it,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )
        }
        if (primaryActionLabel != null && onPrimaryAction != null) {
            Spacer(Modifier.height(24.dp))
            Button(onClick = onPrimaryAction, modifier = Modifier.fillMaxWidth(0.6f)) {
                Text(primaryActionLabel)
            }
        }
        if (secondaryActionLabel != null && onSecondaryAction != null) {
            Spacer(Modifier.height(8.dp))
            OutlinedButton(onClick = onSecondaryAction, modifier = Modifier.fillMaxWidth(0.6f)) {
                Text(secondaryActionLabel)
            }
        }
    }
}

// ─── Variantes prontas ────────────────────────────────────────────────────────

@Composable
fun EmptyListView(
    title: String = "Nada por aqui",
    description: String? = "O conteúdo aparecerá aqui quando disponível.",
    modifier: Modifier = Modifier,
) = EmptyStateView(icon = Inbox, title = title, description = description, modifier = modifier)

@Composable
fun EmptySearchView(query: String, onClearSearch: () -> Unit, modifier: Modifier = Modifier) =
    EmptyStateView(
        icon = SearchOff,
        title = "Nenhum resultado para \"$query\"",
        primaryActionLabel = "Limpar busca",
        onPrimaryAction = onClearSearch,
        modifier = modifier,
    )

@Composable
fun NetworkErrorView(onRetry: () -> Unit, modifier: Modifier = Modifier) =
    EmptyStateView(
        icon = WifiOff,
        title = "Sem conexão",
        description = "Verifique sua internet e tente novamente.",
        primaryActionLabel = "Tentar novamente",
        onPrimaryAction = onRetry,
        modifier = modifier,
    )

@Composable
fun GenericErrorView(onRetry: () -> Unit, modifier: Modifier = Modifier) =
    EmptyStateView(
        icon = AppIcons.Error,
        title = "Algo deu errado",
        description = "Ocorreu um erro inesperado.",
        primaryActionLabel = "Tentar novamente",
        onPrimaryAction = onRetry,
        modifier = modifier,
    )

// ─── Preview ──────────────────────────────────────────────────────────────────

@Preview(showBackground = true)
@Composable
private fun EmptyStateViewPreview() {
    NetworkErrorView(onRetry = {})
}