package org.maplibre.compose.layers

import org.maplibre.compose.expressions.ast.CompiledExpression
import org.maplibre.compose.expressions.value.*
import org.maplibre.compose.sources.Source

internal actual class CircleLayer actual constructor(id: String, source: Source) :
  FeatureLayer(source) {
  override val impl = org.maplibre.kmp.native.layers.CircleLayer(id, source.id)

  actual override var sourceLayer: String = ""
    set(value) {
      field = value
      setProperty("source-layer", org.maplibre.compose.expressions.ast.StringLiteral.of(value))
    }

  actual override fun setFilter(filter: CompiledExpression<BooleanValue>) {
    setFilterInternal(filter)
  }

  actual fun setCircleSortKey(sortKey: CompiledExpression<FloatValue>) {
    setProperty("circle-sort-key", sortKey)
  }

  actual fun setCircleRadius(radius: CompiledExpression<DpValue>) {
    setProperty("circle-radius", radius)
  }

  actual fun setCircleColor(color: CompiledExpression<ColorValue>) {
    setProperty("circle-color", color)
  }

  actual fun setCircleBlur(blur: CompiledExpression<FloatValue>) {
    setProperty("circle-blur", blur)
  }

  actual fun setCircleOpacity(opacity: CompiledExpression<FloatValue>) {
    setProperty("circle-opacity", opacity)
  }

  actual fun setCircleTranslate(translate: CompiledExpression<DpOffsetValue>) {
    setProperty("circle-translate", translate)
  }

  actual fun setCircleTranslateAnchor(translateAnchor: CompiledExpression<TranslateAnchor>) {
    setProperty("circle-translate-anchor", translateAnchor)
  }

  actual fun setCirclePitchScale(pitchScale: CompiledExpression<CirclePitchScale>) {
    setProperty("circle-pitch-scale", pitchScale)
  }

  actual fun setCirclePitchAlignment(pitchAlignment: CompiledExpression<CirclePitchAlignment>) {
    setProperty("circle-pitch-alignment", pitchAlignment)
  }

  actual fun setCircleStrokeWidth(strokeWidth: CompiledExpression<DpValue>) {
    setProperty("circle-stroke-width", strokeWidth)
  }

  actual fun setCircleStrokeColor(strokeColor: CompiledExpression<ColorValue>) {
    setProperty("circle-stroke-color", strokeColor)
  }

  actual fun setCircleStrokeOpacity(strokeOpacity: CompiledExpression<FloatValue>) {
    setProperty("circle-stroke-opacity", strokeOpacity)
  }
}
