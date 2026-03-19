package org.maplibre.compose.layers

import org.maplibre.compose.expressions.ast.CompiledExpression
import org.maplibre.compose.expressions.value.BooleanValue
import org.maplibre.compose.expressions.value.ColorValue
import org.maplibre.compose.expressions.value.DpOffsetValue
import org.maplibre.compose.expressions.value.DpValue
import org.maplibre.compose.expressions.value.FloatValue
import org.maplibre.compose.expressions.value.ImageValue
import org.maplibre.compose.expressions.value.LineCap
import org.maplibre.compose.expressions.value.LineJoin
import org.maplibre.compose.expressions.value.TranslateAnchor
import org.maplibre.compose.expressions.value.VectorValue
import org.maplibre.compose.sources.Source

internal actual class LineLayer actual constructor(id: String, source: Source) :
  FeatureLayer(source) {

  override val impl = org.maplibre.kmp.native.layers.LineLayer(id, source.id)

  actual override var sourceLayer: String = ""
    set(value) {
      field = value
      setProperty("source-layer", org.maplibre.compose.expressions.ast.StringLiteral.of(value))
    }

  actual override fun setFilter(filter: CompiledExpression<BooleanValue>) {
    setFilterInternal(filter)
  }

  actual fun setLineCap(cap: CompiledExpression<LineCap>) {
    setProperty("line-cap", cap)
  }

  actual fun setLineJoin(join: CompiledExpression<LineJoin>) {
    setProperty("line-join", join)
  }

  actual fun setLineMiterLimit(miterLimit: CompiledExpression<FloatValue>) {
    setProperty("line-miter-limit", miterLimit)
  }

  actual fun setLineRoundLimit(roundLimit: CompiledExpression<FloatValue>) {
    setProperty("line-round-limit", roundLimit)
  }

  actual fun setLineSortKey(sortKey: CompiledExpression<FloatValue>) {
    setProperty("line-sort-key", sortKey)
  }

  actual fun setLineOpacity(opacity: CompiledExpression<FloatValue>) {
    setProperty("line-opacity", opacity)
  }

  actual fun setLineColor(color: CompiledExpression<ColorValue>) {
    setProperty("line-color", color)
  }

  actual fun setLineTranslate(translate: CompiledExpression<DpOffsetValue>) {
    setProperty("line-translate", translate)
  }

  actual fun setLineTranslateAnchor(translateAnchor: CompiledExpression<TranslateAnchor>) {
    setProperty("line-translate-anchor", translateAnchor)
  }

  actual fun setLineWidth(width: CompiledExpression<DpValue>) {
    setProperty("line-width", width)
  }

  actual fun setLineGapWidth(gapWidth: CompiledExpression<DpValue>) {
    setProperty("line-gap-width", gapWidth)
  }

  actual fun setLineOffset(offset: CompiledExpression<DpValue>) {
    setProperty("line-offset", offset)
  }

  actual fun setLineBlur(blur: CompiledExpression<DpValue>) {
    setProperty("line-blur", blur)
  }

  actual fun setLineDasharray(dasharray: CompiledExpression<VectorValue<Number>>) {
    setProperty("line-dasharray", dasharray)
  }

  actual fun setLinePattern(pattern: CompiledExpression<ImageValue>) {
    setProperty("line-pattern", pattern)
  }

  actual fun setLineGradient(gradient: CompiledExpression<ColorValue>) {
    setProperty("line-gradient", gradient)
  }
}
