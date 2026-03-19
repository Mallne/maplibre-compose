package org.maplibre.compose.layers

import org.maplibre.compose.util.toJson
import org.maplibre.compose.expressions.ast.CompiledExpression
import org.maplibre.kmp.native.map.MapLibreMap
import org.maplibre.kmp.native.layers.Layer as NativeLayer

internal actual sealed class Layer {
  abstract val impl: NativeLayer
  internal var map: MapLibreMap? = null

  actual val id: String
    get() = impl.id

  protected fun setProperty(name: String, value: CompiledExpression<*>) {
    map?.setLayerProperty(id, name, value.toJson())
  }

  protected fun setLayerFilter(filter: CompiledExpression<*>) {
    map?.setLayerFilter(id, filter.toJson())
  }

  actual var minZoom: Float = 0f
    set(value) {
      field = value
      setProperty("minzoom", org.maplibre.compose.expressions.ast.FloatLiteral.of(value))
    }

  actual var maxZoom: Float = 24f
    set(value) {
      field = value
      setProperty("maxzoom", org.maplibre.compose.expressions.ast.FloatLiteral.of(value))
    }

  actual var visible: Boolean = true
    set(value) {
      field = value
      setProperty("visibility", org.maplibre.compose.expressions.ast.StringLiteral.of(if (value) "visible" else "none"))
    }

  override fun toString() = "${this::class.simpleName}(id=\"$id\")"
}
