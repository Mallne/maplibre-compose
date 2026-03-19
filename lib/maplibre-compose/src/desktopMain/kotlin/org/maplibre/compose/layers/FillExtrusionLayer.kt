package org.maplibre.compose.layers

import org.maplibre.compose.expressions.ast.CompiledExpression
import org.maplibre.compose.expressions.value.*
import org.maplibre.compose.sources.Source

internal actual class FillExtrusionLayer actual constructor(id: String, source: Source) :
  FeatureLayer(source) {
  override val impl = org.maplibre.kmp.native.layers.FillExtrusionLayer(id, source.id)

  actual override var sourceLayer: String = ""
    set(value) {
      field = value
      setProperty("source-layer", org.maplibre.compose.expressions.ast.StringLiteral.of(value))
    }

  actual override fun setFilter(filter: CompiledExpression<BooleanValue>) {
    setFilterInternal(filter)
  }

  actual fun setFillExtrusionOpacity(opacity: CompiledExpression<FloatValue>) {
    setProperty("fill-extrusion-opacity", opacity)
  }

  actual fun setFillExtrusionColor(color: CompiledExpression<ColorValue>) {
    setProperty("fill-extrusion-color", color)
  }

  actual fun setFillExtrusionTranslate(translate: CompiledExpression<DpOffsetValue>) {
    setProperty("fill-extrusion-translate", translate)
  }

  actual fun setFillExtrusionTranslateAnchor(anchor: CompiledExpression<TranslateAnchor>) {
    setProperty("fill-extrusion-translate-anchor", anchor)
  }

  actual fun setFillExtrusionPattern(pattern: CompiledExpression<ImageValue>) {
    setProperty("fill-extrusion-pattern", pattern)
  }

  actual fun setFillExtrusionHeight(height: CompiledExpression<FloatValue>) {
    setProperty("fill-extrusion-height", height)
  }

  actual fun setFillExtrusionBase(base: CompiledExpression<FloatValue>) {
    setProperty("fill-extrusion-base", base)
  }

  actual fun setFillExtrusionVerticalGradient(verticalGradient: CompiledExpression<BooleanValue>) {
    setProperty("fill-extrusion-vertical-gradient", verticalGradient)
  }
}
