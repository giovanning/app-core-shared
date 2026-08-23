package giovanni.projetos.com.designsystem.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import giovanni.projetos.com.designsystem.theme.AppTheme

/**
 * Chip de filtro — alterna entre selecionado/não selecionado.
 *
 * Uso:
 *   AppFilterChip(
 *       label = "Urgente",
 *       selected = state.filterUrgent,
 *       onToggle = { onAction(ToggleFilter(Filter.Urgent)) },
 *   )
 */
@Composable
fun AppFilterChip(
    label: String,
    selected: Boolean,
    onToggle: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null,
) {
    FilterChip(
        selected = selected,
        onClick  = { onToggle(!selected) },
        label    = { Text(label) },
        modifier = modifier,
        leadingIcon = if (selected) {
            { Icon(Icons.Outlined.Check, contentDescription = null, modifier = Modifier.size(16.dp)) }
        } else {
            leadingIcon?.let { { Icon(it, contentDescription = null, modifier = Modifier.size(16.dp)) } }
        },
    )
}

/**
 * Chip de input — com ação de remover (X).
 * Ideal para listas de tags, destinatários, filtros aplicados.
 *
 * Uso:
 *   AppInputChip(
 *       label = "Kotlin",
 *       onRemove = { onAction(RemoveTag("Kotlin")) },
 *   )
 */
@Composable
fun AppInputChip(
    label: String,
    onRemove: () -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null,
) {
    InputChip(
        selected = false,
        onClick  = {},
        label    = { Text(label) },
        modifier = modifier,
        leadingIcon = leadingIcon?.let {
            { Icon(it, contentDescription = null, modifier = Modifier.size(16.dp)) }
        },
        trailingIcon = {
            IconButton(
                onClick = onRemove,
                modifier = Modifier.size(18.dp),
            ) {
                Icon(
                    imageVector = Icons.Outlined.Check, // use Icons.Outlined.Close
                    contentDescription = "Remover $label",
                    modifier = Modifier.size(14.dp),
                )
            }
        },
    )
}

/**
 * Chip de sugestão — não selecionável, apenas clicável.
 *
 * Uso:
 *   AppSuggestionChip(label = "Adicionar tag", onClick = { })
 */
@Composable
fun AppSuggestionChip(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null,
) {
    SuggestionChip(
        onClick = onClick,
        label   = { Text(label) },
        modifier = modifier,
        icon = leadingIcon?.let {
            { Icon(it, contentDescription = null, modifier = Modifier.size(16.dp)) }
        },
    )
}

// ─── Preview ──────────────────────────────────────────────────────────────────

@Preview(showBackground = true)
@Composable
private fun AppChipPreview() {
    AppTheme {
        var selected by remember { mutableStateOf(true) }
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                AppFilterChip("Todos", selected = true, onToggle = {})
                AppFilterChip("Urgente", selected = false, onToggle = {})
                AppFilterChip("Concluído", selected = selected, onToggle = { selected = it })
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                AppInputChip("Kotlin", onRemove = {})
                AppInputChip("Android", onRemove = {})
            }
            AppSuggestionChip("+ Adicionar tag", onClick = {})
        }
    }
}