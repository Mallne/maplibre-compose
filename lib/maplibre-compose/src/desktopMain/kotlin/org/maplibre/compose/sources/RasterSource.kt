package org.maplibre.compose.sources

import org.maplibre.kmp.native.sources.RasterSource as NativeRasterSource

public actual class RasterSource : Source {
  public actual constructor(id: String, uri: String, tileSize: Int) : super() {
    this.impl = NativeRasterSource(id = id, uri = uri, tileSize = tileSize)
  }

  public actual constructor(
    id: String,
    tiles: List<String>,
    options: TileSetOptions,
    tileSize: Int,
  ) : super() {
    this.impl = NativeRasterSource(id = id, tiles = tiles, tileSize = tileSize)
  }

  override val impl: NativeRasterSource
}
