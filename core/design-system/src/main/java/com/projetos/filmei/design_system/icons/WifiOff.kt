package com.projetos.filmei.design_system.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Suppress("CheckReturnValue")
public val wifi_off: ImageVector
  get() {
    if (_wifi_off != null) {
      return _wifi_off!!
    }
    _wifi_off =
      ImageVector.Builder(
          name = "wifi_off",
          defaultWidth = 24.dp,
          defaultHeight = 24.dp,
          viewportWidth = 24f,
          viewportHeight = 24f,
        )
        .apply {
          path(
            fill = SolidColor(Color.Black),
            fillAlpha = 1f,
            stroke = null,
            strokeAlpha = 1f,
            strokeLineWidth = 1f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Bevel,
            strokeLineMiter = 1f,
            pathFillType = PathFillType.Companion.NonZero,
          ) {
            moveTo(19.75f, 22.6f)
            lineToRelative(-9.4f, -9.45f)
            quadTo(9.18f, 13.43f, 8.16f, 13.98f)
            reflectiveQuadTo(6.35f, 15.35f)
            lineTo(4.25f, 13.2f)
            quadToRelative(0.8f, -0.8f, 1.73f, -1.4f)
            reflectiveQuadTo(7.95f, 10.75f)
            lineTo(5.7f, 8.5f)
            quadTo(4.68f, 9.02f, 3.79f, 9.66f)
            reflectiveQuadTo(2.1f, 11.1f)
            lineTo(0f, 8.95f)
            quadTo(0.8f, 8.15f, 1.66f, 7.51f)
            reflectiveQuadTo(3.5f, 6.3f)
            lineTo(1.4f, 4.2f)
            lineTo(2.8f, 2.8f)
            lineTo(21.2f, 21.2f)
            lineToRelative(-1.45f, 1.4f)
            close()
            moveTo(10.23f, 20.26f)
            quadTo(9.5f, 19.52f, 9.5f, 18.5f)
            quadToRelative(0f, -1.05f, 0.73f, -1.77f)
            reflectiveQuadTo(12f, 16f)
            reflectiveQuadToRelative(1.78f, 0.73f)
            reflectiveQuadTo(14.5f, 18.5f)
            quadToRelative(0f, 1.02f, -0.72f, 1.76f)
            reflectiveQuadTo(12f, 21f)
            reflectiveQuadTo(10.23f, 20.26f)
            close()
            moveTo(17.9f, 15.05f)
            quadTo(17.48f, 14.63f, 17.18f, 14.33f)
            reflectiveQuadTo(16.45f, 13.6f)
            lineTo(12.85f, 10f)
            quadToRelative(2.02f, 0.2f, 3.79f, 1.02f)
            reflectiveQuadToRelative(3.11f, 2.18f)
            lineTo(17.9f, 15.05f)
            close()
            moveToRelative(4f, -3.95f)
            quadTo(19.98f, 9.17f, 17.44f, 8.09f)
            reflectiveQuadTo(12f, 7f)
            quadTo(11.48f, 7f, 10.99f, 7.04f)
            reflectiveQuadTo(10f, 7.15f)
            lineTo(7.45f, 4.6f)
            quadTo(8.55f, 4.3f, 9.69f, 4.15f)
            reflectiveQuadTo(12f, 4f)
            quadToRelative(3.55f, 0f, 6.63f, 1.32f)
            reflectiveQuadTo(24f, 8.95f)
            lineTo(21.9f, 11.1f)
            close()
          }
        }
        .build()
    return _wifi_off!!
  }

private var _wifi_off: ImageVector? = null
