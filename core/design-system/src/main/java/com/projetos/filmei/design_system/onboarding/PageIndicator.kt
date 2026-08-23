package com.projetos.filmei.design_system.onboarding

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Indicador de páginas (dots) animado.
 *
 * Pertence ao :core:designsystem — sem dependência de ViewModel ou navegação.
 *
 * @param pageCount    Número total de páginas.
 * @param currentPage  Índice da página ativa (0-based).
 * @param accentColor  Cor do dot ativo, já animada pelo container pai.
 */
@Composable
fun PageIndicator(
    pageCount: Int,
    currentPage: Int,
    accentColor: Color,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pageCount) { index ->
            val isSelected = index == currentPage

            val dotWidth by animateDpAsState(
                targetValue = if (isSelected) 28.dp else 8.dp,
                animationSpec = spring(stiffness = Spring.StiffnessMedium),
                label = "dotWidth_$index"
            )
            val dotColor by animateColorAsState(
                targetValue = if (isSelected) accentColor else Color.White.copy(alpha = 0.35f),
                animationSpec = tween(300),
                label = "dotColor_$index"
            )

            Box(
                modifier = Modifier
                    .height(8.dp)
                    .width(dotWidth)
                    .clip(CircleShape)
                    .background(dotColor)
            )
        }
    }
}