package giovanni.projetos.com.designsystem.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import giovanni.projetos.com.designsystem.theme.AppTheme

/**
 * Diálogo de confirmação padrão.
 *
 * Uso:
 *   if (state.showDeleteDialog) {
 *       AppConfirmDialog(
 *           title = "Excluir nota?",
 *           message = "Esta ação não pode ser desfeita.",
 *           confirmLabel = "Excluir",
 *           isDestructive = true,
 *           onConfirm = { onAction(ConfirmDelete) },
 *           onDismiss = { onAction(DismissDialog) },
 *       )
 *   }
 */
@Composable
fun AppConfirmDialog(
    title: String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    message: String? = null,
    confirmLabel: String = "Confirmar",
    dismissLabel: String = "Cancelar",
    isDestructive: Boolean = false,
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        modifier = modifier,
        title = { Text(title) },
        text = message?.let { { Text(it) } },
        confirmButton = {
            TextButton(
                onClick = onConfirm,
                colors = if (isDestructive) {
                    ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.error)
                } else ButtonDefaults.textButtonColors(),
            ) {
                Text(confirmLabel)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text(dismissLabel) }
        },
    )
}

/**
 * Diálogo com conteúdo customizável via slot.
 *
 * Uso:
 *   AppCustomDialog(
 *       title = "Escolha uma opção",
 *       onDismiss = { onAction(DismissDialog) },
 *   ) {
 *       // qualquer composable aqui
 *       RadioGroup(...)
 *   }
 */
@Composable
fun AppCustomDialog(
    title: String,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    dismissLabel: String = "Fechar",
    confirmLabel: String? = null,
    onConfirm: (() -> Unit)? = null,
    properties: DialogProperties = DialogProperties(),
    content: @Composable ColumnScope.() -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        modifier = modifier,
        properties = properties,
        title = { Text(title) },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                content()
            }
        },
        confirmButton = {
            if (confirmLabel != null && onConfirm != null) {
                TextButton(onClick = onConfirm) { Text(confirmLabel) }
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text(dismissLabel) }
        },
    )
}

// ─── Preview ──────────────────────────────────────────────────────────────────

@Preview
@Composable
private fun AppConfirmDialogPreview() {
    AppTheme {
        AppConfirmDialog(
            title = "Excluir item?",
            message = "Esta ação não pode ser desfeita.",
            isDestructive = true,
            onConfirm = {},
            onDismiss = {},
        )
    }
}