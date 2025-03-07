package rana.krishna.gamehokapp.utils

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import kotlin.times

class PremiumShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            moveTo(size.width * 0.15f, 0f) // Start from top-left with an offset
            lineTo(size.width, 0f)  // Top-right
            lineTo(size.width * 0.85f, size.height) // Bottom-right with offset
            lineTo(0f, size.height) // Bottom-left
            close()
        }
        return Outline.Generic(path)
    }

}