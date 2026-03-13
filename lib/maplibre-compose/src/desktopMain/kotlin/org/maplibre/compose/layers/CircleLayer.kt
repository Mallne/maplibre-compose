package org.maplibre.compose.layers

import org.maplibre.compose.expressions.ast.CompiledExpression
import org.maplibre.compose.expressions.value.BooleanValue
import org.maplibre.compose.expressions.value.CirclePitchAlignment
import org.maplibre.compose.expressions.value.CirclePitchScale
import org.maplibre.compose.expressions.value.ColorValue
import org.maplibre.compose.expressions.value.DpOffsetValue
import org.maplibre.compose.expressions.value.DpValue
import org.maplibre.compose.expressions.value.FloatValue
import org.maplibre.compose.expressions.value.TranslateAnchor
import org.maplibre.compose.sources.Source

import org.maplibre.kmp.native.layers.CircleLayer as NativeCircleLayer

internal actual class CircleLayer actual constructor(id: String, source: Source) :
  FeatureLayer(source) {
  override val impl: NativeCircleLayer = NativeCircleLayer(id = id, sourceId = source.id)

  actual override var sourceLayer: String = "" // TODO

  actual override fun setFilter(filter: CompiledExpression<BooleanValue>) {
    {}
  }

  actual fun setCircleSortKey(sortKey: CompiledExpression<FloatValue>) {
    {}
  }

  actual fun setCircleRadius(radius: CompiledExpression<DpValue>) {
    {}
  }

  actual fun setCircleColor(color: CompiledExpression<ColorValue>) {
    {}
  }

  actual fun setCircleBlur(blur: CompiledExpression<FloatValue>) {
    {}
  }

  actual fun setCircleOpacity(opacity: CompiledExpression<FloatValue>) {
    {}
  }

  actual fun setCircleTranslate(translate: CompiledExpression<DpOffsetValue>) {
    {}
  }

  actual fun setCircleTranslateAnchor(translateAnchor: CompiledExpression<TranslateAnchor>) {
    {}
  }

  actual fun setCirclePitchScale(pitchScale: CompiledExpression<CirclePitchScale>) {
    {}
  }

  actual fun setCirclePitchAlignment(pitchAlignment: CompiledExpression<CirclePitchAlignment>) {
    {}
  }

  actual fun setCircleStrokeWidth(strokeWidth: CompiledExpression<DpValue>) {
    {}
  }

  actual fun setCircleStrokeColor(strokeColor: CompiledExpression<ColorValue>) {
    {}
  }

  actual fun setCircleStrokeOpacity(strokeOpacity: CompiledExpression<FloatValue>) {
    {}
  }
}
