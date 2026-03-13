package org.maplibre.compose.layers

import org.maplibre.compose.expressions.ast.CompiledExpression
import org.maplibre.compose.expressions.value.FloatValue
import org.maplibre.compose.expressions.value.MillisecondsValue
import org.maplibre.compose.expressions.value.RasterResampling
import org.maplibre.compose.sources.Source

import org.maplibre.kmp.native.layers.RasterLayer as NativeRasterLayer

internal actual class RasterLayer actual constructor(id: String, actual val source: Source) :
  Layer() {
  override val impl: NativeRasterLayer = NativeRasterLayer(id = id, sourceId = source.id)

  actual fun setRasterOpacity(opacity: CompiledExpression<FloatValue>) {
    {}
  }

  actual fun setRasterHueRotate(hueRotate: CompiledExpression<FloatValue>) {
    {}
  }

  actual fun setRasterBrightnessMin(brightnessMin: CompiledExpression<FloatValue>) {
    {}
  }

  actual fun setRasterBrightnessMax(brightnessMax: CompiledExpression<FloatValue>) {
    {}
  }

  actual fun setRasterSaturation(saturation: CompiledExpression<FloatValue>) {
    {}
  }

  actual fun setRasterContrast(contrast: CompiledExpression<FloatValue>) {
    {}
  }

  actual fun setRasterResampling(resampling: CompiledExpression<RasterResampling>) {
    {}
  }

  actual fun setRasterFadeDuration(fadeDuration: CompiledExpression<MillisecondsValue>) {
    {}
  }
}
