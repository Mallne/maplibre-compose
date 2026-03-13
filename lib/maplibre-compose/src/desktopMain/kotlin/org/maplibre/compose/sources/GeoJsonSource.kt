package org.maplibre.compose.sources

import kotlinx.serialization.json.JsonObject
import org.maplibre.spatialk.geojson.Feature
import org.maplibre.spatialk.geojson.FeatureCollection
import org.maplibre.kmp.native.sources.GeoJsonSource as NativeGeoJsonSource

public actual class GeoJsonSource : Source {

  override val impl: NativeGeoJsonSource

  public actual constructor(id: String, data: GeoJsonData, options: GeoJsonOptions) : super() {
    val json = when (data) {
        is GeoJsonData.Features -> data.geoJson.toString()
        is GeoJsonData.JsonString -> data.json
        is GeoJsonData.Uri -> null // TODO: handle URI in native if possible
    }
    this.impl = NativeGeoJsonSource(id = id, json = json)
  }

  public actual fun setData(data: GeoJsonData) {
    // TODO: Update native source if mbgl supports it after creation
  }

  public actual fun isCluster(feature: Feature<*, JsonObject?>): Boolean {
    return false
  }

  public actual fun getClusterExpansionZoom(feature: Feature<*, JsonObject?>): Double {
    return 0.0
  }

  public actual fun getClusterChildren(
    feature: Feature<*, JsonObject?>
  ): FeatureCollection<*, JsonObject?> {
    return FeatureCollection<org.maplibre.spatialk.geojson.Geometry, JsonObject?>(emptyList())
  }

  public actual fun getClusterLeaves(
    feature: Feature<*, JsonObject?>,
    limit: Long,
    offset: Long,
  ): FeatureCollection<*, JsonObject?> {
    return FeatureCollection<org.maplibre.spatialk.geojson.Geometry, JsonObject?>(emptyList())
  }
}
