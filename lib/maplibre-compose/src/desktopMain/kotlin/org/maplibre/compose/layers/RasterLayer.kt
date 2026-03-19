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
    setProperty("raster-opacity", opacity)
  }

  actual fun setRasterHueRotate(hueRotate: CompiledExpression<FloatValue>) {
    setProperty("raster-hue-rotate", hueRotate)
  }

  actual fun setRasterBrightnessMin(brightnessMin: CompiledExpression<FloatValue>) {
    setProperty("raster-brightness-min", brightnessMin)
  }

  actual fun setRasterBrightnessMax(brightnessMax: CompiledExpression<FloatValue>) {
    setProperty("raster-brightness-max", brightnessMax)
  }

  actual fun setRasterSaturation(saturation: CompiledExpression<FloatValue>) {
    setProperty("raster-saturation", saturation)
  }

  actual fun setRasterContrast(contrast: CompiledExpression<FloatValue>) {
    setProperty("raster-contrast", contrast)
  }

  actual fun setRasterResampling(resampling: CompiledExpression<RasterResampling>) {
    setProperty("raster-resampling", resampling)
  }

  actual fun setRasterFadeDuration(fadeDuration: CompiledExpression<MillisecondsValue>) {
    setProperty("raster-fade-duration", fadeDuration)
  }
}
