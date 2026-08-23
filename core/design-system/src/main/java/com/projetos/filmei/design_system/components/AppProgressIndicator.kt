package giovanni.projetos.com.designsystem.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import giovanni.projetos.com.designsystem.theme.AppTheme

/**
 * Indicador circular centralizado na tela — para loading de tela cheia.
 *
 * Uso:
 *   if (state.isLoading) AppLoadingScreen()
 */
@Composable
fun AppLoadingScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator()
    }
}

/**
 * Indicador circular inline — para loading dentro de um componente.
 *
 * Uso:
 *   AppCircularLoading(size = 24.dp, strokeWidth = 2.dp)
 */
@Composable
fun AppCircularLoading(
    modifier: Modifier = Modifier,
    size: Dp = 40.dp,
    strokeWidth: Dp = 4.dp,
) {
    CircularProgressIndicator(
        modifier    = modifier.size(size),
        strokeWidth = strokeWidth,
    )
}

/**
 * Barra de progresso linear determinada (com valor 0f..1f).
 *
 * Uso:
 *   AppLinearProgress(progress = state.uploadProgress)
 */
@Composable
fun AppLinearProgress(
    progress: Float,
    modifier: Modifier = Modifier,
) {
    val animatedProgress by animateFloatAsState(
        targetValue   = progress.coerceIn(0f, 1f),
        animationSpec = tween(durationMillis = 300),
        label         = "linear_progress",
    )
    LinearProgressIndicator(
        progress  = { animatedProgress },
        modifier  = modifier.fillMaxWidth(),
    )
}

/**
 * Barra de progresso linear indeterminada.
 *
 * Uso:
 *   if (state.isSyncing) AppLinearLoadingBar()
 */
@Composable
fun AppLinearLoadingBar(modifier: Modifier = Modifier) {
    LinearProgressIndicator(modifier = modifier.fillMaxWidth())
}

// ─── Preview ──────────────────────────────────────────────────────────────────

@Preview(showBackground = true)
@Composable
private fun AppProgressPreview() {
    AppTheme {
        Column(
            modifier = Modifier.padding(24.dp).fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AppCircularLoading()
            AppCircularLoading(size = 24.dp, strokeWidth = 2.dp)
            AppLinearProgress(progress = 0.65f)
            AppLinearLoadingBar()
        }
    }
}