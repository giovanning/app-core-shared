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
public val save_as: ImageVector
  get() {
    if (_save_as != null) {
      return _save_as!!
    }
    _save_as =
      ImageVector.Builder(
          name = "save_as",
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
            moveTo(5f, 21f)
            quadTo(4.18f, 21f, 3.59f, 20.41f)
            reflectiveQuadTo(3f, 19f)
            verticalLineTo(5f)
            quadTo(3f, 4.17f, 3.59f, 3.59f)
            reflectiveQuadTo(5f, 3f)
            horizontalLineTo(17f)
            lineToRelative(4f, 4f)
            verticalLineToRelative(5.3f)
            quadTo(20.53f, 12.1f, 20.01f, 12.04f)
            reflectiveQuadTo(19f, 12.05f)
            verticalLineTo(7.82f)
            lineTo(16.18f, 5f)
            horizontalLineTo(5f)
            verticalLineTo(19f)
            horizontalLineToRelative(6f)
            verticalLineToRelative(0.1f)
            verticalLineTo(21f)
            horizontalLineTo(5f)
            close()
            moveTo(5f, 5f)
            verticalLineTo(7.82f)
            verticalLineToRelative(4.22f)
            quadToRelative(0f, 0.08f, 0f, 0.31f)
            reflectiveQuadToRelative(0f, 0.61f)
            verticalLineTo(19f)
            verticalLineTo(5f)
            close()
            moveToRelative(8f, 18f)
            verticalLineTo(19.93f)
            lineToRelative(5.53f, -5.5f)
            quadToRelative(0.22f, -0.22f, 0.5f, -0.32f)
            reflectiveQuadTo(19.58f, 14f)
            quadToRelative(0.3f, 0f, 0.57f, 0.11f)
            quadToRelative(0.27f, 0.11f, 0.5f, 0.34f)
            lineToRelative(0.93f, 0.93f)
            quadToRelative(0.2f, 0.22f, 0.31f, 0.5f)
            reflectiveQuadTo(22f, 16.43f)
            reflectiveQuadToRelative(-0.1f, 0.56f)
            quadToRelative(-0.1f, 0.29f, -0.32f, 0.51f)
            lineTo(16.08f, 23f)
            horizontalLineTo(13f)
            close()
            moveToRelative(7.5f, -6.57f)
            lineTo(19.58f, 15.5f)
            lineToRelative(0.92f, 0.93f)
            close()
            moveToRelative(-6f, 5.07f)
            horizontalLineToRelative(0.95f)
            lineToRelative(3.03f, -3.05f)
            lineTo(18.03f, 17.98f)
            lineTo(17.55f, 17.52f)
            lineTo(14.5f, 20.55f)
            verticalLineTo(21.5f)
            close()
            moveToRelative(3.53f, -3.52f)
            lineTo(17.55f, 17.52f)
            lineToRelative(0.93f, 0.93f)
            lineTo(18.03f, 17.98f)
            close()
            moveTo(6f, 10f)
            horizontalLineToRelative(9f)
            verticalLineTo(6f)
            horizontalLineTo(6f)
            verticalLineToRelative(4f)
            close()
            moveToRelative(6f, 8f)
            quadToRelative(0.03f, 0f, 0.05f, 0f)
            reflectiveQuadToRelative(0.05f, 0f)
            lineTo(15f, 15.13f)
            quadToRelative(0f, -0.05f, 0f, -0.06f)
            reflectiveQuadTo(15f, 15f)
            quadToRelative(0f, -1.25f, -0.88f, -2.13f)
            reflectiveQuadTo(12f, 12f)
            reflectiveQuadTo(9.88f, 12.88f)
            reflectiveQuadTo(9f, 15f)
            reflectiveQuadToRelative(0.88f, 2.13f)
            reflectiveQuadTo(12f, 18f)
            close()
          }
        }
        .build()
    return _save_as!!
  }

private var _save_as: ImageVector? = null
