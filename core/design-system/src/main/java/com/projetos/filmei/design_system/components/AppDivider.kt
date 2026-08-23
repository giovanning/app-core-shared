package giovanni.projetos.com.designsystem.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import giovanni.projetos.com.designsystem.theme.AppTheme

/**
 * Divisor horizontal com espessura e cor configuráveis.
 */
@Composable
fun AppDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    color: Color = MaterialTheme.colorScheme.outlineVariant,
    indent: Dp = 0.dp,
) {
    HorizontalDivider(
        modifier  = modifier.padding(horizontal = indent),
        thickness = thickness,
        color     = color,
    )
}

/**
 * Divisor vertical para separar itens em linha.
 */
@Composable
fun AppVerticalDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    color: Color = MaterialTheme.colorScheme.outlineVariant,
) {
    VerticalDivider(
        modifier  = modifier,
        thickness = thickness,
        color     = color,
    )
}

/**
 * Divisor com label central — ex: "ou" entre opções de login.
 *
 * Uso:
 *   AppLabeledDivider(label = "ou")
 */
@Composable
fun AppLabeledDivider(
    label: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.outlineVariant,
) {
    Row(
        modifier          = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        HorizontalDivider(modifier = Modifier.weight(1f), color = color)
        Text(
            text     = label,
            modifier = Modifier.padding(horizontal = 16.dp),
            style    = MaterialTheme.typography.bodySmall,
            color    = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        HorizontalDivider(modifier = Modifier.weight(1f), color = color)
    }
}

// ─── Preview ──────────────────────────────────────────────────────────────────

@Preview(showBackground = true)
@Composable
private fun AppDividerPreview() {
    AppTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            AppDivider()
            AppDivider(indent = 16.dp)
            AppLabeledDivider(label = "ou")
            Row(modifier = Modifier.height(40.dp), verticalAlignment = Alignment.CenterVertically) {
                Text("Item A")
                Spacer(Modifier.width(8.dp))
                AppVerticalDivider(modifier = Modifier.fillMaxHeight())
                Spacer(Modifier.width(8.dp))
                Text("Item B")
            }
        }
    }
}