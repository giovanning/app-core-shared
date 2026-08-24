package com.projetos.filmei.design_system.custom_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import com.projetos.filmei.design_system.icons.AppIcons
import com.projetos.filmei.design_system.theme.AppSpacing
import com.projetos.filmei.design_system.theme.AppTheme

/**
 * Estado vazio reutilizável — para listas sem itens, buscas sem resultado,
 * telas de erro leve, etc.
 *
 * @param actionLabel se non-null, exibe um botão de ação (ex: "Tentar novamente").
 */
@Composable
public fun AppEmptyState(
    icon: ImageVector,
    title: String,
    modifier: Modifier = Modifier,
    description: String? = null,
    actionLabel: String? = null,
    onActionClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(PaddingValues(AppSpacing.extraLarge)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null, // decorativo: o title já comunica o estado
            modifier = Modifier.padding(bottom = AppSpacing.medium),
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface
        )

        if (description != null) {
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = AppSpacing.extraSmall)
            )
        }

        if (actionLabel != null) {
            Button(
                onClick = onActionClick,
                modifier = Modifier.padding(top = AppSpacing.large)
            ) {
                Text(actionLabel)
            }
        }
    }
}

@androidx.compose.ui.tooling.preview.Preview
@Composable
private fun AppEmptyStatePreview() {
    AppTheme {
        AppEmptyState(
            icon = AppIcons.Error,
            title = "Nenhuma nota encontrada",
            description = "Crie sua primeira nota tocando no botão abaixo.",
            actionLabel = "Criar nota"
        )
    }
}