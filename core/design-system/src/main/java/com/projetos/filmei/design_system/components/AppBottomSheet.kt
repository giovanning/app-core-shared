package com.projetos.filmei.design_system.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * BottomSheet modal padrão com conteúdo customizável via slot.
 *
 * Uso:
 *   val sheetState = rememberModalBottomSheetState()
 *   if (state.showSheet) {
 *       AppBottomSheet(
 *           onDismiss = { onAction(DismissSheet) },
 *           sheetState = sheetState,
 *       ) {
 *           Text("Conteúdo aqui")
 *       }
 *   }
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBottomSheet(
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    sheetState: SheetState = rememberModalBottomSheetState(),
    title: String? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
        ) {
            title?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 16.dp),
                )
                HorizontalDivider()
                Spacer(Modifier.height(8.dp))
            }
            content()
        }
    }
}

// ─── Menu de ações ────────────────────────────────────────────────────────────

data class BottomSheetAction(
    val label: String,
    val icon: ImageVector,
    val onClick: () -> Unit,
    val isDestructive: Boolean = false,
)

/**
 * BottomSheet de ações — lista de itens clicáveis.
 * Padrão para menus de contexto (share, delete, edit, etc).
 *
 * Uso:
 *   AppActionsBottomSheet(
 *       title = "Nota",
 *       actions = listOf(
 *           BottomSheetAction("Compartilhar", Icons.Outlined.Share) { onAction(Share) },
 *           BottomSheetAction("Excluir", Icons.Outlined.Delete, isDestructive = true) { onAction(Delete) },
 *       ),
 *       onDismiss = { onAction(DismissSheet) },
 *   )
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppActionsBottomSheet(
    actions: List<BottomSheetAction>,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    title: String? = null,
    sheetState: SheetState = rememberModalBottomSheetState(),
) {
    AppBottomSheet(
        onDismiss = onDismiss,
        sheetState = sheetState,
        title = title,
        modifier = modifier,
    ) {
        actions.forEach { action ->
            ListItem(
                headlineContent = {
                    Text(
                        text = action.label,
                        color = if (action.isDestructive)
                            MaterialTheme.colorScheme.error
                        else
                            MaterialTheme.colorScheme.onSurface,
                    )
                },
                leadingContent = {
                    Icon(
                        imageVector = action.icon,
                        contentDescription = null,
                        tint = if (action.isDestructive)
                            MaterialTheme.colorScheme.error
                        else
                            MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ListItemDefaults.colors(containerColor = MaterialTheme.colorScheme.surface),
            )
            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
        }
    }
}

// ─── Preview ──────────────────────────────────────────────────────────────────

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun AppActionsBottomSheetPreview() {
    AppActionsBottomSheet(
        title = "Nota",
        actions = listOf(
            BottomSheetAction("Compartilhar", Icons.Outlined.Share, onClick = {}),
            BottomSheetAction(
                "Excluir",
                Icons.Outlined.Delete,
                isDestructive = true,
                onClick = {}),
        ),
        onDismiss = {},
    )

}