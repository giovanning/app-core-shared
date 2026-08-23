package com.projetos.filmei.design_system.custom_components

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

enum class SyncStatus { IDLE, SYNCING, SUCCESS, ERROR }

@Composable
fun SyncStatusIndicator(
    status: SyncStatus,
    modifier: Modifier = Modifier
) {
    AnimatedVisibility(
        visible = status != SyncStatus.IDLE,
        enter   = fadeIn() + slideInVertically(),
        exit    = fadeOut() + slideOutVertically(),
        modifier = modifier
    ) {
        Surface(
            shape = MaterialTheme.shapes.small,
            color = when (status) {
                SyncStatus.SYNCING -> MaterialTheme.colorScheme.secondaryContainer
                SyncStatus.SUCCESS -> MaterialTheme.colorScheme.tertiaryContainer
                SyncStatus.ERROR   -> MaterialTheme.colorScheme.errorContainer
                SyncStatus.IDLE    -> MaterialTheme.colorScheme.surface
            },
            tonalElevation = 2.dp
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                when (status) {
                    SyncStatus.SYNCING -> {
                        CircularProgressIndicator(Modifier.size(12.dp), strokeWidth = 2.dp)
                        Text("Sincronizando com Sheets...", style = MaterialTheme.typography.labelSmall)
                    }
                    SyncStatus.SUCCESS -> {
                        Icon(Icons.Default.CheckCircle, null, Modifier.size(14.dp), tint = MaterialTheme.colorScheme.tertiary)
                        Text("Sheets atualizado", style = MaterialTheme.typography.labelSmall)
                    }
                    SyncStatus.ERROR -> {
                        Icon(Icons.Default.Warning, null, Modifier.size(14.dp), tint = MaterialTheme.colorScheme.error)
                        Text("Erro ao sincronizar", style = MaterialTheme.typography.labelSmall)
                    }
                    SyncStatus.IDLE -> {}
                }
            }
        }
    }
}