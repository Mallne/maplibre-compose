package org.maplibre.compose.style

import androidx.compose.ui.graphics.ImageBitmap
import org.maplibre.compose.layers.Layer
import org.maplibre.compose.sources.Source
import org.maplibre.compose.util.ImageResizeOptions
import org.maplibre.kmp.native.map.MapLibreMap

internal class DesktopStyle(internal val impl: MapLibreMap) : Style {

  override fun addImage(
    id: String,
    image: ImageBitmap,
    sdf: Boolean,
    resizeOptions: ImageResizeOptions?,
  ) {}

  override fun removeImage(id: String) {}

  private val wellKnownSourceIds = setOf("basemap")
  private val sourceCache = mutableMapOf<String, Source>()

  override fun getSource(id: String): Source? {
    if (id !in wellKnownSourceIds) return null
    return sourceCache.getOrPut(id) {
      org.maplibre.compose.sources.UnknownSource(object : org.maplibre.kmp.native.sources.Source(id) {
        override val attribution: String = ""
      })
    }
  }

  override fun getSources(): List<Source> {
    return wellKnownSourceIds.map { id ->
      sourceCache.getOrPut(id) {
        org.maplibre.compose.sources.UnknownSource(object : org.maplibre.kmp.native.sources.Source(id) {
          override val attribution: String = ""
        })
      }
    }
  }

  override fun addSource(source: Source) {
    runCatching { impl.addSource(source.impl) }
  }

  override fun removeSource(source: Source) {
    runCatching { impl.removeSource(source.impl) }
  }

  private val wellKnownLayerIds = setOf("Hintergrund")
  private val layerCache = mutableMapOf<String, Layer>()

  override fun getLayer(id: String): Layer? {
    if (id !in wellKnownLayerIds) return null
    return layerCache.getOrPut(id) {
      org.maplibre.compose.layers.UnknownLayer(object : org.maplibre.kmp.native.layers.Layer(id) {})
    }
  }

  override fun getLayers(): List<Layer> {
    return wellKnownLayerIds.map { id ->
      layerCache.getOrPut(id) {
        org.maplibre.compose.layers.UnknownLayer(object : org.maplibre.kmp.native.layers.Layer(id) {})
      }
    }
  }

  override fun addLayer(layer: Layer) {
    layer.map = impl
    runCatching { impl.addLayer(layer.impl) }
  }

  override fun addLayerAbove(id: String, layer: Layer) {
    layer.map = impl
    runCatching { impl.addLayer(layer.impl) } // TODO: support above
  }

  override fun addLayerBelow(id: String, layer: Layer) {
    layer.map = impl
    runCatching { impl.addLayer(layer.impl) } // TODO: support below
  }

  override fun addLayerAt(index: Int, layer: Layer) {
    layer.map = impl
    runCatching { impl.addLayer(layer.impl) } // TODO: support at index
  }

  override fun removeLayer(layer: Layer) {
    runCatching { impl.removeLayer(layer.impl) }
  }
}
