package com.projetos.filmei.design_system.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Escala de espaçamento em incrementos de 4dp. Use AppSpacing.medium em vez de
 * "16.dp" solto no código — isso é o que garante consistência visual entre
 * os apps que consomem este design system.
 *
 * Object simples em vez de CompositionLocal: os valores são fixos e não variam
 * por tema/contexto, então não há necessidade de propagação via composição.
 */
object AppSpacing {
    public val none: Dp = 0.dp
    public val extraSmall: Dp = 4.dp
    public val small: Dp = 8.dp
    public val medium: Dp = 16.dp
    public val large: Dp = 24.dp
    public val extraLarge: Dp = 32.dp
    public val extraExtraLarge: Dp = 48.dp
}
