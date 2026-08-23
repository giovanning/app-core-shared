package giovanni.projetos.com.designsystem.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import giovanni.projetos.com.designsystem.theme.AppTheme

/**
 * Card padrão — surface com elevação, shape e padding configuráveis.
 * Usa slot API para máxima flexibilidade de conteúdo.
 *
 * Uso:
 *   AppCard(onClick = { onAction(OpenDetail(id)) }) {
 *       Text("Título")
 *       Text("Subtítulo", style = MaterialTheme.typography.bodySmall)
 *   }
 *
 * Apenas visual (sem click):
 *   AppCard { Text("Conteúdo") }
 */
@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    shape: Shape = MaterialTheme.shapes.medium,
    elevation: Dp = 1.dp,
    contentPadding: PaddingValues = PaddingValues(16.dp),
    content: @Composable ColumnScope.() -> Unit,
) {
    if (onClick != null) {
        Card(
            onClick = onClick,
            modifier = modifier,
            shape = shape,
            elevation = CardDefaults.cardElevation(defaultElevation = elevation),
        ) {
            Column(
                modifier = Modifier.padding(contentPadding),
                content = content,
            )
        }
    } else {
        Card(
            modifier = modifier,
            shape = shape,
            elevation = CardDefaults.cardElevation(defaultElevation = elevation),
        ) {
            Column(
                modifier = Modifier.padding(contentPadding),
                content = content,
            )
        }
    }
}

/**
 * Card com cabeçalho separado por divisor.
 *
 * Uso:
 *   AppSectionCard(
 *       header = { Text("Resumo", style = MaterialTheme.typography.titleMedium) },
 *   ) {
 *       Text("Conteúdo da seção")
 *   }
 */
@Composable
fun AppSectionCard(
    modifier: Modifier = Modifier,
    header: @Composable () -> Unit,
    onClick: (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    AppCard(modifier = modifier, onClick = onClick, contentPadding = PaddingValues(0.dp)) {
        Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) { header() }
        HorizontalDivider()
        Column(modifier = Modifier.padding(16.dp)) { content() }
    }
}

// ─── Preview ──────────────────────────────────────────────────────────────────

@Preview(showBackground = true)
@Composable
private fun AppCardPreview() {
    AppTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            AppCard {
                Text("Card simples", style = MaterialTheme.typography.titleMedium)
                Text("Subtítulo aqui", style = MaterialTheme.typography.bodySmall)
            }
            AppCard(onClick = {}) {
                Text("Card clicável", style = MaterialTheme.typography.titleMedium)
            }
            AppSectionCard(header = {
                Text(
                    "Seção",
                    style = MaterialTheme.typography.titleSmall
                )
            }) {
                Text("Conteúdo da seção")
            }
        }
    }
}