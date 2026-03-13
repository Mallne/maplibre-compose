package org.maplibre.compose.layers

import org.maplibre.kmp.native.layers.Layer as NativeLayer

internal actual sealed class Layer {
  abstract val impl: NativeLayer

  actual val id: String
    get() = impl.id

  actual var minZoom: Float
    get() = 0f // TODO
    set(value) {
      // TODO
    }

  actual var maxZoom: Float
    get() = 24f // TODO
    set(value) {
      // TODO
    }

  actual var visible: Boolean
    get() = true // TODO
    set(value) {
      // TODO
    }

  override fun toString() = "${this::class.simpleName}(id=\"$id\")"
}
