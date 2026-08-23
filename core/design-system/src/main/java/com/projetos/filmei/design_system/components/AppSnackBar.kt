package com.projetos.filmei.design_system.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

// ─── Tipos de snackbar ────────────────────────────────────────────────────────

enum class SnackbarStyle { Default, Success, Error, Warning, Info }

/**
 * Host de snackbar padronizado.
 * Coloque no Scaffold principal do app.
 *
 * Uso no Scaffold:
 *   val snackbarHostState = remember { SnackbarHostState() }
 *
 *   Scaffold(snackbarHost = { AppSnackbarHost(snackbarHostState) }) { ... }
 *
 *   // Disparar de um ObserveAsEvents:
 *   ObserveAsEvents(viewModel.events) { event ->
 *       when (event) {
 *           is ShowSnackbar -> snackbarHostState.showSnackbar(
 *               message = event.message.asString(context),
 *               actionLabel = event.actionLabel,
 *               duration = SnackbarDuration.Short,
 *           )
 *       }
 *   }
 */
@Composable
fun AppSnackbarHost(
    hostState: SnackbarHostState,
    modifier: Modifier = Modifier,
) {
    SnackbarHost(
        hostState = hostState,
        modifier = modifier,
        snackbar = { data ->
            Snackbar(
                snackbarData = data,
                shape = MaterialTheme.shapes.medium,
            )
        },
    )
}

// ─── Preview ──────────────────────────────────────────────────────────────────

@Preview(showBackground = true)
@Composable
private fun AppSnackbarPreview() {
    Snackbar(
        action = { TextButton(onClick = {}) { Text("Desfazer") } },
    ) {
        Text("Nota salva com sucesso")
    }

}