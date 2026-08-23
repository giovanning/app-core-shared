package giovanni.projetos.com.designsystem.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import giovanni.projetos.com.designsystem.theme.AppTheme

// ─── Modifier ─────────────────────────────────────────────────────────────────

fun Modifier.shimmerEffect(
    baseColor: Color = Color(0xFFE0E0E0),
    highlightColor: Color = Color(0xFFF5F5F5),
    durationMs: Int = 1000,
): Modifier = composed {
    val transition = rememberInfiniteTransition(label = "shimmer")
    val translateAnim by transition.animateFloat(
        initialValue = 0f,
        targetValue  = 1000f,
        animationSpec = infiniteRepeatable(
            animation  = tween(durationMillis = durationMs, easing = FastOutLinearInEasing),
            repeatMode = RepeatMode.Restart,
        ),
        label = "shimmer_translate",
    )
    background(
        brush = Brush.linearGradient(
            colors = listOf(baseColor, highlightColor, baseColor),
            start  = Offset(translateAnim - 200f, 0f),
            end    = Offset(translateAnim, 0f),
        )
    )
}

// ─── ShimmerBox genérico ──────────────────────────────────────────────────────

@Composable
fun ShimmerBox(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(4.dp),
) {
    Box(modifier = modifier.clip(shape).shimmerEffect())
}

// ─── Layouts prontos ──────────────────────────────────────────────────────────

/**
 * Placeholder para item de lista com avatar + duas linhas de texto.
 */
@Composable
fun ShimmerListItem(
    modifier: Modifier = Modifier,
    avatarSize: Dp = 48.dp,
    showAvatar: Boolean = true,
) {
    Row(
        modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (showAvatar) {
            ShimmerBox(modifier = Modifier.size(avatarSize), shape = CircleShape)
            Spacer(Modifier.width(12.dp))
        }
        Column(modifier = Modifier.weight(1f)) {
            ShimmerBox(modifier = Modifier.fillMaxWidth(0.7f).height(14.dp))
            Spacer(Modifier.height(8.dp))
            ShimmerBox(modifier = Modifier.fillMaxWidth(0.4f).height(12.dp))
        }
    }
}

/**
 * Placeholder para card com imagem de capa + título + subtítulo.
 */
@Composable
fun ShimmerCard(
    modifier: Modifier = Modifier,
    imageHeight: Dp = 180.dp,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        ShimmerBox(
            modifier = Modifier.fillMaxWidth().height(imageHeight),
            shape    = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        )
        Spacer(Modifier.height(12.dp))
        ShimmerBox(modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth(0.75f).height(16.dp))
        Spacer(Modifier.height(8.dp))
        ShimmerBox(modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth(0.45f).height(12.dp))
        Spacer(Modifier.height(16.dp))
    }
}

// ─── Preview ──────────────────────────────────────────────────────────────────

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun ShimmerPreview() {
    AppTheme {
        Column {
            repeat(3) { ShimmerListItem() }
        }
    }
}