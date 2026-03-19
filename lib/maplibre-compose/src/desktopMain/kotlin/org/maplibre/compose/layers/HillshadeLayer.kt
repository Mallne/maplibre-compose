package org.maplibre.compose.layers

import org.maplibre.compose.expressions.ast.CompiledExpression
import org.maplibre.compose.expressions.value.ColorValue
import org.maplibre.compose.expressions.value.FloatValue
import org.maplibre.compose.expressions.value.IlluminationAnchor
import org.maplibre.compose.sources.Source

internal actual class HillshadeLayer actual constructor(id: String, actual val source: Source) :
  Layer() {
  override val impl = org.maplibre.kmp.native.layers.HillshadeLayer(id, source.id)

  actual fun setHillshadeIlluminationDirection(direction: CompiledExpression<FloatValue>) {
    setProperty("hillshade-illumination-direction", direction)
  }

  actual fun setHillshadeIlluminationAnchor(anchor: CompiledExpression<IlluminationAnchor>) {
    setProperty("hillshade-illumination-anchor", anchor)
  }

  actual fun setHillshadeExaggeration(exaggeration: CompiledExpression<FloatValue>) {
    setProperty("hillshade-exaggeration", exaggeration)
  }

  actual fun setHillshadeShadowColor(shadowColor: CompiledExpression<ColorValue>) {
    setProperty("hillshade-shadow-color", shadowColor)
  }

  actual fun setHillshadeHighlightColor(highlightColor: CompiledExpression<ColorValue>) {
    setProperty("hillshade-highlight-color", highlightColor)
  }

  actual fun setHillshadeAccentColor(accentColor: CompiledExpression<ColorValue>) {
    setProperty("hillshade-accent-color", accentColor)
  }
}
