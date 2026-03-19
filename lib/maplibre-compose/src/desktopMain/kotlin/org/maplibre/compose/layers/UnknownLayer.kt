package org.maplibre.compose.layers

import org.maplibre.kmp.native.layers.Layer as NativeLayer

internal actual class UnknownLayer(override val impl: NativeLayer) : Layer()
