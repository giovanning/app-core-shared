package giovanni.projetos.com.designsystem.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import giovanni.projetos.com.designsystem.theme.AppTheme

data class AppTopBarAction(
    val icon: ImageVector,
    val contentDescription: String,
    val onClick: () -> Unit,
)

/**
 * TopBar padrão com suporte a navegação, ações e menu overflow.
 *
 * Uso:
 *   AppTopBar(
 *       title = "Detalhes",
 *       onNavigateBack = onNavigateBack,
 *       actions = listOf(
 *           AppTopBarAction(Icons.Outlined.Share, "Compartilhar") { onAction(Share) }
 *       )
 *   )
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    onNavigateBack: (() -> Unit)? = null,
    actions: List<AppTopBarAction> = emptyList(),
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    TopAppBar(
        title = {
            if (subtitle != null) {
                ListItem(
                    headlineContent = { Text(title, style = MaterialTheme.typography.titleLarge) },
                    supportingContent = { Text(subtitle, style = MaterialTheme.typography.bodySmall) },
                )
            } else {
                Text(title)
            }
        },
        modifier = modifier,
        navigationIcon = {
            onNavigateBack?.let {
                IconButton(onClick = it) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                        contentDescription = "Voltar",
                    )
                }
            }
        },
        actions = {
            actions.forEach { action ->
                IconButton(onClick = action.onClick) {
                    Icon(
                        imageVector = action.icon,
                        contentDescription = action.contentDescription,
                    )
                }
            }
        },
        scrollBehavior = scrollBehavior,
    )
}

// ─── Preview ──────────────────────────────────────────────────────────────────

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
private fun AppTopBarPreview() {
    AppTheme {
        AppTopBar(
            title = "Detalhes",
            subtitle = "Última edição: hoje",
            onNavigateBack = {},
            actions = listOf(
                AppTopBarAction(Icons.Outlined.MoreVert, "Mais opções") {}
            )
        )
    }
}