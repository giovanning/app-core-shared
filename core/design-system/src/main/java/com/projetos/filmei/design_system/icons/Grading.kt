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
public val grading: ImageVector
  get() {
    if (_grading != null) {
      return _grading!!
    }
    _grading =
      ImageVector.Builder(
          name = "grading",
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
            moveTo(16.43f, 20.98f)
            lineTo(13.6f, 18.15f)
            lineTo(15f, 16.75f)
            lineToRelative(1.43f, 1.43f)
            lineTo(19.6f, 15f)
            lineTo(21f, 16.4f)
            lineToRelative(-4.57f, 4.58f)
            close()
            moveTo(3f, 21f)
            verticalLineTo(19f)
            horizontalLineToRelative(9f)
            verticalLineToRelative(2f)
            horizontalLineTo(3f)
            close()
            moveTo(3f, 17f)
            verticalLineTo(15f)
            horizontalLineToRelative(9f)
            verticalLineToRelative(2f)
            horizontalLineTo(3f)
            close()
            moveTo(3f, 13f)
            verticalLineTo(11f)
            horizontalLineTo(21f)
            verticalLineToRelative(2f)
            horizontalLineTo(3f)
            close()
            moveTo(3f, 9f)
            verticalLineTo(7f)
            horizontalLineTo(21f)
            verticalLineTo(9f)
            horizontalLineTo(3f)
            close()
            moveTo(3f, 5f)
            verticalLineTo(3f)
            horizontalLineTo(21f)
            verticalLineTo(5f)
            horizontalLineTo(3f)
            close()
          }
        }
        .build()
    return _grading!!
  }

private var _grading: ImageVector? = null
