package org.maplibre.compose.layers

import org.maplibre.compose.expressions.ast.CompiledExpression
import org.maplibre.compose.expressions.value.ColorValue
import org.maplibre.compose.expressions.value.FloatValue
import org.maplibre.compose.expressions.value.ImageValue

internal actual class BackgroundLayer actual constructor(id: String) : Layer() {

  override val impl = org.maplibre.kmp.native.layers.BackgroundLayer(id)

  actual fun setBackgroundColor(color: CompiledExpression<ColorValue>) {
    setProperty("background-color", color)
  }

  actual fun setBackgroundPattern(pattern: CompiledExpression<ImageValue>) {
    setProperty("background-pattern", pattern)
  }

  actual fun setBackgroundOpacity(opacity: CompiledExpression<FloatValue>) {
    setProperty("background-opacity", opacity)
  }
}
