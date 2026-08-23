package com.projetos.filmei.design_system.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

data class AppBottomBarItem(
    val label: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector = icon,
    val contentDescription: String = label,
    val badgeCount: Int? = null,
    val route: String,
)

/**
 * BottomBar de navegação principal.
 *
 * Uso:
 *   val items = listOf(
 *       AppBottomBarItem("Home",   Icons.Outlined.Home,   Icons.Filled.Home,   route = "home"),
 *       AppBottomBarItem("Perfil", Icons.Outlined.Person, Icons.Filled.Person, route = "profile"),
 *   )
 *   AppBottomBar(
 *       items = items,
 *       currentRoute = currentRoute,
 *       onItemClick = { navController.navigate(it.route) },
 *   )
 */
@Composable
fun AppBottomBar(
    items: List<AppBottomBarItem>,
    currentRoute: String,
    onItemClick: (AppBottomBarItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    NavigationBar(modifier = modifier) {
        items.forEach { item ->
            val isSelected = item.route == currentRoute
            NavigationBarItem(
                selected = isSelected,
                onClick = { onItemClick(item) },
                label = { Text(item.label) },
                icon = {
                    if (item.badgeCount != null && item.badgeCount > 0) {
                        BadgedBox(
                            badge = {
                                Badge { Text(if (item.badgeCount > 99) "99+" else "${item.badgeCount}") }
                            }
                        ) {
                            Icon(
                                imageVector = if (isSelected) item.selectedIcon else item.icon,
                                contentDescription = item.contentDescription,
                            )
                        }
                    } else {
                        Icon(
                            imageVector = if (isSelected) item.selectedIcon else item.icon,
                            contentDescription = item.contentDescription,
                        )
                    }
                },
            )
        }
    }
}

// ─── Preview ──────────────────────────────────────────────────────────────────

@Preview(showBackground = true)
@Composable
private fun AppBottomBarPreview() {
    AppBottomBar(
        items = listOf(
            AppBottomBarItem("Home", Icons.Outlined.Home, route = "home"),
            AppBottomBarItem("Buscar", Icons.Outlined.Search, route = "search"),
            AppBottomBarItem(
                "Avisos",
                Icons.Outlined.Notifications,
                route = "notifs",
                badgeCount = 3
            ),
            AppBottomBarItem("Perfil", Icons.Outlined.Person, route = "profile"),
        ),
        currentRoute = "home",
        onItemClick = {},
    )

}