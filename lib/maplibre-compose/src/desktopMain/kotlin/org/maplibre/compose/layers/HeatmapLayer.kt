package org.maplibre.compose.layers

import org.maplibre.compose.expressions.ast.CompiledExpression
import org.maplibre.compose.expressions.value.BooleanValue
import org.maplibre.compose.expressions.value.ColorValue
import org.maplibre.compose.expressions.value.DpValue
import org.maplibre.compose.expressions.value.FloatValue
import org.maplibre.compose.sources.Source

internal actual class HeatmapLayer actual constructor(id: String, source: Source) :
  FeatureLayer(source) {
  override val impl = org.maplibre.kmp.native.layers.HeatmapLayer(id, source.id)

  actual override var sourceLayer: String = ""
    set(value) {
      field = value
      setProperty("source-layer", org.maplibre.compose.expressions.ast.StringLiteral.of(value))
    }

  actual override fun setFilter(filter: CompiledExpression<BooleanValue>) {
    setFilterInternal(filter)
  }

  actual fun setHeatmapRadius(radius: CompiledExpression<DpValue>) {
    setProperty("heatmap-radius", radius)
  }

  actual fun setHeatmapWeight(weight: CompiledExpression<FloatValue>) {
    setProperty("heatmap-weight", weight)
  }

  actual fun setHeatmapIntensity(intensity: CompiledExpression<FloatValue>) {
    setProperty("heatmap-intensity", intensity)
  }

  actual fun setHeatmapColor(color: CompiledExpression<ColorValue>) {
    setProperty("heatmap-color", color)
  }

  actual fun setHeatmapOpacity(opacity: CompiledExpression<FloatValue>) {
    setProperty("heatmap-opacity", opacity)
  }
}
