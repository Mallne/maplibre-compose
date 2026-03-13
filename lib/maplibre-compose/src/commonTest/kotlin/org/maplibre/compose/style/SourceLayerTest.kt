package org.maplibre.compose.style

import org.maplibre.compose.layers.CircleLayer
import org.maplibre.compose.layers.RasterLayer
import org.maplibre.compose.sources.GeoJsonData
import org.maplibre.compose.sources.GeoJsonSource
import org.maplibre.compose.sources.RasterSource
import org.maplibre.spatialk.geojson.dsl.featureCollectionOf
import kotlin.test.Test
import kotlin.test.assertEquals

class SourceLayerTest {

    @Test
    fun testRasterSource() {
        val style = FakeStyle(emptyList(), emptyList(), emptyList())
        val styleNode = StyleNode(SafeStyle(style), null)
        
        val rasterSource = RasterSource(
            id = "raster-source",
            uri = "https://example.com/tiles/{z}/{x}/{y}.png",
            tileSize = 256
        )
        
        styleNode.sourceManager.addReference(rasterSource)
        assertEquals(1, style.getSources().size)
        assertEquals("raster-source", style.getSources()[0].id)
    }

    @Test
    fun testGeoJsonSource() {
        val style = FakeStyle(emptyList(), emptyList(), emptyList())
        val styleNode = StyleNode(SafeStyle(style), null)
        
        val geoJsonSource = GeoJsonSource(
            id = "geojson-source",
            data = GeoJsonData.Features(featureCollectionOf()),
            options = org.maplibre.compose.sources.GeoJsonOptions()
        )
        
        styleNode.sourceManager.addReference(geoJsonSource)
        assertEquals(1, style.getSources().size)
        assertEquals("geojson-source", style.getSources()[0].id)
    }

    @Test
    fun testCircleLayer() {
        val style = FakeStyle(emptyList(), emptyList(), emptyList())
        val styleNode = StyleNode(SafeStyle(style), null)
        
        val geoJsonSource = GeoJsonSource(
            id = "geojson-source",
            data = GeoJsonData.Features(featureCollectionOf()),
            options = org.maplibre.compose.sources.GeoJsonOptions()
        )
        styleNode.sourceManager.addReference(geoJsonSource)
        
        val circleLayer = CircleLayer(
            id = "circle-layer",
            source = geoJsonSource
        )
        
        style.addLayer(circleLayer)
        assertEquals(1, style.getLayers().size)
        assertEquals("circle-layer", style.getLayers()[0].id)
    }
}
