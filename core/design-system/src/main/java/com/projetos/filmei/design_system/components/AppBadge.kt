package com.projetos.filmei.design_system.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Badge numérico ou ponto indicador sobre um ícone.
 *
 * Uso numérico:
 *   AppBadge(count = 5) {
 *       Icon(Icons.Outlined.Notifications, contentDescription = "Notificações")
 *   }
 *
 * Uso como ponto (sem número):
 *   AppBadge {
 *       Icon(Icons.Outlined.Notifications, contentDescription = "Notificações")
 *   }
 */
@Composable
fun AppBadge(
    modifier: Modifier = Modifier,
    count: Int? = null,
    content: @Composable BoxScope.() -> Unit,
) {
    BadgedBox(
        modifier = modifier,
        badge = {
            if (count != null) {
                Badge { Text(if (count > 99) "99+" else "$count") }
            } else {
                Badge()
            }
        },
        content = content,
    )
}

// ─── Preview ──────────────────────────────────────────────────────────────────

@Preview(showBackground = true)
@Composable
private fun AppBadgePreview() {
    Row(
        modifier = Modifier.padding(24.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        AppBadge(count = 3) {
            Icon(Icons.Outlined.Notifications, contentDescription = null)
        }
        AppBadge(count = 127) {
            Icon(Icons.Outlined.Notifications, contentDescription = null)
        }
        AppBadge {
            Icon(Icons.Outlined.Notifications, contentDescription = null)
        }
    }

}