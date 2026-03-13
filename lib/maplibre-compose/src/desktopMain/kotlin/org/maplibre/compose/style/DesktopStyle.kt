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

  override fun getSource(id: String): Source? {
    return null
  }

  override fun getSources(): List<Source> {
    return emptyList()
  }

  override fun addSource(source: Source) {
    impl.addSource(source.impl)
  }

  override fun removeSource(source: Source) {
    impl.removeSource(source.impl)
  }

  override fun getLayer(id: String): Layer? {
    return null // TODO
  }

  override fun getLayers(): List<Layer> {
    return emptyList() // TODO
  }

  override fun addLayer(layer: Layer) {
    impl.addLayer(layer.impl)
  }

  override fun addLayerAbove(id: String, layer: Layer) {
    impl.addLayer(layer.impl) // TODO: support above
  }

  override fun addLayerBelow(id: String, layer: Layer) {
    impl.addLayer(layer.impl) // TODO: support below
  }

  override fun addLayerAt(index: Int, layer: Layer) {
    impl.addLayer(layer.impl) // TODO: support at index
  }

  override fun removeLayer(layer: Layer) {
    impl.removeLayer(layer.impl)
  }
}
