package org.maplibre.compose.sources

import org.maplibre.kmp.native.sources.Source as NativeSource

public actual class UnknownSource(override val impl: NativeSource) : Source()
