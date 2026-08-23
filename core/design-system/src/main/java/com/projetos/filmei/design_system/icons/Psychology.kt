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
public val psychology: ImageVector
  get() {
    if (_psychology != null) {
      return _psychology!!
    }
    _psychology =
      ImageVector.Builder(
          name = "psychology",
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
            moveTo(6f, 22f)
            verticalLineTo(17.7f)
            quadTo(4.58f, 16.4f, 3.79f, 14.66f)
            reflectiveQuadTo(3f, 11f)
            quadTo(3f, 7.25f, 5.63f, 4.63f)
            reflectiveQuadTo(12f, 2f)
            quadToRelative(3.13f, 0f, 5.54f, 1.84f)
            quadToRelative(2.41f, 1.84f, 3.14f, 4.79f)
            lineToRelative(1.3f, 5.13f)
            quadToRelative(0.13f, 0.47f, -0.18f, 0.86f)
            reflectiveQuadTo(21f, 15f)
            horizontalLineTo(19f)
            verticalLineToRelative(3f)
            quadToRelative(0f, 0.82f, -0.59f, 1.41f)
            reflectiveQuadTo(17f, 20f)
            horizontalLineTo(15f)
            verticalLineToRelative(2f)
            horizontalLineTo(13f)
            verticalLineTo(18f)
            horizontalLineToRelative(4f)
            verticalLineTo(13f)
            horizontalLineToRelative(2.7f)
            lineTo(18.75f, 9.13f)
            quadTo(18.18f, 6.85f, 16.3f, 5.43f)
            reflectiveQuadTo(12f, 4f)
            quadTo(9.1f, 4f, 7.05f, 6.02f)
            reflectiveQuadTo(5f, 10.95f)
            quadToRelative(0f, 1.5f, 0.61f, 2.85f)
            reflectiveQuadToRelative(1.74f, 2.4f)
            lineTo(8f, 16.8f)
            verticalLineTo(22f)
            horizontalLineTo(6f)
            close()
            moveToRelative(6.35f, -9f)
            close()
            moveTo(11f, 15f)
            horizontalLineToRelative(2f)
            lineToRelative(0.15f, -1.25f)
            quadToRelative(0.2f, -0.08f, 0.36f, -0.18f)
            reflectiveQuadTo(13.8f, 13.35f)
            lineToRelative(1.15f, 0.5f)
            lineToRelative(1f, -1.7f)
            lineToRelative(-1f, -0.75f)
            quadTo(15f, 11.2f, 15f, 11f)
            reflectiveQuadTo(14.95f, 10.6f)
            lineToRelative(1f, -0.75f)
            lineToRelative(-1f, -1.7f)
            lineTo(13.8f, 8.65f)
            quadTo(13.68f, 8.52f, 13.51f, 8.42f)
            reflectiveQuadTo(13.15f, 8.25f)
            lineTo(13f, 7f)
            horizontalLineTo(11f)
            lineTo(10.85f, 8.25f)
            quadToRelative(-0.2f, 0.07f, -0.36f, 0.17f)
            reflectiveQuadTo(10.2f, 8.65f)
            lineTo(9.05f, 8.15f)
            lineToRelative(-1f, 1.7f)
            lineToRelative(1f, 0.75f)
            quadTo(9f, 10.8f, 9f, 11f)
            reflectiveQuadToRelative(0.05f, 0.4f)
            lineToRelative(-1f, 0.75f)
            lineToRelative(1f, 1.7f)
            lineToRelative(1.15f, -0.5f)
            quadToRelative(0.13f, 0.13f, 0.29f, 0.22f)
            reflectiveQuadToRelative(0.36f, 0.18f)
            lineTo(11f, 15f)
            close()
            moveTo(10.94f, 12.06f)
            quadTo(10.5f, 11.63f, 10.5f, 11f)
            reflectiveQuadTo(10.94f, 9.94f)
            reflectiveQuadTo(12f, 9.5f)
            reflectiveQuadToRelative(1.06f, 0.44f)
            reflectiveQuadTo(13.5f, 11f)
            reflectiveQuadToRelative(-0.44f, 1.06f)
            reflectiveQuadTo(12f, 12.5f)
            reflectiveQuadTo(10.94f, 12.06f)
            close()
          }
        }
        .build()
    return _psychology!!
  }

private var _psychology: ImageVector? = null
