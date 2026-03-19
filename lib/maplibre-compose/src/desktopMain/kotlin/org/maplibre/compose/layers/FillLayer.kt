package org.maplibre.compose.layers

import org.maplibre.compose.expressions.ast.CompiledExpression
import org.maplibre.compose.expressions.value.*
import org.maplibre.compose.sources.Source

internal actual class FillLayer actual constructor(id: String, source: Source) :
  FeatureLayer(source) {

  override val impl = org.maplibre.kmp.native.layers.FillLayer(id, source.id)

  actual override var sourceLayer: String = ""
    set(value) {
      field = value
      setProperty("source-layer", org.maplibre.compose.expressions.ast.StringLiteral.of(value))
    }

  actual override fun setFilter(filter: CompiledExpression<BooleanValue>) {
    setFilterInternal(filter)
  }

  actual fun setFillSortKey(sortKey: CompiledExpression<FloatValue>) {
    setProperty("fill-sort-key", sortKey)
  }

  actual fun setFillAntialias(antialias: CompiledExpression<BooleanValue>) {
    setProperty("fill-antialias", antialias)
  }

  actual fun setFillOpacity(opacity: CompiledExpression<FloatValue>) {
    setProperty("fill-opacity", opacity)
  }

  actual fun setFillColor(color: CompiledExpression<ColorValue>) {
    setProperty("fill-color", color)
  }

  actual fun setFillOutlineColor(outlineColor: CompiledExpression<ColorValue>) {
    setProperty("fill-outline-color", outlineColor)
  }

  actual fun setFillTranslate(translate: CompiledExpression<DpOffsetValue>) {
    setProperty("fill-translate", translate)
  }

  actual fun setFillTranslateAnchor(translateAnchor: CompiledExpression<TranslateAnchor>) {
    setProperty("fill-translate-anchor", translateAnchor)
  }

  actual fun setFillPattern(pattern: CompiledExpression<ImageValue>) {
    setProperty("fill-pattern", pattern)
  }
}
